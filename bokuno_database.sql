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

insert into `t_patient`(`patient_id`,`patient_name`,`patient_age`,`patient_iden_id`,`last_hospitalizationTime`,`patient_sex`,`disease`,`patient_account_id`,`patient_account_password`) values (NULL,'小明',10,'114514','2020.1','男','瘸腿','小明',1111),(NULL,'小刚',11,'1145141','2020.12','男','断手','xiaogang',1111);


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

insert into `t_room`(`room_id`,`room_function`)values(NULL,"外科手术"),(NULL,"外科门诊"),(NULL,"内科门诊"),(NULL,"B超室");

DROP TABLE IF EXISTS `t_doctor`;

CREATE TABLE `t_doctor` (
  `doctor_id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor_name` varchar(110),
  `doctor_age` int(11) ,
  `doctor_major` varchar(110),
  `doctor_department` varchar(110),
  `doctor_level` varchar(110),
  `doctor_description` text,
  `doctor_experience` int(11), 
  `doctor_account_id` varchar(110),
  `doctor_account_password` varchar(110),
  PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

insert into `t_doctor`(`doctor_id`,`doctor_name`,`doctor_age`,`doctor_major`,`doctor_department`,`doctor_level`,`doctor_description`,`doctor_experience`,`doctor_account_id`,`doctor_account_password`) values(NULL,"医生贾",33,"外科手术","外科","见习","应届毕业生","0.5","AA1213","123456"),(NULL,"医生乙",34,"内科手术","内科","普通","态度良好","2","AB1444","123456HMS");

DROP TABLE IF EXISTS `t_nurse`;

CREATE TABLE `t_nurse` (
  `nurse_id` int(11) NOT NULL AUTO_INCREMENT,
  `nurse_name` varchar(110),
  `nurse_age` int(11) ,
  `nurse_major` varchar(110),
  `nurse_department` varchar(110),
  `nurse_level` varchar(110),
  `nurse_description` text,
  `nurse_experience` int(11), 
  `nurse_account_id` varchar(110),
  `nurse_account_password` varchar(110),
  PRIMARY KEY (`nurse_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

insert into `t_nurse`(`nurse_id`,`nurse_name`,`nurse_age`,`nurse_major`,`nurse_department`,`nurse_level`,`nurse_description`,`nurse_experience`,`nurse_account_id`,`nurse_account_password`) values(NULL,"护士丁",17,"外科护理","外科","见习","应届毕业生","0.2","BB12","544322"),(NULL,"护士卡卡",44,"内科护理","内科","专业","口齿不清","4","CA1111","456HMS");
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
