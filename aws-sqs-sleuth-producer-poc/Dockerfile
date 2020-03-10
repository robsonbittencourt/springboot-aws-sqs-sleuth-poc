FROM openjdk:11.0.6-slim

WORKDIR /app
COPY ./build/libs .

ENTRYPOINT ["sh", "-c", "java -jar aws-sqs-sleuth-producer-poc.jar"]