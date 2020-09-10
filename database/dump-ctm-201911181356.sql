-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: 192.168.10.107    Database: ctm
-- ------------------------------------------------------
-- Server version	5.5.60-MariaDB

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
-- Table structure for table `ip_contract`
--

DROP TABLE IF EXISTS `ip_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ip_contract` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_dt` datetime NOT NULL,
  `name` varchar(255) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg4mqy2eeyfpne2dn70tha8h9y` (`user_id`),
  CONSTRAINT `FKg4mqy2eeyfpne2dn70tha8h9y` FOREIGN KEY (`user_id`) REFERENCES `ip_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ip_contract`
--

LOCK TABLES `ip_contract` WRITE;
/*!40000 ALTER TABLE `ip_contract` DISABLE KEYS */;
INSERT INTO `ip_contract` VALUES (1,'2019-11-18 10:47:55','NH BANK',2),(2,'2019-11-18 10:49:55','Woori Bank',2);
/*!40000 ALTER TABLE `ip_contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ip_contract_detail`
--

DROP TABLE IF EXISTS `ip_contract_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ip_contract_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `changed_content` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `contract_amount` varchar(255) DEFAULT NULL,
  `contract_dt` datetime DEFAULT NULL,
  `contract_term` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_dt` datetime DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_dt` datetime DEFAULT NULL,
  `payment_dt` datetime DEFAULT NULL,
  `payment_invoice_dt` datetime DEFAULT NULL,
  `payment_ratio` varchar(255) DEFAULT NULL,
  `payment_remain` varchar(255) DEFAULT NULL,
  `payment_value` varchar(255) DEFAULT NULL,
  `record_sts` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `contract_id` bigint(20) DEFAULT NULL,
  `root_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKantlx7slvocc7ekgyyv8q9n2k` (`contract_id`),
  KEY `FKccsge7sf89a7v6g75pv4gbx8a` (`root_id`),
  CONSTRAINT `FKantlx7slvocc7ekgyyv8q9n2k` FOREIGN KEY (`contract_id`) REFERENCES `ip_contract` (`id`),
  CONSTRAINT `FKccsge7sf89a7v6g75pv4gbx8a` FOREIGN KEY (`root_id`) REFERENCES `ip_contract_detail` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ip_contract_detail`
--

LOCK TABLES `ip_contract_detail` WRITE;
/*!40000 ALTER TABLE `ip_contract_detail` DISABLE KEYS */;
INSERT INTO `ip_contract_detail` VALUES (1,'','NH Bank','100000','2019-11-18 10:54:20','term',NULL,'2019-11-18 10:54:20',NULL,NULL,'2019-11-18 10:54:20','2019-11-18 10:54:20','30%','50%','500000',0,'1',1,1,1),(2,'Co gi do sai','NH Bank','100000','2019-11-18 10:54:20','term',NULL,'2019-11-18 10:54:20',NULL,'2019-11-18 10:58:20','2019-11-18 10:54:20','2019-11-18 10:54:20','45%','50%','500000',0,'1',2,1,1),(3,'doi value','NH Bank','100000','2019-11-18 10:54:20','term',NULL,'2019-11-18 10:54:20',NULL,'2019-11-18 11:00:43','2019-11-18 10:54:20','2019-11-18 10:54:20','45%','50%','500000',1,'1',3,1,1),(4,NULL,'Worri Bank','50000','2019-11-18 11:02:44','term 1',NULL,'2019-11-18 11:02:44',NULL,NULL,'2019-11-18 11:02:44','2019-11-18 11:02:44','60%','20%','5500000',1,'1',1,2,4),(5,NULL,'Worri Bank','30000','2019-11-18 11:11:40','term2',NULL,'2019-11-18 11:11:40',NULL,NULL,'2019-11-18 11:11:40','2019-11-18 11:11:40','70%','3%','300000',1,'1',1,2,5);
/*!40000 ALTER TABLE `ip_contract_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ip_role`
--

DROP TABLE IF EXISTS `ip_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ip_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2sf6aqtnlkqc3mn8ckbs826bf` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ip_role`
--

LOCK TABLES `ip_role` WRITE;
/*!40000 ALTER TABLE `ip_role` DISABLE KEYS */;
INSERT INTO `ip_role` VALUES (1,'admin'),(2,'employee');
/*!40000 ALTER TABLE `ip_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ip_user`
--

DROP TABLE IF EXISTS `ip_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ip_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2boa5l7ghfnj8l2ohcvcb1p1l` (`email`),
  UNIQUE KEY `UK_r1rienoytyqeqtdsygetliaik` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ip_user`
--

LOCK TABLES `ip_user` WRITE;
/*!40000 ALTER TABLE `ip_user` DISABLE KEYS */;
INSERT INTO `ip_user` VALUES (1,'quan@gm.com','$2a$10$/JhVZ9XTCbGKGgEm4LOyD.FAGfZ9SCUGbww9p.HA3urafwcMyO0xa',1,'quan1'),(2,'admin','$2a$10$/JhVZ9XTCbGKGgEm4LOyD.FAGfZ9SCUGbww9p.HA3urafwcMyO0xa',1,'admin');
/*!40000 ALTER TABLE `ip_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ip_user_role`
--

DROP TABLE IF EXISTS `ip_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ip_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKrpjsinfuasrcl9n5ah87g5ih9` (`role_id`),
  CONSTRAINT `FKbvxmftut6x2af4vok6radyhop` FOREIGN KEY (`user_id`) REFERENCES `ip_user` (`id`),
  CONSTRAINT `FKrpjsinfuasrcl9n5ah87g5ih9` FOREIGN KEY (`role_id`) REFERENCES `ip_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ip_user_role`
--

LOCK TABLES `ip_user_role` WRITE;
/*!40000 ALTER TABLE `ip_user_role` DISABLE KEYS */;
INSERT INTO `ip_user_role` VALUES (1,2),(2,1);
/*!40000 ALTER TABLE `ip_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ctm'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-18 13:56:17
