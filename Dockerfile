FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build app/target/atividade-02-0.0.1-SNAPSHOT.jar /app/atividade-02-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/atividade-02-0.0.1.jar"]



