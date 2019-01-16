FROM openjdk:8-jdk-alpine

COPY ./target/calculadora-service-0.1.0.jar .

ENTRYPOINT ["java", "-jar", "./calculadora-service-0.1.0.jar"]