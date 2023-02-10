FROM openjdk:17-jdk-slim-buster

ADD /target/*.jar ClinicServer.jar
EXPOSE 8082

ENTRYPOINT ["java","-jar","PetServer.jar"]