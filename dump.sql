CREATE DATABASE  IF NOT EXISTS `redis-stock` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `redis-stock`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: redis-stock
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL,
  `address` varchar(128) NOT NULL,
  `phone` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (0,'KA','KLIENT ANONIM','','',''),(1,'K52526202I','A & M Tekstil (Tekstil)','Lagja nr. 3 Cerrik, Elbasan','+355 58 113 434 / +355682945850','a-m.tekstil@info.al'),(2,'J93112231N','Flobest 2003 (Home-Tex)','Lagja Sule Papri, Rruga e Re e Trenit, Elbasan','+355 54 255 433 / +355682046713','flobest2003@hotmail.com'),(3,'K43602402T','Blu Sky (Jeans)','Lagja Kryengritja e Fierit, Fier','+355 34 222 861 / +355692090228','krienko@yahoo.it'),(4,'J63402402T','Krel\'s Luck (Jeans)','Lagja 16 Prilli, Fier','+35534222861 / +355692090228','krel@krienko.com'),(5,'K02715433S','Picari (Jeans & Kepuce)','Patos, Fier','+35538124159 / +355692074104','picari_al@yahoo.it'),(6,'J82916444F','Alitex (Kemisha)','Ish Uzina e Pambukut, Fier','+355692093330','dduduci@abissnet.al'),(7,'K02701021Q','Center Shqiptare (Canta Letre)','Ish Kombinati Tekstil, Berat','+35532236942 / +355692029422','lumirosoja@yahoo.com'),(8,'J61818506C','Stella Tekstile (Tekstil)','Ish Kombinati Tekstil, Berat','+35552624239 / +355682035341','info@tekstilgroup.com'),(9,'K53414001T','Mito-2 (Kepuce)','Ish Kombinati Tekstil, Berat','+35532237770 / +355682098460','kriton_prendi@yahoo.it'),(10,'K02701008M','Kazazi sh.a. (Intime)','Ish Kombinati Tekstil, Berat','+35532324288 / +355692064062','arben.kazazi@yahoo.it'),(11,'K23206023A','Berat Konfeks (Intimo)','Ish Kombinati Tekstil, Berat','+355692064005','berat_konfeks@yahoo.it'),(12,'J62903347C','4 Vellezrit (Intimo)','Lagja Sule Papri, Rruga e Re e Trenit, Elbasan','+35554255816 / +355692082902','kater_vellezrit@yahoo.com'),(13,'J64520020O','Mas Torr (Kepuce)','Ish Fabrika e Kepuces, Korce','+35582245718 - +355692061658','genci_gellci@yahoo.com'),(14,'J64103032J','Europleks (Veshje Grash)','Ish Trikotazhi, Korce','+35582242409 / +355684060403','europlex@hotmail.com'),(15,'J66702620Q','Gjergjefi (Rroba Pune)','Rruga e Barikadave, Bilisht','+35542225518 / +355692040454','jani_gjergjefi@live.com'),(16,'K46818202H','Sirius (Pantallona)','Rruga Demokracia, Vlore','+35533223506 / +355684042990','niram1985@hotmail.com'),(17,'K77029205V','E & K (Sportive)','Ish Fabrika e Makaronave, Vlore','+355684053180',''),(18,'J66703248G','Pier-Ilia (Canta Letre)','Lagja Bashkimi, Vlore','+3556984117','elidon_simoni@yahoo.it'),(19,'J66915250J','It-Altex (Sportive)','Rruga Transballkanike, Vlore','+35533222075',''),(20,'J66828202M','Vlora Konfeksion (Intimo)','Lagja Bashkimi, Vlore','+35533222075',''),(21,'K76616201J','Kid (Sportive)','Lagja Bashkimi, Vlore','+35533233866',''),(22,'K47201202V','M & S Konfeksione','Rruga Transballkanike, Vlore','+355682256414',''),(23,'K17210202R','SIL & AID Quadri-Foglio (Carcafe)','Lagja Lef Sallata, Rruga Sadi, Vlore','+35533232063',''),(25,'K74527801B','Asta (Trikotazhe)','Rruga Transballkanike','+355692027801',''),(26,'K41802031K','Flavio 98 (Kemisha)','Rruga Siri Kodra, Ish Frigoriferi, Tirane','+35542251454 / +355692032156',''),(27,'K11322001C','Dalba (Kemisha)','Rruga e Kavajes, Ish Kom.U, Tirane','+35542250178 / +355692116455','elonashima@hotmail.com'),(28,'K31308003T','Konfeksion Albital Way (Kemisha)','Rruga Niko Avrami, Tirane','+355682050000','studio_legale_alberta@yahoo.com'),(29,'K01612003W','Intim-Triller (Intimo)','Rruga Qemal Stafa, Tirane','+35548302660 / +355682032908','intimtriller.shpk@yahoo.com'),(30,'K52217009V','Oseku  Group (Intimo)','Rruga per Shkoze, Tirane','+35542239686 / +3552052616','oseku_group@hotmail.com'),(31,'J82327001M','Konf Tirana (Jeans)','Rruga Qemal Stafa, Tirane','+35542375531 / +35568405266','konftirana@gmail.com'),(32,'K64720204F','Victoria Motor (Jeans)','Lagja 1, Kruje','+355692988977','alfredkotte@hotmail.com'),(33,'K31726016O','LamiTrans Costums Service (Rroba Pune)','Autostrada Tirane-Durres Km. 25','+355692085031 / +355692023766','xhlami@manifaktura7.com'),(34,'J61628068L','Arisa Konfeksion (Rroba Pune)','Rruga 5 Maji, Tirane','+35542379119 / +355672067820','arisakonfeksion@hotmail.com'),(38,'L76927205O','Aris Shoes shpk',' Vlore',' ',' '),(39,'L46806203C','2 TOCI GROUP SHPK, VLORE',' ',' ',' '),(40,'K52526001L','Marlotex shpk','Berat',' ',' '),(42,'K76716203F','KRISTJURGA SHPK','Vlore',' ',' '),(43,'K73328001T','CENTER SHQIPTARE SHPK','Berat',' ',' '),(44,'L56517201K','Simak Shoes shpk','Vlore',' ',' ');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(16) NOT NULL,
  `name` varchar(256) NOT NULL,
  `address` varchar(256) NOT NULL DEFAULT '',
  `phone` varchar(256) NOT NULL DEFAULT '',
  `email` varchar(256) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (0,'PA','PUNONJES ANONIM','','',''),(1,'I30528109O','Redjan Shabani','Lagja Pavaresia, Vlore','+355 69 20 48 755','redjan.shabani@gmail.com');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `input`
--

