FROM eclipse-temurin:17-jdk-jammy
# ARG JAR_FILE=target/*.jar
COPY koa.jar /koa.jar
ENTRYPOINT ["java", "-jar","/koa.jar"]


