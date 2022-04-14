create table a_role (id int8 generated by default as identity, name varchar(255), primary key (id));
create table a_user (id int8 generated by default as identity, email varchar(255), first_name varchar(50), language varchar(255), last_name varchar(50), password varchar(255), primary key (id));
create table a_user_role (id_user int8 not null, id_role int8 not null, primary key (id_user, id_role));
alter table if exists a_user_role add constraint FK5rlrlroylfqunj1n33ussqh3r foreign key (id_role) references a_role;
alter table if exists a_user_role add constraint FK6o6qk3v4ie2h4usomnt0egxm0 foreign key (id_user) references a_user;
