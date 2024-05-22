create table role (id bigint not null, name varchar(255), primary key (id)) engine=InnoDB;
create table role_seq (next_val bigint) engine=InnoDB;
insert into role_seq values ( 1 );
create table `user` (id bigint not null, password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
create table `user_roles` (roles_id bigint not null, `user_id` bigint not null) engine=InnoDB;
create table user_seq (next_val bigint) engine=InnoDB;
insert into user_seq values ( 1 );
alter table `user_roles` add constraint FKsoyrbfa9510yyn3n9as9pfcsx foreign key (roles_id) references role (id);
alter table `user_roles` add constraint FK40cm955hgg5oxf1oax8mqw0c4 foreign key (`user_id`) references `user` (id);
