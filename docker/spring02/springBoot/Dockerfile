FROM openjdk:8-alpine

LABEL author="Roberto"
LABEL data="23/05/2020"

WORKDIR /usr/local/bin

#Transfer the war file to imagem
COPY ./lab7-boot02-1.0.jar boot02.jar

#execute java application inside the container
CMD ["java", "-Dspring.profiles.active=docker", "-jar", "boot02.jar"]
