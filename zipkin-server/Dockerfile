FROM java:8-jre
MAINTAINER Nikhil

ADD ./target/zipkin-server-1.0.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/zipkin-server-1.0.jar"]

EXPOSE 8020