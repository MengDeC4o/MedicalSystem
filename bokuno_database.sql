/*
SQLyog v10.2 
MySQL - 5.6.24-log : Database - db_appapidemo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bokuno_database` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `bokuno_database`;


DROP TABLE IF EXISTS `t_patient`;

CREATE TABLE `t_patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(110) ,
  `patient_age` int(11) ,
  `patient_iden_id` varchar(110) ,
  `last_hospitalizationTime` varchar(110) ,
  `patient_sex` varchar(110) , 
  `disease` text,
  `patient_account_id` varchar(110) ,
  `patient_account_password` varchar(110) DEFAULT '88888888',
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

insert into `t_patient`(`patient_id`,`patient_name`,`patient_age`,`patient_iden_id`,`last_hospitalizationTime`,`patient_sex`,`disease`,`patient_account_id`) values (NULL,'小明',10,'114514','2020.1','男','瘸腿','小明');


/*Table structure for table `t_album` */

DROP TABLE IF EXISTS `t_drug`;

CREATE TABLE `t_drug` (
  `drug_id` int(11) NOT NULL AUTO_INCREMENT,
  `drug_name` varchar(110) NOT NULL,
  `drug_producer` varchar(110) ,
  `drug_produceDate` varchar(110),
  `drug_expdate` varchar(110),
  `stock` int(11) NOT NULL DEFAULT 1,
  `drug_abstract` text,
  `drug_description` text,
  `comm` varchar(110),  /*comment*/
  PRIMARY KEY (`drug_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

insert into `t_drug`(`drug_id`,`drug_name`,`drug_producer`,`drug_produceDate`,`drug_expdate`,`stock`,`drug_abstract`,`drug_description`, `comm`) values (NULL, "头孢", "中国人", "昨天", "明天", 2, "头孢克圬胶囊","炎症", "无");


DROP TABLE IF EXISTS `t_room`;

CREATE TABLE `t_room` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `room_function` varchar(110) NOT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

insert into `t_room`(`room_id`,`room_function`)values(NULL,"喝水"),(NULL,"喝茶"),(NULL,"吃饭"),(NULL,"吃菜");
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
