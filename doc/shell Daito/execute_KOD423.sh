#!/bin/bash
source ./commons.sh

#
# Uncomment for debugging purposes
#
# echo 'execute_444.sh'
# echo $1 # env (e.g. oracle / aws)
# echo $2 # Job Group (e.g. TKA444)

#package=com.daito.as01.hxx.clp.chhr.procedure
#rograms=(com.daito.as01.hxx.clp.bxm.procedure.Bxm053c)

# run all programs
#for p in ${programs[@]}; do
#	logMessage "--- Start Step ${p}"

#	executeStep "$1" "$p" "$2" "$package" false
	
#	logMessage "--- Step ${p} finished"
#done

	logMessage "--- Start Step Bxm053c"
	executeStep "$1" "Bxm053c" "$2" "com.daito.as01.hxx.clp.bxm.procedure" false
	logMessage "--- Step Bxm053c finished"

	logMessage "--- Start Step Bxm054c"
	executeStep "$1" "Bxm054c" "$2" "com.daito.as01.hxx.clp.bxm.procedure" false
	logMessage "--- Step Bxm054c finished"

	logMessage "--- Start Step Bxm063c"
	executeStep "$1" "Bxm063c" "$2" "com.daito.as01.hxx.clp.bxm.procedure" false
	logMessage "--- Step Bxm063c finished"

	logMessage "--- Start Step Bxt180c"
	executeStep "$1" "Bxt180c" "$2" "com.daito.as01.hxx.clp.bxt.procedure" false
	logMessage "--- Step Bxt180c finished"