#!/bin/bash
# wait-for.sh

set -e

#host="$1"
shift
cmd="$@"

#until PGPASSWORD=$POSTGRES_PASSWORD psql -h "$host" -U "postgres" -c '\q'; do
#  >&2 echo "Postgres is unavailable - sleeping"
#  sleep 1
#done

until nc -z rabbitmq 5672; do
    echo "$(date) - waiting for rabbitmq..."
    sleep 20
done

>&2 echo "RabbitMq is up - executing command"
#exec $cmd
exec java -Xmx200m -jar /app/eureka-service-discovery-1.0.jar






