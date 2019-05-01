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
-- Table structure for table `ricalcoli_apertura_costituzione`
--

DROP TABLE IF EXISTS `ricalcoli_apertura_costituzione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ricalcoli_apertura_costituzione` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idtipoelezione` int(10) unsigned NOT NULL,
  `idtiporicalcolo` int(10) unsigned NOT NULL,
  `numero_sezioni` int(10) unsigned NOT NULL DEFAULT '0',
  `numero_costituite` int(10) unsigned NOT NULL DEFAULT '0',
  `percentuale_costituite` varchar(6) NOT NULL DEFAULT '0.0',
  `numero_aperte` int(10) unsigned NOT NULL DEFAULT '0',
  `percentuale_aperte` varchar(6) NOT NULL DEFAULT '0.0',
  `iscritti_totali` int(10) unsigned NOT NULL,
  `municipio` int(10) unsigned NOT NULL,
  `utente_operazione` varchar(45) NOT NULL,
  `data_operazione` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ricalcoli_apertura_costituzione_tipo_ricalcolo_idx` (`idtiporicalcolo`),
  KEY `fk_ricalcoli_apertura_costituzione_tipo_elezione_idx` (`idtipoelezione`),
  CONSTRAINT `fk_ricalcoli_apertura_costituzione_tipo_elezione` FOREIGN KEY (`idtipoelezione`) REFERENCES `tipoelezione` (`id`),
  CONSTRAINT `fk_ricalcoli_apertura_costituzione_tipo_ricalcolo` FOREIGN KEY (`idtiporicalcolo`) REFERENCES `tipo_ricalcolo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ricalcoli_apertura_costituzione`
--

LOCK TABLES `ricalcoli_apertura_costituzione` WRITE;
/*!40000 ALTER TABLE `ricalcoli_apertura_costituzione` DISABLE KEYS */;
/*!40000 ALTER TABLE `ricalcoli_apertura_costituzione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-01 20:47:16
