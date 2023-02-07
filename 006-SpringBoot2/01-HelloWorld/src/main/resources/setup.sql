-- for testing mysql db and table set up
CREATE SCHEMA mydb1;

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(10) DEFAULT NULL,
  `points` int DEFAULT NULL,
  `createdon` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);

insert into mydb1.users (id, name, password, points, createdon) values (1, 'John', '123', 1200, now()-INTERVAL 1 DAY);
insert into mydb1.users (id, name, password, points, createdon) values (2, 'Amy', 'aaa', 800, now()-INTERVAL 3 DAY);
insert into mydb1.users (id, name, password, points, createdon) values (3, 'Tom', 'ccc', 800, now()-INTERVAL 10 DAY);
insert into mydb1.users (id, name, password, points, createdon) values (4, 'Lisa', '1qaz', 1511, now()-INTERVAL 20 DAY);