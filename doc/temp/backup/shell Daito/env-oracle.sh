export ENV="ora"
export BASE_DIR=${1}
export BASE_LOG_DIR=${BASE_DIR}/stats
export SOFT_DIR=/media/dkdata/daito/soft/

export JDK_DIR=$SOFT_DIR/jdk1.8.0_112/bin

export SERVER_ID=${2}

echo $BASE_DIR
echo $BASE_LOG_DIR

#
# PROFILING OPTIONS: un-comment one of the following 3 options below:
#
export YOURKIT_AGENT_DIR=$SOFT_DIR/yjp-2015-build-15084

# JAVA FLIGHT RECORDER profiling
# export PROFILING_OPTIONS="-XX:+UnlockCommercialFeatures -XX:+FlightRecorder -XX:StartFlightRecording=duration=1800s,filename=${BASE_LOG_DIR}/flightrecorder/fr_$TIMESTAMP.jfr"

# ON-LINE YourKit Profiling
# export PROFILING_OPTIONS="-agentpath:${YOURKIT_AGENT_DIR}/bin/linux-x86-64/libyjpagent.so"

# OFF-LINE YourKit Profiling
# export PROFILING_OPTIONS="-agentpath:${YOURKIT_AGENT_DIR}/bin/linux-x86-64/libyjpagent.so=onexit=snapshot,dir=${BASE_LOG_DIR}/yourkit,logdir=${BASE_LOG_DIR}/yourkit,tracing"


export DB_SCRIPTS_DIR="/home/atlassian/FactoryDevAutomation/scripts/db"
export DATA_COMPARISON_SCRIPTS_BASE_DIR="/u01/CSC/cmpoutput/COMPARE_SCRIPT_BATCH_V3"

export ROWS_COUNT_CSV_DIR=$BASE_LOG_DIR/rowsCount

export DB_SERVER_CONN="atlassian@20.197.20.57"

# This option allows to "assign" the process to certain CPU Cores. E.g: cores 0, 1, 2 and 3
#export TASKSET="taskset -c 0-5 " # Please do not remove the space at the end
