FROM java:8-jre
MAINTAINER Nikhil

ADD ./target/zuul-api-gateway-1.0.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/zuul-api-gateway-1.0.jar"]

EXPOSE 8095