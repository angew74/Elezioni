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
-- Table structure for table `tipo_interrogazione`
--

DROP TABLE IF EXISTS `tipo_interrogazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_interrogazione` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(200) NOT NULL,
  `codice_fase` varchar(3) NOT NULL,
  `codice` varchar(3) NOT NULL,
  `tipoelezioneid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tipo_interrogazione_tipo_elezione_idx` (`tipoelezioneid`),
  CONSTRAINT `tipo_interrogazione_tipo_elezione` FOREIGN KEY (`tipoelezioneid`) REFERENCES `tipoelezione` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_interrogazione`
--

LOCK TABLES `tipo_interrogazione` WRITE;
/*!40000 ALTER TABLE `tipo_interrogazione` DISABLE KEYS */;
INSERT INTO `tipo_interrogazione` VALUES (1,'Interrogazione 1 Affluenza','RIC','AF1',1),(2,'Interrogazione 2 Affluenza','RIC','AF2',1),(3,'Interrogazione Chiusura','RIC','CHI',1),(4,'Interrogazione 1 Apertura','RIA','AP1',1),(5,'Interrogazione 1 Costituzione','RIA','CO1',1),(6,'Interrogazione Voti Lista','RIL','VL',1),(7,'Interrogazione Preferenze','RIP','VP',1);
/*!40000 ALTER TABLE `tipo_interrogazione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-05 21:01:24
