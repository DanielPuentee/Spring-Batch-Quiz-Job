FROM maven:3.8.6-jdk-8-slim AS build

COPY src /src
COPY pom.xml .
RUN mvn -f pom.xml clean package

#
# App execution
#

FROM openjdk:8-jre-slim
COPY --from=build /target/quiz-0.0.1-SNAPSHOT.jar /usr/local/lib/quiz.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/quiz.jar"]