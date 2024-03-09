FROM openjdk:17
EXPOSE 8080
ADD target/configuration-service.jar configuration-service.jar
ENTRYPOINT ["java","-jar","/configuration-service.jar"]