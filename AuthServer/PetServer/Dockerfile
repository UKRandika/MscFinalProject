FROM openjdk:17-jdk-slim-buster

ADD /target/*.jar PetServer.jar
EXPOSE 8081

ENTRYPOINT ["java","-jar","PetServer.jar"]