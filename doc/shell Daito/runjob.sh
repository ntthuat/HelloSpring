#!/bin/bash
source ./commons.sh

#
# Flags initialization
#
snapshot=false
rowcount=false
awr=false
datacomparison=false
profiling=false
zipLogs=true
monitoring=false
deleteLogFiles=true

# ========================================
# Subroutines 
# ========================================
usage() {
	echo "============================================================================"
	echo "Usage: $0 {-j <TKA444|TKA445>} {-e < AWS | db2i.csc | db2i.dk >}[-s] [-c] [-a] [-d] [-s] [-p] [-z] [-f] [-v]"
	echo ""
	echo "-e: [MANDATORY] Environment (e.g. aws.k1 or db2i.csc or db2i.dk)"
	echo "-j: [MANDATORY] Job Name - TKA444 or TKA445"
	echo "-s: [OPTIONAL] Creates DB snapshots after each step of the job is completed (only for ORACLE)"
#	echo "-a: [OPTIONAL] Creates the AWR report for the step that has just finished (only for ORACLE)"
#	echo "-d: [OPTIONAL] Generates the Data Comparison Report (only for ORACLE)"
	echo "-m: [OPTIONAL] Enables Monitoring tools (e.g. NMON, MPSTAT, etc)"
#	echo "-p: [OPTIONAL] Runs the process with Profiling enabled"
	echo "-z: [OPTIONAL] Disables creation of ZIP file with all log files at the end of the process"
	echo "-x: [OPTIONAL] Disables deletion of all log files before the process runs"
	echo "-h: [OPTIONAL] This help screen"
	echo "============================================================================"
	exit 1;
} 
 
runDataComparisonScripts() {
	
	SCRIPT="EMPTY"
	if [ "${jobname}" == "TKA444" ]; then
		SCRIPT="run_444.sh"
	else
		if [ "${jobname}" == "TKA445" ]; then
			SCRIPT="run_445.sh"
		fi
	fi

	logMessage "Executing Data Comparison report: ${DATA_COMPARISON_SCRIPTS_BASE_DIR} - ${SCRIPT} - "
	ssh "${DB_SERVER_CONN} ${DATA_COMPARISON_SCRIPTS_BASE_DIR}/${SCRIPT} && exit"

	logMessage "Generation of Data Comparison report finished"
}

zipLogFiles() {
	# ZIPs all files under the /statistics directory, except the /archive directory itself.
	logMessage "Compressing all logs files ..."
	./zipLogs.sh $env $folder $vmname
}

deleteLogFiles() {
	logMessage "Deleting all logs files ..."
	./deleteLogs.sh $env $folder $vmname
}

generateAWR() {
	logMessage "Generation of AWR report is not implemented yet ..." 
}

# ========================================
# MAIN LOGIC 
# ========================================

#
# Determines what runtime options have been passed/set by the operator
#
while getopts "e:j:f:v:sxadpzm" opt; do
	echo 'opt=' + $opt
      case "$opt" in
          s) snapshot=true;; 
          a) awr=true;;
		  d) datacomparison=true;;
		  p) profiling=true;;
		  z) zipLogs=false;;
		  m) monitoring=true;;
  		  x) deleteLogFiles=false;;
		  j) jobname="$(tr [a-z] [A-Z] <<< ${OPTARG})"

		  if [ -z "$jobname" ]; then
			usage
		  fi
		  
		  #if [[ $jobname != "TKA445" && $jobname != "TKA444" && $jobname != "KNA480" && $jobname != "KOA458" && $jobname != "KOD551" && $jobname != "TEA026" && $jobname != "KOA434" && $jobname != "TEA410" && $jobname != "KOD423" ]]; then
			#usage
		 # fi
		  ;;
		  
		  e) env="$(tr [A-Z] [a-z] <<< ${OPTARG})"

  		if [[ $env != "oracle" ]]; then
			usage
		  fi
		  ;;
      
      f) folder="${OPTARG}"

  		
		  ;;
        
      v) vmname="${OPTARG}"

  		if [ -z "$vmname" ]; then
			usage
		  fi
		  ;;
          *) usage;;
      esac
done
shift "$((OPTIND-1))" # Shift off the options and optional --.

if [[ -z "$jobname" || -z "$env" ]]; then
    usage
fi

# -------------------------
# set BASE_DIR, BASE_LOG_DIR, PROFILING_OPTIONS
#
setEnv $env $folder $vmname


getTimestamp

if $deleteLogFiles; then
	deleteLogFiles
fi


# Start monitoring tools. We need only one instance of these tools for the whole duration of the process.
if $monitoring; then
	startMonTools "${SERVER_ID}_${jobname}" ${TIMESTAMP}
fi 

export awr
if $awr; then
# Generate a snapshot so all previous database load is not impacting the AWR report
     export JOB_STEP_NAME="Start"
	generateAWR_snapshot
	setupAWR_report	"$jobname" ${TIMESTAMP}
    
fi 
# -------------------------

# if [ "${jobname}" == "TKA444" ]; then
# 	./execute_TKA444.sh "$env" "$jobname"
# else
# 	if [ "${jobname}" == "TKA445" ]; then
# 		./execute_TKA445.sh "$env" "$jobname"
# 		sleep 2400
# 	else
#  if [ "${jobname}" == "KNA480" ]; then
# 	./execute_KNA480.sh "$env" "$jobname"
#  else
#  if [ "${jobname}" == "KOA458" ]; then
# 	./execute_KOA458.sh "$env" "$jobname"
# else
#  if [ "${jobname}" == "KOD551" ]; then
# 	./execute_KOD551.sh "$env" "$jobname" "$snapshot"
# else
#  if [ "${jobname}" == "TEA026" ]; then
# 	./execute_TEA026.sh "$env" "$jobname"
# else
#  if [ "${jobname}" == "KOA434" ]; then
# 	./execute_KOA434.sh "$env" "$jobname"
# else
#  if [ "${jobname}" == "TEA410" ]; then
# 	./execute_TEA410.sh "$env" "$jobname"
# else
#  if [ "${jobname}" == "KOD423" ]; then
# 	./execute_KOD423.sh "$env" "$jobname"
# else
# 		echo "invalid job name"
# 		exit -1
#    fi
# 	fi
# fi
#  fi
# fi
# fi
# fi
# fi
# fi

./execute_$jobname.sh "$env" "$jobname"

getTimestamp

# Creates restores points/snapshot.
#if $snapshot; then
#	createSnapshot "$jobname"
#fi


# Terminates all monitoring tools.
if $monitoring; then
	stopMonTools
fi

if $datacomparison; then
	runDataComparisonScripts
fi

if $zipLogs; then
	zipLogFiles
fi

if $awr; then
#   generate a snapshot and produce a report
    echo "------------------------------ `date`" >> ${run_AWR_reports}
	
    generateAWR_report
fi 


logMessage "--- Complete Job ${jobname}"
