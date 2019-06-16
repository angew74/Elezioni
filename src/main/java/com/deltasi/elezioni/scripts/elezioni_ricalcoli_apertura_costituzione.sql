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
-- Table structure for table `ricalcoli_apertura_costituzione`
--

DROP TABLE IF EXISTS `ricalcoli_apertura_costituzione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ricalcoli_apertura_costituzione` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idtipoelezione` int(10) unsigned NOT NULL,
  `idtiporicalcolo` int(10) unsigned NOT NULL,
  `numero_sezioni` int(10) unsigned NOT NULL DEFAULT '0',
  `numero_costituite` int(10) unsigned NOT NULL DEFAULT '0',
  `percentuale_costituite` varchar(6) NOT NULL DEFAULT '0.0',
  `numero_aperte` int(10) unsigned NOT NULL DEFAULT '0',
  `percentuale_aperte` varchar(6) NOT NULL DEFAULT '0.0',
  `iscritti_totali` int(10) unsigned NOT NULL,
  `municipio` int(10) unsigned NOT NULL,
  `utente_operazione` varchar(45) NOT NULL,
  `data_operazione` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ricalcoli_apertura_costituzione_tipo_ricalcolo_idx` (`idtiporicalcolo`),
  KEY `fk_ricalcoli_apertura_costituzione_tipo_elezione_idx` (`idtipoelezione`),
  CONSTRAINT `fk_ricalcoli_apertura_costituzione_tipo_elezione` FOREIGN KEY (`idtipoelezione`) REFERENCES `tipoelezione` (`id`),
  CONSTRAINT `fk_ricalcoli_apertura_costituzione_tipo_ricalcolo` FOREIGN KEY (`idtiporicalcolo`) REFERENCES `tipo_ricalcolo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ricalcoli_apertura_costituzione`
--

LOCK TABLES `ricalcoli_apertura_costituzione` WRITE;
/*!40000 ALTER TABLE `ricalcoli_apertura_costituzione` DISABLE KEYS */;
INSERT INTO `ricalcoli_apertura_costituzione` VALUES (1,1,4,183,0,'0',2,'1,09',1996,3,'admin','2019-05-12 13:49:48'),(2,1,4,164,0,'0',8,'4,88',7170,1,'admin','2019-05-12 13:49:48'),(3,1,6,183,2,'1,09',0,'0',1996,3,'admin','2019-05-12 13:50:00'),(4,1,6,164,12,'7,32',0,'0',10855,1,'admin','2019-05-12 13:50:00'),(5,1,6,153,3,'1,96',0,'0',864,2,'admin','2019-05-12 13:50:00'),(6,1,6,165,1,'0,61',0,'0',901,4,'admin','2019-05-12 13:50:00'),(7,1,6,222,1,'0,45',0,'0',921,5,'admin','2019-05-12 13:50:00'),(8,1,6,195,1,'0,51',0,'0',1245,6,'admin','2019-05-12 13:50:00'),(9,1,6,297,2,'0,67',0,'0',1848,7,'admin','2019-05-12 13:50:00'),(10,1,6,136,3,'2,21',0,'0',2565,8,'admin','2019-05-12 13:50:00'),(11,1,6,174,1,'0,57',0,'0',1156,9,'admin','2019-05-12 13:50:00'),(12,1,6,183,1,'0,55',0,'0',1125,10,'admin','2019-05-12 13:50:00'),(13,1,6,148,1,'0,68',0,'0',935,11,'admin','2019-05-12 13:50:00'),(14,1,6,137,1,'0,73',0,'0',1044,12,'admin','2019-05-12 13:50:00'),(15,1,6,119,1,'0,84',0,'0',838,13,'admin','2019-05-12 13:50:00'),(16,1,6,180,1,'0,56',0,'0',1110,14,'admin','2019-05-12 13:50:00'),(17,1,6,144,1,'0,69',0,'0',932,15,'admin','2019-05-12 13:50:00'),(18,1,4,2600,0,'0',10,'0,38',9166,99,'admin','2019-05-12 16:32:39');
/*!40000 ALTER TABLE `ricalcoli_apertura_costituzione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-16 20:03:33
