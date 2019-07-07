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
-- Table structure for table `voti_sindaco`
--

DROP TABLE IF EXISTS `voti_sindaco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `voti_sindaco` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tipoelezioneid` int(10) unsigned NOT NULL,
  `sindacoid` int(10) unsigned NOT NULL,
  `sezioneid` int(10) unsigned NOT NULL,
  `municipio` int(10) unsigned NOT NULL,
  `numero_voti` int(10) NOT NULL DEFAULT '0',
  `numero_voti_solo_sindaco` int(10) unsigned NOT NULL DEFAULT '0',
  `votigeneraliid` int(10) unsigned NOT NULL,
  `utente_operazione` varchar(45) NOT NULL,
  `data_operazione` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_voti_sindaco_tipo_elezioni_idx` (`tipoelezioneid`),
  KEY `fk_voti_sindaco_sindaco_idx` (`sindacoid`),
  KEY `fk_voti_sindaco_sezioni_idx` (`sezioneid`),
  KEY `fk_voti_sindaco_voti_generali_idx` (`votigeneraliid`),
  CONSTRAINT `fk_voti_sindaco_sezioni` FOREIGN KEY (`sezioneid`) REFERENCES `sezioni` (`id`),
  CONSTRAINT `fk_voti_sindaco_sindaco` FOREIGN KEY (`sindacoid`) REFERENCES `sindaci` (`id`),
  CONSTRAINT `fk_voti_sindaco_tipo_elezioni` FOREIGN KEY (`tipoelezioneid`) REFERENCES `tipoelezione` (`id`),
  CONSTRAINT `fk_voti_sindaco_voti_generali` FOREIGN KEY (`votigeneraliid`) REFERENCES `voti_generali` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voti_sindaco`
--

LOCK TABLES `voti_sindaco` WRITE;
/*!40000 ALTER TABLE `voti_sindaco` DISABLE KEYS */;
INSERT INTO `voti_sindaco` VALUES (3,4,2,3128,0,0,0,3,'admin','2019-07-03 15:00:50'),(4,4,4,3128,0,0,0,3,'admin','2019-07-03 15:00:50'),(5,4,12,3128,0,0,0,3,'admin','2019-07-03 15:00:50'),(6,4,7,3128,0,5,0,3,'admin','2019-07-03 15:00:50'),(7,4,8,3128,0,0,0,3,'admin','2019-07-03 15:00:50'),(8,4,1,3128,0,117,1,3,'admin','2019-07-03 15:00:50'),(9,4,10,3128,0,0,0,3,'admin','2019-07-03 15:00:50'),(10,4,5,3128,0,0,0,3,'admin','2019-07-03 15:00:50'),(11,4,6,3128,0,4,0,3,'admin','2019-07-03 15:00:50'),(12,4,9,3128,0,62,3,3,'admin','2019-07-03 15:00:50'),(13,4,3,3128,0,81,4,3,'admin','2019-07-03 15:00:50'),(14,4,11,3128,0,0,0,3,'admin','2019-07-03 15:00:50'),(15,4,13,3128,0,0,0,3,'admin','2019-07-03 15:00:50');
/*!40000 ALTER TABLE `voti_sindaco` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `voti_sindaco_BEFORE_UPDATE` BEFORE UPDATE ON `voti_sindaco` FOR EACH ROW BEGIN
INSERT INTO 
VOTI_SINDACO_STORICO (`id`,
`tipoelezioneid`,
`sindacoid`,
`sezioneid`,
`municipio`,
`numero_voti`,
`numero_voti_solo_sindaco`,
`votigeneraliid`,
`utente_operazione_old`,
`data_operazione_old`,
`utente_operazione`,
`data_operazione`)
VALUES (OLD.id,
OLD.tipoelezioneid,
OLD.sindacoid,
OLD.municipio,
OLD.numero_voti,
OLD.numero_voti_solo_sindaco,
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

-- Dump completed on 2019-07-07 11:51:18
