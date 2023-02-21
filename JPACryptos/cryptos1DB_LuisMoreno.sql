CREATE DATABASE  IF NOT EXISTS `cryptos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cryptos`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: cryptos
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countries` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (1,'Spain'),(2,'Francia'),(3,'Portugal'),(4,'Alemania'),(5,'Rumania'),(6,'Polonia'),(10,'Italia'),(11,'Malta'),(12,'RandomEditado'),(14,'Random2'),(16,'vacio'),(17,'vacio2'),(18,'Vacio3');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cryptocurrency`
--

DROP TABLE IF EXISTS `cryptocurrency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cryptocurrency` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `based_in` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` double DEFAULT NULL,
  `country` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcuobr1ya7ati0k9tu34y4mx30` (`country`),
  CONSTRAINT `FKcuobr1ya7ati0k9tu34y4mx30` FOREIGN KEY (`country`) REFERENCES `countries` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cryptocurrency`
--

LOCK TABLES `cryptocurrency` WRITE;
/*!40000 ALTER TABLE `cryptocurrency` DISABLE KEYS */;
INSERT INTO `cryptocurrency` VALUES (1,'mi','imagination','alalal','Guantes',0.00006,1),(2,'otro','a saber','y salga','in28minutes',0.20245,2),(3,'Casillas','pasion','oajie','user1',0.06354,4),(5,'no','pereza','editado','pa borrar',0.564656,10),(6,'hola','inu','lagostios','Prueba',1,3),(7,'','','','a',NULL,1),(8,'Goku','mesas','Editado','b',0.003,2),(9,'','','','c',NULL,3),(10,'','','','d',NULL,4),(11,'','','','e',NULL,5),(12,'','','','f',NULL,6),(13,'','','','f',NULL,6),(14,'','','','g',NULL,10),(15,'','','','h',NULL,11),(16,'','','','i',NULL,12),(17,'','','','j',NULL,1),(18,'','','','k',NULL,2),(19,'','','','l',NULL,3),(20,'','','','m',NULL,4),(21,'','','','n',NULL,5),(22,'','','','o',NULL,6),(23,'','','','p',NULL,10),(24,'','','','q',NULL,11),(25,'','','','r',NULL,12),(27,'s','','','aja',NULL,14),(29,'','','','kaksksk',NULL,11);
/*!40000 ALTER TABLE `cryptocurrency` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-21  1:22:30
