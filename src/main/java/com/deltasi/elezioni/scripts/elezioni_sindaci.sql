-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: elezioni
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
-- Table structure for table `sindaci`
--

DROP TABLE IF EXISTS `sindaci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sindaci` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `cognome` varchar(200) NOT NULL,
  `sesso` varchar(1) NOT NULL,
  `progressivo` int(10) unsigned NOT NULL,
  `tipoelezioneid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tipo_elezione_sindaci_idx` (`tipoelezioneid`),
  CONSTRAINT `fk_tipo_elezione_sindaci` FOREIGN KEY (`tipoelezioneid`) REFERENCES `tipoelezione` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sindaci`
--

LOCK TABLES `sindaci` WRITE;
/*!40000 ALTER TABLE `sindaci` DISABLE KEYS */;
INSERT INTO `sindaci` VALUES (1,'IGNAZIO ROBERTO','MARINO','M',1,4),(2,'VIRGINIA','RAGGI','F',2,4),(3,'ALESSANDRO','MUSTILLO','M',3,4),(4,'GIORGIA','MELONI','F',4,4),(5,'ALFREDO','IORIO','M',5,4),(6,'STEFANO','FASSINA','M',6,4),(7,'ALFIO','MARCHINI','M',7,4),(8,'MARIO','ADINOLFI','M',8,4),(9,'DARIO','DI FRANCESCO','M',9,4),(10,'SIMONE','DI STEFANO','M',10,4),(11,'CARLO','RIENZI','M',11,4),(12,'FABRIZIO','VERDUCHI','M',12,4),(13,'MICHEL','EMI MARITATO','M',13,4);
/*!40000 ALTER TABLE `sindaci` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-07 11:51:19
