
FROM maven:3.6.0-jdk-11-slim AS build

COPY src /src
COPY pom.xml .
RUN mvn -f pom.xml clean package

#
# App execution
#

FROM openjdk:11-jre-slim
COPY --from=build quizjob-0.0.1-SNAPSHOT.jar /usr/local/lib/quizjob.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/quizjob.jar"]



