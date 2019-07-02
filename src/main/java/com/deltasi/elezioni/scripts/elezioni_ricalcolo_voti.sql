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
-- Table structure for table `ricalcolo_voti`
--

DROP TABLE IF EXISTS `ricalcolo_voti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ricalcolo_voti` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idtipoelezione` int(10) unsigned NOT NULL,
  `idtiporicalcolo` int(10) unsigned NOT NULL,
  `municipio` int(10) unsigned NOT NULL,
  `idlista` int(10) unsigned NOT NULL,
  `numero_voti` int(10) unsigned NOT NULL DEFAULT '0',
  `percentuale_voti` varchar(6) NOT NULL DEFAULT '0.0',
  `numero_sezioni` int(10) unsigned NOT NULL DEFAULT '0',
  `totale_sezioni` int(10) unsigned NOT NULL DEFAULT '0',
  `percentuale_sezioni_pervenute` varchar(6) NOT NULL DEFAULT '0.0',
  `iscritti_pervenute` int(10) unsigned NOT NULL DEFAULT '0',
  `iscritti_totale` int(10) unsigned NOT NULL DEFAULT '0',
  `votanti_pervenute` int(10) unsigned NOT NULL DEFAULT '0',
  `votanti_totali` int(10) unsigned NOT NULL,
  `percentuale_votanti_pervenute` varchar(6) NOT NULL DEFAULT '0.0',
  `percentuale_votanti_totale` varchar(6) NOT NULL DEFAULT '0.0',
  `utente_operazione` varchar(45) NOT NULL,
  `data_operazione` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ricalcolo_voti_tipo_elezione_idx` (`idtipoelezione`),
  KEY `fk_ricalcolo_voti_tipo_ricalcolo_idx` (`idtiporicalcolo`),
  KEY `fk_ricalcolo_voti_lista_idx` (`idlista`),
  CONSTRAINT `fk_ricalcolo_voti_lista` FOREIGN KEY (`idlista`) REFERENCES `liste` (`id`),
  CONSTRAINT `fk_ricalcolo_voti_tipo_elezione` FOREIGN KEY (`idtipoelezione`) REFERENCES `tipoelezione` (`id`),
  CONSTRAINT `fk_ricalcolo_voti_tipo_ricalcolo` FOREIGN KEY (`idtiporicalcolo`) REFERENCES `tipo_ricalcolo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ricalcolo_voti`
--

LOCK TABLES `ricalcolo_voti` WRITE;
/*!40000 ALTER TABLE `ricalcolo_voti` DISABLE KEYS */;
INSERT INTO `ricalcolo_voti` VALUES (1,1,11,1,13,120,'10,81',2,164,'1,22',1898,0,1110,0,'58,48','0.0','admin','2019-05-04 20:21:04'),(2,1,11,1,14,30,'2,7',2,164,'1,22',1898,166,1110,0,'58,48','0.0','admin','2019-05-04 20:21:04'),(3,1,11,1,15,30,'2,7',2,164,'1,22',1898,0,1110,0,'58,48','0.0','admin','2019-05-04 20:21:04'),(4,1,11,1,16,30,'2,7',2,164,'1,22',1898,0,1110,0,'58,48','0.0','admin','2019-05-04 20:21:04'),(5,1,11,1,17,710,'63,96',2,164,'1,22',1898,0,1110,0,'58,48','0.0','admin','2019-05-04 20:21:04'),(6,1,11,1,18,30,'2,7',2,164,'1,22',1898,0,1110,0,'58,48','0.0','admin','2019-05-04 20:21:04'),(7,1,11,1,19,30,'2,7',2,164,'1,22',1898,0,1110,0,'58,48','0.0','admin','2019-05-04 20:21:04'),(8,1,11,1,20,50,'4,5',2,164,'1,22',1898,0,1110,0,'58,48','0.0','admin','2019-05-04 20:21:04'),(9,1,11,1,21,30,'2,7',2,164,'1,22',1898,0,1110,0,'58,48','0.0','admin','2019-05-04 20:21:04'),(10,1,11,1,22,10,'0,9',2,164,'1,22',1898,0,1110,0,'58,48','0.0','admin','2019-05-04 20:21:04'),(11,1,11,1,23,10,'0,9',2,164,'1,22',1898,0,1110,0,'58,48','0.0','admin','2019-05-04 20:21:04'),(12,1,11,1,24,20,'1,8',2,164,'1,22',1898,0,1110,0,'58,48','0.0','admin','2019-05-04 20:21:04'),(13,1,11,1,25,10,'0,9',2,164,'1,22',1898,0,1110,0,'58,48','0.0','admin','2019-05-04 20:21:04'),(14,1,11,99,13,120,'10,81',2,2600,'0,08',1898,2600,1110,0,'58,48','0.0','admin','2019-05-04 20:30:27'),(15,1,11,99,14,30,'2,7',2,2600,'0,08',1898,2600,1110,0,'58,48','0.0','admin','2019-05-04 20:30:27'),(16,1,11,99,15,30,'2,7',2,2600,'0,08',1898,2600,1110,0,'58,48','0.0','admin','2019-05-04 20:30:27'),(17,1,11,99,16,30,'2,7',2,2600,'0,08',1898,2600,1110,0,'58,48','0.0','admin','2019-05-04 20:30:27'),(18,1,11,99,17,710,'63,96',2,2600,'0,08',1898,2600,1110,0,'58,48','0.0','admin','2019-05-04 20:30:27'),(19,1,11,99,18,30,'2,7',2,2600,'0,08',1898,2600,1110,0,'58,48','0.0','admin','2019-05-04 20:30:27'),(20,1,11,99,19,30,'2,7',2,2600,'0,08',1898,2600,1110,0,'58,48','0.0','admin','2019-05-04 20:30:27'),(21,1,11,99,20,50,'4,5',2,2600,'0,08',1898,2600,1110,0,'58,48','0.0','admin','2019-05-04 20:30:27'),(22,1,11,99,21,30,'2,7',2,2600,'0,08',1898,2600,1110,0,'58,48','0.0','admin','2019-05-04 20:30:27'),(23,1,11,99,22,10,'0,9',2,2600,'0,08',1898,2600,1110,0,'58,48','0.0','admin','2019-05-04 20:30:27'),(24,1,11,99,23,10,'0,9',2,2600,'0,08',1898,2600,1110,0,'58,48','0.0','admin','2019-05-04 20:30:27'),(25,1,11,99,24,20,'1,8',2,2600,'0,08',1898,2600,1110,0,'58,48','0.0','admin','2019-05-04 20:30:27'),(26,1,11,99,25,10,'0,9',2,2600,'0,08',1898,2600,1110,0,'58,48','0.0','admin','2019-05-04 20:30:27');
/*!40000 ALTER TABLE `ricalcolo_voti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-02 19:02:14
