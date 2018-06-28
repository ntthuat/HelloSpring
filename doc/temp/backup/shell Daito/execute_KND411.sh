#!/bin/bash
source ./commons.sh
 
# This option allows to assign the process to certain CPU Cores. E.g: cores 0, 1, 2 and 3 
export TASKSET="taskset -c 0-7 " # Please do not remove the space at the end 
	logMessage "--- Start Step Agc120c"
	executeStep "$1" "Agc120c" "$2" "com.daito.as01.hxx.clp.agc.procedure" false 
	logMessage "--- Step Agc120c finished"

	logMessage "--- Start Step Kvfa0cc"
	executeStep "$1" "Kvfa0cc" "$2" "com.daito.as01.hxx.clp.kvf.procedure" false 
	logMessage "--- Step Kvfa0cc finished"


