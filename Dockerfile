FROM eclipse-temurin:17-jdk-jammy
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} koa.jar
ENTRYPOINT ["java", "-jar","/koa.jar"]


