FROM tomcat:9.0.35-jdk8-openjdk-slim

LABEL author="Roberto"
LABEL data="22/05/2020"

#Transfer the war file to Tomcat
COPY ./lab7-web00.war /usr/local/tomcat/webapps/lab7-web00.war

#Good practice - just for documentation
EXPOSE 8080

#execute tomcat inside the container
CMD ["catalina.sh", "run"]

