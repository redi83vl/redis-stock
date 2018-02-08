-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema redis-stock
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema redis-stock
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `redis-stock` DEFAULT CHARACTER SET utf8 ;
USE `redis-stock` ;

-- -----------------------------------------------------
-- Table `redis-stock`.`Warehouse`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redis-stock`.`Warehouse` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(16) NOT NULL,
  `name` VARCHAR(256) NOT NULL,
  `address` VARCHAR(256) NOT NULL,
  `phone` VARCHAR(256) NOT NULL,
  `email` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `redis-stock`.`Supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redis-stock`.`Supplier` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(16) NOT NULL,
  `name` VARCHAR(256) NOT NULL,
  `address` VARCHAR(256) NOT NULL,
  `phone` VARCHAR(256) NOT NULL,
  `email` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `redis-stock`.`Consumer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redis-stock`.`Consumer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(16) NOT NULL,
  `name` VARCHAR(256) NOT NULL,
  `address` VARCHAR(256) NOT NULL,
  `phone` VARCHAR(256) NOT NULL,
  `email` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `redis-stock`.`Buyin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redis-stock`.`Buyin` (
  `id` INT NOT NULL,
  `code` VARCHAR(16) NOT NULL,
  `instant` DATETIME NOT NULL,
  `source` INT NOT NULL,
  `target` INT NOT NULL,
  `description` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC),
  INDEX `fk_buyin_supplier_idx` (`source` ASC),
  INDEX `fk_buyin_warehouse_idx` (`target` ASC),
  CONSTRAINT `fk_buyin_source`
    FOREIGN KEY (`source`)
    REFERENCES `redis-stock`.`Supplier` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_buyin_target`
    FOREIGN KEY (`target`)
    REFERENCES `redis-stock`.`Warehouse` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `redis-stock`.`Sellout`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redis-stock`.`Sellout` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(16) NOT NULL,
  `instant` DATETIME NOT NULL,
  `source` INT NOT NULL,
  `target` INT NOT NULL,
  `description` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_output_target_idx` (`target` ASC),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC),
  CONSTRAINT `fk_sellout_source`
    FOREIGN KEY (`source`)
    REFERENCES `redis-stock`.`Warehouse` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_sellout_target`
    FOREIGN KEY (`target`)
    REFERENCES `redis-stock`.`Consumer` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `redis-stock`.`Transfer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redis-stock`.`Transfer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(16) NOT NULL,
  `instant` DATETIME NOT NULL,
  `source` INT NOT NULL,
  `target` INT NOT NULL,
  `description` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_transfer_source_idx` (`source` ASC),
  INDEX `fk_transfer_target_idx` (`target` ASC),
  UNIQUE INDEX `code_UNIQUE` (`code` ASC),
  CONSTRAINT `fk_transfer_source`
    FOREIGN KEY (`source`)
    REFERENCES `redis-stock`.`Warehouse` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_transfer_target`
    FOREIGN KEY (`target`)
    REFERENCES `redis-stock`.`Warehouse` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `redis-stock`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redis-stock`.`Product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(16) NOT NULL,
  `group` VARCHAR(256) NOT NULL,
  `name` VARCHAR(256) NOT NULL,
  `unit` VARCHAR(256) NOT NULL,
  `cost` DOUBLE NOT NULL,
  `buy` DOUBLE NOT NULL,
  `sell` DOUBLE NOT NULL,
  `vat` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `redis-stock`.`BuyinProduct`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redis-stock`.`BuyinProduct` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `buyin` INT NOT NULL,
  `product` INT NOT NULL,
  `size` DOUBLE NOT NULL,
  `cost` DOUBLE NOT NULL,
  `price` DOUBLE NOT NULL,
  `tax` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_inputitem_parent_idx` (`buyin` ASC),
  INDEX `fk_inputitem_item_idx` (`product` ASC),
  CONSTRAINT `fk_buyinproduct_buyin`
    FOREIGN KEY (`buyin`)
    REFERENCES `redis-stock`.`Buyin` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_buyinproduct_product`
    FOREIGN KEY (`product`)
    REFERENCES `redis-stock`.`Product` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `redis-stock`.`SelloutProduct`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redis-stock`.`SelloutProduct` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sellout` INT NOT NULL,
  `product` INT NOT NULL,
  `size` DOUBLE NOT NULL,
  `cost` DOUBLE NOT NULL,
  `price` DOUBLE NOT NULL,
  `tax` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_outputitem_parent_idx` (`sellout` ASC),
  INDEX `fk_outputitem_item_idx` (`product` ASC),
  CONSTRAINT `fk_outputitem_parent`
    FOREIGN KEY (`sellout`)
    REFERENCES `redis-stock`.`Sellout` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_outputitem_item`
    FOREIGN KEY (`product`)
    REFERENCES `redis-stock`.`Product` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `redis-stock`.`TransferProduct`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `redis-stock`.`TransferProduct` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `transfer` INT NOT NULL,
  `product` INT NOT NULL,
  `size` DOUBLE NOT NULL,
  `cost` DOUBLE NOT NULL,
  `price` DOUBLE NOT NULL,
  `tax` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_transfer_parent_idx` (`transfer` ASC),
  INDEX `fk_transferitem_item_idx` (`product` ASC),
  CONSTRAINT `fk_transferitem_parent`
    FOREIGN KEY (`transfer`)
    REFERENCES `redis-stock`.`Transfer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_transferitem_item`
    FOREIGN KEY (`product`)
    REFERENCES `redis-stock`.`Product` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;

CREATE USER 'admin' IDENTIFIED BY 'admin';

GRANT ALL ON `redis-stock`.* TO 'admin';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
