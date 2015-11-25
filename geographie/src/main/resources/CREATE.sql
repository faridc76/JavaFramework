--
--  TP3 - Hibernate with Association
--
-- --------------------------------------
--
--  CHOUAKRIA Farid
--  HUANG Mincong
--
DROP DATABASE IF EXISTS `bdd_geographie`;
CREATE DATABASE `bdd_geographie` CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bdd_geographie`;
CREATE TABLE `bdd_geographie`.`pays`
(
	`id` INT NOT NULL AUTO_INCREMENT,
    `nom` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `superficie` FLOAT NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE TABLE `bdd_geographie`.`ville`
(
	`id` INT NOT NULL AUTO_INCREMENT,
    `nom` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `nb_habitants` INT NOT NULL,
    `id_pays` INT NOT NULL,
    PRIMARY KEY(`id`),
    CONSTRAINT `fk_ville_pays` FOREIGN KEY (`id_pays`)
	REFERENCES `pays`(`id`) ON DELETE CASCADE
) ENGINE = INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;
