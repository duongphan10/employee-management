CREATE DATABASE  IF NOT EXISTS `employee_management` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `employee_management`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: employee_management
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `certificates`
--

DROP TABLE IF EXISTS certificates;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE certificates (
  id int NOT NULL AUTO_INCREMENT,
  employee_profile_id int NOT NULL,
  `name` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  issued_date datetime NOT NULL,
  issued_location varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  field varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  effective_date datetime DEFAULT NULL,
  PRIMARY KEY (id),
  KEY employee_profile_id (employee_profile_id),
  CONSTRAINT certificates_ibfk_1 FOREIGN KEY (employee_profile_id) REFERENCES employeeprofiles (id)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS departments;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE departments (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employeeprofiles`
--

DROP TABLE IF EXISTS employeeprofiles;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE employeeprofiles (
  id int NOT NULL AUTO_INCREMENT,
  full_name varchar(50) COLLATE utf8mb3_unicode_ci NOT NULL,
  `code` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  gender bit(1) NOT NULL,
  birthday datetime NOT NULL,
  hometown varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  ethnicity varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  religion varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  nationality varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  address varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  team int NOT NULL,
  image varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  id_card_number varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  id_card_issued_date datetime NOT NULL,
  id_card_issued_location varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  phone_number varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  email varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  salary int NOT NULL,
  salary_level int NOT NULL,
  created_by int NOT NULL,
  department_id int NOT NULL,
  position_id int NOT NULL,
  status_id int NOT NULL,
  PRIMARY KEY (id),
  KEY department_id (department_id),
  KEY position_id (position_id),
  KEY status_id (status_id),
  CONSTRAINT employeeprofiles_ibfk_1 FOREIGN KEY (department_id) REFERENCES departments (id),
  CONSTRAINT employeeprofiles_ibfk_2 FOREIGN KEY (position_id) REFERENCES positions (id),
  CONSTRAINT employeeprofiles_ibfk_3 FOREIGN KEY (status_id) REFERENCES `status` (id)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `familyrelationships`
--

DROP TABLE IF EXISTS familyrelationships;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE familyrelationships (
  id int NOT NULL AUTO_INCREMENT,
  employee_profile_id int NOT NULL,
  full_name varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  gender bit(1) NOT NULL,
  birthday datetime NOT NULL,
  id_card_number varchar(50) COLLATE utf8mb3_unicode_ci NOT NULL,
  relationship varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  address varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  occupation varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  phone_number varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  email varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (id),
  KEY employee_profile_id (employee_profile_id),
  CONSTRAINT familyrelationships_ibfk_1 FOREIGN KEY (employee_profile_id) REFERENCES employeeprofiles (id)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `positions`
--

DROP TABLE IF EXISTS positions;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE positions (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `records`
--

DROP TABLE IF EXISTS records;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE records (
  id int NOT NULL AUTO_INCREMENT,
  employee_profile_id int NOT NULL,
  decision_date date NOT NULL,
  saved_number varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (id),
  KEY records_ibfk_1_idx (employee_profile_id),
  CONSTRAINT records_ibfk_1 FOREIGN KEY (employee_profile_id) REFERENCES employeeprofiles (id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `registrations`
--

DROP TABLE IF EXISTS registrations;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE registrations (
  id int NOT NULL AUTO_INCREMENT,
  employee_profile_id int NOT NULL,
  manager_id int NOT NULL,
  leader_id int NOT NULL,
  submission_date datetime NOT NULL,
  submission_content varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  appointment_date datetime DEFAULT NULL,
  additional_request_content varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  rejection_date datetime DEFAULT NULL,
  rejection_reason varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  status_id int NOT NULL,
  PRIMARY KEY (id),
  KEY employee_profile_id (employee_profile_id),
  KEY leader_id (leader_id),
  KEY manager_id (manager_id),
  KEY status_id (status_id),
  CONSTRAINT registrations_ibfk_1 FOREIGN KEY (employee_profile_id) REFERENCES employeeprofiles (id),
  CONSTRAINT registrations_ibfk_2 FOREIGN KEY (leader_id) REFERENCES users (id),
  CONSTRAINT registrations_ibfk_3 FOREIGN KEY (manager_id) REFERENCES users (id),
  CONSTRAINT registrations_ibfk_4 FOREIGN KEY (status_id) REFERENCES `status` (id)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS roles;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE roles (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `salaryincreases`
--

DROP TABLE IF EXISTS salaryincreases;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE salaryincreases (
  id int NOT NULL AUTO_INCREMENT,
  employee_profile_id int NOT NULL,
  manager_id int NOT NULL,
  leader_id int NOT NULL,
  `date` date NOT NULL,
  increase_number int NOT NULL,
  reason varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  status_id int NOT NULL,
  PRIMARY KEY (id),
  KEY employee_profile_id_idx (employee_profile_id),
  KEY salaryincrease_ibfk_2_idx (status_id),
  KEY salaryincrease_ibfk_3_idx (leader_id),
  KEY salaryincrease_ibfk_3_idx1 (manager_id),
  CONSTRAINT salaryincrease_ibfk_1 FOREIGN KEY (employee_profile_id) REFERENCES employeeprofiles (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT salaryincrease_ibfk_2 FOREIGN KEY (status_id) REFERENCES `status` (id),
  CONSTRAINT salaryincrease_ibfk_3 FOREIGN KEY (leader_id) REFERENCES users (id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS status;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  id int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `terminations`
--

DROP TABLE IF EXISTS terminations;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE terminations (
  id int NOT NULL AUTO_INCREMENT,
  employee_profile_id int NOT NULL,
  manager_id int NOT NULL,
  leader_id int NOT NULL,
  termination_date datetime NOT NULL,
  termination_reason varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  additional_request_content varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  rejection_date datetime DEFAULT NULL,
  rejection_reason varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  status_id int NOT NULL,
  PRIMARY KEY (id),
  KEY employee_profile_id (employee_profile_id),
  KEY leader_id (leader_id),
  KEY manager_id (manager_id),
  KEY status_id (status_id),
  CONSTRAINT terminations_ibfk_1 FOREIGN KEY (employee_profile_id) REFERENCES employeeprofiles (id),
  CONSTRAINT terminations_ibfk_2 FOREIGN KEY (leader_id) REFERENCES users (id),
  CONSTRAINT terminations_ibfk_3 FOREIGN KEY (manager_id) REFERENCES users (id),
  CONSTRAINT terminations_ibfk_4 FOREIGN KEY (status_id) REFERENCES `status` (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS users;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE users (
  id int NOT NULL AUTO_INCREMENT,
  department_id int NOT NULL,
  position_id int NOT NULL,
  username varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  full_name varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  gender bit(1) NOT NULL,
  phone_number varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  email varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  avatar varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  role_id int NOT NULL,
  PRIMARY KEY (id),
  KEY role_id (role_id),
  KEY department_id (department_id),
  KEY position_id (position_id),
  CONSTRAINT users_ibfk_1 FOREIGN KEY (role_id) REFERENCES roles (id),
  CONSTRAINT users_ibfk_2 FOREIGN KEY (department_id) REFERENCES departments (id),
  CONSTRAINT users_ibfk_3 FOREIGN KEY (position_id) REFERENCES positions (id)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'employee_management'
--
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckExistsCertificateId */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckExistsCertificateId(IN id INT, OUT idExists INT)
BEGIN
	SET idExists = 0;
    SELECT 
		1 INTO idExists
	FROM 
		certificates
	WHERE 
		certificates.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckExistsEmployeeId */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckExistsEmployeeId(IN id INT, OUT idExists INT)
BEGIN
	SET idExists = 0;
    SELECT 
		1 INTO idExists
	FROM 
		employeeprofiles e
	WHERE 
		e.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckExistsFamilyRelationshipId */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckExistsFamilyRelationshipId(IN id INT, OUT idExists INT)
BEGIN
	SET idExists = 0;
    SELECT 
		1 INTO idExists
	FROM 
		familyrelationships
	WHERE 
		familyrelationships.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckExistsRecordId */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckExistsRecordId(IN id INT, OUT idExists INT)
BEGIN
	SET idExists = 0;
    SELECT 
		1 INTO idExists
	FROM 
		records
	WHERE 
		records.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckExistsRegistrationId */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckExistsRegistrationId(IN id INT, OUT idExists INT)
BEGIN
	SET idExists = 0;
    SELECT 
		1 INTO idExists
	FROM 
		registrations
	WHERE 
		registrations.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckExistsSalaryIncreaseId */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckExistsSalaryIncreaseId(IN id INT, OUT idExists INT)
BEGIN
	SET idExists = 0;
    SELECT 
		1 INTO idExists
	FROM 
		salaryincreases
	WHERE 
		salaryincreases.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckExistsTerminationId */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckExistsTerminationId(IN id INT, OUT idExists INT)
BEGIN
	SET idExists = 0;
    SELECT 
		1 INTO idExists
	FROM 
		terminations
	WHERE 
		terminations.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckExistsUserId */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckExistsUserId(IN id INT, OUT idExists INT)
BEGIN
	SET idExists = 0;
    SELECT 
		1 INTO idExists
	FROM 
		users
	WHERE 
		users.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckPermissionDeleteCertificate */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckPermissionDeleteCertificate(IN employeeId INT, IN userId INT, OUT result INT)
BEGIN
	DECLARE managerId INT;
    DECLARE statusId INT;
    SET result = 2;
    
    SELECT 
		created_by, status_id
	INTO 
		managerId, statusId
	FROM 
		employeeprofiles
	WHERE 
		employeeprofiles.id = employeeId;
        
	IF userId <> managerId THEN
		SET result = 0;
	ELSE
		IF statusId <> 1 THEN
			SET result = 1;
		END IF;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckPermissionDeleteFamilyRelationship */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckPermissionDeleteFamilyRelationship(IN employeeId INT, IN userId INT, OUT result INT)
BEGIN
	DECLARE managerId INT;
    DECLARE statusId INT;
    SET result = 2;
    
    SELECT 
		created_by, status_id
	INTO 
		managerId, statusId
	FROM 
		employeeprofiles
	WHERE 
		employeeprofiles.id = employeeId;
        
	IF userId <> managerId THEN
		SET result = 0;
	ELSE
		IF statusId <> 1 THEN
			SET result = 1;
		END IF;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckPermissionGetCertificate */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckPermissionGetCertificate(IN id INT, IN userId INT, OUT result INT)
BEGIN
	DECLARE employeeId INT;
    SELECT
		employee_profile_id INTO employeeId
	FROM 
		certificates
	WHERE 
		certificates.id = id;
	
    CALL sp_CheckPermissionGetEmployee(employeeId, userId, result);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckPermissionGetEmployee */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckPermissionGetEmployee(IN id INT, IN userId INT, OUT result INT)
BEGIN
	DECLARE managerId INT;
    SET result = 1;
    SELECT 
		created_by INTO managerId
	FROM 
		employeeprofiles
	WHERE 
		employeeprofiles.id = id;
	
    IF managerId <> userId THEN		
		IF NOT EXISTS (
			SELECT 1 FROM registrations r WHERE r.leader_id = userId AND r.employee_profile_id = id
            UNION
			SELECT 1 FROM terminations t WHERE t.leader_id = userId AND t.employee_profile_id = id
		) THEN
			SET result = 0;
		END IF;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckPermissionGetFamilyRelationship */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckPermissionGetFamilyRelationship(IN id INT, IN userId INT, OUT result INT)
BEGIN
	DECLARE employeeId INT;
    SELECT
		employee_profile_id INTO employeeId
	FROM 
		familyrelationships
	WHERE 
		familyrelationships.id = id;
	
    CALL sp_CheckPermissionGetEmployee(employeeId, userId, result);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckPermissionGetRecord */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckPermissionGetRecord(IN id INT, IN userId INT, OUT result INT)
BEGIN
	DECLARE employeeProfileId INT;
	DECLARE managerId INT;   
    SET result = 1;
    SELECT 
		employee_profile_id
	INTO 
		employeeProfileId
	FROM
		records 
	WHERE 
		records.id = id;
        
    SELECT 
		created_by
	INTO 
		managerId
	FROM
		employeeprofiles
	WHERE
		employeeprofiles.id = employeeProfileId;
	
    IF userId <> managerId THEN
		SET result = 0;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckPermissionGetRegistration */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckPermissionGetRegistration(IN id INT, IN userId INT, OUT result INT)
BEGIN
	DECLARE managerId INT;
	DECLARE leaderId INT;
    SET result = 1;
    SELECT 
		manager_id, leader_id
	INTO 
		managerId, leaderId
	FROM
		registrations
	WHERE
		registrations.id = id;
	
    IF userId <> managerId AND userId <> leaderId THEN
		SET result = 0;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckPermissionGetSalaryIncrease */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckPermissionGetSalaryIncrease(IN id INT, IN userId INT, OUT result INT)
BEGIN
	DECLARE managerId INT;
	DECLARE leaderId INT;
    SET result = 1;
    SELECT 
		manager_id, leader_id
	INTO 
		managerId, leaderId
	FROM
		salaryincreases
	WHERE
		salaryincreases.id = id;
	
    IF userId <> managerId AND userId <> leaderId THEN
		SET result = 0;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckPermissionGetTermination */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckPermissionGetTermination(IN id INT, IN userId INT, OUT result INT)
BEGIN
	DECLARE managerId INT;
	DECLARE leaderId INT;
    SET result = 1;
    SELECT 
		manager_id, leader_id
	INTO 
		managerId, leaderId
	FROM
		terminations
	WHERE
		terminations.id = id;
	
    IF userId <> managerId AND userId <> leaderId THEN
		SET result = 0;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckPermissionUpdateCertificate */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckPermissionUpdateCertificate(IN employeeId INT, IN userId INT, OUT result INT)
BEGIN
	DECLARE managerId INT;
    DECLARE statusId INT;
    SET result = 2;
    
    SELECT 
		created_by, status_id
	INTO 
		managerId, statusId
	FROM 
		employeeprofiles
	WHERE 
		employeeprofiles.id = employeeId;
        
	IF userId <> managerId THEN
		SET result = 0;
	ELSE
		IF statusId <> 1 THEN
			SET result = 1;
		END IF;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CheckPermissionUpdateFamilyRelationship */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CheckPermissionUpdateFamilyRelationship(IN employeeId INT, IN userId INT, OUT result INT)
BEGIN
	DECLARE managerId INT;
    DECLARE statusId INT;
    SET result = 2;
    
    SELECT 
		created_by, status_id
	INTO 
		managerId, statusId
	FROM 
		employeeprofiles
	WHERE 
		employeeprofiles.id = employeeId;
        
	IF userId <> managerId THEN
		SET result = 0;
	ELSE
		IF statusId <> 1 THEN
			SET result = 1;
		END IF;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CreateCertificate */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CreateCertificate(IN employeeId INT, IN certificateJson JSON)
BEGIN
	DECLARE name VARCHAR(255);
    DECLARE issuedDate DATE;
    DECLARE issuedLocation VARCHAR(255);
    DECLARE field VARCHAR(255);
    DECLARE type VARCHAR(255);
    DECLARE description VARCHAR(255);
    DECLARE effectiveDate DATE;
    DECLARE elementJson JSON;
    DECLARE i INT DEFAULT 0;
    DECLARE len INT;    
    SET len = JSON_LENGTH(certificateJson);

    WHILE i < len DO
		-- Lấy phần tử thứ i từ mảng
		SET elementJson = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, CONCAT('$[', i, ']')));
        
        SET name = JSON_UNQUOTE(JSON_EXTRACT(elementJson, '$.name'));
		SET issuedDate = JSON_UNQUOTE(JSON_EXTRACT(elementJson, '$.issuedDate'));
		SET issuedLocation = JSON_UNQUOTE(JSON_EXTRACT(elementJson, '$.issuedLocation'));
		SET field = JSON_UNQUOTE(JSON_EXTRACT(elementJson, '$.field'));
		SET type = JSON_UNQUOTE(JSON_EXTRACT(elementJson, '$.type'));
		SET description = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(elementJson, '$.description')), 'null');
		SET effectiveDate = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(elementJson, '$.effectiveDate')), 'null');
        
        INSERT INTO certificates (
			name, 
            issued_date, 
            issued_location, 
            field, 
            type, 
            description, 
            effective_date, 
            employee_profile_id
		)
        VALUES (            
            name,
			issuedDate,
			issuedLocation,
			field,
			type,
			description,
			effectiveDate,
            employeeId
        );
        SET i = i + 1;
    END WHILE;
    
    SELECT 
		c.id,
        c.name,
        c.issued_date,
        c.issued_location,
        c.field,
        c.type,
        c.description,
        c.effective_date,
        c.employee_profile_id
	FROM 
		certificates c
	WHERE 
		c.employee_profile_id = employeeId
	ORDER BY 
		c.id DESC 
	LIMIT 
		len;        
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CreateEmployee */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CreateEmployee(IN employeeProfileJson JSON)
BEGIN
	DECLARE employeeJson JSON;
	DECLARE certificateJsons JSON;
    DECLARE familyRelationshipJsons JSON;
    DECLARE employeeId INT;
    DECLARE fullName VARCHAR(50);
    DECLARE employeeCode VARCHAR(50);
    DECLARE gender BOOLEAN;
    DECLARE birthday DATE;
    DECLARE hometown VARCHAR(255);
    DECLARE ethnicity VARCHAR(50);
    DECLARE religion VARCHAR(255);
    DECLARE nationality VARCHAR(255);
    DECLARE address VARCHAR(255);
    DECLARE team INT;
    DECLARE image VARCHAR(255);
    DECLARE idCardNumber VARCHAR(50);
    DECLARE idCardIssuedDate DATE;
    DECLARE idCardIssuedLocation VARCHAR(255);
    DECLARE phoneNumber VARCHAR(20);
    DECLARE email VARCHAR(255);
    DECLARE salary INT;
    DECLARE salaryLevel INT;
     DECLARE createdBy INT;
    DECLARE departmentId INT;
    DECLARE positionId INT;
    DECLARE statusId INT;   
    
    SET employeeJson = JSON_EXTRACT(employeeProfileJson, '$.employeeRequestDto');
    
    SET fullName = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.fullName'));
    SET employeeCode = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.code'));
    SET gender = JSON_EXTRACT(employeeJson, '$.gender');
    SET birthday = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.birthday'));
    SET hometown = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.hometown'));
    SET ethnicity = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.ethnicity'));
    SET religion = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.religion'));
    SET nationality = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.nationality'));
    SET address = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.address'));
    SET team = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.team'));
    SET image = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.image'));
    SET idCardNumber = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.idCardNumber'));
    SET idCardIssuedDate = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.idCardIssuedDate'));
    SET idCardIssuedLocation = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.idCardIssuedLocation'));
    SET phoneNumber = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.phoneNumber'));
    SET email = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.email'));
    SET salary = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.salary'));
    SET salaryLevel = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.salaryLevel'));
    SET createdBy = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.createdBy'));
    SET departmentId = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.departmentId'));
    SET positionId = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.positionId'));
    SET statusId = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.statusId'));    
	
    INSERT INTO employeeprofiles (
		full_name,
        code,
        gender,
        birthday,
        hometown,
        ethnicity,
        religion,
        nationality,
        address,
        team,
        image,
        id_card_number,
        id_card_issued_date,
        id_card_issued_location,
        phone_number,
        email,
        salary,
        salary_level,
        created_by,
        department_id,
        position_id,
        status_id        
	)
	VALUES (
		fullName,
        employeeCode,
		gender,
		birthday,
		hometown,
		ethnicity,
		religion,
		nationality,
		address,
		team,
		image,
		idCardNumber,
		idCardIssuedDate,
		idCardIssuedLocation,
		phoneNumber,
		email,
		salary,
		salaryLevel,
        createdBy,
		departmentId,
		positionId,
		statusId        
	);
    
    SET employeeId = LAST_INSERT_ID();    
    CALL sp_GetEmployeeById(employeeId, @result);
    
    SET certificateJsons = JSON_EXTRACT(employeeProfileJson, '$.certificateRequestDtos');
	IF JSON_LENGTH(certificateJsons) > 0 THEN
			CALL sp_CreateCertificate(employeeId, certificateJsons);
	END IF;
	
	SET familyRelationshipJsons = JSON_EXTRACT(employeeProfileJson, '$.familyRelationshipRequestDtos');
	IF JSON_LENGTH(familyRelationshipJsons) > 0 THEN
			CALL sp_CreateFamilyRelationship(employeeId, familyRelationshipJsons);
	END IF;	   
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CreateFamilyRelationship */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CreateFamilyRelationship(IN employeeId INT, IN familyRelationshipJson JSON)
BEGIN
	DECLARE fullName VARCHAR(50);
    DECLARE gender BOOLEAN;
    DECLARE birthday DATE;
    DECLARE idCardNumber VARCHAR(50);
    DECLARE relationship VARCHAR(50);
    DECLARE address VARCHAR(255);
    DECLARE occupation VARCHAR(255);
    DECLARE phoneNumber VARCHAR(20);
    DECLARE email VARCHAR(255);

    DECLARE i INT DEFAULT 0;
    DECLARE len INT;
    DECLARE elementJson JSON;
    SET len = JSON_LENGTH(familyRelationshipJson);

    WHILE i < len DO
		-- Lấy phần tử thứ i từ mảng
		SET elementJson = JSON_UNQUOTE(JSON_EXTRACT(familyRelationshipJson, CONCAT('$[', i, ']')));
        
        SET fullName = JSON_UNQUOTE(JSON_EXTRACT(elementJson, '$.fullName'));
		SET gender = JSON_EXTRACT(elementJson, '$.gender');
		SET birthday = JSON_UNQUOTE(JSON_EXTRACT(elementJson, '$.birthday'));
		SET idCardNumber = JSON_UNQUOTE(JSON_EXTRACT(elementJson, '$.idCardNumber'));
		SET relationship = JSON_UNQUOTE(JSON_EXTRACT(elementJson, '$.relationship'));
		SET address = JSON_UNQUOTE(JSON_EXTRACT(elementJson, '$.address'));
		SET occupation = JSON_UNQUOTE(JSON_EXTRACT(elementJson, '$.occupation'));
		SET phoneNumber = JSON_UNQUOTE(JSON_EXTRACT(elementJson, '$.phoneNumber'));
		SET email = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(elementJson, '$.email')), 'null');       
        
        INSERT INTO familyrelationships (
			full_name, 
            gender, 
            birthday, 
            id_card_number, 
            relationship, 
            address, 
            occupation, 
            phone_number, 
            email, 
            employee_profile_id
		)
        VALUES (                      
            fullName,
			gender,
			birthday,
			idCardNumber,
			relationship,
			address,
			occupation,
			phoneNumber,
			email,
            employeeId
        );
        SET i = i + 1;
    END WHILE;
    
    SELECT 
		f.id,
        f.full_name,
        f.gender,
        f.birthday,
        f.id_card_number,
        f.relationship,
        f.address,
        f.occupation,
        f.phone_number,
        f.email,
        f.employee_profile_id
	FROM 
		familyrelationships f
	WHERE 
		f.employee_profile_id = employeeId
    ORDER BY 
		f.id DESC 
	LIMIT 
		len;        
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CreateRecord */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CreateRecord(IN recordJson JSON)
BEGIN	
    DECLARE employeeProfileId INT;
	DECLARE decisionDate DATE;
    DECLARE savedNumber VARCHAR(20);
    DECLARE recordId INT;
    
	SET employeeProfileId = JSON_UNQUOTE(JSON_EXTRACT(recordJson, '$.employeeProfileId'));
	SET decisionDate = JSON_UNQUOTE(JSON_EXTRACT(recordJson, '$.decisionDate'));
	SET savedNumber = JSON_UNQUOTE(JSON_EXTRACT(recordJson, '$.savedNumber'));
	
	INSERT INTO records (
        employee_profile_id,
        decision_date,
        saved_number
	)
    VALUES (
		employeeProfileId,
        decisionDate,
        savedNumber
    );
    
    UPDATE employeeprofiles 
    SET
		status_id = 10
	WHERE 
		id = employeeProfileId;
        
	SET recordId = LAST_INSERT_ID();
    
    CALL sp_GetRecordById(recordId, @result);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CreateRegistration */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CreateRegistration(IN registrationJson JSON)
BEGIN	
    DECLARE employeeProfileId INT;
    DECLARE managerId INT;
	DECLARE leaderId INT;
	DECLARE submissionDate DATE;
    DECLARE submissionContent VARCHAR(255);
    DECLARE statusId INT;
    DECLARE registrationId INT;
    
	SET employeeProfileId = JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.employeeProfileId'));
	SET managerId = JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.managerId'));
	SET leaderId = JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.leaderId'));
	SET submissionDate = JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.submissionDate'));
	SET submissionContent = JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.submissionContent'));
	SET statusId = JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.statusId'));
	
	INSERT INTO registrations (
        employee_profile_id,
        manager_id,
        leader_id,
        submission_date,
        submission_content,
        status_id
	)
    VALUES (
		employeeProfileId,
        managerId,
        leaderId,
        submissionDate,
        submissionContent,
        statusId
    );
    
    UPDATE employeeprofiles 
    SET
		status_id = statusId
	WHERE 
		id = employeeProfileId;
        
	SET registrationId = LAST_INSERT_ID();
    
    CALL sp_GetRegistrationById(registrationId, @result);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CreateSalaryIncrease */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CreateSalaryIncrease(IN salaryIncreaseJson JSON)
BEGIN	
    DECLARE employeeProfileId INT;
    DECLARE managerId INT;
    DECLARE leaderId INT;
	DECLARE increaseDate DATE;
    DECLARE increaseNumber INT;
    DECLARE increaseReason VARCHAR(255);
    DECLARE increaseDescription VARCHAR(255);
    DECLARE statusId INT;
    DECLARE salaryIncreaseId INT;
    
	SET employeeProfileId = JSON_UNQUOTE(JSON_EXTRACT(salaryIncreaseJson, '$.employeeProfileId'));
	SET managerId = JSON_UNQUOTE(JSON_EXTRACT(salaryIncreaseJson, '$.managerId'));
	SET leaderId = JSON_UNQUOTE(JSON_EXTRACT(salaryIncreaseJson, '$.leaderId'));
	SET increaseDate = JSON_UNQUOTE(JSON_EXTRACT(salaryIncreaseJson, '$.date'));
	SET increaseReason = JSON_UNQUOTE(JSON_EXTRACT(salaryIncreaseJson, '$.reason'));
	SET increaseDescription = JSON_UNQUOTE(JSON_EXTRACT(salaryIncreaseJson, '$.description'));
	SET statusId = JSON_UNQUOTE(JSON_EXTRACT(salaryIncreaseJson, '$.statusId'));
	SELECT 
		COUNT(*) + 1 
    INTO 
		increaseNumber
	FROM 
		salaryincreases s
	WHERE 
		s.employee_profile_id = employeeProfileId AND s.status_id = 12;
    
	INSERT INTO salaryincreases (
        employee_profile_id,
		manager_id,
		leader_id,
		date,
		increase_number,
		reason,
		description,
		status_id
	)
    VALUES (
		employeeProfileId,
        managerId,
        leaderId,
        increaseDate,
        increaseNumber,
        increaseReason,
        increaseDescription,
        statusId
    );
        
	SET salaryIncreaseId = LAST_INSERT_ID();
    
    CALL sp_GetSalaryIncreaseById(salaryIncreaseId, @result);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_CreateTermination */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_CreateTermination(IN terminationJson JSON)
BEGIN
	DECLARE employeeProfileId INT;
    DECLARE managerId INT;
	DECLARE leaderId INT;
	DECLARE terminationDate DATE;
    DECLARE terminationReason VARCHAR(255);
    DECLARE statusId INT;
    DECLARE terminationId INT;
    
    SET employeeProfileId = JSON_UNQUOTE(JSON_EXTRACT(terminationJson, '$.employeeProfileId'));
	SET managerId = JSON_UNQUOTE(JSON_EXTRACT(terminationJson, '$.managerId'));
	SET leaderId = JSON_UNQUOTE(JSON_EXTRACT(terminationJson, '$.leaderId'));
	SET terminationDate = JSON_UNQUOTE(JSON_EXTRACT(terminationJson, '$.terminationDate'));
	SET terminationReason = JSON_UNQUOTE(JSON_EXTRACT(terminationJson, '$.terminationReason'));
	SET statusId = JSON_UNQUOTE(JSON_EXTRACT(terminationJson, '$.statusId'));
    
    INSERT INTO terminations (
        employee_profile_id,
        manager_id,
        leader_id,
        termination_date,
        termination_reason,
        status_id
	)
    VALUES (
		employeeProfileId,
        managerId,
        leaderId,
        terminationDate,
        terminationReason,
        statusId
    );
    
    UPDATE employeeprofiles 
    SET
		status_id = statusId
	WHERE 
		id = employeeProfileId;
    
	SET terminationId = LAST_INSERT_ID();
    
	CALL sp_GetTerminationById(terminationId, @result);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_DeleteCertificateById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_DeleteCertificateById(IN id INT)
BEGIN
	DELETE FROM 
		certificates
	WHERE
		certificates.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_DeleteEmployeeById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_DeleteEmployeeById(IN id INT)
BEGIN	
	DELETE FROM 
		certificates
	WHERE 
		certificates.employee_profile_id = id;
		
	DELETE FROM 
		familyrelationships 
	WHERE 
		familyrelationships.employee_profile_id = id;
	
	DELETE FROM 
		employeeprofiles 
	WHERE 
		employeeprofiles.id = id;		
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_DeleteFamilyRelationshipById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_DeleteFamilyRelationshipById(IN id INT)
BEGIN
    DELETE FROM 
		familyrelationships
    WHERE
        familyrelationships.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_DeleteRegistrationById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_DeleteRegistrationById(IN id INT)
BEGIN	
	DELETE FROM 
		registrations 
	WHERE 
		registrations.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_DeleteSalaryIncreaseById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_DeleteSalaryIncreaseById(IN id INT)
BEGIN	
	DELETE FROM 
		salaryincreases 
	WHERE 
		salaryincreases.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_DeleteTerminationById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_DeleteTerminationById(IN id INT)
BEGIN	
	DELETE FROM 
		terminations 
	WHERE 
		terminations.id = id;			
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetAllCertificateByEmployeeId */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetAllCertificateByEmployeeId(IN employeeId INT)
BEGIN
	SELECT 
		id,
		name,
		issued_date,
		issued_location,
		field,
		type,
		description,
		effective_date,
		employee_profile_id
	FROM 
		certificates
	WHERE 
		certificates.employee_profile_id = employeeId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetAllDepartment */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetAllDepartment()
BEGIN
	SELECT 
		id,
        name,
        description
	FROM 
		departments;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetAllEmployeeByUserId */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetAllEmployeeByUserId(IN userId INT)
BEGIN
	SELECT 
		e.id,
        e.full_name,
        e.code,
        e.gender,
        e.birthday,
        e.hometown,        
        e.id_card_number,
        e.phone_number,
        e.email,
        e.department_id,
        e.position_id,
        e.status_id,
        s.name AS status_name
	FROM 
		employeeprofiles e
	INNER JOIN 
		status s ON e.status_id = s.id
	WHERE 
		e.created_by = userId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetAllFamilyRelationshipByEmployeeId */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetAllFamilyRelationshipByEmployeeId(IN employeeId INT)
BEGIN  	
	SELECT
		id,
		full_name,
		gender,
		birthday,
		id_card_number,
		relationship,
		address,
		occupation,
		phone_number,
		email,
		employee_profile_id
	FROM
		familyrelationships
	WHERE
		familyrelationships.employee_profile_id = employeeId;	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetAllPosition */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetAllPosition()
BEGIN
	SELECT 
		id,
        name,
        description
	FROM 
		positions;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetAllRegistrationByUserId */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetAllRegistrationByUserId(IN userId INT)
BEGIN
	SELECT 
		r.id,
        r.employee_profile_id,
        r.manager_id,
        r.leader_id,
        r.submission_date,
        r.submission_content,
        r.appointment_date,
        r.additional_request_content,
        r.rejection_date,
        r.rejection_reason,
        r.status_id,
        s.name AS status_name
	FROM 
		registrations r
	INNER JOIN
		status s ON r.status_id = s.id
	WHERE 
		r.manager_id = userId OR (r.leader_id = userId AND r.status_id = 2);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetAllSalaryIncreaseByUserId */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetAllSalaryIncreaseByUserId(IN userId INT)
BEGIN
	SELECT 
		s.id,
		s.employee_profile_id,
		s.manager_id,
		s.leader_id,
		s.date,
		s.increase_number,
		s.reason,
		s.description,
		s.status_id
	FROM 
		salaryincreases s
	WHERE
		s.manager_id = userId OR (s.leader_id = userId AND s.status_id = 11);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetAllTerminationByUserId */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetAllTerminationByUserId(IN userId INT)
BEGIN
	SELECT 
		t.id,
		t.employee_profile_id,
		t.manager_id,
		t.leader_id,
		t.termination_date,
		t.termination_reason,
		t.additional_request_content,
		t.rejection_date,
		t.rejection_reason,
		t.status_id,
		s.name AS status_name
	FROM 
		terminations t
	INNER JOIN
		status s ON t.status_id = s.id
	WHERE 
		t.manager_id = userId OR (t.leader_id = userId AND t.status_id = 6);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetAllUserLeader */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetAllUserLeader()
BEGIN
	SELECT 
		id,
        full_name, 
		gender, 
        department_id, 
		position_id, 
		role_id
	FROM 
		users
	WHERE 
		users.role_id = 2;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetCertificateById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetCertificateById(IN id INT, OUT result INT)
BEGIN
	CALL sp_CheckExistsCertificateId(id, result);
	
    IF result = 1 THEN
		SELECT 
			id,
			name,
			issued_date,
			issued_location,
			field,
			type,
			description,
			effective_date,
			employee_profile_id
		FROM 
			certificates
		WHERE 
			certificates.id = id;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetEmployeeById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetEmployeeById(IN id INT, OUT result INT)
BEGIN
    CALL sp_CheckExistsEmployeeId(id, result);   
    
	if result = 1 THEN 
		SELECT 
			e.id,
			e.full_name,
			e.code,
			e.gender,
			e.birthday,
			e.hometown,
			e.ethnicity,
			e.religion,
			e.nationality,
			e.address,
			e.team,
			e.image,
			e.id_card_number,
			e.id_card_issued_date,
			e.id_card_issued_location,
			e.phone_number,
			e.email,
			e.salary,
			e.salary_level,
            e.created_by,
			e.department_id,
			e.position_id,
            e.status_id,
			s.name AS status_name
		FROM 
			employeeprofiles e
		INNER JOIN 
			status s ON e.status_id = s.id
		WHERE 
			e.id = id;
	END IF;  	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetFamilyRelationshipById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetFamilyRelationshipById(IN id INT, OUT result INT)
BEGIN
	CALL sp_CheckExistsFamilyRelationshipId(id, result);
    
    IF result = 1 THEN
		SELECT
			id,
			full_name,
			gender,
			birthday,
			id_card_number,
			relationship,
			address,
			occupation,
			phone_number,
			email,
			employee_profile_id
		FROM
			familyrelationships 
		WHERE
			familyrelationships.id = id;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetRecordById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetRecordById(IN id INT, OUT result INT)
BEGIN
	CALL sp_CheckExistsRecordId(id, result);
	
    if result = 1 THEN 
        SELECT 
			r.id,
			r.employee_profile_id,			
			r.decision_date,
			r.saved_number		
		FROM 
			records r
		WHERE 
			r.id = id;
	END IF;  	
        
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetRegistrationById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetRegistrationById(IN id INT, OUT result INT)
BEGIN
	CALL sp_CheckExistsRegistrationId(id, result);
	
    if result = 1 THEN 
        SELECT 
			r.id,
			r.employee_profile_id,
			r.manager_id,
			r.leader_id,
			r.submission_date,
			r.submission_content,
			r.appointment_date,
			r.additional_request_content,
			r.rejection_date,
			r.rejection_reason,
			r.status_id,
			s.name AS status_name
		FROM 
			registrations r
		INNER JOIN
			status s ON r.status_id = s.id
		WHERE 
			r.id = id;
	END IF;  	
        
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetSalaryIncreaseById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetSalaryIncreaseById(IN id INT, OUT result INT)
BEGIN
	CALL sp_CheckExistsSalaryIncreaseId(id, result);
	
    if result = 1 THEN 
        SELECT 
			s.id,
			s.employee_profile_id,
			s.manager_id,
			s.leader_id,
			s.date,
			s.increase_number,
			s.reason,
			s.description,
			s.status_id
		FROM 
			salaryincreases s
		WHERE 
			s.id = id;
	END IF;  	
        
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetTerminationById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetTerminationById(IN id INT, OUT result INT)
BEGIN
	CALL sp_CheckExistsTerminationId(id, result);
    
    if result = 1 THEN 
		SELECT 
			t.id,
			t.employee_profile_id,
			t.manager_id,
			t.leader_id,
			t.termination_date,
			t.termination_reason,
			t.additional_request_content,
			t.rejection_date,
			t.rejection_reason,
			t.status_id,
			s.name AS status_name
		FROM 
			terminations t
		INNER JOIN
			status s ON t.status_id = s.id
		WHERE 
			t.id = id;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_GetUserById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_GetUserById(IN id INT, OUT result INT)
BEGIN
	CALL sp_CheckExistsUserId(id, result);
    
    IF result = 1 THEN
		SELECT 
			id, 
			username, 
			full_name, 
			gender, 
			phone_number, 
			email, 
			avatar, 
			department_id, 
			position_id, 
			role_id
		FROM 
			users 
		WHERE 
			id = id;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_LoadUserById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_LoadUserById(IN id INT)
BEGIN
	SELECT 
		u.id, 
        u.username, 
        u.password, 
        r.name AS role_name
    FROM 
		users u
    INNER JOIN 
		roles r ON u.role_id = r.id
    WHERE 
		u.id = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_LoadUserByUsername */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_LoadUserByUsername(IN username VARCHAR(255))
BEGIN
	SELECT 
		u.id, 
        u.username, 
        u.password, 
        r.name AS role_name
    FROM 
		users u
    INNER JOIN 
		roles r ON u.role_id = r.id
    WHERE 
		u.username = username;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_UpdateCertificateById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_UpdateCertificateById(IN id INT, IN certificateJson JSON)
BEGIN
	DECLARE name VARCHAR(255);
	DECLARE issuedDate DATE;
	DECLARE issuedLocation VARCHAR(255);
	DECLARE field VARCHAR(255);
	DECLARE type VARCHAR(255);
	DECLARE description VARCHAR(255);
	DECLARE effectiveDate DATE;    
		
	SET name = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.name'));
	SET issuedDate = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.issuedDate'));
	SET issuedLocation = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.issuedLocation'));
	SET field = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.field'));
	SET type = JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.type'));
	SET description = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.description')), 'null');
	SET effectiveDate = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(certificateJson, '$.effectiveDate')), 'null');
	
	UPDATE certificates c
	SET
		c.name = name,
		c.issued_date = issuedDate,
		c.issued_location = issuedLocation,
		c.field = field,
		c.type = type,
		c.description = description,
		c.effective_date = effectiveDate
	WHERE
		c.id = id;
		
	CALL sp_GetCertificateById(id, @result1);
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_UpdateEmployeeById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_UpdateEmployeeById(IN id INT, IN employeeJson JSON)
BEGIN
	DECLARE fullName VARCHAR(50);
    DECLARE employeeCode VARCHAR(50);
    DECLARE gender BOOLEAN;
    DECLARE birthday DATE;
    DECLARE hometown VARCHAR(255);
    DECLARE ethnicity VARCHAR(50);
    DECLARE religion VARCHAR(255);
    DECLARE nationality VARCHAR(255);
    DECLARE address VARCHAR(255);
    DECLARE team INT;
    DECLARE image VARCHAR(255);
    DECLARE idCardNumber VARCHAR(50);
    DECLARE idCardIssuedDate DATE;
    DECLARE idCardIssuedLocation VARCHAR(255);
    DECLARE phoneNumber VARCHAR(20);
    DECLARE email VARCHAR(255);
    DECLARE salary INT;
    DECLARE salaryLevel INT;
    DECLARE departmentId INT;
    DECLARE positionId INT;
    
    SET fullName = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.fullName'));
    SET employeeCode = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.code'));
    SET gender = JSON_EXTRACT(employeeJson, '$.gender');
    SET birthday = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.birthday'));
    SET hometown = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.hometown'));
    SET ethnicity = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.ethnicity'));
    SET religion = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.religion'));
    SET nationality = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.nationality'));
    SET address = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.address'));
    SET team = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.team'));
    SET image = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.image')), 'null');
    SET idCardNumber = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.idCardNumber'));
    SET idCardIssuedDate = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.idCardIssuedDate'));
    SET idCardIssuedLocation = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.idCardIssuedLocation'));
    SET phoneNumber = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.phoneNumber'));
    SET email = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.email'));
    SET salary = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.salary'));
    SET salaryLevel = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.salaryLevel'));
    SET departmentId = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.departmentId'));
    SET positionId = JSON_UNQUOTE(JSON_EXTRACT(employeeJson, '$.positionId'));
    
    UPDATE employeeprofiles e
    SET
        e.full_name = fullName,
        e.code = employeeCode,
        e.gender = gender,
        e.birthday = birthday,
        e.hometown = hometown,
        e.ethnicity = ethnicity,
        e.religion = religion,
        e.nationality = nationality,
        e.address = address,
        e.team = team,
        e.image = COALESCE(image, e.image),
        e.id_card_number = idCardNumber,
        e.id_card_issued_date = idCardIssuedDate,
        e.id_card_issued_location = idCardIssuedLocation,
        e.phone_number = phoneNumber,
        e.email = email,
        e.salary = salary,
        e.salary_level = salaryLevel,
        e.department_id = departmentId,
        e.position_id = positionId
    WHERE
        e.id = id;
        
	CALL sp_GetEmployeeById(id, @result);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_UpdateFamilyRelationshipById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_UpdateFamilyRelationshipById(IN id INT, IN familyRelationshipJson JSON)
BEGIN
	DECLARE fullName VARCHAR(50);
    DECLARE gender BOOLEAN;
    DECLARE birthday DATE;
    DECLARE idCardNumber VARCHAR(50);
    DECLARE relationship VARCHAR(50);
    DECLARE address VARCHAR(255);
    DECLARE occupation VARCHAR(255);
    DECLARE phoneNumber VARCHAR(20);
    DECLARE email VARCHAR(255);
    
	SET fullName = JSON_UNQUOTE(JSON_EXTRACT(familyRelationshipJson, '$.fullName'));
	SET gender = JSON_EXTRACT(familyRelationshipJson, '$.gender');
	SET birthday = JSON_UNQUOTE(JSON_EXTRACT(familyRelationshipJson, '$.birthday'));
	SET idCardNumber = JSON_UNQUOTE(JSON_EXTRACT(familyRelationshipJson, '$.idCardNumber'));
	SET relationship = JSON_UNQUOTE(JSON_EXTRACT(familyRelationshipJson, '$.relationship'));
	SET address = JSON_UNQUOTE(JSON_EXTRACT(familyRelationshipJson, '$.address'));
	SET occupation = JSON_UNQUOTE(JSON_EXTRACT(familyRelationshipJson, '$.occupation'));
	SET phoneNumber = JSON_UNQUOTE(JSON_EXTRACT(familyRelationshipJson, '$.phoneNumber'));
	SET email = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(familyRelationshipJson, '$.email')), 'null');
	
	UPDATE familyrelationships f
	SET
		f.full_name = fullName,
		f.gender = gender,
		f.birthday = birthday,
		f.id_card_number = idCardNumber,
		f.relationship = relationship,
		f.address = address,
		f.occupation = occupation,
		f.phone_number = phoneNumber,
		f.email = email
	WHERE
		f.id = id;
	
	CALL sp_GetFamilyRelationshipById(id, @result1);
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_UpdateRegistrationById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_UpdateRegistrationById(IN id INT, IN registrationJson JSON)
BEGIN
	DECLARE submissionDate DATE;
    DECLARE submissionContent VARCHAR(255);
    DECLARE appointmentDate DATE;
    DECLARE additionalRequestContent VARCHAR(255);
    DECLARE rejectionDate DATE;
    DECLARE rejectionReason VARCHAR(255);
    DECLARE statusId INT;
    DECLARE employeeId INT;
    
	SET submissionDate = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.submissionDate')), 'null');
	SET submissionContent = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.submissionContent')), 'null');
	SET appointmentDate = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.appointmentDate')), 'null');
	SET additionalRequestContent = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.additionalRequestContent')), 'null');
	SET rejectionDate = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.rejectionDate')), 'null');
	SET rejectionReason = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.rejectionReason')), 'null');
	SET statusId = JSON_UNQUOTE(JSON_EXTRACT(registrationJson, '$.statusId'));
    
    UPDATE registrations
    SET 		
        submission_date = COALESCE(submissionDate, submission_date),
        submission_content = COALESCE(submissionContent, submission_content),
        appointment_date = COALESCE(appointmentDate, appointment_date),
        additional_request_content = COALESCE(additionalRequestContent, additional_request_content),
        rejection_date = COALESCE(rejectionDate, rejection_date),
        rejection_reason = COALESCE(rejectionReason, rejection_reason),
        status_id = statusId
	WHERE 
		registrations.id = id;
	
    SELECT 
		employee_profile_id
	INTO 
		employeeId
	FROM 
		registrations
	WHERE
		registrations.id = id;
    
    UPDATE 
		employeeprofiles
    SET
		status_id = statusId
	WHERE 
		employeeprofiles.id = employeeId;
    
    CALL sp_GetRegistrationById(id, @result);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_UpdateSalaryIncreaseById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_UpdateSalaryIncreaseById(IN id INT, IN salaryIncreaseJson JSON)
BEGIN
	DECLARE employeeProfileId INT;
	DECLARE statusId INT;
    SET statusId = JSON_UNQUOTE(JSON_EXTRACT(salaryIncreaseJson, '$.statusId'));
    
    UPDATE salaryincreases
    SET 
		status_id = statusId
    WHERE
		salaryincreases.id = id;
    
    if statusId = 12 THEN
		SELECT 
			employee_profile_id 
		INTO 
			employeeProfileId
		FROM 
			salaryincreases s
		WHERE 
			s.id = id;
            
		UPDATE 
			employeeprofiles
		SET
			salary_level = salary_level + 1
		WHERE 
			employeeprofiles.id = employeeProfileId;
	END IF;    
    
    CALL sp_GetSalaryIncreaseById(id, @result);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS sp_UpdateTerminationById */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=root@localhost PROCEDURE sp_UpdateTerminationById(IN id INT, IN terminationJson JSON)
BEGIN
	DECLARE terminationDate DATE;
    DECLARE terminationReason VARCHAR(255);
    DECLARE additionalRequestContent VARCHAR(255);
    DECLARE rejectionDate DATE;
    DECLARE rejectionReason VARCHAR(255);
    DECLARE statusId INT;
    DECLARE employeeId INT;
    
    SET terminationDate = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(terminationJson, '$.terminationDate')), 'null');
	SET terminationReason = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(terminationJson, '$.terminationReason')), 'null');
	SET additionalRequestContent = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(terminationJson, '$.additionalRequestContent')), 'null');
	SET rejectionDate = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(terminationJson, '$.rejectionDate')), 'null');
	SET rejectionReason = NULLIF(JSON_UNQUOTE(JSON_EXTRACT(terminationJson, '$.rejectionReason')), 'null');
	SET statusId = JSON_UNQUOTE(JSON_EXTRACT(terminationJson, '$.statusId'));
    
    UPDATE terminations
    SET 		
        termination_date = COALESCE(terminationDate, termination_date),
        termination_reason = COALESCE(terminationReason, termination_reason),
        additional_request_content = COALESCE(additionalRequestContent, additional_request_content),
        rejection_date = COALESCE(rejectionDate, rejection_date),
        rejection_reason = COALESCE(rejectionReason, rejection_reason),
        status_id = statusId
	WHERE 
		terminations.id = id;
	
    SELECT 
		employee_profile_id
	INTO 
		employeeId
	FROM 
		terminations
	WHERE
		terminations.id = id;
    
    UPDATE 
		employeeprofiles
    SET
		status_id = statusId
	WHERE 
		employeeprofiles.id = employeeId;
	
    CALL sp_GetTerminationById(id, @result);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
