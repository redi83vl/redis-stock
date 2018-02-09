CREATE SCHEMA IF NOT EXISTS `redis-stock`;
USE `redis-stock` ;

CREATE TABLE IF NOT EXISTS `Warehouse` (
	`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`code` VARCHAR(16) NOT NULL UNIQUE,
	`name` VARCHAR(256) NOT NULL DEFAULT '',
	`address` VARCHAR(256) NOT NULL DEFAULT '',
	`phone` VARCHAR(256) NOT NULL DEFAULT '',
	`email` VARCHAR(256) NOT NULL DEFAULT ''
);

CREATE TABLE IF NOT EXISTS `Supplier` (
	`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`code` VARCHAR(16) NOT NULL UNIQUE,
	`name` VARCHAR(256) NOT NULL DEFAULT '',
	`address` VARCHAR(256) NOT NULL DEFAULT '',
	`phone` VARCHAR(256) NOT NULL DEFAULT '',
	`email` VARCHAR(256) NOT NULL DEFAULT ''
);

CREATE TABLE IF NOT EXISTS `Consumer` (
	`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`code` VARCHAR(16) NOT NULL UNIQUE,
	`name` VARCHAR(256) NOT NULL DEFAULT '',
	`address` VARCHAR(256) NOT NULL DEFAULT '',
	`phone` VARCHAR(256) NOT NULL DEFAULT '',
	`email` VARCHAR(256) NOT NULL DEFAULT ''
);

CREATE TABLE IF NOT EXISTS `Product` (
	`id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`code` VARCHAR(16) NOT NULL UNIQUE,
	`group` VARCHAR(256) NOT NULL DEFAULT '',
	`name` VARCHAR(256) NOT NULL DEFAULT '',
	`unit` VARCHAR(256) NOT NULL DEFAULT '',
	`cost` DOUBLE NOT NULL DEFAULT 0,
	`buy` DOUBLE NOT NULL DEFAULT 0,
	`sell` DOUBLE NOT NULL DEFAULT 0,
	`vat` DOUBLE NOT NULL DEFAULT 0
);