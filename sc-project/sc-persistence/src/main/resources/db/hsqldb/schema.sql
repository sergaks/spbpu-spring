CREATE SCHEMA sc DEFAULT CHARACTER SET utf8;


CREATE TABLE countries (
  country_id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
  code VARCHAR(10) NULL,
  name VARCHAR(30) NULL,
  PRIMARY KEY (country_id));


CREATE TABLE cities (
  city_id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
  country_id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (city_id));

  
CREATE TABLE subway_stations (
  subway_station_id INT NOT NULL,
  city_id INT NOT NULL,
  name VARCHAR(45) NULL,
  PRIMARY KEY (subway_station_id));

  
CREATE TABLE addresses (
  address_id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
  city_id INT NOT NULL,
  subway_station_id INT NOT NULL,
  street VARCHAR(45) NULL,
  house VARCHAR(45) NULL,
  flat VARCHAR(45) NULL,
  description VARCHAR(255) NULL,
  PRIMARY KEY (address_id));


CREATE TABLE users (
  user_id INT NOT NULL,
  user_name VARCHAR(20) NULL,
  email VARCHAR(40) NULL,
  password VARCHAR(100) NULL,
  first_name VARCHAR(45) NULL,
  last_name VARCHAR(45) NULL,
  patronymic VARCHAR(45) NULL,
  birth_date DATE NULL,
  self_information VARCHAR(5120) NULL,
  address_id INT NULL,
  PRIMARY KEY (user_id));


CREATE TABLE faculties (
  faculty_id INT NOT NULL,
  name VARCHAR(45) NULL,
  PRIMARY KEY (faculty_id));

CREATE TABLE departments (
  department_id INT NOT NULL,
  faculty_id INT NOT NULL,
  name VARCHAR(45) NULL,
  PRIMARY KEY (department_id));


CREATE TABLE teachers (
  teacher_id INT NOT NULL,
  department_id INT,
  position VARCHAR(45) NULL,
  PRIMARY KEY (teacher_id));


-- -----------------------------------------------------
-- Table educations
-- -----------------------------------------------------
CREATE TABLE educations (
  education_id INT NOT NULL,
  education_level TINYINT NOT NULL,
  university_name VARCHAR(255) NULL,
  faculty VARCHAR(255) NULL,
  speciality VARCHAR(255) NULL,
  graduate_year INT NULL,
  PRIMARY KEY (education_id));


-- -----------------------------------------------------
-- Table teachers_educations
-- -----------------------------------------------------
CREATE TABLE teachers_educations (
  teacher_id INT NOT NULL,
  education_id INT NOT NULL);

CREATE TABLE specialities (
  speciality_id INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
  name VARCHAR(100) NULL,
  description VARCHAR(1024) NULL,
  PRIMARY KEY (speciality_id));


CREATE TABLE users_specialitites (
  user_id INT NOT NULL,
  speciality_id INT NOT NULL);

CREATE TABLE students (
  student_id INT NOT NULL,
  start_year INT NOT NULL,
  graduation_year INT NULL,
  PRIMARY KEY (student_id));
