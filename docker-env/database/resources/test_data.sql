
\c handbook

drop table if exists reference ;
drop table if exists users ;

BEGIN;

CREATE TABLE users
  (
     username  VARCHAR(30) NOT NULL,
     password  VARCHAR(100) NOT NULL,
     authority  VARCHAR(50) NOT NULL,
     enabled   BOOLEAN DEFAULT TRUE,
     PRIMARY KEY (username)
  ) ;

CREATE TABLE reference
  (
     id        BIGSERIAL NOT NULL,
     email     VARCHAR(255),
     firstname VARCHAR(255),
     lastname  VARCHAR(255),
     password  VARCHAR(255),
     ts        DATE,
     username  VARCHAR(255),
     deleted   BOOLEAN DEFAULT FALSE,
     PRIMARY KEY (id)
  ) ;


insert into reference
  (email, firstName, lastName, password, ts, username)
values
  ('test1@test.com', 'test1_firstName', 'test1_lastName', 'pass1', '2019-01-25', 'test1'),
  ('test2@test.com', 'test2_firstName', 'test2_lastName', 'pass2', '2019-01-25', 'test2'),
  ('test3@test.com', 'test3_firstName', 'test3_lastName', 'pass3', '2019-01-25', 'test3');

insert into
  users (username, password, authority)
values
  ('user','$2a$10$Z00qRR286FPYsfNe6a/Ehezhpgi00UGLWVD8CEVh13jQ2WDfkm.m6', 'ROLE_USER'),
  ('admin','$2a$10$SOM2NgjndVdYzGD/u9Iqg.2dGwuG8EXCx87eEMEk03VcZ8zOs8z3u','ROLE_ADMIN');

COMMIT;