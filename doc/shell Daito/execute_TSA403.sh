#!/bin/bash
source ./commons.sh
 
# This option allows to assign the process to certain CPU Cores. E.g: cores 0, 1, 2 and 3 
export TASKSET="taskset -c 0-7 " # Please do not remove the space at the end 
	logMessage "--- Start Step Esf05ac"
	executeStep "$1" "Esf05ac" "$2" "com.daito.as01.hxx.clp.esf.procedure" false 
	logMessage "--- Step Esf05ac finished"

	logMessage "--- Start Step Esf05bc"
	executeStep "$1" "Esf05bc" "$2" "com.daito.as01.hxx.clp.esf.procedure" false 
	logMessage "--- Step Esf05bc finished"

	logMessage "--- Start Step Esf05cc"
	executeStep "$1" "Esf05cc" "$2" "com.daito.as01.hxx.clp.esf.procedure" false 
	logMessage "--- Step Esf05cc finished"

	logMessage "--- Start Step Esf05dc"
	executeStep "$1" "Esf05dc" "$2" "com.daito.as01.hxx.clp.esf.procedure" false 
	logMessage "--- Step Esf05dc finished"

	logMessage "--- Start Step Esf05ec"
	executeStep "$1" "Esf05ec" "$2" "com.daito.as01.hxx.clp.esf.procedure" false 
	logMessage "--- Step Esf05ec finished"

	logMessage "--- Start Step Esf05fc"
	executeStep "$1" "Esf05fc" "$2" "com.daito.as01.hxx.clp.esf.procedure" false 
	logMessage "--- Step Esf05fc finished"

	logMessage "--- Start Step Esf05gc"
	executeStep "$1" "Esf05gc" "$2" "com.daito.as01.hxx.clp.esf.procedure" false 
	logMessage "--- Step Esf05gc finished"

	logMessage "--- Start Step Esf05hc"
	executeStep "$1" "Esf05hc" "$2" "com.daito.as01.hxx.clp.esf.procedure" false 
	logMessage "--- Step Esf05hc finished"

	logMessage "--- Start Step Esf05ic"
	executeStep "$1" "Esf05ic" "$2" "com.daito.as01.hxx.clp.esf.procedure" false 
	logMessage "--- Step Esf05ic finished"

	logMessage "--- Start Step Esf05jc"
	executeStep "$1" "Esf05jc" "$2" "com.daito.as01.hxx.clp.esf.procedure" false 
	logMessage "--- Step Esf05jc finished"

	logMessage "--- Start Step Esf050c"
	executeStep "$1" "Esf050c" "$2" "com.daito.as01.hxx.clp.esf.procedure" false 
	logMessage "--- Step Esf050c finished"


