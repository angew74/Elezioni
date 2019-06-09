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
-- Table structure for table `ricalcoli_affluenza`
--

DROP TABLE IF EXISTS `ricalcoli_affluenza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ricalcoli_affluenza` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idtipoelezione` int(10) unsigned NOT NULL,
  `idtiporicalcolo` int(10) unsigned NOT NULL,
  `municipio` int(10) unsigned NOT NULL,
  `affluenza_totale` int(10) unsigned NOT NULL DEFAULT '0',
  `iscritti_totale` int(10) DEFAULT NULL,
  `percentuale_totale` varchar(6) NOT NULL DEFAULT '0.0',
  `affluenza_maschi` int(10) unsigned NOT NULL DEFAULT '0',
  `iscritti_maschi` int(10) unsigned NOT NULL,
  `percentuale_maschi` varchar(6) NOT NULL DEFAULT '0.0',
  `affluenza_femmine` int(10) unsigned NOT NULL DEFAULT '0',
  `iscritti_femmine` int(10) unsigned NOT NULL,
  `percentuale_femmine` varchar(6) NOT NULL DEFAULT '0.0',
  `numero_affluenza` int(10) unsigned NOT NULL,
  `numero_sezioni` int(10) unsigned DEFAULT '0',
  `totale_sezioni` int(10) unsigned NOT NULL DEFAULT '0',
  `percentuale_sezioni_pervenute` varchar(6) NOT NULL DEFAULT '0',
  `utente_operazione` varchar(45) NOT NULL,
  `data_operazione` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ricalcoli_affluenza_idx` (`idtiporicalcolo`),
  KEY `fk_ricaloli_affluenza_tipo_elezione_idx` (`idtipoelezione`),
  CONSTRAINT `fk_ricalcoli_affluenza_tipo_ricalcolo` FOREIGN KEY (`idtiporicalcolo`) REFERENCES `tipo_ricalcolo` (`id`),
  CONSTRAINT `fk_ricaloli_affluenza_tipo_elezione` FOREIGN KEY (`idtipoelezione`) REFERENCES `tipoelezione` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ricalcoli_affluenza`
--

LOCK TABLES `ricalcoli_affluenza` WRITE;
/*!40000 ALTER TABLE `ricalcoli_affluenza` DISABLE KEYS */;
INSERT INTO `ricalcoli_affluenza` VALUES (1,1,1,1,210,1057,'19,87',105,502,'20,92',105,555,'18,92',1,3,164,'1,83','admin','2019-04-20 21:24:09'),(2,1,1,4,200,748,'26,74',100,359,'27,86',100,389,'25,71',1,1,165,'0,61','admin','2019-04-20 21:24:09'),(3,1,1,3,210,1058,'19,85',105,502,'20,92',105,556,'18,88',1,1,183,'0,55','admin','2019-05-04 18:39:26'),(4,1,1,1,836,4322,'19,34',405,2252,'17,98',431,2070,'20,82',1,5,164,'3,05','admin','2019-05-04 18:39:26'),(5,1,2,1,515,1898,'27,13',255,1095,'23,29',260,803,'32,38',2,2,164,'1,22','admin','2019-05-04 18:40:39'),(6,1,3,1,1110,1898,'58,48',700,1095,'63,93',410,803,'51,06',3,2,164,'1,22','admin','2019-05-04 18:40:49'),(7,1,3,1,1110,1898,'58,48',700,1095,'63,93',410,803,'51,06',3,2,164,'1,22','admin','2019-05-04 21:13:42'),(8,1,1,99,1648,2770,'59,49',811,1496,'54,21',837,1274,'65,7',1,8,2600,'0,31','admin','2019-05-05 19:38:04'),(9,1,3,99,1710,2770,'61,73',1000,1496,'66,84',710,1274,'55,73',3,3,2600,'0,12','admin','2019-05-05 19:55:03'),(10,1,1,3,210,1058,'19,85',105,502,'20,92',105,556,'18,88',1,1,183,'0,55','admin','2019-05-05 20:01:29'),(11,1,1,1,1438,6232,'23,07',706,3131,'22,55',732,3101,'23,61',1,7,164,'4,27','admin','2019-05-05 20:01:29'),(12,1,3,1,2510,3808,'65,91',1400,1974,'70,92',1110,1834,'60,52',3,4,164,'2,44','admin','2019-05-05 20:36:08'),(13,1,3,99,2510,3808,'65,91',1400,1974,'70,92',1110,1834,'60,52',3,4,2600,'0,15','admin','2019-05-05 20:36:21'),(14,1,3,1,2510,3808,'65,91',1400,1974,'70,92',1110,1834,'60,52',3,4,164,'2,44','admin','2019-05-05 20:42:18'),(15,1,3,3,600,938,'63,97',300,433,'69,28',300,505,'59,41',3,1,183,'0,55','admin','2019-05-05 20:42:18');
/*!40000 ALTER TABLE `ricalcoli_affluenza` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-09 19:00:57
