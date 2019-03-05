#!/bin/bash -x

sed -i -e"s/^max_connections = 100.*$/max_connections = 100/" /var/lib/postgresql/data/pgdata/postgresql.conf
sed -i -e"s/^#max_prepared_transactions = 0.*$/max_prepared_transactions = 100/" /var/lib/postgresql/data/pgdata/postgresql.conf
sed -i -e"s/^#log_directory = 'pg_log'.*$/log_directory = 'pg_log'/" /var/lib/postgresql/data/pgdata/postgresql.conf
sed -i -e"s/^#log_filename = 'postgresql-%Y-%m-%d_%H%M%S.log'.*$/log_filename = 'postgresql-%Y-%m-%d_%H%M%S.log'/" /var/lib/postgresql/data/pgdata/postgresql.conf
sed -i -e"s/^#log_statement = 'none'.*$/log_statement = 'all'/" /var/lib/postgresql/data/pgdata/postgresql.conf

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE spitter_db;
EOSQL