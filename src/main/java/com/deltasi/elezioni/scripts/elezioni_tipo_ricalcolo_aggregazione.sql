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
-- Table structure for table `tipo_ricalcolo_aggregazione`
--

DROP TABLE IF EXISTS `tipo_ricalcolo_aggregazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_ricalcolo_aggregazione` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(200) NOT NULL,
  `codice` varchar(3) NOT NULL,
  `tipoelezioneid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tipo_ricalcolo_aggregazione_unique` (`descrizione`,`codice`,`tipoelezioneid`),
  KEY `tipo_ricalcolo_aggregazione_tipo_elezione_idx` (`tipoelezioneid`),
  CONSTRAINT `tipo_ricalcolo_aggregazione_tipo_elezione` FOREIGN KEY (`tipoelezioneid`) REFERENCES `tipoelezione` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_ricalcolo_aggregazione`
--

LOCK TABLES `tipo_ricalcolo_aggregazione` WRITE;
/*!40000 ALTER TABLE `tipo_ricalcolo_aggregazione` DISABLE KEYS */;
INSERT INTO `tipo_ricalcolo_aggregazione` VALUES (2,'Comune','COM',1),(1,'Municipio','MUN',1),(4,'Plesso','PLE',3),(3,'Sezione','SEZ',3);
/*!40000 ALTER TABLE `tipo_ricalcolo_aggregazione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-07 11:51:24
