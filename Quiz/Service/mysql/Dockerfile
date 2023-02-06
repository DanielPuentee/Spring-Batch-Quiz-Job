FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=123456789
ENV MYSQL_DATABASE=quiz01   
ADD quiz01.sql /docker-entrypoint-initdb.d

ENTRYPOINT ["docker-entrypoint.sh","mysqld"]
