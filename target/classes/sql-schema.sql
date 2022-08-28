CREATE SCHEMA IF NOT EXISTS `vet`;

USE `vet` ;

CREATE TABLE IF NOT EXISTS `vet`.`customer` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `last_name` VARCHAR(40) DEFAULT NULL,
    `email` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `vet`.`customer` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `last_name` VARCHAR(40) DEFAULT NULL,
    `email` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `vet`.`vet` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `last_name` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `vet`.`pet` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) DEFAULT NULL,
    `type` VARCHAR(40) DEFAULT NULL,
    `customer_id` INT(11) DEFAULT NULL,
    `dob` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `vet`.`appointment` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT(11),
    `pet_id` INT(11),
    `vet_id` INT(11),
    PRIMARY KEY (`id`)
);

INSERT INTO `vet`.`customer` (`first_name`, `last_name`, `email`) VALUES ('shai', 'lynch', 'slynch\"qa.com');
INSERT INTO `vet`.`pet` (`name`, `type`, `customerid`) VALUES ('Tom', 'tortoise', 1);