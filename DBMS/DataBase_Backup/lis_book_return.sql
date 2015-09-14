CREATE DATABASE  IF NOT EXISTS `lis` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `lis`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: lis
-- ------------------------------------------------------
-- Server version	5.5.23

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
-- Table structure for table `book_return`
--

DROP TABLE IF EXISTS `book_return`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_return` (
  `return_dt` date NOT NULL,
  `accession_no` int(11) NOT NULL DEFAULT '0',
  `member_id` varchar(50) DEFAULT NULL,
  `issue_dt` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`return_dt`,`accession_no`,`issue_dt`),
  KEY `accession_no` (`accession_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `book_return_ibfk_2` FOREIGN KEY (`accession_no`) REFERENCES `books` (`accession_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `book_return_ibfk_3` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_return`
--

LOCK TABLES `book_return` WRITE;
/*!40000 ALTER TABLE `book_return` DISABLE KEYS */;
INSERT INTO `book_return` VALUES ('2015-09-10',101,'student1','2015-07-01'),('2015-08-31',100,'student2','2015-08-15');
/*!40000 ALTER TABLE `book_return` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-14 12:42:42
