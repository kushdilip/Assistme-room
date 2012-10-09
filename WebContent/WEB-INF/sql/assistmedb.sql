/*
SQLyog Community v9.02 
MySQL - 5.5.12 : Database - assistmedb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`assistmedb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `assistmedb`;

/*Table structure for table `anniversaries` */

DROP TABLE IF EXISTS `anniversaries`;

CREATE TABLE `anniversaries` (
  `anniversary_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `people` varchar(500) NOT NULL,
  `repeat_cycle` varchar(1) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`anniversary_id`),
  KEY `FK_anniversaries1` (`user_id`),
  CONSTRAINT `FK_anniversaries1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `anniversaries` */

insert  into `anniversaries`(`anniversary_id`,`title`,`date`,`people`,`repeat_cycle`,`user_id`) values (1,'birthday','1990-04-08','dilip','y',1),(5,'birthday ','2011-05-23','sldfj','m',1),(6,'Birthday','2012-10-17','xyz','y',3),(7,'Birthday','2012-09-30','ddgdfgdfg','y',3),(8,'Birthday','2012-10-17','fsdfsdf','y',4),(9,'Birthday','2012-10-10','ddgdfgdfg','y',3),(10,'Birthday','2012-10-09','sfsdf','y',3),(11,'Other','2012-10-29','asdfsf','m',3);

/*Table structure for table `contacts` */

DROP TABLE IF EXISTS `contacts`;

CREATE TABLE `contacts` (
  `CONTACTS_PK` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `MOBILE` varchar(255) DEFAULT NULL,
  `EMAIL_ID` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`CONTACTS_PK`),
  KEY `FK_contacts4` (`user_id`),
  CONSTRAINT `FK_contacts4` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

/*Data for the table `contacts` */

insert  into `contacts`(`CONTACTS_PK`,`NAME`,`MOBILE`,`EMAIL_ID`,`user_id`) values (32,'Naresh kumar','45345','kush.dilip@gmail.com',3),(35,'Siddhartha','9985587855','s.y@gmail.com',1),(36,'Siddhartha','9985587855','s.y@gmail.com',3),(37,'Anudeep','9985587855','k.s@gmail.com',4);

/*Table structure for table `transactions` */

DROP TABLE IF EXISTS `transactions`;

CREATE TABLE `transactions` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `description` varchar(255) NOT NULL,
  `contact_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `is_deleted` bit(1) NOT NULL DEFAULT b'0',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `FK_iou_tracker1` (`user_id`),
  KEY `FK_iou_tracker2` (`contact_id`),
  CONSTRAINT `FK_iou_tracker1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_iou_tracker2` FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`CONTACTS_PK`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `transactions` */

insert  into `transactions`(`transaction_id`,`date`,`description`,`contact_id`,`amount`,`is_deleted`,`user_id`) values (1,'2010-12-30','lunch',36,200,'\0',3),(2,'2009-11-20','breakfast',32,400,'\0',3),(3,'2012-08-10','shopping',36,1000,'\0',3),(5,'2011-12-30','shopping',36,230,'\0',3),(10,'2011-12-30','shopping',36,230,'\0',3),(11,'2010-12-12','shopping',36,1200,'\0',3);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email_id` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`user_id`,`first_name`,`last_name`,`email_id`,`password`) values (1,'krishnashree','saika','k.s@gmail.com','password'),(3,'dilip','kushwaha','kush.dilip@gmail.com','password'),(4,'dilip','kushwaha','d.k@g.com','password');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
