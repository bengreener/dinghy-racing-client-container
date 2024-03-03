-- v2024.3.1
CREATE DATABASE `dinghy_racing_client` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE dinghy_racing_client;

CREATE TABLE hibernate_sequence (
	next_val BIGINT
) engine=InnoDB;
INSERT INTO hibernate_sequence VALUES ( 1 );

CREATE TABLE `user` (
	id BIGINT NOT NULL, 
	username VARCHAR(255) NOT NULL,
    password CHAR(60) NOT NULL,
    CONSTRAINT PK_user_id PRIMARY KEY (id)
) engine=InnoDB;

CREATE TABLE role (
	id BIGINT NOT NULL, 
    name VARCHAR(255) NOT NULL,
    CONSTRAINT PK_role_id PRIMARY KEY (id)
) engine=InnoDB;

CREATE TABLE `user_roles` (
	`user_id` BIGINT NOT NULL,
    roles_id BIGINT NOT NULL,
    CONSTRAINT PK_user_roles_user_id_roles_id PRIMARY KEY (user_id, roles_id)
) engine=InnoDB;

-- insert required roles
INSERT INTO role (id, name) VALUES (1, 'RACE_SCHEDULER');
INSERT INTO role (id, name) VALUES (2, 'RACE_OFFICER');
INSERT INTO role (id, name) VALUES (3, 'COMPETITOR');

UPDATE hibernate_sequence SET next_val = 4;