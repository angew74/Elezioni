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
-- Table structure for table `fase_elezione`
--

DROP TABLE IF EXISTS `fase_elezione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fase_elezione` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `codice` varchar(3) NOT NULL,
  `descrizione` varchar(45) NOT NULL,
  `abilitata` int(1) NOT NULL DEFAULT '0',
  `idtipoelezione` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_fase_elezioni_elezioni` (`codice`,`idtipoelezione`),
  KEY `fk_fase_elezione_tipo_elezione_idx` (`idtipoelezione`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fase_elezione`
--

LOCK TABLES `fase_elezione` WRITE;
/*!40000 ALTER TABLE `fase_elezione` DISABLE KEYS */;
INSERT INTO `fase_elezione` VALUES (27,'CO','Costituzione',1,1),(30,'1A','1 Affluenza',1,1),(31,'2A','2 Affluenza',1,1),(32,'3C','Chiusura',1,1),(33,'3A','3 Affluenza',0,1),(34,'4C','Chiusura 4 Affluenza',0,1),(35,'VL','Voti Lista',1,1),(36,'VP','Voti Presidente',0,3),(37,'VS','Voti Sindaco',1,4),(38,'VU','Voti Uninominalie',0,2),(39,'PC','Preferenze Comunali',0,4),(40,'PR','Preferenze Regionali',0,3),(41,'AP','Apertura',1,1),(42,'RCO','Rettifica Costituzione',1,1),(43,'RAP','Rettiifica Apertura',1,1),(44,'R1A','Rettifica 1 Affluenza',1,1),(45,'R2A','Rettifica 2 Affluenza',0,1),(46,'R3C','Rettifica Chiusura',0,1),(47,'RVL','Rettifica Voti Lista',1,1),(48,'RPE','Rettifica Preferenze Europee',0,1),(49,'PE','Preferenze Europee',1,1),(50,'RIC','Ricalcoli Affluenze',1,1),(51,'RIL','Ricalcoli Voti Lista',1,1),(52,'RIP','Ricalcoli Preferenze',1,1),(53,'RIA','Ricalcoli Costituzione Apertura',1,1),(54,'RIS','Ricalcolo Sindaco',0,4),(56,'RPI','Ricalcolo Presidente',0,3),(57,'RCS','Ricalcolo Coalizioni Sindaco',0,4),(58,'RCP','Ricalcolo Coalizioni Presidente',0,3),(72,'CO','Costituzione Seggio',1,4),(73,'1A','1 Affluenza',1,4),(74,'2A','2 Affluenza',1,4),(75,'3C','Chiusura Affluenza',1,4),(76,'AP','Apertura Seggio',1,4),(77,'RAP','Rettifica Apertura',0,4),(78,'R1A','Rettifica 1 Affluenza',0,4),(79,'R2A','Rettifica 2 Affluenza',0,4),(80,'R3C','Rettifica Chiusura Affluenza',0,4),(81,'VL','Voti Lista',0,4),(82,'RVL','Rettifica Voti Lista',0,4),(83,'RIL','Ricalcolo Voti Lista',0,4),(84,'RIP','Ricalcolo Preferenze',0,4),(85,'RVS','Rettifica Voti Sindaco',0,4);
/*!40000 ALTER TABLE `fase_elezione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-16 12:15:10
