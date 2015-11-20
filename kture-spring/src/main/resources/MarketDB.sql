DROP database MarketDB;

CREATE database MarketDB;
USE MarketDB;

CREATE TABLE Users (
	id INT AUTO_INCREMENT NOT NULL,
	name VARCHAR(100),
	email VARCHAR(100),
	phoneNumber VARCHAR(20),
	PRIMARY KEY (id)	
) TYPE = InnoDB, CHARACTER SET=UTF8;

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

INSERT INTO Users(name, email, phoneNumber) VALUES ("kate", "ttt@gmail.com", "lklk");
INSERT INTO Users(name, email, phoneNumber) VALUES ("kate", "main@gmail.com", "2486");
INSERT INTO Users(name, email, phoneNumber) VALUES ("masha", "mash@gmail.com", "911");

INSERT INTO Products(title, description, price, userId) VALUES ("candy", "sweet", 12, 1);

INSERT INTO UserAccounts(userId) VALUES (1);
INSERT INTO UserAccounts(userId) VALUES (2);
INSERT INTO UserAccounts(userId) VALUES (3);


