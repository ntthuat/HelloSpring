#!/bin/bash
source ./commons.sh

#
# Uncomment for debugging purposes
#
# echo 'execute_445.sh'
# echo $1 # env (e.g. oracle / aws)
# echo $2 # Job Group (e.g. TKA444)

#
# Execution of FTD300C
#
logMessage "--- Start Step FTD300C"

export TASKSET="taskset -c 0-5 " # Please do not remove the space at the end
executeStep "$1" "Ftd300c" "$2" true

logMessage "--- Step FTD300C finished"


#
# Execution of FTD600C
#
logMessage "--- Start Step FTD600C"

export TASKSET="taskset -c 6-11 " # Please do not remove the space at the end
executeStep "$1" "Ftd600c" "$2" true

logMessage "--- Step FTD600C finished"
