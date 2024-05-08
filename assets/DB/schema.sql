
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SSAFIT
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SSAFIT` DEFAULT CHARACTER SET utf8 ;
USE `SSAFIT` ;

-- -----------------------------------------------------
-- Table `SSAFIT`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SSAFIT`.`User` (
  `user_id` VARCHAR(20) NOT NULL,
  `user_password` VARCHAR(20) NOT NULL,
  `user_name` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSAFIT`.`Manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SSAFIT`.`Manager` (
  `manager_id` VARCHAR(20) NOT NULL,
  `manager_password` VARCHAR(20) NOT NULL,
  `manager_name` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`manager_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSAFIT`.`Club`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SSAFIT`.`Club` (
  `club_id` INT NOT NULL AUTO_INCREMENT,
  `club_name` VARCHAR(45) NOT NULL,
  `club_discription` VARCHAR(200) NOT NULL,
  `manager_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`club_id`),
  CONSTRAINT `fk_Club_Manager`
    FOREIGN KEY (`manager_id`)
    REFERENCES `SSAFIT`.`Manager` (`manager_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSAFIT`.`Club_board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SSAFIT`.`Club_board` (
  `board_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `writer_id` VARCHAR(20) NOT NULL,
  `writer_name` VARCHAR(10) NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `view_cnt` INT NOT NULL,
  `content` TEXT NOT NULL,
  `writer_type` VARCHAR(10) NOT NULL,
  `club_id` INT NOT NULL,
  PRIMARY KEY (`board_id`),
  CONSTRAINT `fk_Club_board_Club`
    FOREIGN KEY (`club_id`)
    REFERENCES `SSAFIT`.`Club` (`club_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSAFIT`.`Board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SSAFIT`.`Board` (
  `board_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `writer_id` VARCHAR(20) NOT NULL,
  `writer_name` VARCHAR(10) NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `view_cnt` INT NOT NULL,
  `content` TEXT NOT NULL,
  PRIMARY KEY (`board_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSAFIT`.`Member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SSAFIT`.`Member` (
  `user_id` VARCHAR(20) NOT NULL,
  `club_id` INT NOT NULL,
  `access` TINYINT NOT NULL,
  PRIMARY KEY (`user_id`, `club_id`),
  CONSTRAINT `fk_Member_User`
    FOREIGN KEY (`user_id`)
    REFERENCES `SSAFIT`.`User` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Member_Club`
    FOREIGN KEY (`club_id`)
    REFERENCES `SSAFIT`.`Club` (`club_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSAFIT`.`User_schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SSAFIT`.`User_schedule` (
  `schedule_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `schedule` DATETIME NOT NULL,
  PRIMARY KEY (`schedule_id`),
  CONSTRAINT `fk_User_schedule_User`
    FOREIGN KEY (`user_id`)
    REFERENCES `SSAFIT`.`User` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSAFIT`.`Club_schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SSAFIT`.`Club_schedule` (
  `schedule_id` INT NOT NULL AUTO_INCREMENT,
  `schedule` DATETIME NOT NULL,
  `club_id` INT NOT NULL,
  PRIMARY KEY (`schedule_id`),
  CONSTRAINT `fk_Club_schedule_Club`
    FOREIGN KEY (`club_id`)
    REFERENCES `SSAFIT`.`Club` (`club_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
