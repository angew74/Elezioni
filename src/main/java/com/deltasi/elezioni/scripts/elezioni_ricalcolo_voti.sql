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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ricalcolo_voti`
--

LOCK TABLES `ricalcolo_voti` WRITE;
/*!40000 ALTER TABLE `ricalcolo_voti` DISABLE KEYS */;
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

-- Dump completed on 2019-04-22 20:36:48
