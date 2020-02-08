BEGIN;
insert into reference
  (email, firstName, lastName, password, ts, username)
values
  ('test1@test.com', 'test1_firstName', 'test1_lastName', 'pass1', '2019-01-25', 'test1'),
  ('test2@test.com', 'test2_firstName', 'test2_lastName', 'pass2', '2019-01-25', 'test2'),
  ('test3@test.com', 'test3_firstName', 'test3_lastName', 'pass3', '2019-01-25', 'test3');

insert into
  users (username, password, authority, enabled)
values
  ('user','$2a$10$Z00qRR286FPYsfNe6a/Ehezhpgi00UGLWVD8CEVh13jQ2WDfkm.m6', 'ROLE_USER', true),
  ('admin','$2a$10$SOM2NgjndVdYzGD/u9Iqg.2dGwuG8EXCx87eEMEk03VcZ8zOs8z3u','ROLE_ADMIN', true);

COMMIT;