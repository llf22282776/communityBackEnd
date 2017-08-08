CREATE DATABASE  IF NOT EXISTS `botbackend` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `botbackend`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: botbackend
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
-- Table structure for table `comment_c`
--

DROP TABLE IF EXISTS `comment_c`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment_c` (
  `cid` int(11) NOT NULL,
  `nid` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_c`
--

LOCK TABLES `comment_c` WRITE;
/*!40000 ALTER TABLE `comment_c` DISABLE KEYS */;
INSERT INTO `comment_c` VALUES (2,'1','我一般都用带防滑线的轮胎','2017-04-17 18:16:00',1),(1,'2','现在人都没素质','2017-04-17 14:56:00',1),(1,'3','我去，你也是厉害','2017-04-17 18:16:00',1),(1,'4','快自首吧，不然驾照都没了','2017-04-17 22:41:00',1),(2,'1','我一般都用带防滑线的轮胎','2017-04-17 18:16:00',1),(2,'2','给轮胎放气，加防滑线，配置防滑链就行了','2017-04-17 22:41:00',0),(3,'1','可怕','2017-04-19 22:27:45',0),(3,'1','心疼你朋友','2017-04-16 16:41:00',0),(3,'1','你也是，搞毛线啊，根本没必要','2017-04-17 18:22:00',0),(13,'1','欢迎欢迎！！大家欢迎啊','2017-04-17 18:22:00',0),(1,'1','sb','2017-05-04 10:12:04',0),(1,'1','sb','2017-05-04 10:12:13',0),(16,'1','so sorry to hear that ,[sad]','2017-05-05 10:11:49',1),(16,'1','you can  try to eat something','2017-05-05 10:14:03',1),(16,'1','fghhhh','2017-05-05 10:15:22',1),(16,'1','ddddd','2017-05-05 10:15:47',1),(16,'1','hahaha ','2017-05-05 10:17:55',1),(17,'3','oh ,poor babay!!!','2017-05-05 10:24:15',NULL),(17,'4','you are a fool!!','2017-05-05 10:25:37',NULL),(18,'2','poor boy !','2017-05-05 11:42:31',1),(18,'3','so sad, sorry to hear that','2017-05-05 11:43:37',1),(19,'2','so sorry to hear that','2017-05-05 22:41:24',1),(19,'3','so sorry to hear','2017-05-05 22:43:38',1),(20,'1','qqqqq','2017-05-07 09:45:29',0),(21,'1','hhhh','2017-05-07 09:50:22',0),(16,'1','good gril!','2017-05-07 09:52:37',1),(12,'3','dangran you a ','2017-05-08 23:32:26',1),(24,'3','sb','2017-05-09 01:11:39',1),(24,'3','111111','2017-05-09 01:16:29',1),(25,'4','zhangweiqilihai a ','2017-05-09 02:31:03',1),(26,'3','ksadlsaajfjdhfsjdfsfdgdgfg','2017-05-09 04:32:13',0),(24,'3','sb','2017-05-09 04:32:54',1);
/*!40000 ALTER TABLE `comment_c` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coversion`
--

DROP TABLE IF EXISTS `coversion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coversion` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `nid` int(11) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `content` varchar(4000) DEFAULT NULL,
  `supportNum` int(11) DEFAULT NULL,
  `commentNum` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `imageUrl` text,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coversion`
--

LOCK TABLES `coversion` WRITE;
/*!40000 ALTER TABLE `coversion` DISABLE KEYS */;
INSERT INTO `coversion` VALUES (1,1,'有人别我车','从我左边别车的，能不能起诉他,特别气人，车给我划了一个大口子',0,5,'2017-04-10 18:36:57','1.jpg'),(2,2,'冬天车胎打滑我用什么轮胎','我是本田系suv，开了2年，轮胎之前一直用的米其林，有没有什么推荐的',2,2,'2017-04-11 14:44:57',NULL),(3,1,'关于撞人问题','有人闯红灯，我撞了，负多少责任呢，我本来想停下，但是太可气了，我就开走了',0,3,'2017-04-13 15:23:57',NULL),(4,1,'考驾照容易吗','我没开过车，正在上大学，有点近视，各位学长学姐给点建议呀',0,0,'2017-04-13 16:11:57',''),(5,2,'撞人后车逃逸','有人撞了我，车逃逸了，但闯了红灯，我本来是没创红灯的，但是走一半变红，我就跑起来了',0,0,'2017-04-16 08:55:57',''),(6,2,'路考容易吗','我有点散光，会有影响吗，夜里也有点看不清楚',0,0,'2017-04-16 08:41:57',''),(7,2,'车内能不能用清洁剂呢','我喜欢放点清洁剂在车里，但是我听说有可能爆炸，是不是要有固体的呢',0,0,'2017-04-14 10:22:57',''),(8,2,'刹车片多久更换清洗一次才行呢','每次刹车都有声响，是不是该更换了，我现在半年检查一次车，时间会不会有点太长了',0,0,'2017-04-11 14:18:57',''),(9,2,'去年买的车，发动机出了问题','我买的bmw，打折款的，能不能更换新车呢，我听说公司都有这个服务的',0,0,'2017-04-13 12:39:57',''),(10,2,'为什么现在有人老闯红灯啊','挺烦的，尤其是现在共享单车，贼烦',0,0,'2017-04-11 12:29:57',''),(11,2,'打个广告，欢迎使用药知道','如题，哈哈哈',0,0,'2017-04-18 11:41:53',''),(12,1,'这个论坛有没有人啊 ','看来我是第一个',0,1,'2017-04-20 00:23:38',''),(13,1,'欢迎大家来到这个论坛 ','相亲相爱的一家人',0,1,'2017-04-20 00:24:15',''),(14,1,'what  a  fucking day!!!!!!!!!!!!','my first day just like eating tons of shit .',0,0,'2017-05-04 08:17:18',''),(15,1,'what  a  fucking day!!!!!!!!!!!!','my first day just like eating tons of shit .',0,0,'2017-05-04 08:17:18',''),(16,2,'what a tough day','   this is my first time to get driver linces ,so i come to road , but some bitch hit my car ,and i got hurt!!!!!!',0,6,'2017-05-05 10:10:17',''),(17,1,'just can believe that!','this is my first day to run on the road ,but i crashed !!!!!!!!!!!!!!!!!!!!!!!!what a crash day',2,2,'2017-05-05 10:22:56',''),(18,1,'oh,my bad day ','my car is broken by an accident sad',0,2,'2017-05-05 11:41:22',''),(19,1,'how  bad day it is','it\'s my first time to drive,but some body hit me badly ,i\'m so sad',2,3,'2017-05-05 22:40:15',''),(20,1,'asdasd','hhhhh',0,1,'2017-05-06 12:57:38',''),(21,1,'big day','test',1,1,'2017-05-07 09:46:13',''),(22,1,'test','aaaa',0,0,'2017-05-07 09:50:34',''),(23,3,'adfasggh','qqqqqq',0,0,'2017-05-08 23:35:30',''),(24,4,'hhhahha','qqqqq',1,3,'2017-05-09 01:11:07',''),(25,3,'new 1','dddddd',0,1,'2017-05-09 02:29:28',''),(26,3,'test 1','ggggggg',0,1,'2017-05-09 04:32:00','');
/*!40000 ALTER TABLE `coversion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coversionimage`
--

DROP TABLE IF EXISTS `coversionimage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coversionimage` (
  `cid` int(11) DEFAULT NULL,
  `imageUrl` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coversionimage`
--

LOCK TABLES `coversionimage` WRITE;
/*!40000 ALTER TABLE `coversionimage` DISABLE KEYS */;
INSERT INTO `coversionimage` VALUES (1,''),(2,'1.jpg');
/*!40000 ALTER TABLE `coversionimage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal` (
  `nid` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(14) DEFAULT NULL,
  `sex` binary(1) DEFAULT NULL,
  `thumbnail` varchar(200) DEFAULT NULL,
  `passPort` varchar(200) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` VALUES (1,'leo','1','1.png','ps','1','1788882129'),(2,'徐徐清风','1','2.png','ps','2','1788882130'),(3,'张炜奇','1','3.png','zhangweiqi','123456','1788882131'),(4,'费孟君','1','4.png','feimengjun','123456','1788882132');
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `support`
--

DROP TABLE IF EXISTS `support`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `support` (
  `cid` int(11) NOT NULL,
  `nid` int(11) NOT NULL,
  PRIMARY KEY (`cid`,`nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `support`
--

LOCK TABLES `support` WRITE;
/*!40000 ALTER TABLE `support` DISABLE KEYS */;
INSERT INTO `support` VALUES (0,1),(17,3),(17,4),(19,2),(19,3),(21,1),(24,4);
/*!40000 ALTER TABLE `support` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'botbackend'
--

--
-- Dumping routines for database 'botbackend'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-17 22:07:20
