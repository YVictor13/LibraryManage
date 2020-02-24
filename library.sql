/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.17 : Database - qqdatebase
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`qqdatebase` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `qqdatebase`;

/*Table structure for table `friends` */

DROP TABLE IF EXISTS `friends`;

CREATE TABLE `friends` (
  `account_id1` varchar(20) NOT NULL,
  `account_id2` varchar(20) NOT NULL,
  PRIMARY KEY (`account_id1`,`account_id2`),
  KEY `account_id2` (`account_id2`),
  CONSTRAINT `friends_ibfk_1` FOREIGN KEY (`account_id1`) REFERENCES `information` (`id`),
  CONSTRAINT `friends_ibfk_2` FOREIGN KEY (`account_id2`) REFERENCES `information` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `friends` */

insert  into `friends`(`account_id1`,`account_id2`) values ('874274302','1079079202'),('874274302','139823201'),('836053023','594187485'),('874274302','594187485'),('809975741','731658414'),('874274302','731658414'),('809975741','770730214'),('731658414','809975741'),('770730214','809975741'),('838334661','809975741'),('874274302','836053023'),('809975741','838334661'),('836053023','874274302'),('809975741','918600103'),('838334661','918600103');

/*Table structure for table `groupinformation` */

DROP TABLE IF EXISTS `groupinformation`;

CREATE TABLE `groupinformation` (
  `groupname` varchar(20) NOT NULL,
  `groupid` varchar(20) NOT NULL,
  PRIMARY KEY (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `groupinformation` */

insert  into `groupinformation`(`groupname`,`groupid`) values ('西电群','1'),('西安群','2'),('陕西群','3'),('西南群','4'),('中国群','5'),('世界群','6');

/*Table structure for table `grouplist` */

DROP TABLE IF EXISTS `grouplist`;

CREATE TABLE `grouplist` (
  `account` varchar(20) NOT NULL,
  `groupid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`account`,`groupid`),
  KEY `groupid` (`groupid`),
  CONSTRAINT `grouplist_ibfk_1` FOREIGN KEY (`account`) REFERENCES `information` (`id`),
  CONSTRAINT `grouplist_ibfk_2` FOREIGN KEY (`groupid`) REFERENCES `groupinformation` (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `grouplist` */

insert  into `grouplist`(`account`,`groupid`) values ('770730214','1'),('809975741','1'),('838334661','1'),('874274302','1'),('770730214','2'),('809975741','2'),('838334661','2'),('874274302','2'),('809975741','3'),('838334661','3'),('874274302','3'),('809975741','6'),('874274302','6');

/*Table structure for table `information` */

DROP TABLE IF EXISTS `information`;

CREATE TABLE `information` (
  `id` varchar(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `brithday` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `Email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `state` varchar(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `information` */

insert  into `information`(`id`,`username`,`password`,`sex`,`brithday`,`address`,`Email`,`state`) values ('1003539340','呵呵','1111',NULL,NULL,NULL,NULL,'0'),('1079079202','hh','1111',NULL,NULL,NULL,NULL,'0'),('1097543946','lh','1111',NULL,NULL,NULL,NULL,'0'),('139823201','哈哈哈','1111',NULL,NULL,NULL,NULL,'0'),('594187485','呵呵','1111',NULL,NULL,NULL,NULL,'0'),('696624366','hhh','1111',NULL,NULL,NULL,NULL,'0'),('731658414','嘻嘻嘻','1111',NULL,NULL,NULL,NULL,'0'),('770730214','lihuang','1111',NULL,NULL,NULL,NULL,'1'),('809975741','林鑫','1111',NULL,NULL,NULL,NULL,'1'),('836053023','呵呵呵','1111',NULL,NULL,NULL,NULL,'0'),('838334661','李煌','1111',NULL,NULL,NULL,NULL,'1'),('874274302','啧啧啧','1111',NULL,NULL,NULL,NULL,'0'),('918600103','dd','sss',NULL,NULL,NULL,NULL,'0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
