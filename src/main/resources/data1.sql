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
  `content` text,
  `correct` int(11) NOT NULL DEFAULT '0',
  `explanation` text,
  `questionid` int(11) DEFAULT NULL,
  PRIMARY KEY (`answerid`),
  KEY `FK_isvinvqhm350yv1fgumn7x9qc` (`questionid`),
  CONSTRAINT `FK_isvinvqhm350yv1fgumn7x9qc` FOREIGN KEY (`questionid`) REFERENCES `question` (`questionid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,'this will not compile',1,'duhh',1),(2,'this will compile',0,'juist',1),(3,'this will compile if  line //1 is changed',1,'want',1),(4,'awesome  code',1,'i told you so',2),(5,'i don\'t get it...',0,'start listening',2),(6,'this will compile.',0,'this i needs to be instantiated',3),(7,'what is i?',1,'gues we don\'t know',3);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
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
  PRIMARY KEY (`questionid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'this is not  perfect code',1,'dhh',0,'http://',0,0,'What will happen?'),(2,'this is some awesome code',2,'woow',1,'http://javaguru.com',0,1,'here is an other question'),(3,'i = 1;',0,'NOWAY',1,'what\'s an int,chapter one',0,1,'what is happening');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-15 15:13:02