DROP TABLE IF EXISTS `input`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `input` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(128) NOT NULL,
  `instant` datetime NOT NULL,
  `author` int(11) NOT NULL DEFAULT '0',
  `source` int(11) NOT NULL DEFAULT '0',
  `paid` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_input_source_idx` (`source`),
  KEY `fk_input_author_idx` (`author`),
  CONSTRAINT `fk_input_author` FOREIGN KEY (`author`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_input_source` FOREIGN KEY (`source`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=321 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `input`
--

LOCK TABLES `input` WRITE;
/*!40000 ALTER TABLE `input` DISABLE KEYS */;
INSERT INTO `input` VALUES (3,'171226201307','2017-12-26 00:00:00',1,37,1),(215,'L70309210044B','2017-03-08 00:00:00',1,37,1),(216,'L70220203044B','2017-02-20 00:00:00',1,37,1),(217,'L70128000043B','2016-09-30 00:00:00',1,37,1),(218,'L70127234809B','2016-10-04 00:00:00',1,37,1),(219,'L70127234058B','2016-10-14 00:00:00',1,37,1),(220,'L70127225610B','2016-11-07 00:00:00',1,37,1),(221,'L70127224557B','2016-12-02 00:00:00',1,37,1),(222,'L70127224718B','2016-12-04 00:00:00',1,37,1),(223,'L70127223553B','2016-12-14 00:00:00',1,37,1),(224,'L70127222851B','2016-12-23 00:00:00',1,37,1),(225,'L70127210635B','2017-01-25 00:00:00',1,37,1),(226,'L70204203356B','2017-02-04 00:00:00',1,37,1),(227,'L70213120153B','2017-02-13 00:00:00',1,37,1),(228,'L70712185434B','2017-03-08 00:00:00',1,37,1),(229,'L70525195159B','2017-04-11 00:00:00',1,37,1),(230,'L70525195825B','2017-04-12 00:00:00',1,37,1),(231,'L70525200145B','2017-05-05 00:00:00',1,37,1),(232,'L70525200818B','2017-05-19 00:00:00',1,37,1),(233,'L70601210114B','2017-06-01 00:00:00',1,37,1),(234,'L70616175405B','2017-06-09 00:00:00',1,37,1),(235,'L70704190812B','2017-06-22 00:00:00',1,37,1),(236,'L70704190535B','2017-06-29 00:00:00',1,37,1),(237,'L70719215053B','2017-07-18 00:00:00',1,37,1),(238,'L70804210650B','2017-08-04 00:00:00',1,37,1),(239,'L70916123125B','2017-09-16 00:00:00',1,37,1),(240,'L71002192344B','2017-10-02 00:00:00',1,37,1),(241,'L71009160532B','2017-10-09 00:00:00',1,37,1),(242,'L71022193332B','2017-10-18 00:00:00',1,37,1),(243,'L71025185146B','2017-10-24 00:00:00',1,37,1),(244,'L71102173914B','2017-11-02 00:00:00',1,37,1),(245,'L71108193859B','2017-11-07 00:00:00',1,37,1),(319,'171130190723','2017-11-30 00:00:00',1,37,1);
/*!40000 ALTER TABLE `input` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inputentry`
--

DROP TABLE IF EXISTS `inputentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inputentry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `input` int(11) NOT NULL,
  `code` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL,
  `unit` varchar(128) NOT NULL,
  `size` double NOT NULL,
  `price` double NOT NULL,
  `tax` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_inputentry_input_idx` (`input`),
  CONSTRAINT `fk_inputentry_input` FOREIGN KEY (`input`) REFERENCES `input` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1442 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inputentry`
--

LOCK TABLES `inputentry` WRITE;
/*!40000 ALTER TABLE `inputentry` DISABLE KEYS */;
INSERT INTO `inputentry` VALUES (4,3,'GER0001','GERSHERE DE LUCA ACCIAO INOX TEMPERATO E ZEZE 6\'\'','COP',5,5,0.2),(5,3,'MB0002','MOLA SENZA BUSSOLA','COP',10,6,0),(6,3,'PMCLGP08','PENELLO M/CORTO LEGNO G/PLAST 08','COP',150,0.5,0),(1273,219,'70X7X6MA','GUR ZMERIL 707X7X6MA 11A70/I/7V2','COP',1,5,0),(1274,220,'70X7X6MA','GUR ZMERIL 707X7X6MA 11A70/I/7V2','COP',1,5,0),(1275,221,'70X7X6MA','GUR ZMERIL 707X7X6MA 11A70/I/7V2','COP',1,5,0),(1276,222,'70X7X6MA','GUR ZMERIL 707X7X6MA 11A70/I/7V2','COP',1,5,0),(1277,215,'B010200125','B010200125','KON',50,2,0),(1278,215,'B010200224','B010200224','KON',51,2,0),(1279,215,'B040200225','B040200225','KON',35,2,0),(1280,215,'B040200226','B040200226','KON',36,2,0),(1281,216,'B010200125','B010200125','KON',22,1.77,0),(1282,216,'Y03402','NE 20/3 100% COTTON LENGTH 2500M SHADE NO. 11100','KON',3,1.73,0),(1283,216,'Y05001','NE 30/3 100% COTTON LENGTH 4000Y SHADE NO. 11111','KON',3,1.9,0),(1284,216,'Y08501','NE 34/2 100% COTTON LENGTH 5000Y SHADE NO. 11111','KON',3,1.55,0),(1285,216,'X15002','SPUN POLYESTER TKT 15 010000Y COL 0100','KON',3,0.92,0),(1286,216,'E08050','E08050','KON',2,2.42,0),(1287,217,'901223','VERDA NO 22 1 LT','BIDON',5,2.17,0),(1288,217,'904153','VERDA NO 15 1 LT','BIDON',5,2.79,0),(1289,217,'B02020','B02020','KON',80,2,0),(1290,217,'B03020','B03020','KON',20,2,0),(1291,217,'B04020','B04020','KON',509,2,0),(1292,217,'B06020','B06020','KON',190,2.4,0),(1293,217,'B08020','B08020','KON',50,2.8,0),(1294,217,'D12000','D12000 - TKT NO. 120 - COL. 0000 - Y. 5000','KON',40,1.5,0),(1295,217,'E16050','E16050','KON',10,1.9,0),(1296,217,'G12010','G12010','KON',10,1.44,0),(1297,217,'K05000','THREAD NM 7\'/2','KON',7,4.5,0),(1298,217,'K07500','K07500 - TKT NO. 75 - COL. 20 - M. 7500','KON',10,4.3,0),(1299,217,'Y03400','COTTON THREAD NE 20/3 2500 M/C','KON',10,2.8,0),(1300,218,'B02020','B02020','KON',220,2,0),(1301,218,'B03020','B03020','KON',280,2,0),(1302,218,'B04020','B04020','KON',490,2,0),(1303,218,'B06020','B06020','KON',363,2.4,0),(1304,218,'B08020','B08020','KON',223,2.8,0),(1305,218,'K02500','K02500','KON',20,3.9,0),(1306,218,'W99900','W99900','',72,0.01,0),(1307,218,'W99901','W99901','',130,0.01,0),(1308,218,'W99902','W99902','',75,1,0),(1309,218,'W99903','W99903','',150,2,0),(1310,218,'W99905','W99905','',400,0.01,0),(1311,218,'K03605','K03605','KON',20,4.6,0),(1312,219,'B04020','B04020','KON',10,2,0),(1313,219,'B06020','B06020','KON',200,2.4,0),(1314,219,'B08020','B08020','KON',40,2.8,0),(1315,219,'G12002','G12002','KON',20,0.82,0),(1316,219,'G12010','G12010','KON',10,1.44,0),(1317,220,'B04020','B04020','KON',72,2,0),(1318,220,'B06020','B06020','KON',20,2.4,0),(1319,220,'901221','VERDA No.22 125ML','BIDON',50,0.91,0),(1320,220,'904151','DENOL WHITE No.15 125ml','BIDON',50,1.05,0),(1321,220,'B08020','B08020','KON',230,2.8,0),(1322,220,'B08050','B08050','KON',80,5.5,0),(1323,220,'E16050','E16050','KON',20,1.9,0),(1324,220,'E16051','E16051','KON',40,3.4,0),(1325,220,'W50945','W50945','KON',25,3,0),(1326,220,'X12000','X12000','KON',200,0.72,0),(1327,220,'X12001','X12001','KON',160,0.77,0),(1328,220,'X12002','X12002','KON',135,0.72,0),(1329,220,'X12010','X12010','KON',60,1.3,0),(1330,220,'Y05000','Y05000','KON',20,3,0),(1331,220,'X12002','X12002','KON',20,0.72,0),(1332,221,'B02020','B02020','KON',83,2,0),(1333,221,'B03020','B03020','KON',19,2,0),(1334,221,'B04020','B04020','KON',91,2,0),(1335,222,'B01020','B01020','KON',155,2,0),(1336,222,'B02020','B02020','KON',192,2,0),(1337,222,'B03020','B03020','KON',36,2,0),(1338,222,'B04020','B04020','KON',121,2,0),(1339,223,'B01020','B01020','KON',87,2,0),(1340,223,'B02020','B02020','KON',74,2,0),(1341,223,'B04020','B04020','KON',97,2,0),(1342,223,'B03020','B03020','KON',50,2,0),(1343,223,'D07500','D07500','KON',700,1.1,0),(1344,223,'X12002','X12002','KON',10,0.82,0),(1345,224,'B01020','B01020','KON',191,2,0),(1346,224,'B02020','B02020','KON',112,2,0),(1347,224,'B04020','B04020','KON',47,2,0),(1348,225,'B020200211','B02020 TKT NO. 20 COL. 0211 M. 1500','KON',100,2,0),(1349,225,'B020200213','B02020 TKT NO. 20 COL. 0213 M. 1500','KON',100,2,0),(1350,225,'B020200218','B02020 TKT NO. 20 COL. 0218 M. 1500','KON',100,2,0),(1351,225,'B020200222','B02020 TKT NO. 20 COL. 0222 M. 1500','KON',100,2,0),(1352,225,'B040200211','B04020 TKT NO. 40 COL. 0211 M. 3000','KON',100,2,0),(1353,225,'B040200213','B04020 TKT NO. 40 COL. 0213  M. 3000','KON',100,2,0),(1354,225,'B010200121','B010200121 NO. 10 COL. 0121  M. 800','KON',25,2,0),(1355,226,'B040200122','B040200122','KON',100,2,0),(1356,226,'B040200216','B04020 TKT NO. 40 COL. 0216 M. 3000','KON',30,2,0),(1357,226,'B040200211','B04020 TKT NO. 40 COL. 0211 M. 3000','KON',50,2,0),(1358,226,'B040200212','B04020 TKT NO. 40 COL. 0212 M. 3000','KON',50,2,0),(1359,226,'B040200218','B04020 TKT NO. 40 COL. 0218 M. 3000','KON',30,2,0),(1360,226,'B040200222','B04020 TKT NO. 40 COL. 0222 M. 3000','KON',50,2,0),(1361,226,'B020200122','B02020 - TKT NO. 20 COL. 0122 M. 1500','KON',100,2,0),(1362,226,'B020200211','B02020 TKT NO. 20 COL. 0211 M. 1500','KON',50,2,0),(1363,226,'B020200212','B02020 TKT NO. 20 COL. 0212 M. 1500','KON',50,2,0),(1364,226,'B020200222','B02020 TKT NO. 20 COL. 0222 M. 1500','KON',50,2,0),(1365,226,'B010200120','B010200120','KON',29,2,0),(1366,226,'B010200125','B010200125','KON',30,2,0),(1367,226,'B010200224','B010200224','KON',100,2,0),(1368,227,'B010200224','B010200224','KON',117,2,0),(1369,228,'AR0001','ARTIKULL','COP',-1,5813.72,0),(1370,229,'B02020','B02020','KON',428,2,0),(1371,229,'B01020','B01020','KON',25,2,0),(1372,229,'ART0000','ARTIKULL I PERGJITHSHEM','COP',30,2.3,0),(1373,229,'ART0000','ARTIKULL I PERGJITHSHEM','COP',30,2.9,0),(1374,229,'B06020','B06020','KON',20,2.4,0),(1375,230,'D07500','D07500','KON',170,1.1,0),(1376,230,'B04020','B04020','KON',100,2,0),(1377,230,'B01020','B01020','KON',160,2,0),(1378,230,'ART0000','ARTIKULL I PERGJITHSHEM','COP',30,2.3,0),(1379,230,'ART0000','ARTIKULL I PERGJITHSHEM','COP',30,2.9,0),(1380,231,'B01020','B01020','KON',343,2,0),(1381,231,'B04020','B04020','KON',192,2,0),(1382,231,'B02020','B02020','KON',88,2,0),(1383,231,'D07500','D07500','KON',300,1.1,0),(1384,231,'Y05001','NE 30/3 100% COTTON LENGTH 4000Y SHADE NO. 11111','KON',100,2.9,0),(1385,232,'B01020','B01020','KON',321,2,0),(1386,232,'B04020','B04020','KON',672,2,0),(1387,232,'B02020','B02020','KON',186,2,0),(1388,233,'B02020','B02020','KON',47,2,0),(1389,233,'B01020','B01020','KON',171,2,0),(1390,233,'B04020','B04020','KON',30,2,0),(1391,233,'B06020','B06020','KON',89,2.4,0),(1392,234,'B04020','B04020','KON',462,2,0),(1393,234,'B03020','B03020','KON',133,2,0),(1394,234,'B02020','B02020','KON',267,2,0),(1395,234,'B01020','B01020','KON',283,2,0),(1396,234,'B06020','B06020','KON',77,2.4,0),(1397,235,'B04020','B04020','KON',163,2,0),(1398,236,'B01020','B01020','KON',199,2,0),(1399,236,'B04020','B04020','KON',171,2,0),(1400,237,'B02020','B02020','KON',157,2,0),(1401,237,'B01020','B01020','KON',56,2,0),(1402,237,'B04020','B04020','KON',77,2,0),(1403,238,'B01020','B01020','KON',24,2,0),(1404,238,'B02020','B02020','KON',31,2,0),(1405,238,'B04020','B04020','KON',90,2,0),(1406,238,'B06020','B06020','KON',30,2.4,0),(1407,238,'M11510','METAL THREAD NO. 115 2500Y/C','KON',40,4.36,0),(1408,238,'VAJDV22','DENOL VERDA NO 22 1 LT','BIDON',12,3.1,0),(1409,238,'VAJDV15','DENOL VERDA NO 15 1 LT','BIDON',12,3.98,0),(1410,239,'B01020','B01020','KON',-1421,2,0),(1411,239,'M11510','METAL THREAD NO. 115 2500Y/C','KON',-40,4.36,0),(1412,240,'B04020','B04020','KON',410,2,0),(1413,240,'B06020','B06020','KON',150,2.4,0),(1414,240,'B02020','B02020','KON',108,2,0),(1415,240,'D07500','D07500','KON',400,1.1,0),(1416,240,'B01020','B01020','KON',50,2,0),(1417,241,'B01020','B01020','KON',133,2,0),(1418,241,'B02020','B02020','KON',50,2,0),(1419,241,'B03020','B03020','KON',13,2,0),(1420,241,'B04020','B04020','KON',207,2,0),(1421,241,'X12000','X12000','KON',20,0.82,0),(1422,242,'B03020','CF POLYESTER THREAD Nm 80/3 2400M/C','KON',28,2,0),(1423,242,'B08020','CF POLYESTER THREAD Nm 80/3 7500M/C','KON',30,2.8,0),(1424,242,'X12000','SPUN POLYESTER THREAD Nm 70/2 5000Y/C','KON',1260,0.82,0),(1425,243,'B02020','B02020','KON',50,2,0),(1426,243,'B04020','B04020','KON',50,2,0),(1427,243,'B08020','CF POLYESTER THREAD Nm 80/3 7500M/C','KON',172,2.8,0),(1428,243,'X12000','SPUN POLYESTER THREAD Nm 70/2 5000Y/C','KON',1500,0.82,0),(1429,243,'D12000','D12000 - TKT NO. 120 - COL. 0000 - Y. 5000','KON',63,1.5,0),(1430,244,'X05002','SPUN POLYESTER THREAD Nm50/3 5000Y/C','KON',200,1.7,0),(1431,244,'B04020','B04020','KON',100,2,0),(1432,245,'D07500','SPUN POLYESTER THREAD Nm70/3 5000Y/C','KON',200,1.1,0),(1433,245,'X12003','SPUN POLYESTER THREAD Nm70/2 5000Y/C','KON',300,0.77,0),(1434,245,'X12001','SPUN POLYESTER THREAD Nm70/2 5000Y/ECRU','KON',200,0.72,0),(1435,245,'X12000','SPUN POLYESTER THREAD Nm 70/2 5000Y/C','KON',320,0.79,0),(1436,245,'B04020','B04020','KON',50,2,0),(1437,245,'B02020','B02020','KON',50,2,0),(1438,319,'D07500','SPUN POLYESTER THREAD Nm70/3 5000Y/C','KON',1000,1.1,0),(1439,319,'B02020','CF POLYESTER THREAD Nm 20/3 1500M/C','KON',98,2,0),(1440,319,'B04020','CF POLYESTER THREAD Nm 40/3 3000M/C','KON',50,2,0);
/*!40000 ALTER TABLE `inputentry` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `redis-stock`.`inputentry_BEFORE_INSERT` BEFORE INSERT ON `inputentry` FOR EACH ROW
BEGIN
	UPDATE `Product` `p` 
	SET `size` = `size` + NEW.`size` 
    WHERE NEW.`code` = `p`.`code`;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `redis-stock`.`inputentry_BEFORE_UPDATE` BEFORE UPDATE ON `inputentry` FOR EACH ROW
BEGIN
	UPDATE `Product` `p` 
	SET `size` = `size` + NEW.`size` - OLD.`size` 
    WHERE NEW.`code` = `p`.`code`;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `redis-stock`.`inputentry_BEFORE_DELETE` BEFORE DELETE ON `inputentry` FOR EACH ROW
BEGIN
	UPDATE `Product` `p` 
	SET `size` = `size` - OLD.`size` 
    WHERE  OLD.`code` = `p`.`code`;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `output`
--

DROP TABLE IF EXISTS `output`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `output` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(128) NOT NULL,
  `instant` datetime NOT NULL,
  `author` int(11) NOT NULL DEFAULT '0',
  `target` int(11) NOT NULL DEFAULT '0',
  `paid` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_output_target_idx` (`target`),
  KEY `fk_output_author_idx` (`author`),
  CONSTRAINT `fk_output_author` FOREIGN KEY (`author`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_output_target` FOREIGN KEY (`target`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `output`
--

LOCK TABLES `output` WRITE;
/*!40000 ALTER TABLE `output` DISABLE KEYS */;
INSERT INTO `output` VALUES (51,'171225163324','2017-12-25 16:33:24',0,0,1),(52,'171225163335','2017-12-25 16:33:36',0,0,1),(53,'171225163345','2017-12-25 16:33:45',0,0,1),(54,'171225163359','2017-12-01 00:00:00',0,0,0),(58,'171226033757','2017-12-26 00:00:00',0,0,0),(59,'171226171114','2017-12-26 17:11:15',0,0,1),(60,'171226171150','2017-12-26 17:11:50',0,0,1),(61,'171226171421','2017-12-26 00:00:00',0,0,1),(62,'171227152122','2017-12-27 15:21:23',0,0,1),(63,'171227192842','2017-12-27 19:28:43',0,0,1);
/*!40000 ALTER TABLE `output` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outputentry`
--

DROP TABLE IF EXISTS `outputentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `outputentry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `output` int(11) NOT NULL,
  `code` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL,
  `unit` varchar(128) NOT NULL,
  `size` double NOT NULL,
  `price` double NOT NULL,
  `tax` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_outputentry_output_idx` (`output`),
  CONSTRAINT `fk_outputentry_output` FOREIGN KEY (`output`) REFERENCES `output` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=419 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outputentry`
--

LOCK TABLES `outputentry` WRITE;
/*!40000 ALTER TABLE `outputentry` DISABLE KEYS */;
INSERT INTO `outputentry` VALUES (320,51,'VAJDS125ML','SPECIAL - 125 ML','BIDON',1,1.7,0.2),(321,51,'901223','VERDA NO 22 1 LT','BIDON',1,0,0.2),(322,51,'GSUK090','GJILPER 134 SUK FIN 90','COP',1,0.162,0.2),(323,51,'G12002','G12002','KON',1,0,0.2),(324,51,'GER0001','GERSHERE DE LUCA ACCIAO INOX TEMPERATO E ZEZE 6\'\'','COP',1,4.725,0.2),(325,51,'X12010','KORALI - SPUN POLYESTER THREAD TKT NO. 120 - 10000Y - COL. C','KON',4,1.755,0.2),(326,51,'FUR0001','FURCE PENEL ME BISHT DRURI 12','COP',2,0,0),(327,51,'K05000','KENTAVROS - POLY/POLY - TKT NO. 50 - 5000M - COL. A','KON',5,6.075,0.2),(328,51,'GR120','GJILPER 134 R FIN 120','COP',2,0.161,0.2),(329,51,'G35R130','GJILPER 134 - 35 R FIN 130','COP',1,0.25,0.2),(330,51,'B02020','CF POLYESTER THREAD Nm 20/3 1500M/C','KON',1,2.7,0.2),(331,51,'GSUK110','GJILPER 134 SUK FIN 110','COP',1,0.162,0.2),(332,51,'D07500','SPUN POLYESTER THREAD Nm70/3 5000Y/C','KON',5,1.5,0.2),(333,52,'VAJDS125ML','SPECIAL - 125 ML','BIDON',4,1.7,0.2),(334,52,'901223','VERDA NO 22 1 LT','BIDON',6,0,0.2),(335,52,'GSUK090','GJILPER 134 SUK FIN 90','COP',8,0.162,0.2),(336,52,'GSUK110','GJILPER 134 SUK FIN 110','COP',3,0.162,0.2),(337,52,'901221','VERDA No.22 125ML','BIDON',3,1.5,0.2),(338,52,'E08050','E08050','KON',3,3.5,0.2),(339,52,'GKK100','GJILPER 134 KK FIN 100','COP',6,0.174,0.2),(340,53,'G35R120','GJILPER 134 - 35 R FIN 120','COP',1,0.25,0.2),(341,53,'FUR0001','FURCE PENEL ME BISHT DRURI 12','COP',3,0,0),(342,53,'K05000','KENTAVROS - POLY/POLY - TKT NO. 50 - 5000M - COL. A','KON',1,6.075,0.2),(343,53,'D07500','SPUN POLYESTER THREAD Nm70/3 5000Y/C','KON',1,1.5,0.2),(344,53,'THK0001','COLTELLO PER SCARNIRE','COP',8,22,0.2),(345,54,'GR090','GJILPER 134 R FIN 90','COP',2,0.161,0.2),(346,54,'G35R130','GJILPER 134 - 35 R FIN 130','COP',1,0.25,0.2),(347,54,'GLR100','GJILPER 134 LR FIN 100','COP',1,0.273,0.2),(348,54,'GR140','GJILPER 134 R FIN 140','COP',1,0.161,0.2),(349,54,'GLR130','GJILPER 134 LR FIN 130','COP',1,0.273,0.2),(350,54,'GLR140','GJILPER 134 LR FIN 140','COP',1,0.273,0.2),(351,54,'GLR090','GJILPER 134 LR FIN 90','COP',1,0.273,0.2),(352,54,'G35R140','GJILPER 134 - 35 FIN 140','COP',1,0.25,0.2),(353,54,'G35R110','GJILPER 134 - 35 R FIN 110','COP',1,0.25,0.2),(354,54,'GR130','GJILPER 134 R FIN 130','COP',1,0.161,0.2),(355,54,'GKK130','GJILPER 134 KK FIN 130','COP',1,0.174,0.2),(356,54,'G35R075','GJILPER 134 - 35 R FIN 75','COP',1,0.25,0.2),(357,54,'GLR120','GJILPER 134 LR FIN 120','COP',1,0.273,0.2),(358,54,'GLR080','GJILPER 134 LR FIN 80','COP',1,0.273,0.2),(359,54,'GR100','GJILPER 134 R FIN 100','COP',1,0.161,0.2),(360,54,'G35R120','GJILPER 134 - 35 R FIN 120','COP',9,0.25,0.2),(361,58,'B02020','CF POLYESTER THREAD Nm 20/3 1500M/C','KON',2,2.7,0.2),(362,58,'D07500','SPUN POLYESTER THREAD Nm70/3 5000Y/C','KON',1,1.5,0.2),(363,59,'G35R140','GJILPER 134 - 35 FIN 140','COP',1,0.25,0.2),(364,59,'GLR100','GJILPER 134 LR FIN 100','COP',1,0.273,0.2),(365,59,'901223','VERDA NO 22 1 LT','BIDON',1,0,0.2),(366,59,'GLR080','GJILPER 134 LR FIN 80','COP',1,0.273,0.2),(367,59,'GER0002','GERSHERE ME KELLEF TE KUQ 6\'\'','COP',1,4.32,0.2),(368,59,'PMCLGF06','PENELLO M/CORTO LEGNO G/FERR 06','COP',1,1.5,0.2),(369,59,'GLR075','GJILPER 134 LR FIN 75','COP',1,0.273,0.2),(370,59,'K07500','KENTAVROS - POLY/POLY - TKT NO. 75 - 7000M - COL. A','KON',1,5.805,0.2),(371,59,'K02500','KENTAVROS - POLY/POLY - TKT NO. 25 - 2500M - COL. A','KON',1,5.265,0.2),(372,59,'G35R130','GJILPER 134 - 35 R FIN 130','COP',1,0.25,0.2),(373,59,'E08050','E08050','KON',1,3.5,0.2),(374,59,'B01020','CF POLYESTER THREAD Nm 20/3 1500M/C','KON',1,2.7,0.2),(375,59,'VAJL125ML','LUBR OIL - 125 ML','BIDON',1,1.7,0.2),(376,59,'D07500','SPUN POLYESTER THREAD Nm70/3 5000Y/C','KON',1,1.5,0.2),(377,60,'B04020','CF POLYESTER THREAD Nm 40/3 3000M/C','KON',1,2.7,0.2),(378,60,'G12002','G12002','KON',1,0,0.2),(379,60,'X12003','KORALI - SPUN POLYESTER THREAD Nm70/2 5000Y/C','KON',5,1.2,0.2),(380,60,'G35R140','GJILPER 134 - 35 FIN 140','COP',4,0.25,0.2),(381,60,'GLR080','GJILPER 134 LR FIN 80','COP',2,0.273,0.2),(382,60,'Y08501','NE 34/2 100% COTTON LENGTH 5000Y SHADE NO. 11111','KON',2,2.7,0.2),(383,60,'PMCLGF06','PENELLO M/CORTO LEGNO G/FERR 06','COP',2,1.5,0.2),(384,60,'GER0002','GERSHERE ME KELLEF TE KUQ 6\'\'','COP',2,4.32,0.2),(385,61,'B02020','CF POLYESTER THREAD Nm 20/3 1500M/C','KON',3,2.7,0.2),(386,61,'D07500','SPUN POLYESTER THREAD Nm70/3 5000Y/C','KON',2,1.5,0.2),(387,62,'D07500','SPUN POLYESTER THREAD Nm70/3 5000Y/C','KON',1,1.5,0.2),(388,62,'PEN001','REFILLS PENA - ARGENTO PUNTA FINE 1 MM','COP',1,0.169,0.2),(389,62,'GLR080','GJILPER 134 LR FIN 80','COP',1,0.273,0.2),(390,62,'PEN003','REZERVE SHKRIMI PLASTIKE, NGJYRE JESHILE','COP',1,0.66,0.2),(391,62,'GSUK110','GJILPER 134 SUK FIN 110','COP',1,0.162,0.2),(392,62,'GKK100','GJILPER 134 KK FIN 100','COP',1,0.174,0.2),(393,62,'GR080','GJILPER 134 R FIN 80','COP',1,0.161,0.2),(394,62,'GLR075','GJILPER 134 LR FIN 75','COP',10,0.273,0.2),(395,62,'GSUK075','GJILPER 134 SUK FIN 75','COP',7,0.162,0.2),(396,63,'GLR090','GJILPER 134 LR FIN 90','COP',1,0.273,0.2),(397,63,'PEN006','INK CLEANER','COP',1,0,0.2),(398,63,'X12000','KORALI - SPUN POLYESTER THREAD TKT NO. 120 - 5000Y - COL. W','KON',1,0.972,0.2),(399,63,'G35R090','GJILPER 134 - 35 R FIN 90','COP',1,0.25,0.2),(400,63,'PEN003','REZERVE SHKRIMI PLASTIKE, NGJYRE JESHILE','COP',1,0.66,0.2),(401,63,'GLR110','GJILPER 134 LR FIN 110','COP',1,0.273,0.2),(402,63,'Y03400','COTTON THREAD NE 20/3 2500 M/C','KON',1,0,0.2),(403,63,'D12000','DELFINI - SPUN POLYESTER  TKT NO. 120 5000Y','KON',1,2,0.2),(404,63,'GLR080','GJILPER 134 LR FIN 80','COP',1,0.273,0.2),(405,63,'K07500','KENTAVROS - POLY/POLY - TKT NO. 75 - 7000M - COL. A','KON',1,5.805,0.2),(406,63,'GSUK100','GJILPER 134 SUK FIN 100','COP',1,0.162,0.2),(407,63,'G35R080','GJILPER 134 - 35 R FIN 80','COP',1,0.25,0.2),(408,63,'X15002','KORALI - SPUN POLYESTER TKT NO. 15 - 10000Y COL 0100','KON',1,2.7,0.2),(409,63,'PMCLGP02','PENELLO M/CORTO LEGNO G/PLAST 02','COP',1,1.5,0.2),(410,63,'GR110','GJILPER 134 R FIN 110','COP',1,0.161,0.2),(411,63,'PMCLGF04','PENELLO M/CORTO LEGNO G/FERR 04','COP',1,1.5,0.2),(412,63,'GR090','GJILPER 134 R FIN 90','COP',1,0.161,0.2),(413,63,'G35R130','GJILPER 134 - 35 R FIN 130','COP',1,0.25,0.2),(414,63,'5304000180508','Philip Morris Supreme 10 Cigare','Pakete',1,0,0),(415,63,'GLR120','GJILPER 134 LR FIN 120','COP',1,0.273,0.2),(416,63,'GR075','GJILPER 134 R FIN 75','COP',1,0.161,0.2),(417,63,'GR140','GJILPER 134 R FIN 140','COP',1,0.161,0.2),(418,63,'PMCLGF06','PENELLO M/CORTO LEGNO G/FERR 06','COP',1,2,1);
/*!40000 ALTER TABLE `outputentry` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `redis-stock`.`outputentry_BEFORE_INSERT` BEFORE INSERT ON `outputentry` FOR EACH ROW
BEGIN
	UPDATE `Product` `p` 
	SET `size` = `size` - NEW.`size` 
    WHERE NEW.`code` = `p`.`code`;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `redis-stock`.`outputentry_BEFORE_UPDATE` BEFORE UPDATE ON `outputentry` FOR EACH ROW
BEGIN
	UPDATE `Product` `p` 
	SET `size` = `size` - NEW.`size` + OLD.`size` 
    WHERE NEW.`code` = `p`.`code`;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `redis-stock`.`outputentry_BEFORE_DELETE` BEFORE DELETE ON `outputentry` FOR EACH ROW
BEGIN
	UPDATE `Product` `p` 
	SET `size` = `size` + OLD.`size` 
    WHERE  OLD.`code` = `p`.`code`;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(16) NOT NULL,
  `group` varchar(128) NOT NULL DEFAULT '',
  `name` varchar(128) NOT NULL DEFAULT '',
  `unit` varchar(128) NOT NULL DEFAULT '',
  `size` double NOT NULL DEFAULT '0',
  `cost` double NOT NULL DEFAULT '0',
  `price` double NOT NULL DEFAULT '0',
  `tax` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=258 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (14,'VAJDS125ML','LUBRIFIKANT','SPECIAL - 125 ML','BIDON',-5,1.05,1.7,0.2),(15,'VAJL125ML','LUBRIFIKANT','LUBR OIL - 125 ML','BIDON',-5,1.05,1.7,0.2),(16,'VAJDW15','LUBRIFIKANT','WHITE 15 - 1 L','BIDON',0,2.79,4,0.2),(17,'VAJDV22','LUBRIFIKANT','VERDA 22 - 1 L','BIDON',12,2.17,3.5,0.2),(18,'W50945','LUBRIFIKANT','KOLTEX 20 SILICON SPRY','BOMBOL',25,3,4,0.2),(26,'D12000','FILL QEPJE','DELFINI - SPUN POLYESTER  TKT NO. 120 5000Y','KON',101,1.5,2,0.2),(27,'K07500','FILL QEPJE','KENTAVROS - POLY/POLY - TKT NO. 75 - 7000M - COL. A','KON',16,4.3,5.805,0.2),(28,'D12010','FILL QEPJE','DELFINI - SPUN POLYESTER  TKT NO. 120 10000Y','KON',0,0,1.75,0.2),(56,'D07500','FILL QEPJE','SPUN POLYESTER THREAD Nm70/3 5000Y/C','KON',2759,0,1.5,0.2),(88,'E16050','FILL QEPJE','ELAFI - TEXTURED POLYESTER 160 27000m','KON',60,0,2.45,0.2),(90,'X12000','FILL QEPJE','KORALI - SPUN POLYESTER THREAD TKT NO. 120 - 5000Y - COL. W','KON',3298,0.72,0.972,0.2),(91,'X12001','FILL QEPJE','KORALI - SPUN POLYESTER THREAD TKT NO. 120 - 5000Y - COL. B','KON',360,0.77,1.04,0.2),(92,'X12002','FILL QEPJE','KORALI - SPUN POLYESTER THREAD TKT NO. 120 - 5000Y - COL. C','KON',330,0.82,1.107,0.2),(93,'Y05000','FILL QEPJE','AAA - COTTON TLT NO. 30 - 4000Y - COL. E','KON',40,0,0,0.2),(94,'X12010','FILL QEPJE','KORALI - SPUN POLYESTER THREAD TKT NO. 120 - 10000Y - COL. C','KON',112,1.3,1.755,0.2),(95,'901221','LUBRIFIKANT','VERDA No.22 125ML','BIDON',47,0,1.5,0.2),(96,'904151','LUBRIFIKANT','DENOL WHITE No.15 125ml','BIDON',100,0,1.5,0.2),(97,'B08020','FILL QEPJE','CF POLYESTER THREAD Nm 80/3 7500M/C','KON',745,0,0,0.2),(99,'G12002','FILL QEPJE','G12002','KON',18,0,0,0.2),(100,'G12010','FILL QEPJE','G12010','KON',20,0,0,0.2),(106,'K02500','FILL QEPJE','KENTAVROS - POLY/POLY - TKT NO. 25 - 2500M - COL. A','KON',38,3.9,5.265,0.2),(107,'K03600','FILL QEPJE','KENTAVROS - POLY/POLY - TKT NO. 36 - 4000M - COL. A','KON',0,4.6,6.21,0.2),(108,'901223','LUBRIFIKANT','VERDA NO 22 1 LT','BIDON',-3,0,0,0.2),(109,'VAJDV15','LUBRIFIKANT','VERDA NO 15 1 LT','BIDON',22,0,0,0.2),(110,'Y03400','FILL QEPJE','COTTON THREAD NE 20/3 2500 M/C','KON',8,0,0,0.2),(111,'K05000','FILL QEPJE','KENTAVROS - POLY/POLY - TKT NO. 50 - 5000M - COL. A','KON',1,2,3,0.2),(120,'GER0001','AKSESOR','GERSHERE DE LUCA ACCIAO INOX TEMPERATO E ZEZE 6\'\'','COP',8,0,4.725,0.2),(121,'GER0002','AKSESOR','GERSHERE ME KELLEF TE KUQ 6\'\'','COP',-6,0,4.32,0.2),(122,'THK0001','TE NDRYSHME','COLTELLO PER SCARNIRE','COP',-16,0,22,0.2),(125,'MB0001','AKSESOR','MOLA CON BUSSOLA','COP',0,3.22,4.347,0.2),(126,'SHR0001','AKSESOR','SHIRIT ADEZIV I SILIKONUAR SP 0125','M2',0,0,30,0.2),(127,'GR080','GJILPER','GJILPER 134 R FIN 80','COP',-1,0.119,0.161,0.2),(139,'X15002','FILL QEPJE','KORALI - SPUN POLYESTER TKT NO. 15 - 10000Y COL 0100','KON',4,0,2.7,0.2),(140,'Y08501','FILL QEPJE','NE 34/2 100% COTTON LENGTH 5000Y SHADE NO. 11111','KON',2,0,2.7,0.2),(141,'Y03402','FILL QEPJE','NE 20/3 100% COTTON LENGTH 2500M SHADE NO. 11100','KON',3,0,2.7,0.2),(142,'Y05001','FILL QEPJE','NE 30/3 100% COTTON LENGTH 4000Y SHADE NO. 11111','KON',103,0,2.7,0.2),(143,'E08050','FILL QEPJE','E08050','KON',-4,0,3.5,0.2),(148,'MB0002','AKSESOR','MOLA SENZA BUSSOLA','COP',10,2.444,3.2999,0.2),(177,'PMCLGF08','AKSESOR','PENELLO M/CORTO LEGNO G/FERR 08','COP',0,0,1.5,0.2),(178,'PMCLGP08','AKSESOR','PENELLO M/CORTO LEGNO G/PLAST 08','COP',150,0,1.5,0.2),(179,'PMCLGF06','AKSESOR','PENELLO M/CORTO LEGNO G/FERR 06','COP',-5,3,2,0.2),(180,'PMCLGP06','AKSESOR','PENELLO M/CORTO LEGNO G/PLAST 06','COP',0,0,1.5,0.2),(182,'PMCLGP02','AKSESOR','PENELLO M/CORTO LEGNO G/PLAST 02','COP',-2,0,1.5,0.2),(183,'PMCLGF04','AKSESOR','PENELLO M/CORTO LEGNO G/FERR 04','COP',-2,0,1.5,0.2),(185,'B01020','FILL QEPJE','CF POLYESTER THREAD Nm 20/3 1500M/C','KON',776,2,2.7,0.2),(186,'B02020','FILL QEPJE','CF POLYESTER THREAD Nm 20/3 1500M/C','KON',2315,2,2.7,0.2),(187,'B03020','FILL QEPJE','CF POLYESTER THREAD Nm 80/3 2400M/C','KON',1158,2,2.7,0.2),(188,'B04020','FILL QEPJE','CF POLYESTER THREAD Nm 40/3 3000M/C','KON',4260,2,2.7,0.2),(189,'B06020','FILL QEPJE','CF POLYESTER THREAD Nm 60/2 4800M/C','KON',1139,0,3.5,0.2),(191,'PMCLGP04','AKSESOR','PENELLO M/CORTO LEGNO G/PLAST 04','COP',0,0,0,0.2),(192,'PEN001','AKSESOR','REFILLS PENA - ARGENTO PUNTA FINE 1 MM','COP',-2,0.125,0.169,0.2),(193,'GPQ001','AKSESOR','GOMMA PARA QUADRETTI MM 104X60X8','COP',0,0,0,0.2),(194,'GSUK075','GJILPER','GJILPER 134 SUK FIN 75','COP',-7,0.12,0.162,0.2),(195,'GSUK080','GJILPER','GJILPER 134 SUK FIN 80','COP',0,0.12,0.162,0.2),(196,'GSUK090','GJILPER','GJILPER 134 SUK FIN 90','COP',-18,0.12,0.162,0.2),(197,'GSUK100','GJILPER','GJILPER 134 SUK FIN 100','COP',-2,0.12,0.162,0.2),(198,'GSUK110','GJILPER','GJILPER 134 SUK FIN 110','COP',-5,0.12,0.162,0.2),(199,'GSUK120','GJILPER','GJILPER 134 SUK FIN 120','COP',0,0.12,0.162,0.2),(200,'GSUK130','GJILPER','GJILPER 134 SUK FIN 130','COP',0,0.12,0.162,0.2),(201,'GKK075','GJILPER','GJILPER 134 KK FIN 75','COP',0,0.129,0.174,0.2),(202,'GKK080','GJILPER','GJILPER 134 KK FIN 80','COP',0,0.129,0.174,0.2),(203,'GKK090','GJILPER','GJILPER 134 KK FIN 90','COP',0,0.129,0.174,0.2),(204,'GKK100','GJILPER QEPJE','GJILPER 134 KK FIN 100','COP',-14,0.129,0.174,0.2),(205,'GKK110','GJILPER QEPJE','GJILPER 134 KK FIN 110','COP',0,0.129,0.174,0.2),(206,'GKK120','GJILPER QEPJE','GJILPER 134 KK FIN 120','COP',0,0.129,0.174,0.2),(207,'GKK130','GJILPER QEPJE','GJILPER 134 KK FIN 130','COP',-2,0.129,0.174,0.2),(208,'GLR075','GJILPER QEPJE','GJILPER 134 LR FIN 75','COP',-11,0.202,0.273,0.2),(209,'GLR080','GJILPER QEPJE','GJILPER 134 LR FIN 80','COP',-12,0.202,0.273,0.2),(210,'GLR090','GJILPER QEPJE','GJILPER 134 LR FIN 90','COP',-3,0.202,0.273,0.2),(211,'GLR100','GJILPER QEPJE','GJILPER 134 LR FIN 100','COP',-4,0.202,0.273,0.2),(212,'GLR110','GJILPER QEPJE','GJILPER 134 LR FIN 110','COP',-2,0.202,0.273,0.2),(213,'GLR120','GJILPER QEPJE','GJILPER 134 LR FIN 120','COP',-4,0.202,0.273,0.2),(214,'GLR130','GJILPER QEPJE','GJILPER 134 LR FIN 130','COP',-1,0.202,0.273,0.2),(215,'G35R075','GJILPER QEPJE','GJILPER 134 - 35 R FIN 75','COP',-1,0.185,0.25,0.2),(216,'G35R080','GJILPER QEPJE','GJILPER 134 - 35 R FIN 80','COP',-2,0.185,0.25,0.2),(217,'G35R090','GJILPER QEPJE','GJILPER 134 - 35 R FIN 90','COP',-2,0.185,0.25,0.2),(218,'G35R100','GJILPER QEPJE','GJILPER 134 - 35 R FIN 100','COP',0,0.185,0.25,0.2),(219,'G35R110','GJILPER QEPJE','GJILPER 134 - 35 R FIN 110','COP',-1,0.185,0.25,0.2),(220,'G35R120','GJILPER QEPJE','GJILPER 134 - 35 R FIN 120','COP',-20,0.185,0.25,0.2),(221,'G35R130','GJILPER QEPJE','GJILPER 134 - 35 R FIN 130','COP',-8,0.185,0.25,0.2),(222,'PEN002','AKSESOR','REFILLS PENA - ARGENTO PUNTA MEDIA 1.2 MM','COP',0,0.162,0.219,0.2),(223,'GR075','GJILPER QEPJE','GJILPER 134 R FIN 75','COP',-2,0.119,0.161,0.2),(224,'GR110','GJILPER QEPJE','GJILPER 134 R FIN 110','COP',-2,0.119,0.161,0.2),(225,'GR090','GJILPER QEPJE','GJILPER 134 R FIN 90','COP',-6,0.119,0.161,0.2),(226,'GR100','GJILPER QEPJE','GJILPER 134 R FIN 100','COP',-1,0.119,0.161,0.2),(227,'GR120','GJILPER QEPJE','GJILPER 134 R FIN 120','COP',-2,0.119,0.161,0.2),(228,'GR130','GJILPER QEPJE','GJILPER 134 R FIN 130','COP',-2,0.119,0.161,0.2),(230,'GR140','GJILPER QEPJE','GJILPER 134 R FIN 140','COP',-3,0.119,0.161,0.2),(231,'G35R140','GJILPER QEPJE','GJILPER 134 - 35 FIN 140','COP',-12,0.185,0.25,0.2),(232,'GLR140','GJILPER QEPJE','GJILPER 134 LR FIN 140','COP',-1,0.202,0.273,0.2),(233,'PEN003','AKSESOR','REZERVE SHKRIMI PLASTIKE, NGJYRE JESHILE','COP',-4,0.46,0.66,0.2),(234,'PEN004','AKSESOR','REZERVE SHKRIMI PLASTIKE, NGJYRE E KUQE','COP',0,0.46,0.66,0.2),(235,'PEN005','AKSESOR','REZERVE SHKRIMI PLASTIKE, NGJYRE E BARDHE','COP',0,0.48,0.68,0.2),(236,'PEN006','AKSESOR','INK CLEANER','COP',-2,0,0,0.2),(239,'X05002','FILL QEPJE','KORALI - SPUN POLYESTER THREAD Nm50/3 5000Y/C','KON',200,0,2.2,0.2),(240,'X12003','FILL QEPJE','KORALI - SPUN POLYESTER THREAD Nm70/2 5000Y/C','KON',590,0,1.2,0.2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `description` varchar(256) NOT NULL,
  `view` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (0,'Gjendja e Artikujve','Lista e te gjithe produkteve dhe gjendjet perkatese ne magazina.','view_states'),(1,'Historiku i Blerjeve','Lista e te gjitha blerjeve sipas fatures, dates dhe artikullit.','view_inputs'),(2,'Historiku i Shitjeve','Lista e te gjitha shitjeve sipas fatures, dates dhe artikullit.','view_outputs');
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(256) NOT NULL DEFAULT '',
  `name` varchar(256) NOT NULL DEFAULT '',
  `address` varchar(256) NOT NULL DEFAULT '',
  `phone` varchar(256) NOT NULL DEFAULT '',
  `email` varchar(256) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (0,'','Magazine Anonime','','','');
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(16) NOT NULL,
  `name` varchar(128) NOT NULL,
  `address` varchar(128) NOT NULL DEFAULT '',
  `phone` varchar(128) NOT NULL DEFAULT '',
  `email` varchar(128) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (0,'FA','FORNITOR ANONIM','','',''),(35,'L76604205F','REDIS I. T.','Rr. F. Gjomema, Vlore 9403','+355 69 20 48 755','info@redis-it.com'),(36,'PI03215120753','RAMAC SRL','Lecce, Italy',' ',' '),(37,'EL094360080','BRILLANT THREADS S.A','Athens, Greece',' ',' ');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_inputs`
--

DROP TABLE IF EXISTS `view_inputs`;
/*!50001 DROP VIEW IF EXISTS `view_inputs`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_inputs` AS SELECT 
 1 AS `Fatura`,
 1 AS `Data`,
 1 AS `Kodi`,
 1 AS `Emertimi`,
 1 AS `Njesia`,
 1 AS `Sasia`,
 1 AS `Cmimi`,
 1 AS `Tvsh %`,
 1 AS `Vlera`,
 1 AS `Tvsh`,
 1 AS `Total`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_outputs`
--

DROP TABLE IF EXISTS `view_outputs`;
/*!50001 DROP VIEW IF EXISTS `view_outputs`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_outputs` AS SELECT 
 1 AS `Fatura`,
 1 AS `Data`,
 1 AS `Kodi`,
 1 AS `Emertimi`,
 1 AS `Njesia`,
 1 AS `Sasia`,
 1 AS `Cmimi`,
 1 AS `Tvsh %`,
 1 AS `Vlera`,
 1 AS `Tvsh`,
 1 AS `Total`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_states`
--

DROP TABLE IF EXISTS `view_states`;
/*!50001 DROP VIEW IF EXISTS `view_states`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_states` AS SELECT 
 1 AS `Kodi`,
 1 AS `Kategoria`,
 1 AS `Emertimi`,
 1 AS `Njesia`,
 1 AS `Sasia`,
 1 AS `Sasi Blerje`,
 1 AS `Cmim Blerje`,
 1 AS `Vlere Blerje`,
 1 AS `Tvsh Blerje`,
 1 AS `Total Blerje`,
 1 AS `Sasi Shitje`,
 1 AS `Cmim Shitje`,
 1 AS `Vlere Shitje`,
 1 AS `Tvsh Shitje`,
 1 AS `Total Shitje`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'redis-stock'
--

--
-- Dumping routines for database 'redis-stock'
--

--
-- Final view structure for view `view_inputs`
--

/*!50001 DROP VIEW IF EXISTS `view_inputs`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_inputs` AS select `i`.`code` AS `Fatura`,`i`.`instant` AS `Data`,`e`.`code` AS `Kodi`,`e`.`name` AS `Emertimi`,`e`.`unit` AS `Njesia`,`e`.`size` AS `Sasia`,`e`.`price` AS `Cmimi`,`e`.`tax` AS `Tvsh %`,round((`e`.`size` * `e`.`price`),2) AS `Vlera`,round(((`e`.`size` * `e`.`price`) * `e`.`tax`),2) AS `Tvsh`,round(((`e`.`size` * `e`.`price`) + ((`e`.`size` * `e`.`price`) * `e`.`tax`)),2) AS `Total` from (`input` `i` join `inputentry` `e` on((`i`.`id` = `e`.`input`))) order by `i`.`instant`,`e`.`code` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_outputs`
--

/*!50001 DROP VIEW IF EXISTS `view_outputs`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_outputs` AS select `o`.`code` AS `Fatura`,`o`.`instant` AS `Data`,`e`.`code` AS `Kodi`,`e`.`name` AS `Emertimi`,`e`.`unit` AS `Njesia`,`e`.`size` AS `Sasia`,`e`.`price` AS `Cmimi`,`e`.`tax` AS `Tvsh %`,round((`e`.`size` * `e`.`price`),2) AS `Vlera`,round(((`e`.`size` * `e`.`price`) * `e`.`tax`),2) AS `Tvsh`,round(((`e`.`size` * `e`.`price`) + ((`e`.`size` * `e`.`price`) * `e`.`tax`)),2) AS `Total` from (`output` `o` join `outputentry` `e` on((`o`.`id` = `e`.`output`))) order by `o`.`instant`,`e`.`code` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_states`
--

/*!50001 DROP VIEW IF EXISTS `view_states`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_states` AS select `p`.`code` AS `Kodi`,`p`.`group` AS `Kategoria`,`p`.`name` AS `Emertimi`,`p`.`unit` AS `Njesia`,(ifnull(sum(`ie`.`size`),0) - ifnull(sum(`oe`.`size`),0)) AS `Sasia`,round(sum(`ie`.`size`),2) AS `Sasi Blerje`,round((sum((`ie`.`size` * `ie`.`price`)) / sum(`ie`.`size`)),2) AS `Cmim Blerje`,round(sum((`ie`.`size` * `ie`.`price`)),2) AS `Vlere Blerje`,round(sum(((`ie`.`size` * `ie`.`price`) * `ie`.`tax`)),2) AS `Tvsh Blerje`,round((sum((`ie`.`size` * `ie`.`price`)) + sum(((`ie`.`size` * `ie`.`price`) * `ie`.`tax`))),2) AS `Total Blerje`,round(sum(`oe`.`size`),2) AS `Sasi Shitje`,round((sum((`oe`.`size` * `oe`.`price`)) / sum(`oe`.`size`)),2) AS `Cmim Shitje`,round(sum((`oe`.`size` * `oe`.`price`)),2) AS `Vlere Shitje`,round(sum(((`oe`.`size` * `oe`.`price`) * `oe`.`tax`)),2) AS `Tvsh Shitje`,round((sum((`oe`.`size` * `oe`.`price`)) + sum(((`oe`.`size` * `oe`.`price`) * `oe`.`tax`))),2) AS `Total Shitje` from ((`product` `p` left join `inputentry` `ie` on((`p`.`code` = `ie`.`code`))) left join `outputentry` `oe` on((`p`.`code` = `oe`.`code`))) group by `p`.`code` order by `p`.`name` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-30  2:42:30
