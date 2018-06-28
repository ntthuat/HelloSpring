#!/bin/bash
# Absolute path to this script, e.g. /home/user/bin/foo.sh
SCRIPT=$(readlink -f "$0")
# Absolute path this script is in, thus /home/user/bin
SCRIPTPATH=$(dirname "$SCRIPT")

echo $SCRIPTPATH

DBName=$1
RPName=$2

echo "DBName="$DBName
echo "RPName="$RPName

CDBName=$($ORACLE_HOME/bin/sqlplus -s QRE/QRE@$DBName <<EOF
       set pagesize 0 feedback off verify off heading off echo off;
       select value from v\$parameter where name='db_name';
       exit;
EOF
)

echo "CDBName="$CDBName

$ORACLE_HOME/bin/sqlplus "C##DBFBUSER/C##DBFBUSER@$CDBName" <<EOF
begin
  SYS.SP_CREATE_RESTOREPOINT('$DBName','$RPName');
end;
/
EOF

