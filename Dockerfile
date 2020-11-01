FROM openjdk:11.0.8-jre

EXPOSE 8080

LABEL maintainer="Jorge Vargas <jorgevargasmateo@hotmail.com>"

COPY /build/libs/DockerComposePractica-0.0.1-SNAPSHOT.jar practica-docker-compose.jar

ENTRYPOINT ["java", "-jar", "practica-docker-compose.jar"]
