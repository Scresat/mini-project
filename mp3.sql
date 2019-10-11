CREATE DATABASE  IF NOT EXISTS `mp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mp`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mp
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `billid` int(11) NOT NULL AUTO_INCREMENT,
  `price` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  PRIMARY KEY (`billid`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (3,2,'2019-10-02','20:38:33'),(4,22,'2019-10-02','21:22:19'),(5,10,'2019-10-02','21:26:37'),(6,108,'2019-10-02','23:00:22'),(7,22,'2019-10-02','23:05:37'),(8,10,'2019-10-03','23:54:46'),(10,10,'2019-10-03','23:56:53'),(11,44,'2019-10-04','00:00:37'),(12,100,'2019-10-05','18:28:13'),(13,44,'2019-10-05','19:59:48'),(14,7,'2019-10-05','20:00:25'),(15,31,'2019-10-05','20:05:13'),(16,19,'2021-12-12','20:20:20'),(32,185,'2019-10-08','13:04:53'),(33,60,'2019-10-08','13:16:59'),(34,2000,'2019-10-08','13:30:17'),(36,1125,'2019-10-08','13:31:19'),(37,120,'2019-10-08','20:29:35'),(38,10,'2019-10-08','20:35:33'),(39,30,'2019-10-08','20:40:59'),(40,160,'2019-10-08','20:46:31'),(41,20,'2019-10-08','20:47:53'),(42,1700,'2019-10-08','20:48:17'),(43,77,'2019-10-08','22:03:39'),(44,245,'2019-10-08','22:05:56'),(45,122,'2019-10-08','22:11:48'),(46,30,'2019-10-08','22:15:02'),(48,100,'2019-10-08','22:19:07'),(49,190,'2019-10-08','22:51:43'),(50,10,'2019-10-08','23:07:36'),(51,3800,'2019-10-09','00:47:54'),(52,290,'2019-10-09','01:06:25'),(53,275,'2019-10-09','11:03:29'),(54,250,'2019-10-09','11:37:31'),(56,65,'2019-10-09','19:02:42'),(57,140,'2019-10-09','22:22:08');
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  KEY `id_idx` (`id`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `medicine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `expiry` date DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (17,'Acebutolol','Tablet','2020-01-02',20,16),(18,'Aclovate','Tablet','2021-01-07',30,2),(19,'Paracetamol','Tablet','2021-01-08',10,11),(22,'Burnol','Cream','2019-01-14',20,4),(23,'Licinopril','Capsule','2020-01-14',85,1),(25,'d cold total','Tablet','2020-01-08',5,1),(26,'eno','Other','2022-01-14',7,9),(28,'Hydrozinocolonite','Liquid','2020-10-05',120,19);
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `outofstocktrigger` BEFORE UPDATE ON `medicine` FOR EACH ROW begin
if NEW.quantity <= 0
then
insert into out_of_stock
set id = NEW.id;
elseif NEW.quantity > 0
then
delete from out_of_stock where out_of_stock.id = NEW.id;
end if;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `out_of_stock`
--

DROP TABLE IF EXISTS `out_of_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `out_of_stock` (
  `id` int(11) NOT NULL,
  KEY `out_of_stock_ibfk_1` (`id`),
  CONSTRAINT `out_of_stock_ibfk_1` FOREIGN KEY (`id`) REFERENCES `medicine` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `out_of_stock`
--

LOCK TABLES `out_of_stock` WRITE;
/*!40000 ALTER TABLE `out_of_stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `out_of_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('abcd','123'),('adharv','123'),('admin','admin'),('admin2','123'),('akshay','123'),('akshay2','1234'),('sahil','123'),('sat','123'),('satyam','123'),('satyam6','1234');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mp'
--

--
-- Dumping routines for database 'mp'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-10  0:03:54
