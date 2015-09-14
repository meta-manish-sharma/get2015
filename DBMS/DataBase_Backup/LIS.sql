CREATE DATABASE  IF NOT EXISTS `getzip` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `getzip`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: getzip
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-14 12:41:46
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
-- Table structure for table `title_author`
--

DROP TABLE IF EXISTS `title_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `title_author` (
  `title_id` varchar(50) NOT NULL DEFAULT '',
  `author_id` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`title_id`,`author_id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `title_author_ibfk_1` FOREIGN KEY (`title_id`) REFERENCES `titles` (`title_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `title_author_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `authors` (`author_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `title_author`
--

LOCK TABLES `title_author` WRITE;
/*!40000 ALTER TABLE `title_author` DISABLE KEYS */;
INSERT INTO `title_author` VALUES ('title1','author1'),('title2','author2'),('title4','author2'),('title5','author2'),('title3','author3');
/*!40000 ALTER TABLE `title_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publishers`
--

DROP TABLE IF EXISTS `publishers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publishers` (
  `publisher_id` varchar(50) NOT NULL,
  `publisher_nm` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`publisher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publishers`
--

LOCK TABLES `publishers` WRITE;
/*!40000 ALTER TABLE `publishers` DISABLE KEYS */;
INSERT INTO `publishers` VALUES ('publisher1','jaipur books'),('publisher2','delhi books'),('publisher3','Ajmer books'),('publisher4','CBC');
/*!40000 ALTER TABLE `publishers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `member_details`
--

DROP TABLE IF EXISTS `member_details`;
/*!50001 DROP VIEW IF EXISTS `member_details`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `member_details` (
  `member_name` varchar(100),
  `member_id` varchar(50),
  `catagory` varchar(50)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `book_issue`
--

DROP TABLE IF EXISTS `book_issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_issue` (
  `issue_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `accession_no` int(11) NOT NULL DEFAULT '0',
  `member_id` varchar(50) NOT NULL DEFAULT '',
  `due_dt` date DEFAULT NULL,
  PRIMARY KEY (`issue_dt`,`accession_no`,`member_id`),
  KEY `accession_no` (`accession_no`),
  KEY `member_id` (`member_id`),
  CONSTRAINT `book_issue_ibfk_2` FOREIGN KEY (`accession_no`) REFERENCES `books` (`accession_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `book_issue_ibfk_3` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_issue`
--

LOCK TABLES `book_issue` WRITE;
/*!40000 ALTER TABLE `book_issue` DISABLE KEYS */;
INSERT INTO `book_issue` VALUES ('2015-05-17 18:30:00',100,'other1','2015-08-31'),('2015-06-14 18:30:00',102,'teacher1','2015-08-30'),('2015-06-30 18:30:00',101,'student1','2015-07-16'),('2015-08-14 18:30:00',100,'student2','2015-08-31');
/*!40000 ALTER TABLE `book_issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `member_issue`
--

DROP TABLE IF EXISTS `member_issue`;
/*!50001 DROP VIEW IF EXISTS `member_issue`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `member_issue` (
  `member_nm` varchar(100),
  `member_id` varchar(50),
  `addressline1` varchar(100),
  `addressline2` varchar(100),
  `catagory` varchar(50),
  `issue_dt` timestamp,
  `accession_no` int(11),
  `due_dt` date
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `book_details`
--

DROP TABLE IF EXISTS `book_details`;
/*!50001 DROP VIEW IF EXISTS `book_details`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `book_details` (
  `member_nm` varchar(100),
  `catagory` varchar(50),
  `subject_nm` varchar(100),
  `title_nm` varchar(100),
  `issue_dt` timestamp,
  `due_dt` date,
  `return_dt` date
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `titles`
--

DROP TABLE IF EXISTS `titles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `titles` (
  `title_id` varchar(50) NOT NULL,
  `title_nm` varchar(100) DEFAULT NULL,
  `subject_id` varchar(50) DEFAULT NULL,
  `publisher_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`title_id`),
  KEY `subject_id` (`subject_id`),
  KEY `publisher_id` (`publisher_id`),
  CONSTRAINT `titles_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `titles_ibfk_2` FOREIGN KEY (`publisher_id`) REFERENCES `publishers` (`publisher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `titles`
--

LOCK TABLES `titles` WRITE;
/*!40000 ALTER TABLE `titles` DISABLE KEYS */;
INSERT INTO `titles` VALUES ('title1','first title','dbms1','publisher1'),('title2','second title','dbms2','publisher2'),('title3','thrird title','oops1','publisher3'),('title4','fourth title','dsa1','publisher4'),('title5','fifth title','dsa2','publisher4');
/*!40000 ALTER TABLE `titles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `accession_no` int(11) NOT NULL,
  `title_id` varchar(50) DEFAULT NULL,
  `purchase_dt` date DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`accession_no`),
  KEY `title_id` (`title_id`),
  CONSTRAINT `books_ibfk_1` FOREIGN KEY (`title_id`) REFERENCES `titles` (`title_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (100,'title1','2015-03-12',20,'F'),(101,'title2','2015-04-12',22,'N'),(102,'title3','2015-05-12',32,'N'),(103,'title4','2015-06-12',32,'F'),(104,'title5','2015-07-12',32,'F');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `members` (
  `member_id` varchar(50) NOT NULL,
  `member_nm` varchar(100) DEFAULT NULL,
  `addressline1` varchar(100) DEFAULT NULL,
  `addressline2` varchar(100) DEFAULT NULL,
  `catagory` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES ('other1','keshav sharma','mahaveer nagar','Jaipur','O'),('student1','manish','EPIP, Sitapura','Jaipur','S'),('student2','jignesh','EPIP, Sitapura','Jaipur','S'),('teacher1','rohit','Malviya nagar','Jaipur','T'),('teacher2','prakash','Civil lines','Jaipur','T');
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authors` (
  `author_id` varchar(50) NOT NULL,
  `author_nm` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES ('author1','mehul'),('author2','manish'),('author3','suman');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjects` (
  `subject_id` varchar(50) NOT NULL,
  `subject_nm` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES ('dbms1','dbms'),('dbms2','rdbms'),('dsa1','DSA'),('dsa2','Advance DSA'),('oops1','oops');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `member_details`
--

/*!50001 DROP TABLE IF EXISTS `member_details`*/;
/*!50001 DROP VIEW IF EXISTS `member_details`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `member_details` AS select `m`.`member_nm` AS `member_name`,`m`.`member_id` AS `member_id`,if((`m`.`catagory` = 'o'),'Other',if((`m`.`catagory` = 's'),'Student',if((`m`.`catagory` = 't'),'teacher',`m`.`catagory`))) AS `catagory` from `members` `m` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `member_issue`
--

/*!50001 DROP TABLE IF EXISTS `member_issue`*/;
/*!50001 DROP VIEW IF EXISTS `member_issue`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `member_issue` AS select `m`.`member_nm` AS `member_nm`,`m`.`member_id` AS `member_id`,`m`.`addressline1` AS `addressline1`,`m`.`addressline2` AS `addressline2`,`m`.`catagory` AS `catagory`,`bi`.`issue_dt` AS `issue_dt`,`bi`.`accession_no` AS `accession_no`,`bi`.`due_dt` AS `due_dt` from (`book_issue` `bi` join `members` `m` on((`m`.`member_id` = `bi`.`member_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `book_details`
--

/*!50001 DROP TABLE IF EXISTS `book_details`*/;
/*!50001 DROP VIEW IF EXISTS `book_details`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `book_details` AS select `m`.`member_nm` AS `member_nm`,`m`.`catagory` AS `catagory`,`s`.`subject_nm` AS `subject_nm`,`t`.`title_nm` AS `title_nm`,`bi`.`issue_dt` AS `issue_dt`,`bi`.`due_dt` AS `due_dt`,`br`.`return_dt` AS `return_dt` from ((((`members` `m` join `books` `b`) join `titles` `t`) join `subjects` `s`) join (`book_issue` `bi` left join `book_return` `br` on(((`bi`.`accession_no` = `br`.`accession_no`) and (`bi`.`member_id` = `br`.`member_id`))))) where ((`m`.`member_id` = `bi`.`member_id`) and (`bi`.`accession_no` = `b`.`accession_no`) and (`b`.`title_id` = `t`.`title_id`) and (`t`.`subject_id` = `s`.`subject_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-14 12:41:46
