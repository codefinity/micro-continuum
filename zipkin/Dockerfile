FROM java:8-jre
MAINTAINER Nikhil

RUN apt-get update && apt-get -y install netcat && apt-get clean

ADD ./zipkin-server-2.7.1-exec.jar /app/
ADD ./wait-for.sh /app/
RUN chmod +x ./app/wait-for.sh
#CMD ["java", "-Xmx200m", "-jar", "/zipkin-server-2.7.1-exec.jar"]


EXPOSE 9411
