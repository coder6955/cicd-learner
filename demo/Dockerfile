#Gets JDK required to run the application
FROM eclipse-temurin:21-jdk

#Set the working directory in the container as /app, henceforth all commands will be run in this directory
WORKDIR /app

#Copy the built JAR file from the target directory to the container's /app directory
COPY target/*.jar demo-app.jar

#Expose the port that the application will run on (default is 8080)
EXPOSE 8080

#Command to run the application when the container starts
CMD ["java", "-jar", "demo-app.jar"]