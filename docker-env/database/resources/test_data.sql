
\c my_spitter

drop table if exists spitters ;

CREATE TABLE spitters
  (
     id        BIGSERIAL NOT NULL,
     email     VARCHAR(255),
     firstname VARCHAR(255),
     lastname  VARCHAR(255),
     password  VARCHAR(255),
     ts        DATE,
     username  VARCHAR(255),
     PRIMARY KEY (id)
  ) ;


BEGIN;
insert into SPITTERS (email, firstName, lastName, password, ts, username) values ('test@test.com', 'test1_firstName', 'test1_lastName', 'pass', '2019-01-25', 'test1');
COMMIT;