#!/bin/bash
# wait-for.sh

set -e

shift
cmd="$@"

is_config_server_on=false
is_rabbitmq_on=false
is_eureka_discovery_on=false
is_zuul_api_gateway_on=false
is_mongodb_on=false

until 
		#$is_config_server_on &&
		#$is_rabbitmq_on &&
		#$is_eureka_discovery_on && 
		#$is_zuul_api_gateway_on &&
		$is_mongodb_on ; do
    
    sleep 20


    if [ $(nc -z mongodb 27017; echo $?) -eq 0 ]
	then
		is_mongodb_on=true
		echo "$(date) - MongoDb Connected"
	else
		echo "$(date) - Waiting for MongoDb"		
	fi    
    
#    if [ $(nc -z rabbitmq 5672; echo $?) -eq 0 ]
#	then
#		is_rabbitmq_on=true
#		echo "$(date) - RabbitMQ Connected"
#	else
#		echo "$(date) - Waiting for RabbitMQ"		
#	fi
#    
#	if [ $(nc -z config-server 8888; echo $?) -eq 0 ]
#	then
#		is_config_server_on=true
#		echo "$(date) - Config Server Connected"
#	else		
#		echo "$(date) - Waiting for Config Server"
#	fi
#	
#	if [ $(nc -z eureka-service-discovery 8761; echo $?) -eq 0 ]
#	then
#		is_eureka_discovery_on=true
#		echo "$(date) - Eureka Discovery Server Connected"
#	else		
#		echo "$(date) - Waiting for Eureka Discovery Server"
#	fi
#	
#	if [ $(nc -z zuul-api-gateway 8095; echo $?) -eq 0 ]
#	then
#		is_zuul_api_gateway_on=true
#		echo "$(date) - ZUUL API Gateway Connected"
#	else		
#		echo "$(date) - Waiting for ZUUL API Gateway"
#	fi
    
done

>&2 echo "Dependencies are up - starting user-microservice Container"
exec java -Xmx200m -jar /app/user-microservice-1.0.jar
