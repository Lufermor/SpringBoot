CREATE DATABASE  IF NOT EXISTS `blacklist_club` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `blacklist_club`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: blacklist_club
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
-- Table structure for table `clientevip`
--

DROP TABLE IF EXISTS `clientevip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientevip` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `vipzone_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hu6rswvvut2h8e2leom660jrb` (`dni`),
  KEY `FK6xust5feud9qbi025p4bna3b2` (`vipzone_id`),
  CONSTRAINT `FK6xust5feud9qbi025p4bna3b2` FOREIGN KEY (`vipzone_id`) REFERENCES `vipzone` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientevip`
--

LOCK TABLES `clientevip` WRITE;
/*!40000 ALTER TABLE `clientevip` DISABLE KEYS */;
INSERT INTO `clientevip` VALUES (1,'Madrid','11111111A',5,'Mariano',3),(2,'Aso','12345678A',1,'Ramiro',3),(4,'Oporto','12345678B',3,'Alfa',3),(5,'Alda','12345678C',14,'Raul',1),(6,'kasa','12345678D',15,'Linda',1),(9,'EDITADO','99999999A',20,'Nuevo',1);
/*!40000 ALTER TABLE `clientevip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id_persona` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellidos` varchar(45) DEFAULT NULL,
  `Fecha_nac` date DEFAULT NULL,
  `Telefono` varchar(45) DEFAULT NULL,
  `Provincia` varchar(45) DEFAULT NULL,
  `Profesion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'John','Doe','1800-01-01','600000001','Huesca','Vigilante'),(2,'Contacto','Prueba','1111-11-11','DijoQueNo','Irlanda','Pruebador'),(3,'Contacto2','Prueba2','2222-11-11','555sinCorriente','Sinergia','NiNi'),(4,'A','AA','1111-11-12','--','Planeta Tierra','Vegano'),(5,'Contacto','Pa Editar*',NULL,'Editado1','Editado2','Edit3'),(7,'Pa','Borrar',NULL,'3','',''),(8,'Pa','Borrar',NULL,'46','','');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vipzone`
--

DROP TABLE IF EXISTS `vipzone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vipzone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `disponibilidad` int DEFAULT NULL,
  `gasto` double DEFAULT NULL,
  `num_personas` int DEFAULT NULL,
  `zona` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vipzone`
--

LOCK TABLES `vipzone` WRITE;
/*!40000 ALTER TABLE `vipzone` DISABLE KEYS */;
INSERT INTO `vipzone` VALUES (1,1,5000,5000,'Salesianos'),(2,1,3000,3000,'Miami'),(3,0,1000,400,'Reservado sin editar'),(4,1,1000,200,'Reservado editado');
/*!40000 ALTER TABLE `vipzone` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-23  6:59:53
