USE dinghy_racing_client;

-- clear existing data
DELETE FROM `user`;

-- create testing data
insert into `user` (id, username, password) values (1, 'OOD', '$2a$10$c7iYFL4UuomBGM0a4V8po.kFcNQ175H9y1r8VeiRzq4.xdQonyg.u'); -- password: ood