DROP database MarketDB;

CREATE database MarketDB;
USE MarketDB;

CREATE TABLE Users (
	id INT NOT NULL AUTO_INCREMENT ,
	username VARCHAR(45) NOT NULL,
	password VARCHAR(100) NOT NULL,
	enabled TINYINT NOT NULL DEFAULT 1 ,
 	name VARCHAR(100),
	email VARCHAR(100),
	phoneNumber VARCHAR(20),
	PRIMARY KEY (id)	
) TYPE = InnoDB, CHARACTER SET=UTF8;

CREATE TABLE UserRoles (
  userRoleId INT NOT NULL AUTO_INCREMENT,
  userId INT,
  username VARCHAR(45) NOT NULL,
  role VARCHAR(45) NOT NULL,
  PRIMARY KEY (userRoleId),
 FOREIGN KEY (userId) REFERENCES Users (id))TYPE = InnoDB, CHARACTER SET=UTF8;

CREATE TABLE Products (
	id INT AUTO_INCREMENT NOT NULL,
	title VARCHAR(100),
	description VARCHAR(100),
	price INT,
	userId INT,
	PRIMARY KEY (id),
	FOREIGN KEY (userId) REFERENCES Users(id)
) TYPE = InnoDB, CHARACTER SET=UTF8;

CREATE TABLE UserAccounts (
	id INT AUTO_INCREMENT NOT NULL,
	userId INT,
	fund INT DEFAULT 0,
	PRIMARY KEY (id),
	FOREIGN KEY (userId) REFERENCES Users(id)
) TYPE = InnoDB, CHARACTER SET=UTF8;

INSERT INTO Users(username, password, name, email, phoneNumber) VALUES ("admin", "adminpassword", "kate", "ttt@gmail.com", "1234");
INSERT INTO Users(username, password, name, email, phoneNumber) VALUES ("user", "userpassword", "Masha", "masha@gmail.com", "4321");

INSERT INTO UserRoles(userId, username, role) VALUES ("1", "admin", "ROLE_ADMIN");
INSERT INTO UserRoles(userId, username, role) VALUES ("1", "admin", "ROLE_USER");
INSERT INTO UserRoles(userId, username, role) VALUES ("2", "user", "ROLE_USER");

INSERT INTO Products(title, description, price, userId) VALUES ("candy", "sweet", 12, 1);

INSERT INTO UserAccounts(userId) VALUES (1);
INSERT INTO UserAccounts(userId) VALUES (2);


