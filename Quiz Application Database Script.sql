---- This will create new root user is not exists ---
CREATE USER 'root'@'localhost' IDENTIFIED BY 'root';

GRANT ALL PRIVILEGES ON * . * TO 'root'@'localhost';


----- Create database command -----
CREATE DATABASE test

----- Create tables --------------
USE test

CREATE TABLE quiz
(
	id 			INT(11) PRIMARY KEY AUTO_INCREMENT,
	question 	VARCHAR(50),
	option1 	VARCHAR(50),
	option2 	VARCHAR(50),
	option3 	VARCHAR(50),
	option4 	VARCHAR(50),
	answer 		VARCHAR(50)
)


CREATE TABLE quizuserregister
(
	registerid	INT(11) PRIMARY KEY AUTO_INCREMENT,
	firstName 	VARCHAR(50),
	lastName 	VARCHAR(50),
	UserName	VARCHAR(50),
	password 	VARCHAR(50),
)

