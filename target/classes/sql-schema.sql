CREATE SCHEMA IF NOT EXISTS `qacinema`;

USE `qacinema` ;

CREATE TABLE IF NOT EXISTS `qacinema`.`customer` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `last_name` VARCHAR(40) DEFAULT NULL,
    `email` VARCHAR(40) DEFAULT NULL,
    `mobile` VARCHAR(40) DEFAULT NULL,
    `dob` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `qacinema`.`movie` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(40) DEFAULT NULL,
    `runtime` int(4) DEFAULT NULL,
    `cast` VARCHAR(1000) DEFAULT NULL,
    `release_date` VARCHAR(10) DEFAULT NULL,
    `age_rating` VARCHAR(40) DEFAULT NULL,
    `description` VARCHAR(500) DEFAULT NULL,
    `poster_url` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `qacinema`.`screen` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `capacity` int(4) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `qacinema`.`viewing` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `screen_id` INT(11) NOT NULL,
    `movie_id` INT(11) NOT NULL,
    `start_time` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`id`)
);



CREATE TABLE IF NOT EXISTS `qacinema`.`booking` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT(11) NOT NULL,
    `viewing_id` INT(11) NOT NULL,
    `booking_date` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`id`)
);
