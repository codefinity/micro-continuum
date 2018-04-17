FROM java:8-jre
MAINTAINER Nikhil

RUN apt-get update && apt-get -y install netcat && apt-get clean

ADD ./target/user-microservice-1.0.jar /app/
ADD ./wait-for.sh /app/
RUN chmod +x ./app/wait-for.sh
#CMD ["java", "-Xmx200m", "-jar", "/app/user-microservice-1.0.jar"]

EXPOSE 8000