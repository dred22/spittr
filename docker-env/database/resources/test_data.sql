
\c spitter_db

drop table if exists spitters ;
drop table if exists users ;

CREATE TABLE users
  (
     username  VARCHAR(30) NOT NULL,
     enabled   BOOLEAN DEFAULT TRUE,
     password  VARCHAR(255),
     PRIMARY KEY (username)
  ) ;
CREATE TABLE authorities
(
   username  VARCHAR(30) NOT NULL,
   authority  VARCHAR(255) NOT NULL
) ;


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

insert into SPITTERS
  (email, firstName, lastName, password, ts, username)
values
  ('test1@test.com', 'test1_firstName', 'test1_lastName', 'pass1', '2019-01-25', 'test1'),
  ('test2@test.com', 'test2_firstName', 'test2_lastName', 'pass2', '2019-01-25', 'test2'),
  ('test3@test.com', 'test3_firstName', 'test3_lastName', 'pass3', '2019-01-25', 'test3');

insert into users (username, password) values ('user','user');
insert into authorities (username, authority) values ('user','ROLE_USER');

insert into users (username, password) values ('admin','admin');
insert into authorities (username, authority) values ('admin','ROLE_USER');
insert into authorities (username, authority) values ('admin','ROLE_ADMIN');
COMMIT;