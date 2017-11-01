#!/bin/bash
#######################################################
# Usage:
#  setEnv [environment ID]
#######################################################
function setEnv {

	source env-$1.sh $2 $3
	
	if [[ -z "$BASE_DIR" ]]; then
		echo "============================================================================"
		echo "BASE_DIR must be set - include env-<ENV>-<SERVER_ID> where: <ENV>=[oracle, aws, db2i.belldata] and server id=NAG1, P1"
		echo "============================================================================"
		exit 1;
	fi
	logMessage "BASE_DIR is ${BASE_DIR}"
	logMessage "BASE_LOG_DIR is ${BASE_LOG_DIR}"
	logMessage "SERVER_ID is ${SERVER_ID}"

}
#######################################################
# Usage:
#  printVersion release-number
# this function print out release number and jar revision no if it not done so yet
#######################################################
function printVersion {
	if [[ -z "$printVersion" ]]; then
		# print release number, which is substituted during maven build
		logMessage "Release Number: $1"
		# to print out tar file version as well as JAR svn vesion
		APP_PROPERTIES="-Dlogback.configurationFile=${LOG_CONFIG_FILE} -DBASE_LOG_DIR=${BASE_LOG_DIR} -DTIMESTAMP=${TIMESTAMP} -DJOB_NAME=${JOB_STEP_NAME}"
		java -classpath ./java:./java/* $APP_PROPERTIES com.csc.qre.core.util.JarManifestInfo "daito-pilot"
		printVersion=1
	fi
}
#######################################################
# Usage:
#  log [INFO|ERROR] message
# Output Pattern:
#  yyyy-mm-dd HH:MM:SS [Current Process ID] [INFO|ERROR] : aMessage
#############################################
function log {
    echo "$(date '+%Y-%m-%d %T,%3N') $1 [$$] : [$0] $2"
}

#############################################
# Usage:
#	logMessage aMessage
#############################################
function logMessage {
    log "INFO " "$*"
}

#############################################
# Usage:
#	logError aMessage
#############################################
function logError {
    log "ERROR" "$*"
}

#############################################
# Usage:
#	startNmon  job-step-name timestamp
#############################################
function startMonTools {
    nmon -F "${BASE_LOG_DIR}/nmon/nmon_$1_$2.nmon" -s2 -c9000 &
	mpstat -P ALL 3 10000 > "${BASE_LOG_DIR}/nmon/mpstat_${1}_${2}.log" &
	nohup iostat -d -k -t -x ALL 2  > "${BASE_LOG_DIR}/nmon/iostat_${1}_${2}.log" &
	nohup vmstat 5 3600 > "${BASE_LOG_DIR}/nmon/vmstat_${1}_${2}.log" &
	logMessage "Monitoring tools started ..."
}
function stopMonTools {
    killall nmon
	killall mpstat
	killall iostat
	killall vmstat
}
#############################################
# Usage:
#	getTimestamp
#############################################
function getTimestamp {
	# set timestamp
	if [[ -z "$TIMESTAMP" ]]; then
		export TIMESTAMP=$(date +%Y%m%d_%H%M%S)
	fi
}
#############################################
# Usage:
#	createSnapshot aStepName
#############################################
function createSnapshot {
	getTimestamp
	#RESTORE_POINT_NAME="DAITO_AFTER_${1}_${TIMESTAMP}"
  RESTORE_POINT_NAME="DAITO_AFTER_${1}_${2}"
	logMessage "About to take Restore Point: $RESTORE_POINT_NAME" 

#	ssh ${DB_SERVER_CONN} "$DB_SCRIPTS_DIR/node2/create_restore_point_node2.sh $RESTORE_POINT_NAME && exit"
  ./Flashback_CreateRestorePoint.sh "${1}" "$RESTORE_POINT_NAME"

	logMessage "Finished Restore Point: $RESTORE_POINT_NAME";
}


#######################################################
# Usage:
#  generateAWR_snapshot
#  this function creates an AWR snapshot and returns generated snapshot id
#######################################################
generateAWR_snapshot() {
	if [ "${DB_SERVER_ID}" == "NAG2" ]; then
		export snap_id=`ssh $DB_SERVER_CONN "${DB_SCRIPTS_DIR}/node2/AWR_snapshot.sh  && exit"`
	else 
		export snap_id=`ssh $DB_SERVER_CONN "${DB_SCRIPTS_DIR}/node1/AWR_snapshot.sh  && exit"`
	fi
	logMessage "Created AWR snapshot $snap_id for ${jobname} ${JOB_STEP_NAME}" 
}


#######################################################
# Usage:
#  setupAWR_report
#  this function creates an AWR report from the last TKA444/445 application execution
#######################################################
setupAWR_report() {
    export run_AWR_reports="$BASE_LOG_DIR/AWR/AWR_reports_${1}_${2}.sql"
	logMessage "Setup AWR reports: ${run_AWR_reports}" 
	
	echo "----- genarated by runjob.sh    `date`"  > ${run_AWR_reports}
	chmod ugo+rx                                     ${run_AWR_reports}
    echo "def AWR_total=AWR_${1}_total"            >>${run_AWR_reports}
	echo "def AWR_begin_snap=$snap_id"             >>${run_AWR_reports}
	echo "def AWR_start_snap=$snap_id"             >>${run_AWR_reports}

}

#######################################################
# Usage:
#  generateAWR_report
#  this function creates an AWR report from the last TKA444/445 application execution
#######################################################
generateAWR_report() {
	logMessage "Generate AWR reports" 

	echo "---------------------------------------" >> ${run_AWR_reports}
	echo "----- AWR for the whole run &&AWR_total" >> ${run_AWR_reports}
	echo "def AWR_title=&&AWR_total              " >> ${run_AWR_reports}
	echo "@AWR_generate_report &&AWR_begin_snap &&AWR_start_snap &&AWR_total" >> ${run_AWR_reports}

    cd $BASE_LOG_DIR/AWR
    export SQL_PATH="$DATA_COMPARISON_SCRIPTS_BASE_DIR"
    export SQLPATH="$DATA_COMPARISON_SCRIPTS_BASE_DIR"
    if [ "${DB_SERVER_ID}" == "NAG2" ]; then
  	    export conn=daito/daito@daito_clone
    else 
        if [ "${SERVER_ID}" == "NAG2" ]; then
            export conn=daito/daito@daito1 
		else
            export conn=daito/daito@daito 
	    fi
    fi
    echo exit|sqlplus ${conn} @${run_AWR_reports}
}

#############################################
# Usage:
#	executeStep env stepName jobGroup inParallel
#############################################
function executeStep {

#	echo 'executeStep ${2}' $*

	# If inParallel flag == true
	if $5; then
		./execute.sh "$1" "$2" "$3" "$4" &
	else
		./execute.sh "$1" "$2" "$3" "$4"
	fi
	exitCode=$?
	
	if [ $exitCode -ne 0 ]; then
		logMessage "--- Step ${2} is finished with error = $exitCode"
		exit $exitCode
	else
		logMessage "--- Step ${2} is finished without error";
	fi
}
