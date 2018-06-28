#!/bin/bash
source ./commons.sh

setEnv "$1" "$2" "$3"

#
# ZIPs up all the latests logs files under the /daito/stats directory.
#
# if a parameter is specified, then it should be RUN ID. 
# then zip up file with the RUN ID
if [ $# -eq 2 ]; then
	TIMESTAMP="$2"
else
	getTimestamp
fi

# Bash 3.x version
zipFileName="$BASE_LOG_DIR/archive/LOGS_$(tr [a-z] [A-Z] <<< ${SERVER_ID})_$TIMESTAMP.zip"

# Bash 4.x version
# zipFileName="$BASE_LOG_DIR/archive/LOGS_${SERVER_ID^^}_$TIMESTAMP.zip"

echo "creating $zipFileName"
zip -r $zipFileName $BASE_LOG_DIR/* -x $BASE_LOG_DIR/archive/*