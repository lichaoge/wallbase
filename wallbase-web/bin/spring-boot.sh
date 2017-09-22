#!/bin/sh
SERVICE_NAME=wallbase
HOME=/export/App
PATH_TO_JAR=$HOME/wallbase.jar
APP_PROT=1080
PID_PATH_NAME=/tmp/wallbase.pid
LOG=$HOME/logs/wallbase-boot.log
ERROR_LOG=$HOME/logs/wallbase-boot.error
case $1 in
    start)
        echo "Starting $SERVICE_NAME ..."
        if [ ! -f $PID_PATH_NAME ]; then
            cd $HOME
            nohup java -jar $PATH_TO_JAR > $LOG 2> $ERROR_LOG &
                        echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is already running ..."
        fi
    ;;
    stop)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stoping ..."
            kill $PID;
            echo "$SERVICE_NAME stopped ..."
            rm $PID_PATH_NAME
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
    restart)
        if [ -f $PID_PATH_NAME ]; then
            PID=$(cat $PID_PATH_NAME);
            echo "$SERVICE_NAME stopping ...";
            kill $PID;
            echo "$SERVICE_NAME stopped ...";
            rm $PID_PATH_NAME
            echo "$SERVICE_NAME starting ..."
            cd $HOME
            nohup java -jar $PATH_TO_JAR > $LOG 2> $ERROR_LOG &
                        echo $! > $PID_PATH_NAME
            echo "$SERVICE_NAME started ..."
        else
            echo "$SERVICE_NAME is not running ..."
        fi
    ;;
esac

url="http://localhost:${APP_PROT}"
echo "Waiting for $artifact to start... $url"
until [ $(curl -sL -w '%{http_code}\n' "$url" -o /dev/null) == "200" ];
do
 sleep 2
done

echo "Deploy finished OK."
