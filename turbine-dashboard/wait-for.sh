#!/bin/bash
# wait-for.sh

set -e

shift
cmd="$@"

is_eureka_service_discovery_on=false

until $is_eureka_service_discovery_on ; do
    sleep 20
    
	if [ $(nc -z eureka-service-discovery 8761; echo $?) -eq 0 ]
	then
		is_eureka_service_discovery_on=true
		echo "$(date) - Eureka Service Discovery Connected"
	else		
		echo "$(date) - Waiting for Eureka Service Discovery"
	fi
    
done

>&2 echo "Dependencies are up - starting turbine-dashboard Container"
exec java -Xmx200m -jar /app/turbine-dashboard-1.0.jar






