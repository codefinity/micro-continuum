FROM java:8-jre
MAINTAINER Nikhil

RUN apt-get update && apt-get -y install netcat && apt-get clean

ADD ./target/management-1.0.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/management-1.0.jar"]

EXPOSE 8020