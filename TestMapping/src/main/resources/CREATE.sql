--
-- Script for database creation
--
-- Author: m.huang.11, f.chouakria.13
-- Date: 2015.11.25
--
CREATE DATABASE IF NOT EXISTS `client`;

CREATE TABLE IF NOT EXISTS `client`.`personne` (
	`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
	`nom` varchar(45) NOT NULL,
	`prenom` varchar(45) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;