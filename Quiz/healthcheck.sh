#!/bin/sh
ip=$(docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' complete_db)
nc -z "$ip" 33060
if [ $? -eq 0 ]; then
  echo "Connection succeeded"
else
  echo "Connection failed"
fi
exit $?
