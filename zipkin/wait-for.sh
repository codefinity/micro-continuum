#!/bin/bash
# wait-for.sh

set -e

shift
cmd="$@"

is_elasticsearch_server_on=false

until $is_elasticsearch_server_on ; do
    sleep 20
    
    	if [ $(nc -z elasticsearch 9200 ; echo $?) -eq 0 ]
		then
			is_elasticsearch_server_on=true
			echo "$(date) - Elasticsearch Connected"
		else
			echo "$(date) - Waiting for Elasticsearch"		
	fi
    
done

>&2 echo "Dependencies are up - starting zipkin Container"
exec java -jar ./app/zipkin-server-2.7.1-exec.jar STORAGE_TYPE=elasticsearch ES_HOSTS=elasticsearch

#Zipkin jar downloaded from 
#https://jcenter.bintray.com/io/zipkin/java/zipkin-server/2.7.1/zipkin-server-2.7.1-exec.jar
