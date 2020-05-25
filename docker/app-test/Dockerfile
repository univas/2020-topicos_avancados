FROM openjdk:8-alpine

LABEL author="Roberto"
LABEL data="21/05/2020"

WORKDIR /usr/local/bin

#Transfer the jar file to image
COPY ./lab7-test-1.0.jar test.jar

#execute java application inside the container
CMD ["java", "-jar", "test.jar"]

