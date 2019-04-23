drop table user if exists;

drop sequence if exists user_seq;

create sequence user_seq start with 1 increment by 50;

create table user (id bigint not null, street varchar(255), house_number varchar(255), city varchar(255), country varchar(255), state varchar(255), zip_code varchar(255), email varchar(255) not null, first_name varchar(255), last_name varchar(255), middle_name varchar(255), primary key (id));

alter table user add constraint UK_user_email unique (email);

insert into user (street, house_number, city, country, state, zip_code, email, first_name, last_name, middle_name, id) values ('addressLine1', 'addressLine2', 'city', 'country', 'state', 'zipCode', 'test@test.com', 'firstName', 'lastName', 'middleName', 1);
