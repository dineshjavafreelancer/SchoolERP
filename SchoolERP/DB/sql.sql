CREATE DATABASE `schoolerp`; 
USE `schoolerp`; 

CREATE TABLE `schoolerp`.`student`( `id` INT(10) NOT NULL, `name` VARCHAR(45), `father_name` VARCHAR(45), PRIMARY KEY (`id`) );

CREATE TABLE `schoolerp`.`ids_keeper`( `id` INT(10) NOT NULL, `id_type` VARCHAR(45), `LAST_VALUE_GENERATED` INT(10), PRIMARY KEY (`id`) );

INSERT INTO `schoolerp`.`ids_keeper` (`id`, `id_type`, `LAST_VALUE_GENERATED`) VALUES ('1', 'STUDENT_ID', '0'); 

UPDATE `schoolerp`.`ids_keeper` SET `LAST_VALUE_GENERATED` = '1' WHERE `id` = '1'; 

CREATE TABLE `schoolerp`.`erp_users` (
  `ID` INT NOT NULL,
  `USERNAME` VARCHAR(45) NULL,
  `PASSWORD` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`));
INSERT INTO `schoolerp`.`erp_users` (`ID`, `USERNAME`, `PASSWORD`) VALUES ('1', 'admin@erp.com', 'admin');

commit;
