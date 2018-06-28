#!/bin/bash
source ./commons.sh

#
# Uncomment for debugging purposes
#
# echo 'execute_444.sh'
# echo $1 # env (e.g. oracle / aws)
# echo $2 # Job Group (e.g. TKA444)

programs=(Ftd010c Ftd200c Ftd400c Ftd510c Ftd520c)

# run all programs
for p in ${programs[@]}; do
	logMessage "--- Start Step ${p}"

	executeStep "$1" "$p" "$2" false
	
	logMessage "--- Step ${p} finished"
done

