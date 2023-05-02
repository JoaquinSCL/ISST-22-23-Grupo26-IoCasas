insert into users(username, password, enabled) values ('prop1@email.com', '{noop}prop1', true);
insert into authorities(username, authority) values ('prop1@email.com','ROLE_PROP');

insert into users(username, password, enabled) values ('admin1@email.com', '{noop}admin1', true);
insert into authorities(username, authority) values ('admin1@email.com','ROLE_ADMIN');

insert into users(username, password, enabled) values ('prop2@email.com', '{noop}prop2', true);
insert into authorities(username, authority) values ('prop2@email.com','ROLE_PROP');

insert into users(username, password, enabled) values ('inq1@email.com', '{noop}inq1', true);
insert into authorities(username, authority) values ('inq1@email.com','ROLE_INQ');