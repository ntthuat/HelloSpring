#!/bin/bash
source ./commons.sh

# echo 'execute.sh'
# echo $1	# env	(eg. oracle/aws)
# echo $2	# Step Name (e.g FTD600C)
# echo $3	# Job Group (e.g. TKA445)

# 
# CMD TO INVOKE THIS SCRIPT: ./execute.sh $1=ENV $2=PROCEDURE $3=TKA444/TKA445.
# EXAMPLE: ./execute.sh oracle Ftd600c TKA445
#
export JOB_GROUP="$(tr [a-z] [A-Z] <<< ${3})"
export JOB_STEP_NAME="$(tr [a-z] [A-Z] <<< ${2})"
export LOG_CONFIG_FILE=logback-default.xml

# get timestamp if it's not set yet
getTimestamp


# set CONSOLE_LOG
if [[ -z "$CONSOLE_LOG" ]]; then
	export CONSOLE_LOG="${BASE_LOG_DIR}/app/qre-${JOB_STEP_NAME}-${TIMESTAMP}.log"
 echo "console log= ${CONSOLE_LOG}"
	#exec >> ${CONSOLE_LOG}
fi


# !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
# NOTE: project.version and release number are populated by maven build
# !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
printVersion "$project.version - $build.timestamp"

springProfiles="env.$1"
logMessage " ======>>>>> START ${JOB_GROUP} ${JOB_STEP_NAME} with environment profile ${springProfiles}"

JVM_OPTIONS="-Xmx32g -Xms32g -XX:NewRatio=1"
APP_PROPERTIES="-Dqre.batch.app.context.path=classpath:/META-INF/spring/app-batch-context.xml -Dqre.batch.job.writeExitCode=false -Dqre.batch.app.name=AH008001 -Dqre.batch.user.name=OPR001 -Dqre.batch.user.password=OPR001 -Dlogback.configurationFile=${LOG_CONFIG_FILE} -Dspring.profiles.active=${springProfiles} -DBASE_LOG_DIR=${BASE_LOG_DIR} -DTIMESTAMP=${TIMESTAMP} -DJOB_NAME=${JOB_STEP_NAME}"

echo "*****************TASKSET***********:" ${TASKSET}
${TASKSET}./jsm.sh ${SERVER_ID}_${JOB_GROUP} ${JOB_GROUP} ${JOB_STEP_NAME} "java $JVM_OPTIONS $PROFILING_OPTIONS -classpath ./java:./java/*  -Djava.security.egd=file:///dev/urandom $APP_PROPERTIES com.csc.qre.service.CommandLineBatchController $4.$2"
exitCode=$?
#com.daito.as01.hxx.rpg.alb.program
#com.daito.as01.hxx.clp.alb.procedure

logMessage " ======>>>>> FINISHED AT: $(date +%Y%m%d_%H%M%S)"
echo $exitCode
unset TIMESTAMP
exit $exitCode