# Users schema
 
# --- !Ups
 
CREATE TABLE User (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    fullname varchar(255) NOT NULL,
    isAdmin boolean NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO User VALUES (1, 'User1@example.com', 'password', 'User1', true);
INSERT INTO User VALUES (2, 'User2@example.com', 'password', 'User2', false);
INSERT INTO User VALUES (3, 'User3@example.com', 'password', 'User3', false);
 
# --- !Downs
 
DROP TABLE User;
