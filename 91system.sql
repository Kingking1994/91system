CREATE DATABASE  IF NOT EXISTS `91system` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `91system`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: 91system
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `gender` int(11) NOT NULL,
  `title` int(11) NOT NULL,
  `path` varchar(128) DEFAULT NULL,
  `goodat` varchar(255) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `oid` int(11) NOT NULL,
  PRIMARY KEY (`did`),
  KEY `oid-fk_idx` (`oid`),
  CONSTRAINT `o_d_fk` FOREIGN KEY (`oid`) REFERENCES `office` (`oid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'testdoc1',0,0,NULL,NULL,NULL,1),(2,'testdoc2',0,0,NULL,NULL,NULL,1),(3,'testdoc2',0,0,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital` (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `address` varchar(128) NOT NULL,
  `telephone` varchar(16) NOT NULL,
  `intro` varchar(225) DEFAULT NULL,
  `quality` int(11) DEFAULT NULL,
  `region` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (1,'scut_hospital','scut','123456789',NULL,0,0,0,0),(2,'华工大医院','华南理工大学','123456789',NULL,0,0,0,0),(3,'华工大医院','华南理工大学','123456789',NULL,0,0,0,0),(4,'华工中医院','华南理工大学大学城校区','123456789',NULL,0,0,0,0),(5,'大学城医院','华南理工大学大学城校区','123456789',NULL,0,0,0,0),(6,'大学城中医院','大学城','123456789',NULL,0,0,0,0),(7,'番禺中医院','大学城','123456789',NULL,0,0,0,0);
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `office`
--

DROP TABLE IF EXISTS `office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `office` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `hid` int(11) NOT NULL,
  PRIMARY KEY (`oid`),
  KEY `hid_idx` (`hid`),
  CONSTRAINT `h_o_fk` FOREIGN KEY (`hid`) REFERENCES `hospital` (`hid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `office`
--

LOCK TABLES `office` WRITE;
/*!40000 ALTER TABLE `office` DISABLE KEYS */;
INSERT INTO `office` VALUES (1,'手术室',0,0,1),(2,'妇科',0,0,1),(3,'门诊室',0,0,1),(4,'儿科',0,0,1);
/*!40000 ALTER TABLE `office` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderitem` (
  `oiid` varchar(32) NOT NULL,
  `timing` time NOT NULL,
  `pname` varchar(10) NOT NULL,
  `pbirthday` date NOT NULL,
  `pgender` int(11) NOT NULL,
  `pphone` varchar(11) NOT NULL,
  `pinfo` varchar(255) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `payed` timestamp NULL DEFAULT NULL,
  `status` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  `uiid` int(11) NOT NULL,
  PRIMARY KEY (`oiid`),
  KEY `sid-fk_idx` (`sid`),
  KEY `uiid-fk_idx` (`uiid`),
  CONSTRAINT `s_oi_fk` FOREIGN KEY (`sid`) REFERENCES `schedule` (`sid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ui_oi_fk` FOREIGN KEY (`uiid`) REFERENCES `userinfo` (`uiid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitem`
--

LOCK TABLES `orderitem` WRITE;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
INSERT INTO `orderitem` VALUES ('orderitem1461240435571','20:07:15','xiaojin','2016-04-21',0,'18814122697',NULL,'2016-04-21 12:07:16','2016-04-21 12:32:12',0,1,1);
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refund`
--

DROP TABLE IF EXISTS `refund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `refund` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `apply` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `amount` double NOT NULL,
  `status` int(11) NOT NULL,
  `completed` timestamp NULL DEFAULT NULL,
  `oiid` varchar(32) NOT NULL,
  `wid` int(11) NOT NULL,
  PRIMARY KEY (`rid`),
  KEY `w_r_fk_idx` (`wid`),
  KEY `oi_r_fk_idx` (`oiid`),
  CONSTRAINT `oi_r_fk` FOREIGN KEY (`oiid`) REFERENCES `orderitem` (`oiid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `w_r_fk` FOREIGN KEY (`wid`) REFERENCES `wallet` (`wid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refund`
--

LOCK TABLES `refund` WRITE;
/*!40000 ALTER TABLE `refund` DISABLE KEYS */;
/*!40000 ALTER TABLE `refund` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `time` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  `ordernum` int(11) NOT NULL,
  `fee` double NOT NULL,
  `did` int(11) NOT NULL,
  PRIMARY KEY (`sid`),
  KEY `did-fk_idx` (`did`),
  CONSTRAINT `d_s_fk` FOREIGN KEY (`did`) REFERENCES `doctor` (`did`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'2016-04-21',0,20,20,4,1);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade`
--

DROP TABLE IF EXISTS `trade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trade` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `amount` double NOT NULL,
  `oiid` varchar(32) NOT NULL,
  `wid` int(11) NOT NULL,
  PRIMARY KEY (`tid`),
  KEY `oi_t_fk_idx` (`oiid`),
  KEY `w_t_fk_idx` (`wid`),
  CONSTRAINT `oi_t_fk` FOREIGN KEY (`oiid`) REFERENCES `orderitem` (`oiid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `w_t_fk` FOREIGN KEY (`wid`) REFERENCES `wallet` (`wid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade`
--

LOCK TABLES `trade` WRITE;
/*!40000 ALTER TABLE `trade` DISABLE KEYS */;
INSERT INTO `trade` VALUES (1,'2016-04-21 12:32:12',4,'orderitem1461240435571',1);
/*!40000 ALTER TABLE `trade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) NOT NULL,
  `password` varchar(16) NOT NULL,
  `identified` int(11) NOT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'18814122697','123456',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinfo` (
  `uiid` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(11) NOT NULL,
  `name` varchar(10) NOT NULL,
  `gender` int(11) NOT NULL,
  `birthday` date NOT NULL,
  `idcard` varchar(32) NOT NULL,
  `email` varchar(32) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `blood` int(11) DEFAULT NULL,
  `married` int(11) DEFAULT NULL,
  `career` varchar(32) DEFAULT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`uiid`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  KEY `uid-fk_idx` (`uid`),
  CONSTRAINT `u_ui_fk` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'18814122697','肖劲',0,'2016-04-21','12345678910',NULL,NULL,0,0,NULL,1);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallet`
--

DROP TABLE IF EXISTS `wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wallet` (
  `wid` int(11) NOT NULL AUTO_INCREMENT,
  `account` double NOT NULL,
  `uiid` int(11) NOT NULL,
  PRIMARY KEY (`wid`),
  KEY `uiid-fk_idx` (`uiid`),
  CONSTRAINT `ui_w_fk` FOREIGN KEY (`uiid`) REFERENCES `userinfo` (`uiid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet`
--

LOCK TABLES `wallet` WRITE;
/*!40000 ALTER TABLE `wallet` DISABLE KEYS */;
INSERT INTO `wallet` VALUES (1,100,1);
/*!40000 ALTER TABLE `wallet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-24 22:45:18
