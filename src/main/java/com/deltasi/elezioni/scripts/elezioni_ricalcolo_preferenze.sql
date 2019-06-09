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
-- Table structure for table `ricalcolo_preferenze`
--

DROP TABLE IF EXISTS `ricalcolo_preferenze`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ricalcolo_preferenze` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tipoelezioneid` int(10) unsigned NOT NULL,
  `tiporicalcoloid` int(10) unsigned NOT NULL,
  `municipio` int(10) unsigned NOT NULL,
  `listaid` int(10) unsigned NOT NULL,
  `candidatoid` int(10) unsigned NOT NULL,
  `numero_voti` int(10) unsigned NOT NULL,
  `percentuale_voti` varchar(6) DEFAULT '0.0',
  `numero_sezioni` int(10) unsigned NOT NULL DEFAULT '0',
  `totale_sezioni` int(10) unsigned NOT NULL DEFAULT '0',
  `percentuale_sezioni_pervenute` varchar(6) NOT NULL DEFAULT '0.0',
  `iscritti_pervenute` int(10) unsigned NOT NULL DEFAULT '0',
  `iscritti_totale` int(10) unsigned NOT NULL DEFAULT '0',
  `votanti_pervenute` int(10) unsigned NOT NULL DEFAULT '0',
  `votanti_totale` int(10) unsigned NOT NULL DEFAULT '0',
  `percentuale_votanti_pervenute` varchar(6) NOT NULL DEFAULT '0.0',
  `percentuale_votanti_totale` varchar(6) NOT NULL DEFAULT '0.0',
  `utente_operazione` varchar(45) NOT NULL,
  `data_operazione` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ricalcolo_preferenze_tipo_elezione_idx` (`tipoelezioneid`),
  KEY `fk_ricalcolo_preferenze_candidato_idx` (`candidatoid`),
  KEY `fk_ricalcolo_preferenze_liste_idx` (`listaid`),
  KEY `fk_ricalcolo_tipo_ricalcolo_idx` (`tiporicalcoloid`),
  CONSTRAINT `fk_ricalcolo_preferenze_candidato` FOREIGN KEY (`candidatoid`) REFERENCES `candidati` (`id`),
  CONSTRAINT `fk_ricalcolo_preferenze_liste` FOREIGN KEY (`listaid`) REFERENCES `liste` (`id`),
  CONSTRAINT `fk_ricalcolo_preferenze_tipo_elezione` FOREIGN KEY (`tipoelezioneid`) REFERENCES `tipoelezione` (`id`),
  CONSTRAINT `fk_ricalcolo_tipo_ricalcolo` FOREIGN KEY (`tiporicalcoloid`) REFERENCES `tipo_ricalcolo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ricalcolo_preferenze`
--

LOCK TABLES `ricalcolo_preferenze` WRITE;
/*!40000 ALTER TABLE `ricalcolo_preferenze` DISABLE KEYS */;
INSERT INTO `ricalcolo_preferenze` VALUES (1,1,12,1,13,1,100,'14,08',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-12 18:32:14'),(2,1,12,1,13,2,100,'14,08',1,164,'0,61',932,166,710,0,'76,18','0.0','admin','2019-05-12 18:32:14'),(3,1,12,1,13,5,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-12 18:32:14'),(4,1,12,1,13,7,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-12 18:32:14'),(5,1,12,1,13,9,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-12 18:32:14'),(6,1,12,1,13,10,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-12 18:32:14'),(7,1,12,1,13,16,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-12 18:32:14'),(8,1,12,1,13,18,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-12 18:32:14'),(9,1,12,1,13,21,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-12 18:32:14'),(10,1,12,1,13,23,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-12 18:32:14'),(11,1,12,1,13,1,100,'14,08',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-18 20:29:08'),(12,1,12,1,13,2,100,'14,08',1,164,'0,61',932,166,710,0,'76,18','0.0','admin','2019-05-18 20:29:08'),(13,1,12,1,13,5,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-18 20:29:08'),(14,1,12,1,13,7,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-18 20:29:08'),(15,1,12,1,13,9,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-18 20:29:08'),(16,1,12,1,13,10,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-18 20:29:08'),(17,1,12,1,13,16,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-18 20:29:08'),(18,1,12,1,13,18,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-18 20:29:08'),(19,1,12,1,13,21,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-18 20:29:08'),(20,1,12,1,13,23,0,'0',1,164,'0,61',932,0,710,0,'76,18','0.0','admin','2019-05-18 20:29:08');
/*!40000 ALTER TABLE `ricalcolo_preferenze` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-09 19:01:10
