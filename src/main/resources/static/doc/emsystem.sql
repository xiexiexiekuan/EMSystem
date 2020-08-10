CREATE DATABASE  IF NOT EXISTS `emsystem` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `emsystem`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: emsystem
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `applicationinformation`
--

DROP TABLE IF EXISTS `applicationinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applicationinformation` (
  `enterId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `examineeNumber` varchar(50) NOT NULL,
  `publishId` int NOT NULL,
  `examineePhoto` varchar(50) DEFAULT NULL,
  `curSchool` varchar(50) DEFAULT NULL,
  `stuType` varchar(50) NOT NULL,
  `wantSchool` varchar(50) DEFAULT NULL,
  `previewStatus` int DEFAULT NULL,
  `applyStatus` int DEFAULT NULL,
  `payStatus` int DEFAULT NULL,
  `examStatus` int DEFAULT NULL,
  `grades` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`enterId`),
  KEY `FK_Reference_11` (`userId`),
  KEY `FK_Reference_5` (`publishId`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`userId`) REFERENCES `userinformation` (`userId`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`publishId`) REFERENCES `publishexam` (`publishId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicationinformation`
--

LOCK TABLES `applicationinformation` WRITE;
/*!40000 ALTER TABLE `applicationinformation` DISABLE KEYS */;
INSERT INTO `applicationinformation` VALUES (1,5,'160508252501',1,NULL,'华中农业大学','社会型','武汉大学',1,1,1,1,'85');
/*!40000 ALTER TABLE `applicationinformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examroominformation`
--

DROP TABLE IF EXISTS `examroominformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examroominformation` (
  `examRoomId` int NOT NULL AUTO_INCREMENT,
  `examRoomNum` int NOT NULL,
  `examRoomLocate` varchar(50) NOT NULL,
  `roomId` int NOT NULL,
  `useStatus` int NOT NULL,
  PRIMARY KEY (`examRoomId`),
  KEY `FK_Reference_9` (`roomId`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`roomId`) REFERENCES `roommanage` (`roomId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examroominformation`
--

LOCK TABLES `examroominformation` WRITE;
/*!40000 ALTER TABLE `examroominformation` DISABLE KEYS */;
INSERT INTO `examroominformation` VALUES (1,1,'左一',1,0),(2,2,'左二',1,0);
/*!40000 ALTER TABLE `examroominformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examteacher`
--

DROP TABLE IF EXISTS `examteacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examteacher` (
  `teacherId` int NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(50) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `age` int NOT NULL,
  `phone` varchar(11) NOT NULL,
  `position` varchar(50) NOT NULL,
  `roomId` int NOT NULL,
  `examRoomId` int DEFAULT NULL,
  PRIMARY KEY (`teacherId`),
  KEY `FK_Reference_10` (`roomId`),
  KEY `FK_Reference_14` (`examRoomId`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`roomId`) REFERENCES `roommanage` (`roomId`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`examRoomId`) REFERENCES `examroominformation` (`examRoomId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examteacher`
--

LOCK TABLES `examteacher` WRITE;
/*!40000 ALTER TABLE `examteacher` DISABLE KEYS */;
INSERT INTO `examteacher` VALUES (1,'老师1','男',36,'12356485412','教职工',1,NULL);
/*!40000 ALTER TABLE `examteacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examtype`
--

DROP TABLE IF EXISTS `examtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examtype` (
  `typeId` int NOT NULL AUTO_INCREMENT,
  `typeName` varchar(10) NOT NULL,
  `certificate` varchar(100) NOT NULL,
  `userId` varchar(10) NOT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examtype`
--

LOCK TABLES `examtype` WRITE;
/*!40000 ALTER TABLE `examtype` DISABLE KEYS */;
INSERT INTO `examtype` VALUES (1,'JAVA程序设计','Java是一门面向对象编程语言','admin','2020-08-10 13:37:22'),(2,'c++','考试时是闭卷','admin','2020-08-10 13:38:07'),(3,'数据挖掘','需要描述+书写一段数据清洗代码','admin','2020-08-10 13:44:42');
/*!40000 ALTER TABLE `examtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `judgingplan`
--

DROP TABLE IF EXISTS `judgingplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `judgingplan` (
  `planCode` int NOT NULL AUTO_INCREMENT,
  `publishId` int NOT NULL,
  `judgingStart` datetime NOT NULL,
  `judgingEnd` datetime NOT NULL,
  `schoolCode` int NOT NULL,
  `schoolName` varchar(50) NOT NULL,
  `paperCode` varchar(50) NOT NULL,
  `paperNum` int NOT NULL,
  PRIMARY KEY (`planCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `judgingplan`
--

LOCK TABLES `judgingplan` WRITE;
/*!40000 ALTER TABLE `judgingplan` DISABLE KEYS */;
/*!40000 ALTER TABLE `judgingplan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penaltycode`
--

DROP TABLE IF EXISTS `penaltycode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `penaltycode` (
  `punishmentCode` int NOT NULL,
  `punishmentDes` varchar(100) NOT NULL,
  PRIMARY KEY (`punishmentCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penaltycode`
--

LOCK TABLES `penaltycode` WRITE;
/*!40000 ALTER TABLE `penaltycode` DISABLE KEYS */;
INSERT INTO `penaltycode` VALUES (0,'未处罚                          '),(1,'单科成绩记零分            '),(2,'本次成绩记零分 '),(3,'本次成绩记零分并停考一年        '),(4,'本次成绩记零分并停考二年'),(5,'本次成绩记零分并停考三年'),(6,'毕业申请违归停考一年'),(7,'毕业申请违归停考两年               '),(8,'毕业申请违规停考三年');
/*!40000 ALTER TABLE `penaltycode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publishexam`
--

DROP TABLE IF EXISTS `publishexam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publishexam` (
  `publishId` int NOT NULL AUTO_INCREMENT,
  `typeId` int NOT NULL,
  `registrationStarts` datetime NOT NULL,
  `registrationDeadline` datetime NOT NULL,
  `applyStarts` datetime NOT NULL,
  `applyDeadline` datetime NOT NULL,
  `confirmationStarts` datetime NOT NULL,
  `confirmationDeadline` datetime NOT NULL,
  `admissioncardPrintStarts` datetime NOT NULL,
  `admissioncardPrintDeadline` datetime NOT NULL,
  `userId` varchar(50) NOT NULL,
  `publishTime` datetime NOT NULL,
  PRIMARY KEY (`publishId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publishexam`
--

LOCK TABLES `publishexam` WRITE;
/*!40000 ALTER TABLE `publishexam` DISABLE KEYS */;
INSERT INTO `publishexam` VALUES (1,1,'2020-08-10 10:00:00','2020-09-10 10:00:00','2020-09-20 10:00:00','2020-09-30 10:00:00','2020-10-10 10:00:00','2020-10-20 10:00:00','2020-10-21 10:00:00','2020-11-10 10:00:00','admin','2020-08-10 13:47:12');
/*!40000 ALTER TABLE `publishexam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roommanage`
--

DROP TABLE IF EXISTS `roommanage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roommanage` (
  `roomId` int NOT NULL AUTO_INCREMENT,
  `roomName` varchar(50) NOT NULL,
  `roomAddress` varchar(50) NOT NULL,
  `roomNumber` int NOT NULL,
  `numberStart` int NOT NULL,
  `numberEnd` int NOT NULL,
  PRIMARY KEY (`roomId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roommanage`
--

LOCK TABLES `roommanage` WRITE;
/*!40000 ALTER TABLE `roommanage` DISABLE KEYS */;
INSERT INTO `roommanage` VALUES (1,'华中农业大学','湖北省武汉市洪山区狮子山1号',0,0,0);
/*!40000 ALTER TABLE `roommanage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinformation`
--

DROP TABLE IF EXISTS `userinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinformation` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `institute` varchar(50) DEFAULT NULL,
  `certificateType` varchar(50) DEFAULT NULL,
  `certificateId` varchar(50) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `role` int DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinformation`
--

LOCK TABLES `userinformation` WRITE;
/*!40000 ALTER TABLE `userinformation` DISABLE KEYS */;
INSERT INTO `userinformation` VALUES (1,'admin','admin','男',30,'QQ图片20180702191137.png','湖北省考试院助手','身份证','61337819900101000x','15608762678','1279800@qq.com',0),(2,'mayor','mayor','男',35,'QQ图片20180815175616.png','武汉市市长助理','身份证','429006155523256584','15072995824','11211221212@qq.com',1),(3,'manager','manager','女',20,'QQ图片20180614160422.png','华中农业大学','教师资格证','56896325414','12584569632','5896235@qq.com',2),(4,'manager1','manager1','女',23,'d464b0c3d1ce4a65a72ca4eda75021a7_th.png','华中农业大学1','身份证','562339622214522325','15365214521','56232541@qq.com',2),(5,'student','student','男',22,'QQ图片20180815121727.png','华中农业大学','身份证','429006199901031214','15827627269','xiekuan@webmail.hzau.edu.cn',3),(6,'student1','student1','女',19,NULL,'华中农业大学','身份证','429006199901031214','15823565458','11111111@qq.com',3),(7,'student2','student2','女',20,NULL,'华中农业大学','身份证','429006192365431214','15072995824','112222221@qq.com',3);
/*!40000 ALTER TABLE `userinformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `violationinfo`
--

DROP TABLE IF EXISTS `violationinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `violationinfo` (
  `violateRecordId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `publishId` varchar(50) NOT NULL,
  `violationsCode` int NOT NULL,
  `violateDescription` varchar(100) NOT NULL,
  `previewStatus` int NOT NULL,
  `punishmentCode` int DEFAULT NULL,
  `punishDescription` varchar(100) DEFAULT NULL,
  `reportMan` varchar(50) NOT NULL,
  `reportTime` datetime NOT NULL,
  `punishMan` varchar(50) DEFAULT NULL,
  `punishTime` datetime DEFAULT NULL,
  `processing_state` varchar(1) DEFAULT '0',
  PRIMARY KEY (`violateRecordId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `violationinfo`
--

LOCK TABLES `violationinfo` WRITE;
/*!40000 ALTER TABLE `violationinfo` DISABLE KEYS */;
INSERT INTO `violationinfo` VALUES (1,6,'1',1,'手机掉出来了',0,NULL,NULL,'mayor','2020-08-10 14:25:52',NULL,NULL,'0');
/*!40000 ALTER TABLE `violationinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `violationscode`
--

DROP TABLE IF EXISTS `violationscode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `violationscode` (
  `violationsCode` int NOT NULL AUTO_INCREMENT,
  `violationsDes` varchar(100) NOT NULL,
  `punishmentDes` int DEFAULT NULL,
  PRIMARY KEY (`violationsCode`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `violationscode`
--

LOCK TABLES `violationscode` WRITE;
/*!40000 ALTER TABLE `violationscode` DISABLE KEYS */;
INSERT INTO `violationscode` VALUES (1,'带规定以外的物品进入',1),(2,'未在规定的座位参加考试的',1),(3,'考试开始信号发出前答题或者考试结束信号发出后继续答题的',1),(4,'在考试过程中旁窥、交头接耳、互打暗号或者手势的',1),(5,'在考场或者教育考试机构禁止的范围内，喧哗、吸烟或者实施其他影响考场秩序的行为的',1),(6,'未经考试工作人员同意在考试过程中擅自离开考场的',1),(7,'将试卷、答卷(含答题卡、答题纸等，下同)、草稿纸等考试用纸带出考场的',1),(8,'用规定以外的笔或者纸答题或者在试卷规定以外的地方书写姓名、考号或者以其他方式在答卷上标记信息的',1),(9,'其他违返考场规则但尚未构成作弊的行为',1),(10,'携带与考试内容相关的文字材料或者存储有与考试内容相关资料的电子设备参加考试的',2),(11,'抄袭或者协助他人抄袭试题答案或者与考试内容相关的资料的',2),(12,'抢夺、窃取他人试卷、答卷或者强迫他人为自已抄袭提供方便的',2),(13,'在考试过程中使用通讯设备的',3),(14,'由他人冒名代替参加考试的',4),(15,'故意销毁试卷、答卷或者考试材料的',5),(16,'在答卷上填写本人身份不符的姓名、考号等信息的',3),(17,'传、接物品或者交换试卷、答卷、草搞纸的',3),(18,'其他作弊行为的',4),(19,'通过伪造证件、证明、档案及其他材料获得考试资格和考试成绩的',6),(20,'评卷过程中被发现同一科目同一考场有两份以上(含两份)答卷答案雷同的',7),(21,'考场纪律混乱、考试秩序失控，出现大面积考试作弊现象的',8),(22,'考试工作人员协助实施作弊行为，事后查实的',8),(23,'其他应认定为作弊的行为',6),(24,'故意扰乱考点、考场、评卷场所等考试工作场所秩序',5),(25,'拒绝、妨碍考试工作人员履行管理职责',4),(26,'威胁、侮辱、诽谤、诬陷考试工作',3),(27,'其他扰乱考试管理秩序的行为',4);
/*!40000 ALTER TABLE `violationscode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `whitelist`
--

DROP TABLE IF EXISTS `whitelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `whitelist` (
  `listId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `certificateId` varchar(50) NOT NULL,
  PRIMARY KEY (`listId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `whitelist`
--

LOCK TABLES `whitelist` WRITE;
/*!40000 ALTER TABLE `whitelist` DISABLE KEYS */;
INSERT INTO `whitelist` VALUES (1,6,'429006199901031214');
/*!40000 ALTER TABLE `whitelist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-10 15:19:23
