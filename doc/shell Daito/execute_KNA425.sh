#!/bin/bash
source ./commons.sh
 
	logMessage "--- Start Step Auz020c"
	executeStep "$1" "Auz020c" "$2" "com.daito.as01.hxx.clp.auz.procedure" false 
	logMessage "--- Step Auz020c finished"

	logMessage "--- Start Step Auj010c"
	executeStep "$1" "Auj010c" "$2" "com.daito.as01.hxx.clp.auj.procedure" false 
	logMessage "--- Step Auj010c finished"

	logMessage "--- Start Step Auj060c"
	executeStep "$1" "Auj060c" "$2" "com.daito.as01.hxx.clp.auj.procedure" false 
	logMessage "--- Step Auj060c finished"


