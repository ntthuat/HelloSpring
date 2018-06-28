#!/bin/bash
source ./commons.sh
 
# This option allows to assign the process to certain CPU Cores. E.g: cores 0, 1, 2 and 3 
export TASKSET="taskset -c 0-7 " # Please do not remove the space at the end 
	logMessage "--- Start Step Ajv110c"
	executeStep "$1" "Ajv110c" "$2" "com.daito.as01.hxx.clp.ajv.procedure" false 
	logMessage "--- Step Ajv110c finished"


