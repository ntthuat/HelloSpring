#!/bin/bash
source ./commons.sh

#
# Uncomment for debugging purposes
#
# echo 'execute_444.sh'
# echo $1 # env (e.g. oracle / aws)
# echo $2 # Job Group (e.g. TKA444)

package=com.daito.as01.hxx.clp.bxd.procedure
programs=(Bxd28cc Bxd28dc Bxd28ec Bxd28fc Bxd28gc Bxd28hc Bxd281c Bxd282c Bxd283c)

# run all programs
for p in ${programs[@]}; do
	logMessage "--- Start Step ${p}"

	executeStep "$1" "$p" "$2" "$package" false
	
	logMessage "--- Step ${p} finished"
done

