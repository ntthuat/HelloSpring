#!/bin/bash
source ./commons.sh

setEnv "$1" "$2" "$3"

# =======================================================
# Cleans-up all log files under the /stats directory.
# =======================================================

rm -f $BASE_LOG_DIR/app/*
rm -f $BASE_LOG_DIR/nmon/*
rm -f $BASE_LOG_DIR/timer/*
rm -f $BASE_LOG_DIR/flightrecorder/*
rm -f $BASE_LOG_DIR/yourkit/*
rm -f $BASE_LOG_DIR/dataComps/*
rm -f $BASE_LOG_DIR/AWR/*