FROM java:8-jre
MAINTAINER Nikhil

ADD ./target/user-microservice-1.0.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/user-microservice-1.0.jar"]

EXPOSE 8020