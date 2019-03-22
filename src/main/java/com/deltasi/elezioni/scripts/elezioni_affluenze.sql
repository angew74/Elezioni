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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affluenze`
--

LOCK TABLES `affluenze` WRITE;
/*!40000 ALTER TABLE `affluenze` DISABLE KEYS */;
/*!40000 ALTER TABLE `affluenze` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-22 19:31:50
