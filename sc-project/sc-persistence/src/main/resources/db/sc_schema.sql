SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `sc` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `sc` ;

-- -----------------------------------------------------
-- Table `sc`.`countries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sc`.`countries` (
  `country_id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(10) NULL,
  `name` VARCHAR(30) NULL,
  PRIMARY KEY (`country_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sc`.`cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sc`.`cities` (
  `city_id` INT NOT NULL AUTO_INCREMENT,
  `country_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`city_id`),
  INDEX `fk_cities_countries_idx` (`country_id` ASC),
  CONSTRAINT `fk_cities_countries`
    FOREIGN KEY (`country_id`)
    REFERENCES `sc`.`countries` (`country_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sc`.`subway_stations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sc`.`subway_stations` (
  `subway_station_id` INT NOT NULL,
  `city_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`subway_station_id`),
  INDEX `fk_subwaystations_cities_idx` (`city_id` ASC),
  CONSTRAINT `fk_subwaystations_cities`
    FOREIGN KEY (`city_id`)
    REFERENCES `sc`.`cities` (`city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sc`.`addresses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sc`.`addresses` (
  `address_id` INT NOT NULL AUTO_INCREMENT,
  `city_id` INT NOT NULL,
  `subway_station_id` INT NOT NULL,
  `street` VARCHAR(45) NULL,
  `house` VARCHAR(45) NULL,
  `flat` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`address_id`),
  INDEX `fk_addresses_cities_idx` (`city_id` ASC),
  INDEX `fk_addresses_subway_stations_idx` (`subway_station_id` ASC),
  CONSTRAINT `fk_addresses_cities`
    FOREIGN KEY (`city_id`)
    REFERENCES `sc`.`cities` (`city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_addresses_subway_stations`
    FOREIGN KEY (`subway_station_id`)
    REFERENCES `sc`.`subway_stations` (`subway_station_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sc`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sc`.`users` (
  `user_id` INT NOT NULL,
  `user_name` VARCHAR(20) NULL,
  `email` VARCHAR(40) NULL,
  `password` VARCHAR(100) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `patronymic` VARCHAR(45) NULL,
  `birth_date` DATE NULL,
  `self_information` VARCHAR(5120) NULL,
  `address_id` INT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `fk_user_address_idx` (`address_id` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `login_UNIQUE` (`user_name` ASC),
  CONSTRAINT `fk_user_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `sc`.`addresses` (`address_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sc`.`faculties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sc`.`faculties` (
  `faculty_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`faculty_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sc`.`departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sc`.`departments` (
  `department_id` INT NOT NULL,
  `faculty_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`department_id`),
  INDEX `fk_department_faculty_idx` (`faculty_id` ASC),
  CONSTRAINT `fk_department_faculty`
    FOREIGN KEY (`faculty_id`)
    REFERENCES `sc`.`faculties` (`faculty_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sc`.`teachers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sc`.`teachers` (
  `teacher_id` INT NOT NULL,
  `department_id` INT NOT NULL,
  `position` VARCHAR(45) NULL,
  PRIMARY KEY (`teacher_id`),
  CONSTRAINT `fk_teacher_id`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `sc`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_teacher_department_id`
    FOREIGN KEY (`department_id`)
    REFERENCES `sc`.`departments` (`department_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sc`.`educations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sc`.`educations` (
  `education_id` INT NOT NULL,
  `education_level` TINYINT NOT NULL,
  `university_name` VARCHAR(255) NULL,
  `faculty` VARCHAR(255) NULL,
  `speciality` VARCHAR(255) NULL,
  `graduate_year` YEAR NULL,
  PRIMARY KEY (`education_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sc`.`teachers_educations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sc`.`teachers_educations` (
  `teacher_id` INT NOT NULL,
  `education_id` INT NOT NULL,
  INDEX `fk_users_educations_educations_idx` (`education_id` ASC),
  INDEX `fk_teachers_educations_users_idx` (`teacher_id` ASC),
  CONSTRAINT `fk_teachers_educations_users`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `sc`.`teachers` (`teacher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_teachers_educations_educations`
    FOREIGN KEY (`education_id`)
    REFERENCES `sc`.`educations` (`education_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sc`.`specialities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sc`.`specialities` (
  `speciality_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `description` VARCHAR(1024) NULL,
  PRIMARY KEY (`speciality_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sc`.`users_specialitites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sc`.`users_specialitites` (
  `user_id` INT NOT NULL,
  `speciality_id` INT NOT NULL,
  INDEX `fk_users_specialitites_users_idx` (`user_id` ASC),
  INDEX `fk_users_specialitites_specialities_idx` (`speciality_id` ASC),
  CONSTRAINT `fk_users_specialitites_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `sc`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_specialitites_specialities`
    FOREIGN KEY (`speciality_id`)
    REFERENCES `sc`.`specialities` (`speciality_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sc`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sc`.`user` (
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP);


-- -----------------------------------------------------
-- Table `sc`.`students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sc`.`students` (
  `student_id` INT NOT NULL,
  `start_year` YEAR NOT NULL,
  `graduation_year` YEAR NULL,
  PRIMARY KEY (`student_id`),
  CONSTRAINT `fk_student_id`
    FOREIGN KEY (`student_id`)
    REFERENCES `sc`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `sc`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `sc`;
INSERT INTO `sc`.`users` (`user_id`, `user_name`, `email`, `password`, `first_name`, `last_name`, `patronymic`, `birth_date`, `self_information`, `address_id`) VALUES (1, 'Ivan_ivanov', 'ivan.ivanov@gmail.com', '123', 'Ivan', 'Ivanov', NULL, '01.01.1995', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `sc`.`students`
-- -----------------------------------------------------
START TRANSACTION;
USE `sc`;
INSERT INTO `sc`.`students` (`student_id`, `start_year`, `graduation_year`) VALUES (1, 2014, 2019);

COMMIT;

