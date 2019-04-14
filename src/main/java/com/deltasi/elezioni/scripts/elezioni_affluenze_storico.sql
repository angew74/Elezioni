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
-- Table structure for table `affluenze_storico`
--

DROP TABLE IF EXISTS `affluenze_storico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `affluenze_storico` (
  `id` int(10) unsigned NOT NULL,
  `idtipoelezione` int(10) unsigned NOT NULL,
  `idsezione` int(10) unsigned NOT NULL,
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
  `dataoperazioneold` datetime NOT NULL,
  `utenteoperazioneold` varchar(45) NOT NULL,
  `dataoperazione` datetime NOT NULL,
  `utenteoperazione` varchar(45) NOT NULL,
  KEY `fk_affluenze_storico_iscritti_idx` (`idiscritti`),
  KEY `fk_affluenze_storico_tipo_elezione_idx` (`idtipoelezione`),
  KEY `fk_affluenze_storico_plessi_idx` (`idplesso`),
  KEY `fk_affluenze_storico_sezioni_idx` (`idsezione`),
  CONSTRAINT `fk_affluenze_storico_iscritti` FOREIGN KEY (`idiscritti`) REFERENCES `iscritti` (`idiscritti`),
  CONSTRAINT `fk_affluenze_storico_plessi` FOREIGN KEY (`idplesso`) REFERENCES `plessi` (`id`),
  CONSTRAINT `fk_affluenze_storico_tipo_elezione` FOREIGN KEY (`idtipoelezione`) REFERENCES `tipoelezione` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affluenze_storico`
--

LOCK TABLES `affluenze_storico` WRITE;
/*!40000 ALTER TABLE `affluenze_storico` DISABLE KEYS */;
INSERT INTO `affluenze_storico` VALUES (1,1,1,NULL,1,1,NULL,1,NULL,NULL,1,NULL,NULL,NULL,NULL,105,NULL,NULL,NULL,NULL,105,NULL,NULL,NULL,NULL,210,NULL,NULL,NULL,NULL,'2019-03-23 20:20:26','admin','2019-03-23 20:20:26','admin'),(3,1,2,NULL,2,1,NULL,1,NULL,NULL,1,NULL,NULL,NULL,NULL,100,NULL,NULL,NULL,NULL,100,NULL,NULL,NULL,NULL,200,NULL,NULL,NULL,NULL,'2019-03-24 19:40:46','admin','2019-03-24 19:40:46','admin'),(4,1,3,NULL,3,1,NULL,1,NULL,NULL,1,NULL,NULL,NULL,NULL,40,NULL,NULL,NULL,NULL,40,NULL,NULL,NULL,NULL,80,NULL,NULL,NULL,NULL,'2019-03-25 14:51:38','admin','2019-03-25 14:51:38','admin'),(5,1,5,NULL,5,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-03-29 11:30:33','admin','2019-03-29 11:30:33','admin'),(6,1,6,NULL,6,1,NULL,1,NULL,NULL,1,NULL,NULL,NULL,NULL,50,NULL,NULL,NULL,NULL,55,NULL,NULL,NULL,NULL,105,NULL,NULL,NULL,NULL,'2019-03-29 12:35:58','admin','2019-03-29 12:35:58','admin'),(7,1,532,NULL,7,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-03-30 15:55:11','admin','2019-03-30 15:59:28','admin'),(8,1,532,NULL,7,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-03-30 16:02:34','admin','2019-03-30 16:02:34','admin'),(7,1,532,NULL,7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-03-30 15:59:28','admin','2019-03-30 17:05:13','admin'),(7,1,532,NULL,7,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-03-30 17:05:13','admin','2019-03-30 17:05:13','admin'),(9,1,533,NULL,8,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-03-30 17:08:02','admin','2019-03-30 17:08:26','admin'),(9,1,533,NULL,8,1,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-03-30 17:08:26','admin','2019-03-30 17:09:00','admin'),(9,1,533,NULL,8,1,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-03-30 17:09:00','admin','2019-03-30 17:10:23','admin'),(9,1,533,NULL,8,1,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-03-30 17:10:23','admin','2019-03-30 17:10:23','admin'),(9,1,533,NULL,8,1,NULL,1,NULL,NULL,1,NULL,NULL,NULL,NULL,10,NULL,NULL,NULL,NULL,20,NULL,NULL,NULL,NULL,30,NULL,NULL,NULL,NULL,'2019-03-30 17:10:23','admin','2019-03-30 17:10:23','admin'),(9,1,533,NULL,8,1,NULL,1,NULL,NULL,1,NULL,NULL,NULL,NULL,15,NULL,NULL,NULL,NULL,35,NULL,NULL,NULL,NULL,50,NULL,NULL,NULL,NULL,'2019-03-30 17:10:23','admin','2019-03-30 17:10:23','admin'),(9,1,533,NULL,8,1,NULL,1,NULL,NULL,1,NULL,NULL,NULL,NULL,15,NULL,NULL,NULL,NULL,36,NULL,NULL,NULL,NULL,51,NULL,NULL,NULL,NULL,'2019-03-30 17:10:23','admin','2019-03-30 17:10:23','admin'),(9,1,533,NULL,8,1,NULL,1,NULL,NULL,1,1,NULL,NULL,NULL,15,45,NULL,NULL,NULL,36,50,NULL,NULL,NULL,51,95,NULL,NULL,NULL,'2019-03-30 17:10:23','admin','2019-03-30 17:10:23','admin');
/*!40000 ALTER TABLE `affluenze_storico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-14 20:54:50