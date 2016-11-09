-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accounts` (
  `login` varchar(30) NOT NULL,
  `email` varchar(60) NOT NULL,
  `password` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `street` varchar(60) NOT NULL,
  `city` varchar(30) NOT NULL,
  `birth_day` date NOT NULL,
  `sex` enum('M','F') NOT NULL,
  `account_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES ('warp','someemail@gmail.com','somepassword','0933807393','Eugene','Smyrnov','Mira','Kiev','1996-04-23','M',1),('warpenss','secondemail@ya.ru','easypass','0505554433','Andrew','Smyrnov','Pushkina','Kiev','1973-12-12','M',2),('warpenn','stateemail@ya.ru','passpass','5638356853','Sasha','Anatov','Poeta','Dnepr','1982-01-22','F',3),('warpens','strongl@ya.ru','12345678','4274367835','Jhon','Smyrnov','Pushkina','Kiev','1993-12-12','F',4),('warpen','warp@ya.ru','11223344','2435734673','Summer','Hacher','Kukushka','Kiev','1997-12-12','M',5),('warpe','justyou@ya.ru','whtdouwntfromme','4734673568','Scott','Mannly','Pushkina','Kiev','1996-12-15','F',6),('matsuflex','mailmepepls@ya.ru','yeahpls','3568346735','Hansy','Petrov','Lebedeva','Kiev','1995-12-12','M',7),('darkchoko','shtfu@ya.ru','hellohacker','7356835677','Justin','Lyshko','Clowns','Kiev','1994-02-22','M',8),('tumbler','programmergod@ya.ru','proscamer','5675673245','Hacker','Ivanov','Pushkina','Kiev','1993-12-12','F',9),('prospect','justes@ya.ru','skater','3245623455','Eugene','Popov','Pushkina','Kiev','1992-08-10','M',10),('daily','nuller@ya.ru','jumper','5764562456','Andrew','Saske','Pushkina','Kiev','1991-04-12','F',11),('gafer','gafer@ya.ru','chashpasw','0933994443','Huge','Mangus','Duglas','Krakow','1996-04-23','M',12),('gafer','gafer@ya.ru','chashpasw','0933994443','Huge','Mangus','Duglas','Krakow','1996-04-23','M',13),('eragaerg','ergerge@rgr.ru','awerfwrf','qergqertg','etgqerg','tegetg','ergqerg','qergqetg','1995-02-23','M',14),('Warpenneer','hedd@ya.ru','esdfwer','099333494','fvmkksfm','fkfmfmd','TTeer','Cdff','1996-03-22','M',15);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-09 16:33:25
