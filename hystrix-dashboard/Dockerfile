FROM java:8-jre
MAINTAINER Nikhil

ADD ./target/hystrix-dashboard-1.0.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/hystrix-dashboard-1.0.jar"]

EXPOSE 8020