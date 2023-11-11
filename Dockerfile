# Use an official OpenJDK runtime as a base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY build/libs/product-service-1.0-SNAPSHOT.jar /app/your-spring-boot-app.jar

# Specify the command to run on container start
CMD ["java", "-jar", "product-service-1.0-SNAPSHOT.jar"]
