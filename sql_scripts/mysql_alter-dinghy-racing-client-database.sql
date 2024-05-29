-- to v2024.5.2
USE dinghy_racing_client;

DROP TABLE hibernate_sequence;

CREATE TABLE role_seq (
	next_val bigint
) engine=InnoDB;
INSERT INTO role_seq VALUES ( 1 );

CREATE TABLE user_seq (
	next_val bigint
) engine=InnoDB;
INSERT INTO user_seq VALUES ( 1 );

UPDATE user_seq SET next_val = (SELECT MAX(id) + 50 FROM `user`);

UPDATE role_seq SET next_val = (SELECT MAX(id) + 50 FROM role);