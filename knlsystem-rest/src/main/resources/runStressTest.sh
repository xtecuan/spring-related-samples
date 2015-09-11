#!/bin/bash
########Change according to your settings#######
export JAVA_HOME=/home/julianr/Java/jdk1.8.0_60
stressTest_js_file=/home/julianr/Work/NetbeansProjects/knlsystem-services/knlsystem-rest/src/main/resources/stressTest.js
createBookmark_bash=/home/julianr/Work/NetbeansProjects/knlsystem-services/knlsystem-rest/src/main/resources/createBookmark.sh
########End Change according to your settings########

export PATH=$JAVA_HOME/bin:$PATH

jrunscript ${stressTest_js_file} ${createBookmark_bash}