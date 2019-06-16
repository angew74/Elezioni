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
-- Table structure for table `coalizioni`
--

DROP TABLE IF EXISTS `coalizioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `coalizioni` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idtipoelezione` int(10) unsigned NOT NULL,
  `denominazione` varchar(200) NOT NULL,
  `denominazione_breve` varchar(20) NOT NULL DEFAULT 'NESSUNA',
  `sindacoid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_tipoelezioni_coalizioni_idx` (`idtipoelezione`),
  KEY `fk_sindaci_coalizioni_idx` (`sindacoid`),
  CONSTRAINT `fk_sindaci_coalizioni` FOREIGN KEY (`sindacoid`) REFERENCES `sindaci` (`id`),
  CONSTRAINT `fk_tipoelezioni_coalizioni` FOREIGN KEY (`idtipoelezione`) REFERENCES `tipoelezione` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coalizioni`
--

LOCK TABLES `coalizioni` WRITE;
/*!40000 ALTER TABLE `coalizioni` DISABLE KEYS */;
INSERT INTO `coalizioni` VALUES (1,4,'MARINO','NESSUNA',1),(2,4,'RAGGI','NESSUNA',2),(3,4,'MUSTILLO','NESSUNA',3),(4,4,'MELONI','NESSUNA',4),(5,4,'IORIO','NESSUNA',5),(6,4,'FASSINA','NESSUNA',6),(7,4,'MARCHINI','NESSUNA',7),(8,4,'ADINOLFI','NESSUNA',8),(9,4,'DI FRANCESCO','NESSUNA',9),(10,4,'DI STEFANO','NESSUNA',10),(11,4,'RIENZI','NESSUNA',11),(12,4,'VERDUCHI','NESSUNA',12),(13,4,'EMI MARITATO','NESSUNA',13);
/*!40000 ALTER TABLE `coalizioni` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-16 20:03:46
