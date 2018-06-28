#!/bin/bash
source ./commons.sh

#
# Uncomment for debugging purposes
#
# echo 'execute_444.sh'
# echo $1 # env (e.g. oracle / aws)
# echo $2 # Job Group (e.g. TKA444)

package=com.daito.as01.hxx.clp.chhr.procedure
programs=(com.daito.as01.hxx.clp.chhr.procedure.CHashRzbotake com.daito.as01.hxx.clp.chht.procedure.CHashTeno220 com.daito.as01.hxx.clp.chht.procedure.CHashTeno230 com.daito.as01.hxx.clp.jhhr.procedure.JHashRtb0100j)

# run all programs
#for p in ${programs[@]}; do
#	logMessage "--- Start Step ${p}"

#	executeStep "$1" "$p" "$2" "$package" false
	
#	logMessage "--- Step ${p} finished"
#done

	logMessage "--- Start Step CHashRzbotake"
	executeStep "$1" "CHashRzbotake" "$2" "com.daito.as01.hxx.clp.chhr.procedure" false
	logMessage "--- Step CHashRzbotake finished"

	logMessage "--- Start Step CHashTeno220"
	executeStep "$1" "CHashTeno220" "$2" "com.daito.as01.hxx.clp.chht.procedure" false
	logMessage "--- Step CHashTeno220 finished"

	logMessage "--- Start Step CHashTeno230"
	executeStep "$1" "CHashTeno230" "$2" "com.daito.as01.hxx.clp.chht.procedure" false
	logMessage "--- Step CHashTeno230 finished"

	logMessage "--- Start Step JHashRtb0100j"
	executeStep "$1" "JHashRtb0100j" "$2" "com.daito.as01.hxx.clp.jhhr.procedure" false
	logMessage "--- Step JHashRtb0100j finished"