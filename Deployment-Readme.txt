1> First run "mvn clean package -DskipTests" to create jar file in target folder

2> Then create a dockerfile in springboot app root folder eg.inside demo in our case and add below content to it.

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

3> Then run below command to build the docker image as it will read above dockerfile in our directory.
     docker build -t udayp6955/myspringbootapp:1.0.0 .

4> After the image is built successfully, you can run the container using below command locally:
         docker run -d -p 8123:8080 udayp6955/myspringbootapp:1.0.0
    Now you can access the application at http://localhost:8123

5> To push the image to Docker Hub, first login to your Docker Hub account using below command:
         docker login
    Then push the image using below command:
        docker tag udayp6955/myspringbootapp:1.0.0 udayp6955/myspringbootapp:latest
        docker push udayp6955/myspringbootapp:latest

6> To deploy the application on Kubernetes, you can create a deployment YAML file (e.g., deployment.yaml) with the following path
    C:\cicd-module\cicd-learner\k8s\actual_deployment

7> Then apply the deployment and service using below command:
         kubectl apply -f config.yaml -f secret.yaml
         kubectl apply -f deployment-service.yaml

8> Finally, you can access the application using the external IP of the service. You can get the
    external IP using below command:
    kubectl get svc app-service-majhi i.e http://localhost:30080/
    Here, 30080 is the nodeport that we have defined in the service yaml file which helps us to access via browser.





