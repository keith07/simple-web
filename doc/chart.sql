CREATE TABLE `actor_log` (
	`SID` INT NOT NULL AUTO_INCREMENT,
	`ACTOR` VARCHAR (24) NOT NULL,
	`ACTION` VARCHAR (24) NOT NULL,
	`ACTION_TIME` DATETIME NOT NULL,
	PRIMARY KEY (`SID`)
)AUTO_INCREMENT=0;


INSERT INTO actor_log(actor,ACTION,action_time) VALUES('keith','login','2014-07-03 11:20:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('keith','query','2014-07-03 11:25:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('keith','logout','2014-07-03 12:20:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('keith','login','2014-07-03 12:22:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('keith','query','2014-07-03 12:24:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('keith','add','2014-07-03 12:30:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('keith','update','2014-07-03 13:20:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('keith','delete','2014-07-03 13:20:55');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('keith','query','2014-07-03 13:25:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('keith','add','2014-07-03 13:30:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('keith','update','2014-07-03 13:33:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('keith','delete','2014-07-03 13:35:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('keith','logout','2014-07-03 13:40:45');

INSERT INTO actor_log(actor,ACTION,action_time) VALUES('bottle','login','2014-07-03 11:20:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('bottle','query','2014-07-03 11:25:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('bottle','logout','2014-07-03 12:20:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('bottle','login','2014-07-03 12:22:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('bottle','query','2014-07-03 12:24:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('bottle','add','2014-07-03 12:30:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('bottle','update','2014-07-03 13:20:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('bottle','delete','2014-07-03 13:20:55');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('bottle','query','2014-07-03 13:25:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('bottle','add','2014-07-03 13:30:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('bottle','update','2014-07-03 13:33:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('bottle','delete','2014-07-03 13:35:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('bottle','logout','2014-07-03 13:40:45');

INSERT INTO actor_log(actor,ACTION,action_time) VALUES('any','login','2014-07-03 11:20:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('any','query','2014-07-03 11:25:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('any','logout','2014-07-03 12:20:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('any','login','2014-07-03 12:22:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('any','query','2014-07-03 12:24:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('any','add','2014-07-03 12:30:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('any','update','2014-07-03 13:20:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('any','delete','2014-07-03 13:20:55');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('any','query','2014-07-03 13:25:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('any','add','2014-07-03 13:30:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('any','update','2014-07-03 13:33:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('any','delete','2014-07-03 13:35:45');
INSERT INTO actor_log(actor,ACTION,action_time) VALUES('any','logout','2014-07-03 13:40:45');
