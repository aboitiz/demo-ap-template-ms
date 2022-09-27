-- liquibase formatted sql

-- changeset Carlo_Castro:1663810945461-1
CREATE TABLE users (id BIGINT AUTO_INCREMENT NOT NULL, address1 VARCHAR(100) NULL, address2 VARCHAR(100) NULL, inactive CHAR(1) NOT NULL, timestamp datetime NULL, username VARCHAR(50) NULL, CONSTRAINT PK_USERS PRIMARY KEY (id));

