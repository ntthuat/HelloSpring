#!/bin/bash
source ./commons.sh
 
	logMessage "--- Start Step Fig630c"
	executeStep "$1" "Fig630c" "$2" "com.daito.as01.hxx.clp.fig.procedure" false 
	logMessage "--- Step Fig630c finished"

	logMessage "--- Start Step Fig635c"
	executeStep "$1" "Fig635c" "$2" "com.daito.as01.hxx.clp.fig.procedure" false 
	logMessage "--- Step Fig635c finished"


