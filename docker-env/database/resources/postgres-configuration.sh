#!/bin/bash -x

sed -i -e"s/^max_connections = 100.*$/max_connections = 100/" /var/lib/postgresql/data/pgdata/postgresql.conf
sed -i -e"s/^#max_prepared_transactions = 0.*$/max_prepared_transactions = 100/" /var/lib/postgresql/data/pgdata/postgresql.conf

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE my_spitter;
EOSQL