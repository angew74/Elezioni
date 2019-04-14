-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: elezioni
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `voti_lista`
--

DROP TABLE IF EXISTS `voti_lista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `voti_lista` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idlista` int(10) unsigned NOT NULL,
  `idsezione` int(10) unsigned NOT NULL,
  `voti` int(10) unsigned NOT NULL DEFAULT '0',
  `dataoperazione` datetime NOT NULL,
  `utenteoperazione` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_voti_lista_sezioni_idx` (`idsezione`),
  KEY `fk_voti_lista_liste_idx` (`idlista`),
  CONSTRAINT `fk_voti_lista_liste` FOREIGN KEY (`idlista`) REFERENCES `liste` (`id`),
  CONSTRAINT `fk_voti_lista_sezioni` FOREIGN KEY (`idsezione`) REFERENCES `sezioni` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voti_lista`
--

LOCK TABLES `voti_lista` WRITE;
/*!40000 ALTER TABLE `voti_lista` DISABLE KEYS */;
INSERT INTO `voti_lista` VALUES (1,13,533,100,'2019-04-13 20:19:44','admin'),(2,14,533,10,'2019-04-13 20:19:44','admin'),(3,15,533,10,'2019-04-13 20:19:44','admin'),(4,16,533,10,'2019-04-13 20:19:44','admin'),(5,17,533,200,'2019-04-13 20:19:44','admin'),(6,18,533,10,'2019-04-13 20:19:44','admin'),(7,19,533,10,'2019-04-13 20:19:44','admin'),(8,20,533,10,'2019-04-13 20:19:44','admin'),(9,21,533,10,'2019-04-13 20:19:44','admin'),(10,22,533,10,'2019-04-13 20:19:44','admin'),(11,23,533,10,'2019-04-13 20:19:44','admin'),(12,24,533,10,'2019-04-13 20:19:44','admin'),(13,25,533,0,'2019-04-13 20:19:44','admin');
/*!40000 ALTER TABLE `voti_lista` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-14 20:54:51
