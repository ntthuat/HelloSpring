source ./commons.sh
#-------------------------------------------------------------------------------------
#	jsm.sh - FOR NEGOYA EXADATA ENVIRONMENT
#
#	jsm.sh (JobStepMetrics) is a script that invokes /usr/bin/time to gather Linux
#	performance metrics for a command or script.  The output is saved in a .txt file	
#	which can be imported into a spreadsheet or database for analysis.  The output
#	file will be created if it does not exist, and its name will be $jobstream.txt
#	in the current directory.
#
#	If you are timing a job stream (a set of jobs which make up a business process)
#	you can invoke the shell script which invokes the jobs with this script. In this 
#	case you would probably set jobname to "ALL" and jobstep to "ALL".   
#  
#	If you are timing an executable command or set of commands that make up a job 
#	within a job stream invoke the job's script and set the jobmane appropriately and
#	set the jobstep to "ALL".
#
#	If you are timing a job step within a job within a job stream set all three 
#	parameters to relevant values (e.g., BDEBILL ABCDJOB01 XYZSTEP02)
#
#	Charles Smith - CSC - csmith56@csc.com	
#-------------------------------------------------------------------------------------

if [ $# != 4 ] 
	then
	echo "jsm.sh usage: jobstream jobname jobstep commandToTime"
	echo "       Output will be saved to \$jobstream.txt in the current directory"
	echo "       Enclose any parameters which contain delimiters (such as a space character) in quotes."
	exit 1
fi

jobstream=$1
jobname=$2
jobstep=$3
commandToTime=$4

logMessage "number of parameters = $#"
logMessage " jobstream = $1"
logMessage " jobname = $2"
logMessage " jobstep = $3"
logMessage " commandToTime = $4"

baseLogDir=${BASE_LOG_DIR}/timer
jsmLogFile="${baseLogDir}/${jobstream}.txt"
timestamp=$(date +'%Y-%m-%d-%H-%M')

jsmOptions="%U,%S,%P,%E,%e,%I,%O,%r,%s,%M,%K,%D,%X,%Z,%F,%R,%W,%c,%w"

if test -f "$jsmLogFile"
	then
		logMessage "LOG FILE "$jsmLogFile" exists - data will be appended."
	else
	{
		logMessage "LOG FILE "$jsmLogFile" does not exist - creating ..."		
		logMessage "JOB,STEP,START,FINISH,COMMAND,$jsmOptions" > ${jsmLogFile}
	}
fi

startTimeStamp=`date "+%x %T"`

#------------------------------------------------------------------------------
#   THE COMMAND TO BE TIMED IS SPECIFIED WITH THE PARAMETER commandToTime
#------------------------------------------------------------------------------

/usr/bin/time -f $jsmOptions -o timeOutput.$$ $commandToTime
exitCode=$?

endTimeStamp=`date "+%x %T"`

logMessage $jobname,$jobstep,$startTimeStamp,$endTimeStamp,\"$commandToTime\", > $jobname_$stepname.txt
tr -t '\n' ' ' < $jobname_$stepname.txt > $jobname_$stepname.$$

cat $jobname_$stepname.$$ timeOutput.$$ > tempLine.$$

cp $jsmLogFile $jobstream.$$
cat $jobstream.$$ tempLine.$$ > ${jsmLogFile}
cat $jsmLogFile
rm *.$$
logMessage "----------------------------------------------------"	
echo $exitCode
exit $exitCode
