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

-- Dump completed on 2015-09-14 12:42:42
