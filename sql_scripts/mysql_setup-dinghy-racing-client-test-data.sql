-- v2024.5.2
USE dinghy_racing_client;

-- clear existing data
DELETE FROM `user`;
-- DELETE FROM role;
DELETE FROM `user_roles`;

-- create testing data
-- INSERT INTO role (id, name) VALUES (1, 'RACE_SCHEDULER');
-- INSERT INTO role (id, name) VALUES (2, 'RACE_OFFICER');
-- INSERT INTO role (id, name) VALUES (3, 'COMPETITOR');

INSERT INTO `user` (id, username, password) VALUES (1, 'SS', '$2a$10$Gbp1XLmdhelQpMvC3J8heugmTWKVvfsy9UfKqpZ6nxzqM3ySG7evi'); -- password: ss
INSERT INTO `user` (id, username, password) VALUES (2, 'RO', '$2a$10$oxGe8lZ4OR7kEAng8zgfYus9ofN6aU/iSq8tPiboNngVp9Vq1PdFG'); -- password: ro
INSERT INTO `user` (id, username, password) VALUES (3, 'CO', '$2a$10$KO4dEs01J1wo/8tOBni0nuNFg8ZvRndf2uRY8OhQdCPdmgw0zh8x2'); -- password: co

-- assign SS RACE_SCHEDULER
INSERT INTO `user_roles` (`user_id`, roles_id) VALUES (1, 1); 

-- assign SS RACE_OFFICER
-- INSERT INTO `user_roles` (`user_id`, roles_id) VALUES (1, 2);

-- assign RO RACE_OFFICER
INSERT INTO `user_roles` (`user_id`, roles_id) VALUES (2, 2);

-- assign CO COMPETITOR
INSERT INTO `user_roles` (`user_id`, roles_id) VALUES (3, 3);

UPDATE role_seq SET next_val = (SELECT MAX(id) + 50 FROM role);
UPDATE user_seq SET next_val = (SELECT MAX(id) + 50 FROM `user`);