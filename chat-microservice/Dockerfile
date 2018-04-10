FROM java:8-jre
MAINTAINER Nikhil

ADD ./target/chat-microservice-1.0.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/chat-microservice-1.0.jar"]

EXPOSE 8020