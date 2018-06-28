#!/bin/bash
source ./commons.sh

#
# Uncomment for debugging purposes
#
# echo 'execute_444.sh'
# echo $1 # env (e.g. oracle / aws)
# echo $2 # Job Group (e.g. TKA444)

package=com.daito.as01.hxx.clp.dxm.procedure
programs=(Dxm036c Dxm037c Dxm038c)
echo "Is Sanpshot: " $3
# run all programs
for p in ${programs[@]}; do
	logMessage "--- Start Step ${p}"

	executeStep "$1" "$p" "$2" "$package" false
if $3; then
	createSnapshot "KOD551_DBG03" "$p"
fi
	logMessage "--- Step ${p} finished"
done

