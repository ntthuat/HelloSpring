#!/bin/bash
source ./commons.sh
 
	logMessage "--- Start Step Xxp020c"
	executeStep "$1" "Xxp020c" "$2" "com.daito.as01.hxx.clp.xxp.procedure" false 
	logMessage "--- Step Xxp020c finished"

	logMessage "--- Start Step Xxp050c"
	executeStep "$1" "Xxp050c" "$2" "com.daito.as01.hxx.clp.xxp.procedure" false 
	logMessage "--- Step Xxp050c finished"


