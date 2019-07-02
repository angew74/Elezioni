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
-- Table structure for table `profilo_voti`
--

DROP TABLE IF EXISTS `profilo_voti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `profilo_voti` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `votigeneraliid` int(10) unsigned DEFAULT NULL,
  `votisindacoid` int(10) unsigned DEFAULT NULL,
  `votilistaid` int(10) unsigned DEFAULT NULL,
  `sezioneid` int(10) unsigned NOT NULL,
  `tipoelezioneid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_voti_votisindaco_idx` (`votisindacoid`),
  KEY `fk_voti_votilista_idx` (`votilistaid`),
  KEY `fk_voti_votigenerali_idx` (`votigeneraliid`),
  KEY `fk_voti_tipoelezione_idx` (`tipoelezioneid`,`sezioneid`),
  KEY `fk_voti_sezioni_idx` (`sezioneid`),
  CONSTRAINT `fk_voti_sezioni` FOREIGN KEY (`sezioneid`) REFERENCES `sezioni` (`id`),
  CONSTRAINT `fk_voti_tipoelezione` FOREIGN KEY (`tipoelezioneid`) REFERENCES `tipoelezione` (`id`),
  CONSTRAINT `fk_voti_votigenerali` FOREIGN KEY (`votigeneraliid`) REFERENCES `voti_generali` (`id`),
  CONSTRAINT `fk_voti_votilista` FOREIGN KEY (`votilistaid`) REFERENCES `voti_lista` (`id`),
  CONSTRAINT `fk_voti_votisindaco` FOREIGN KEY (`votisindacoid`) REFERENCES `voti_sindaco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profilo_voti`
--

LOCK TABLES `profilo_voti` WRITE;
/*!40000 ALTER TABLE `profilo_voti` DISABLE KEYS */;
/*!40000 ALTER TABLE `profilo_voti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-02 19:02:21
