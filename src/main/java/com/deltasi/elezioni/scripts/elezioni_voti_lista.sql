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
-- Table structure for table `voti_lista`
--

DROP TABLE IF EXISTS `voti_lista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `voti_lista` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `listaid` int(10) unsigned NOT NULL,
  `sezioneid` int(10) unsigned NOT NULL,
  `tipoelezioneid` int(10) unsigned NOT NULL,
  `municipio` int(10) unsigned DEFAULT NULL,
  `voti` int(10) unsigned NOT NULL DEFAULT '0',
  `votigeneraliid` int(10) unsigned NOT NULL,
  `data_operazione` datetime NOT NULL,
  `utente_operazione` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_voti_lista_sezioni_idx` (`sezioneid`),
  KEY `fk_voti_lista_liste_idx` (`listaid`),
  KEY `fk_voti_lista_tipo_elezione_idx` (`tipoelezioneid`),
  KEY `fk_voti_lista_voti_generali_idx` (`votigeneraliid`),
  CONSTRAINT `fk_voti_lista_liste` FOREIGN KEY (`listaid`) REFERENCES `liste` (`id`),
  CONSTRAINT `fk_voti_lista_sezioni` FOREIGN KEY (`sezioneid`) REFERENCES `sezioni` (`id`),
  CONSTRAINT `fk_voti_lista_tipo_elezione` FOREIGN KEY (`tipoelezioneid`) REFERENCES `tipoelezione` (`id`),
  CONSTRAINT `fk_voti_lista_voti_generali` FOREIGN KEY (`votigeneraliid`) REFERENCES `voti_generali` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voti_lista`
--

LOCK TABLES `voti_lista` WRITE;
/*!40000 ALTER TABLE `voti_lista` DISABLE KEYS */;
INSERT INTO `voti_lista` VALUES (3,38,3128,4,0,77,3,'2019-07-03 15:01:00','admin'),(4,37,3128,4,0,0,3,'2019-07-03 15:01:00','admin'),(5,50,3128,4,0,59,3,'2019-07-03 15:01:00','admin'),(6,34,3128,4,0,0,3,'2019-07-03 15:01:00','admin'),(7,31,3128,4,0,0,3,'2019-07-03 15:01:00','admin'),(8,26,3128,4,0,50,3,'2019-07-03 15:01:00','admin'),(9,39,3128,4,0,0,3,'2019-07-03 15:01:00','admin'),(10,43,3128,4,0,4,3,'2019-07-03 15:01:00','admin'),(11,40,3128,4,0,0,3,'2019-07-03 15:01:00','admin'),(12,57,3128,4,0,0,3,'2019-07-03 15:01:00','admin'),(13,53,3128,4,0,5,3,'2019-07-03 15:01:00','admin'),(14,41,3128,4,0,0,3,'2019-07-03 15:01:00','admin'),(15,42,3128,4,0,0,3,'2019-07-03 15:01:00','admin');
/*!40000 ALTER TABLE `voti_lista` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `voti_lista_BEFORE_UPDATE` BEFORE UPDATE ON `voti_lista` FOR EACH ROW BEGIN
INSERT INTO voti_lista_storico (
  `id`,
`listaid`,
`tipoelezioneid`,
`sezioneid`,
`municipio`,
`voti`,
`votigeneraliid`,
`dataoperazioneold`,
`utenteoperazioneold`,
`data_operazione`,
`utente_operazione`)
 VALUES (OLD.id,
OLD.listaid,
OLD.tipoelezioneid,
OLD.sezioneid,
OLD.municipio,
OLD.voti,
OLD.votigeneraliid,
OLD.data_operazione,
OLD.utente_operazione,
new.data_operazione, 
new.utente_operazione);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-07 11:51:31
