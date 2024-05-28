-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

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
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `380Project`.`levels`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `380Project`.`levels`;
CREATE TABLE IF NOT EXISTS `380Project`.`levels` (
  `level` INT NOT NULL,
  `expThreshold` INT NOT NULL,
  `skillPointsAwarded` INT NOT NULL,
  PRIMARY KEY (`level`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `380Project`.`userStats`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `380Project`.`userStats`;
CREATE TABLE IF NOT EXISTS `380Project`.`userStats` (
  `userIDStats` INT NOT NULL,
  `level` INT NOT NULL,
  `intelligence` INT NOT NULL,
  `strength` INT NOT NULL,
  `endurance` INT NOT NULL,
  `wisdom` INT NOT NULL,
  `vitality` INT NOT NULL,
  `skillpoints` INT NOT NULL,
  `exp` INT NOT NULL,
  PRIMARY KEY (`userIDStats`),
  INDEX `statsToLevels_idx` (`level` ASC),
  CONSTRAINT `statsToUser`
    FOREIGN KEY (`userIDStats`)
    REFERENCES `380Project`.`users` (`userID`),
  CONSTRAINT `statsToLevels`
    FOREIGN KEY (`level`)
    REFERENCES `380Project`.`levels` (`level`)
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
  INDEX `categoryToCat_idx` (`category` ASC),
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
  PRIMARY KEY (`userIDTasks`, `taskID`),
  INDEX `userTasksToTasks_idx` (`taskID` ASC),
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

-- Insert example values into users, userStats, tasks, and userTasks
-- Insert test data into the users table
INSERT INTO `380Project`.`users` (`userName`, `password`, `email`) VALUES
('Alice', 'password123', 'alice@example.com'),
('Bob', 'password123', 'bob@example.com'),
('Charlie', 'password123', 'charlie@example.com'),
('David', 'password123', 'david@example.com'),
('Eve', 'password123', 'eve@example.com');

-- Insert test data into the userStats table
INSERT INTO `380Project`.`userStats` (`userIDStats`, `level`, `intelligence`, `strength`, `endurance`, `wisdom`, `vitality`, `skillpoints`, `exp`) VALUES
(1, 1, 10, 15, 12, 14, 13, 5, 90),
(2, 1, 12, 14, 13, 15, 10, 6, 90),
(3, 1, 14, 12, 10, 13, 15, 4, 90),
(4, 1, 15, 10, 14, 12, 12, 7, 90),
(5, 1, 13, 13, 15, 10, 14, 3, 90);

-- Insert test data into the tasks table
INSERT INTO `380Project`.`tasks` (`expGained`, `taskName`, `category`) VALUES
(50, 'Complete Module 1', 1),
(60, 'Run 5 miles', 2),
(40, 'Meditate for 20 minutes', 4),
(70, 'Lift weights', 2),
(30, 'Read a book', 1),
(50, 'Cook a healthy meal', 5);

-- Insert test data into the userTasks table
INSERT INTO `380Project`.`userTasks` (`userIDTasks`, `taskID`) VALUES
(1, 1),
(1, 3),
(2, 2),
(2, 5),
(3, 1),
(3, 6),
(4, 2),
(4, 4),
(5, 3),
(5, 5);

-- Insert test data into the levels table
INSERT INTO `380Project`.`levels` (`level`, `expThreshold`, `skillPointsAwarded`) VALUES
(1, 0, 0),
(2, 100, 3),
(3, 300, 3),
(4, 500, 3),
(5, 750, 3);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
