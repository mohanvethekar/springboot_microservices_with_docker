# Step 1: Use an official OpenJDK 21 image
FROM eclipse-temurin:21-jdk

# Step 2: Set working directory inside the container
WORKDIR /app

# Step 3: Copy the built JAR file from target folder into the container
COPY target/microservicesproject-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Step 5: Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
