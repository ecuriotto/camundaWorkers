# Use a base image with Java pre-installed
FROM openjdk:11-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory on the host to the container
COPY camunda7-order-process-app/target/camunda7-order-process-app.jar worker.jar

# Expose the port on which the Spring Boot application listens
EXPOSE 8081

# Set the command to run when the container starts
CMD ["java", "-jar", "worker.jar"]