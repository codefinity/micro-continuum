#!/bin/bash
# wait-for.sh

set -e

#host="$1"
shift
cmd="$@"

is_config_server_on=false
is_rabbitmq_on=false

until $is_config_server_on && $is_rabbitmq_on ; do
    sleep 20
    
    if [ $(nc -z rabbitmq 5672; echo $?) -eq 0 ]
	then
		is_rabbitmq_on=true
		echo "$(date) - RabbitMQ Connected"
	else
		echo "$(date) - Waiting for RabbitMQ"		
	fi
    
	if [ $(nc -z config-server 8888; echo $?) -eq 0 ]
	then
		is_config_server_on=true
		echo "$(date) - Config Server Connected"
	else		
		echo "$(date) - Waiting for Config Server"
	fi
    
done

>&2 echo "Dependencies are up - starting Eureka Container"
exec java -Xmx200m -jar /app/eureka-service-discovery-1.0.jar






##!/bin/bash
## wait-for.sh
#
#set -e
#
##host="$1"
#shift
#cmd="$@"
#
##until PGPASSWORD=$POSTGRES_PASSWORD psql -h "$host" -U "postgres" -c '\q'; do
##  >&2 echo "Postgres is unavailable - sleeping"
##  sleep 1
##done
#
#until nc -z rabbitmq 5672; do
#    echo "$(date) - waiting for rabbitmq..."
#    sleep 20
#done
#
#>&2 echo "RabbitMq is up - executing command"
##exec $cmd
#exec java -Xmx200m -jar /app/eureka-service-discovery-1.0.jar