CREATE DATABASE  IF NOT EXISTS `xm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `xm`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: xm
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `answerid` int(11) NOT NULL AUTO_INCREMENT,
  `correct` int(11) NOT NULL DEFAULT '0',
  `explanation` text,
  `questionid` int(11) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`answerid`),
  KEY `FK_isvinvqhm350yv1fgumn7x9qc` (`questionid`),
  CONSTRAINT `FK_isvinvqhm350yv1fgumn7x9qc` FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,0,NULL,1,'misschien'),(2,1,NULL,1,'altijd'),(3,1,NULL,2,'ja '),(4,0,NULL,2,'nee'),(5,1,NULL,4,'Spanje'),(6,1,NULL,4,'Turkije'),(7,0,'',5,'1'),(8,1,'een',5,'2'),(9,0,'',6,'Piet'),(10,0,'',6,'Jan'),(11,0,'',6,'Truus'),(12,0,'',6,'Remond'),(13,0,'',6,'Raymond'),(14,0,'',6,'Constant'),(15,0,'',8,'Persoon 1'),(16,0,'',8,'Persoon 2');
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chapter` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `questions` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_parallel` bit(1) NOT NULL,
  `max_timeln_minutes` int(11) NOT NULL,
  `number_of_questions` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `questionid` int(11) NOT NULL AUTO_INCREMENT,
  `code` text,
  `difficulty` int(11) DEFAULT NULL,
  `feedback` text,
  `has_feedback` int(11) DEFAULT '0',
  `internet_link` varchar(255) DEFAULT NULL,
  `is_marked` int(11) DEFAULT '0',
  `status` int(11) DEFAULT NULL,
  `content` text,
  `categoryid` int(11) DEFAULT NULL,
  PRIMARY KEY (`questionid`),
  KEY `FK_5yvp9bw0ab5dde1a5wqcpxjw6` (`categoryid`),
  CONSTRAINT `FK_5yvp9bw0ab5dde1a5wqcpxjw6` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'ujhgerl foikgr',NULL,'1',1,NULL,0,NULL,'Wat is JAVA',NULL),(2,'jhgokadsg',NULL,'jk',0,NULL,1,NULL,'Wat eten we vandaag',NULL),(3,'jhjhj',NULL,'johkoj',0,NULL,1,NULL,'Dit is leuk',NULL),(4,'23',1,'iets',0,'',0,0,'Waar woont Sinterklaas',NULL),(5,'',1,'',0,'',0,0,'Hoeveel is 1 + 1',NULL),(6,'',0,'',0,'',0,0,'What is your name',NULL),(7,NULL,2,NULL,0,NULL,0,NULL,'Wat is het tegenovergestelde van blauw?',NULL),(8,'',0,'',0,'',0,0,'Wie ben ik',NULL);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_views`
--

DROP TABLE IF EXISTS `test_views`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_views` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `test_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_views`
--

LOCK TABLES `test_views` WRITE;
/*!40000 ALTER TABLE `test_views` DISABLE KEYS */;
INSERT INTO `test_views` VALUES (1,'Exam 1','Exam'),(2,'Exam 2','Exam');
/*!40000 ALTER TABLE `test_views` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_views_content`
--

DROP TABLE IF EXISTS `test_views_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test_views_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_nr` int(11) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL,
  `test_views_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_8xqjydw02le159pn3e5mpxxgj` (`test_views_id`),
  CONSTRAINT `FK_8xqjydw02le159pn3e5mpxxgj` FOREIGN KEY (`test_views_id`) REFERENCES `test_views` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_views_content`
--

LOCK TABLES `test_views_content` WRITE;
/*!40000 ALTER TABLE `test_views_content` DISABLE KEYS */;
INSERT INTO `test_views_content` VALUES (1,2,3,1),(2,3,1,1),(3,1,6,2),(4,1,4,1),(5,2,8,2);
/*!40000 ALTER TABLE `test_views_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'a@a.com',1,'a','a');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-20  7:28:24
