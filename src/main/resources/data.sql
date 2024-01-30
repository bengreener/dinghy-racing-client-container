insert into role (id, name) values (1, 'RACE_SCHEDULER');
insert into role (id, name) values (2, 'RACE_OFFICER');
insert into role (id, name) values (3, 'COMPETITOR');

insert into "user" (id, username, password) values (4, 'SS', '$2a$10$Gbp1XLmdhelQpMvC3J8heugmTWKVvfsy9UfKqpZ6nxzqM3ySG7evi'); -- password: ss
insert into "user" (id, username, password) values (5, 'RO', '$2a$10$oxGe8lZ4OR7kEAng8zgfYus9ofN6aU/iSq8tPiboNngVp9Vq1PdFG'); -- password: ro
insert into "user" (id, username, password) values (6, 'CO', '$2a$10$KO4dEs01J1wo/8tOBni0nuNFg8ZvRndf2uRY8OhQdCPdmgw0zh8x2'); -- password: co

insert into "user_roles" ("user_id", roles_id) values (4, 1);
insert into "user_roles" ("user_id", roles_id) values (4, 2);
insert into "user_roles" ("user_id", roles_id) values (5, 2);
insert into "user_roles" ("user_id", roles_id) values (6, 3);