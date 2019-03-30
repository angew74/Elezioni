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
-- Table structure for table `affluenze`
--

DROP TABLE IF EXISTS `affluenze`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `affluenze` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idtipoelezione` int(10) unsigned DEFAULT NULL,
  `numerosezione` int(10) unsigned NOT NULL,
  `idplesso` int(10) unsigned DEFAULT NULL,
  `idiscritti` int(10) unsigned NOT NULL,
  `costituzione1` int(1) unsigned DEFAULT '0',
  `costituzione2` int(1) unsigned DEFAULT '0',
  `apertura1` int(1) unsigned DEFAULT '0',
  `apertura2` int(1) unsigned DEFAULT '0',
  `apertura3` int(1) unsigned DEFAULT '0',
  `affluenza1` int(1) unsigned DEFAULT '0',
  `affluenza2` int(1) unsigned DEFAULT '0',
  `affluenza3` int(1) unsigned DEFAULT '0',
  `affluenza4` int(1) unsigned DEFAULT '0',
  `affluenza5` int(1) unsigned DEFAULT '0',
  `votantimaschi1` int(10) unsigned DEFAULT NULL,
  `votantimaschi2` int(10) unsigned DEFAULT NULL,
  `votantimaschi3` int(10) unsigned DEFAULT NULL,
  `votantimaschi4` int(10) unsigned DEFAULT NULL,
  `votantimaschi5` int(10) unsigned DEFAULT NULL,
  `votantifemmine1` int(10) unsigned DEFAULT NULL,
  `votantifemmine2` int(10) unsigned DEFAULT NULL,
  `votantifemmine3` int(10) unsigned DEFAULT NULL,
  `votantifemmine4` int(10) unsigned DEFAULT NULL,
  `votantifemmine5` int(10) unsigned DEFAULT NULL,
  `votantitotali1` int(10) unsigned DEFAULT NULL,
  `votantitotali2` int(10) unsigned DEFAULT NULL,
  `votantitotali3` int(10) unsigned DEFAULT NULL,
  `votantitotali4` int(10) unsigned DEFAULT NULL,
  `votantitotali5` int(10) unsigned DEFAULT NULL,
  `dataoperazione` datetime DEFAULT NULL,
  `utenteoperazione` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `numerosezione_UNIQUE` (`numerosezione`),
  KEY `fk_affluenze_iscritti_idx` (`idiscritti`),
  KEY `fk_affluenze_tipo_elezione_idx` (`idtipoelezione`),
  KEY `fk_affluenze_plessi_idx` (`idplesso`),
  CONSTRAINT `fk_affluenze_iscritti` FOREIGN KEY (`idiscritti`) REFERENCES `iscritti` (`idiscritti`),
  CONSTRAINT `fk_affluenze_plessi` FOREIGN KEY (`idplesso`) REFERENCES `plessi` (`id`),
  CONSTRAINT `fk_affluenze_tipo_elezione` FOREIGN KEY (`idtipoelezione`) REFERENCES `tipoelezione` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affluenze`
--

LOCK TABLES `affluenze` WRITE;
/*!40000 ALTER TABLE `affluenze` DISABLE KEYS */;
INSERT INTO `affluenze` VALUES (1,1,1,NULL,1,1,NULL,1,NULL,NULL,1,NULL,NULL,NULL,NULL,105,NULL,NULL,NULL,NULL,105,NULL,NULL,NULL,NULL,210,NULL,NULL,NULL,NULL,'2019-03-23 20:20:26','admin'),(3,1,2,NULL,2,1,NULL,1,NULL,NULL,1,NULL,NULL,NULL,NULL,100,NULL,NULL,NULL,NULL,100,NULL,NULL,NULL,NULL,200,NULL,NULL,NULL,NULL,'2019-03-24 19:40:46','admin'),(4,1,3,NULL,3,1,NULL,1,NULL,NULL,1,NULL,NULL,NULL,NULL,40,NULL,NULL,NULL,NULL,40,NULL,NULL,NULL,NULL,80,NULL,NULL,NULL,NULL,'2019-03-25 14:51:38','admin'),(5,1,5,NULL,5,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-03-29 11:30:33','admin'),(6,1,6,NULL,6,1,NULL,1,NULL,NULL,1,NULL,NULL,NULL,NULL,50,NULL,NULL,NULL,NULL,55,NULL,NULL,NULL,NULL,105,NULL,NULL,NULL,NULL,'2019-03-29 12:35:58','admin');
/*!40000 ALTER TABLE `affluenze` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `affluenze_BEFORE_UPDATE` BEFORE UPDATE ON `affluenze` FOR EACH ROW BEGIN
  INSERT INTO affluenze_storico (
  `id`,
`idtipoelezione`,
`numerosezione`,
`idplesso`,
`idiscritti`,
`costituzione1`,
`costituzione2`,
`apertura1`,
`apertura2`,
`apertura3`,
`affluenza1`,
`affluenza2`,
`affluenza3`,
`affluenza4`,
`affluenza5`,
`votantimaschi1`,
`votantimaschi2`,
`votantimaschi3`,
`votantimaschi4`,
`votantimaschi5`,
`votantifemmine1`,
`votantifemmine2`,
`votantifemmine3`,
`votantifemmine4`,
`votantifemmine5`,
`votantitotali1`,
`votantitotali2`,
`votantitotali3`,
`votantitotali4`,
`votantitotali5`,
`dataoperazioneold`,
`utenteoperazioneold`,
`dataoperazione`,
`utenteoperazione`)
	  VALUES(OLD.id,
      OLD.idtipoelezione,
OLD.numerosezione,
OLD.idplesso,
OLD.idiscritti,
OLD.costituzione1,
OLD.costituzione2,
OLD.apertura1,
OLD.apertura2,
OLD.apertura3,
OLD.affluenza1,
OLD.affluenza2,
OLD.affluenza3,
OLD.affluenza4,
OLD.affluenza5,
OLD.votantimaschi1,
OLD.votantimaschi2,
OLD.votantimaschi3,
OLD.votantimaschi4,
OLD.votantimaschi5,
OLD.votantifemmine1,
OLD.votantifemmine2,
OLD.votantifemmine3,
OLD.votantifemmine4,
OLD.votantifemmine5,
OLD.votantitotali1,
OLD.votantitotali2,
OLD.votantitotali3,
OLD.votantitotali4,
OLD.votantitotali5,
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

-- Dump completed on 2019-03-30 12:06:07
