#!/bin/bash
# wait-for-rabbitmq.sh

set -e

host="$1"
shift
cmd="$@"

#until PGPASSWORD=$POSTGRES_PASSWORD psql -h "$host" -U "postgres" -c '\q'; do
#  >&2 echo "Postgres is unavailable - sleeping"
#  sleep 1
#done

until nc -z rabbitmq 5672; do
    echo "$(date) - waiting for rabbitmq..."
    sleep 1
done

>&2 echo "RabbitMq is up - executing command"
exec $cmd






