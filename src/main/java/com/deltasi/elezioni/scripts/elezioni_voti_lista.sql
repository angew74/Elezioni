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
-- Table structure for table `voti_lista`
--

DROP TABLE IF EXISTS `voti_lista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `voti_lista` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idlista` int(10) unsigned NOT NULL,
  `idsezione` int(10) unsigned NOT NULL,
  `idtipoelezione` int(10) unsigned NOT NULL,
  `municipio` int(10) unsigned DEFAULT NULL,
  `voti` int(10) unsigned NOT NULL DEFAULT '0',
  `dataoperazione` datetime NOT NULL,
  `utenteoperazione` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_voti_lista_sezioni_idx` (`idsezione`),
  KEY `fk_voti_lista_liste_idx` (`idlista`),
  KEY `fk_voti_lista_tipo_elezione_idx` (`idtipoelezione`),
  CONSTRAINT `fk_voti_lista_liste` FOREIGN KEY (`idlista`) REFERENCES `liste` (`id`),
  CONSTRAINT `fk_voti_lista_sezioni` FOREIGN KEY (`idsezione`) REFERENCES `sezioni` (`id`),
  CONSTRAINT `fk_voti_lista_tipo_elezione` FOREIGN KEY (`idtipoelezione`) REFERENCES `tipoelezione` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voti_lista`
--

LOCK TABLES `voti_lista` WRITE;
/*!40000 ALTER TABLE `voti_lista` DISABLE KEYS */;
INSERT INTO `voti_lista` VALUES (1,13,533,1,NULL,100,'2019-04-13 20:19:44','admin'),(2,14,533,1,NULL,10,'2019-04-13 20:19:44','admin'),(3,15,533,1,NULL,10,'2019-04-13 20:19:44','admin'),(4,16,533,1,NULL,10,'2019-04-13 20:19:44','admin'),(5,17,533,1,NULL,200,'2019-04-13 20:19:44','admin'),(6,18,533,1,NULL,10,'2019-04-13 20:19:44','admin'),(7,19,533,1,NULL,10,'2019-04-13 20:19:44','admin'),(8,20,533,1,NULL,10,'2019-04-13 20:19:44','admin'),(9,21,533,1,NULL,10,'2019-04-13 20:19:44','admin'),(10,22,533,1,NULL,10,'2019-04-13 20:19:44','admin'),(11,23,533,1,NULL,10,'2019-04-13 20:19:44','admin'),(12,24,533,1,NULL,10,'2019-04-13 20:19:44','admin'),(13,25,533,1,NULL,0,'2019-04-13 20:19:44','admin'),(14,13,535,1,NULL,20,'2019-04-26 20:20:08','admin'),(15,14,535,1,NULL,20,'2019-04-26 20:20:08','admin'),(16,15,535,1,NULL,20,'2019-04-26 20:20:08','admin'),(17,16,535,1,NULL,20,'2019-04-26 20:20:08','admin'),(18,17,535,1,NULL,510,'2019-04-26 20:20:08','admin'),(19,18,535,1,NULL,20,'2019-04-26 20:20:08','admin'),(20,19,535,1,NULL,20,'2019-04-26 20:20:08','admin'),(21,20,535,1,NULL,40,'2019-04-26 20:20:08','admin'),(22,21,535,1,NULL,20,'2019-04-26 20:20:08','admin'),(23,22,535,1,NULL,0,'2019-04-26 20:20:08','admin'),(24,23,535,1,NULL,0,'2019-04-26 20:20:08','admin'),(25,24,535,1,NULL,10,'2019-04-26 20:20:08','admin'),(26,25,535,1,NULL,10,'2019-04-26 20:20:08','admin');
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
`idlista`,
`idtipoelezione`,
`idsezione`,
`municipio`,
`voti`,
`dataoperazioneold`,
`utenteoperazioneold`,
`dataoperazione`,
`utenteoperazione`)
 VALUES (OLD.id,
OLD.idlista,
OLD.idtipoelezione,
OLD.idsezione,
OLD.municipio,
OLD.voti,
OLD.dataoperazione,
OLD.utenteoperazione,
new.dataoperazione, 
new.utenteoperazione);
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

-- Dump completed on 2019-06-16 20:03:41
