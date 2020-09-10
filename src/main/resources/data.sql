INSERT INTO `ip_role` VALUES (1,'admin'),(2,'employee');

INSERT INTO `ip_user`
(id, email, password, status, username)
VALUES(1, 'quanph@info.com', '$2a$10$VRMX8QepXjy649qQIYh.Tu6DN50zB5mxfRuNz.8inTpPIYL67y89q', 1, 'quanph');


INSERT INTO `ip_user_role` VALUES (1,1);


INSERT INTO `ip_contract` VALUES (1,'admin','2019-11-18 10:47:55','NH BANK'),(2,'admin','2019-11-18 10:49:55','Woori Bank');



