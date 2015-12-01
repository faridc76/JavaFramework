DROP DATABASE IF EXISTS `garage`;

CREATE DATABASE `garage`;

DROP TABLE IF EXISTS `garage`.`voiture`;

CREATE TABLE `garage`.`voiture`
(
	`id` INT NOT NULL AUTO_INCREMENT,
    `immatriculation` VARCHAR(30) NOT NULL,
    `modele` VARCHAR(30) NOT NULL,
    `anneeConstruction` INT NOT NULL,
    `km` INT NOT NULL,
    PRIMARY KEY (`id`)
);