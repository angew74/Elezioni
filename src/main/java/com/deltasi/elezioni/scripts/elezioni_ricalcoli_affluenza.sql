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
-- Table structure for table `ricalcoli_affluenza`
--

DROP TABLE IF EXISTS `ricalcoli_affluenza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ricalcoli_affluenza` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idtipoelezione` int(10) unsigned NOT NULL,
  `idtiporicalcolo` int(10) unsigned NOT NULL,
  `municipio` int(10) unsigned NOT NULL,
  `affluenza_totale` int(10) unsigned NOT NULL DEFAULT '0',
  `percentuale_totale` varchar(6) NOT NULL DEFAULT '0.0',
  `affluenza_maschi` int(10) unsigned NOT NULL DEFAULT '0',
  `percentuale_maschi` varchar(6) NOT NULL DEFAULT '0.0',
  `affluenza_femmine` int(10) unsigned NOT NULL DEFAULT '0',
  `percentuale_femmine` varchar(6) NOT NULL DEFAULT '0.0',
  `numero_affluenza` int(10) unsigned NOT NULL,
  `numero_sezioni` int(10) unsigned DEFAULT '0',
  `totale_sezioni` int(10) unsigned NOT NULL DEFAULT '0',
  `utente_operazione` varchar(45) NOT NULL,
  `data_operazione` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ricalcoli_affluenza_idx` (`idtiporicalcolo`),
  KEY `fk_ricaloli_affluenza_tipo_elezione_idx` (`idtipoelezione`),
  CONSTRAINT `fk_ricalcoli_affluenza_tipo_ricalcolo` FOREIGN KEY (`idtiporicalcolo`) REFERENCES `tipo_ricalcolo` (`id`),
  CONSTRAINT `fk_ricaloli_affluenza_tipo_elezione` FOREIGN KEY (`idtipoelezione`) REFERENCES `tipoelezione` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ricalcoli_affluenza`
--

LOCK TABLES `ricalcoli_affluenza` WRITE;
/*!40000 ALTER TABLE `ricalcoli_affluenza` DISABLE KEYS */;
/*!40000 ALTER TABLE `ricalcoli_affluenza` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-14 20:54:48
