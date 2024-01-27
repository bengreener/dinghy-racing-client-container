USE dinghy_racing_client;

CREATE TABLE hibernate_sequence (
	next_val BIGINT
) engine=InnoDB;
INSERT INTO hibernate_sequence VALUES ( 1 );

CREATE TABLE `user` (
	id BIGINT NOT NULL, 
	username VARCHAR(255) NOT NULL,
    password CHAR(60) NOT NULL
) engine=InnoDB;

CREATE TABLE role (
	id BIGINT NOT NULL, 
    name VARCHAR(255) NOT NULL
) engine=InnoDB;

CREATE TABLE `user_roles` (
	`user_id` BIGINT NOT NULL,
    roles_id BIGINT NOT NULL
) engine=InnoDB;