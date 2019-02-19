
FROM postgres:9.6

MAINTAINER Magomed KADIEV <kadiev@laposte.net>

# for convenience
RUN apt-get -y update \
  && apt-get -y install vim \
  && apt-get -y install less \
  && rm -rf /var/lib/apt/lists/*

# This variable is defined by the tomcat image. It defines the
# password of the $POSTGRES_USER, which is postgres by default.
ENV POSTGRES_PASSWORD="postgres"
ENV PGDATA="/var/lib/postgresql/data/pgdata"

# This script creates the DBs and update postgres configuration.
ADD database/resources/postgres-configuration.sh /docker-entrypoint-initdb.d/00-linxo-postgres-configuration.sh
