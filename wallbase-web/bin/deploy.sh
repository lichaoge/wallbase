#!/bin/bash
artifact=wallbase-web-1.0-SNAPSHOT.jar

BASEDIR=$(cd "$(dirname "$0")"; pwd)
DATE=$(date +"%Y-%m-%d-%H:%M:%S")

CODE_DIR=$BASEDIR/wallbase
set -eu

#for app in ${APPS[@]} ; do
if [ ! -d backup ]; then
    mkdir backup
fi

if [ -e ${artifact}.jar ]; then
    mv $artifact.jar backup/$artifact-$DATE.jar
fi  

mvn -pl $CODE_DIR

cp -rf  "$CODE_DIR/wallbase-web/target$artifact" "$BASEDIR/$artifact.jar"
#done

if [ ! -d logs ]; then
   mkdir logs
fi

if [ -e ${artifact}.jar ]; then
   sh  $BASEDIR/spring-boot.sh restart
fi


