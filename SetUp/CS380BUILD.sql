-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema 380Project
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema 380Project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `380Project` DEFAULT CHARACTER SET utf8 ;
USE `380Project` ;

-- -----------------------------------------------------
-- Table `380Project`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `380Project`.`users`;
CREATE TABLE IF NOT EXISTS `380Project`.`users` (
  `userID` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(30) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `380Project`.`userStats`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `380Project`.`userStats`;
CREATE TABLE IF NOT EXISTS `380Project`.`userStats` (
  `userIDStats` INT NOT NULL,
  `intelligence` INT NOT NULL,
  `strength` INT NOT NULL,
  `endurance` INT NOT NULL,
  `wisdom` INT NOT NULL,
  `vitality` INT NOT NULL,
  `skillpoints` INT NOT NULL,
  `exp` INT NOT NULL,
  PRIMARY KEY (`userIDStats`),
  CONSTRAINT `statsToUser`
    FOREIGN KEY (`userIDStats`)
    REFERENCES `380Project`.`users` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `380Project`.`categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `380Project`.`categories`;
CREATE TABLE IF NOT EXISTS `380Project`.`categories` (
  `categoryID` INT NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`categoryID`), 
  UNIQUE INDEX `categoryName_UNIQUE` (`categoryName` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `380Project`.`tasks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `380Project`.`tasks`;
CREATE TABLE IF NOT EXISTS `380Project`.`tasks` (
  `taskID` INT NOT NULL AUTO_INCREMENT,
  `expGained` INT NOT NULL,
  `taskName` VARCHAR(30) NOT NULL,
  `category` INT NOT NULL,
  PRIMARY KEY (`taskID`),
  UNIQUE INDEX `taskName_UNIQUE` (`taskName` ASC),
  INDEX `categoryToCat_idx` (`category` ASC) VISIBLE,
  CONSTRAINT `categoryToCat`
    FOREIGN KEY (`category`)
    REFERENCES `380Project`.`categories` (`categoryID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `380Project`.`userTasks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `380Project`.`userTasks`;
CREATE TABLE IF NOT EXISTS `380Project`.`userTasks` (
  `userIDTasks` INT NOT NULL,
  `taskID` INT NOT NULL,
  PRIMARY KEY (`userIDTasks`, 'taskID'),
  INDEX `userTasksToTasks_idx` (`taskID` ASC) VISIBLE,
  CONSTRAINT `userTasksToUser`
    FOREIGN KEY (`userIDTasks`)
    REFERENCES `380Project`.`users` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `userTasksToTasks`
    FOREIGN KEY (`taskID`)
    REFERENCES `380Project`.`tasks` (`taskID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- Insert initial data into the categories table with specific order
INSERT INTO `380Project`.`categories` (`categoryName`) VALUES
('INT'),
('STR'),
('END'),
('WIS'),
('VIT');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;