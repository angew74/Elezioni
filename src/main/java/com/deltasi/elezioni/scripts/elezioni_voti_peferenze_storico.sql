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
-- Table structure for table `voti_peferenze_storico`
--

DROP TABLE IF EXISTS `voti_peferenze_storico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `voti_peferenze_storico` (
  `id` int(10) unsigned NOT NULL,
  `tipoelezioneid` int(10) unsigned NOT NULL,
  `sezioneid` int(10) unsigned NOT NULL,
  `candidatoid` int(10) unsigned NOT NULL,
  `listaid` int(10) unsigned NOT NULL,
  `numerovoti` int(10) unsigned NOT NULL,
  `utenteoperazione` varchar(45) NOT NULL,
  `dataoperazione` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_voti_preferenze_storico_tipoelezione_id_idx` (`tipoelezioneid`),
  KEY `fk_voti_preferenze_storico_sezioni_idx` (`sezioneid`),
  KEY `fk_voti_preferenze_storico_liste_idx` (`listaid`),
  KEY `fk_voti_preferenze_storico_candidati_idx` (`candidatoid`),
  CONSTRAINT `fk_voti_preferenze_storico_candidati` FOREIGN KEY (`candidatoid`) REFERENCES `candidati` (`id`),
  CONSTRAINT `fk_voti_preferenze_storico_liste` FOREIGN KEY (`listaid`) REFERENCES `liste` (`id`),
  CONSTRAINT `fk_voti_preferenze_storico_sezioni` FOREIGN KEY (`sezioneid`) REFERENCES `sezioni` (`id`),
  CONSTRAINT `fk_voti_preferenze_storico_tipoelezione_id` FOREIGN KEY (`tipoelezioneid`) REFERENCES `tipoelezione` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voti_peferenze_storico`
--

LOCK TABLES `voti_peferenze_storico` WRITE;
/*!40000 ALTER TABLE `voti_peferenze_storico` DISABLE KEYS */;
/*!40000 ALTER TABLE `voti_peferenze_storico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-02 19:02:28
