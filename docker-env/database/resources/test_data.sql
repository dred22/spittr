
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
insert into SPITTERS (email, firstName, lastName, password, ts, username) values ('test@test.com', 'test1_firstName', 'test1_lastName', 'pass', '2019-01-25', 'test1');

insert into users (username, password) values ('user','user');
insert into authorities (username, authority) values ('user','ROLE_USER');

insert into users (username, password) values ('admin','admin');
insert into authorities (username, authority) values ('admin','ROLE_USER');
insert into authorities (username, authority) values ('admin','ROLE_ADMIN');
COMMIT;