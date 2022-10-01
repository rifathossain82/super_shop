/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.0.45-community-nt : Database - super_shop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`super_shop` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `super_shop`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `Sl. No.` int(50) default NULL,
  `Password` varchar(100) NOT NULL,
  PRIMARY KEY  (`Password`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`Sl. No.`,`Password`) values (1,'commonP123'),(2,'generalP123'),(3,'helloJava'),(4,'UltraMordern');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `User Id` int(20) NOT NULL auto_increment,
  `First Name` varchar(30) NOT NULL,
  `Last Name` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Phone no.` int(30) NOT NULL,
  PRIMARY KEY  (`Email`),
  KEY `User Id` (`User Id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`User Id`,`First Name`,`Last Name`,`Email`,`Password`,`Gender`,`Phone no.`) values (3,'Faruk','Kavir','fa@gmail.com','fa123','Male',2147483647),(5,'Fahim','Miah','far@gmail.com','far123','Male',1886765456),(4,'Jobayer ','Hossain','jo@gmail.com','jo123','Male',187876865),(2,'Rasel','Miah','ra@gmail.com','ra123','Male',2147483647),(16,'Rifat','Akbar','rh52560@gmail.com','12345','Male',1885256220),(15,'Rifat','Hossain','rh5256220@gmail.com','rifat123','Male',1885256220),(10,'Rifat ','Hossain','rh52562220@gmail.com','commonP123','Female',1885256220),(1,'Rifat','Hossain','rh@gmail.com','rifat123','Male',1885256220);

/*Table structure for table `product2` */

DROP TABLE IF EXISTS `product2`;

CREATE TABLE `product2` (
  `Product Id` int(20) NOT NULL,
  `Product Name` varchar(50) default NULL,
  `Product Price` int(20) default NULL,
  `Product Details` varchar(200) default NULL,
  PRIMARY KEY  (`Product Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product2` */

insert  into `product2`(`Product Id`,`Product Name`,`Product Price`,`Product Details`) values (101,'T-Shart',550,'Ind'),(102,'Pant',800,'Ban'),(104,'Shart',522,'Ind');

/*Table structure for table `psalesdata` */

DROP TABLE IF EXISTS `psalesdata`;

CREATE TABLE `psalesdata` (
  `Bill no.` int(40) default NULL,
  `Date` varchar(50) default NULL,
  `Amount` int(40) default NULL,
  `Discount` int(40) default NULL,
  `Paid` int(40) default NULL,
  `Paid Type` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `psalesdata` */

insert  into `psalesdata`(`Bill no.`,`Date`,`Amount`,`Discount`,`Paid`,`Paid Type`) values (1,'2020-01-06',113700,200,113500,'Cash'),(2,'2020-01-06',42150,50,42100,'bkash');

/*Table structure for table `purchase` */

DROP TABLE IF EXISTS `purchase`;

CREATE TABLE `purchase` (
  `Bill NO.` int(20) default NULL,
  `Date` varchar(60) default NULL,
  `Suplier Name` varchar(80) default NULL,
  `Product Name` varchar(80) default NULL,
  `Product Price` int(20) default NULL,
  `Product Quantity` int(10) default NULL,
  `Product Details` varchar(200) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `purchase` */

insert  into `purchase`(`Bill NO.`,`Date`,`Suplier Name`,`Product Name`,`Product Price`,`Product Quantity`,`Product Details`) values (1,'2020-01-05','Md kamal','Pant',900,12,'Ban'),(2,'2020-01-06','Md kamal','Pant',900,50,'Ban'),(2,'2020-01-06','Md kamal','T-Shart',550,70,'Ind'),(2,'2020-01-06','Md kamal','Shart',522,120,'Ind'),(3,'2020-01-06','Md kamal','T-Shart',550,40,'Ind'),(3,'2020-01-06','Md kamal','Pant',900,70,'Ban'),(3,'2020-01-06','Md kamal','Shart',522,50,'Ind');

/*Table structure for table `saledata` */

DROP TABLE IF EXISTS `saledata`;

CREATE TABLE `saledata` (
  `Sl no.` int(50) default NULL,
  `Bill no.` int(50) default NULL,
  `Date` varchar(50) default NULL,
  `Product Name` varchar(70) default NULL,
  `Price` int(40) default NULL,
  `Quantity` int(40) default NULL,
  `Details` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `saledata` */

insert  into `saledata`(`Sl no.`,`Bill no.`,`Date`,`Product Name`,`Price`,`Quantity`,`Details`) values (2,1,'2020-01-06','T-Shart',600,80,'Ind'),(3,1,'2020-01-06','Pant',850,50,'Ban'),(4,1,'2020-01-06','Shart',580,40,'Ind'),(1,2,'2020-01-06','T-Shart',600,20,'Ind'),(2,2,'2020-01-06','Pant',850,15,'Ban'),(3,2,'2020-01-06','Shart',580,30,'Ind');

/*Table structure for table `sales_product2` */

DROP TABLE IF EXISTS `sales_product2`;

CREATE TABLE `sales_product2` (
  `Product Id` int(20) NOT NULL,
  `Product Name` varchar(50) default NULL,
  `Product Price` int(20) default NULL,
  `Product Details` varchar(200) default NULL,
  PRIMARY KEY  (`Product Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sales_product2` */

insert  into `sales_product2`(`Product Id`,`Product Name`,`Product Price`,`Product Details`) values (101,'T-Shart',600,'Ind'),(102,'Pant',850,'Ban'),(104,'Shart',580,'Ind');

/*Table structure for table `showpurchase` */

DROP TABLE IF EXISTS `showpurchase`;

CREATE TABLE `showpurchase` (
  `SL NO.` int(30) NOT NULL auto_increment,
  `Bill no.` varchar(40) default NULL,
  `Date` varbinary(30) default NULL,
  `Suplier Name` varchar(40) default NULL,
  `Amount` int(40) default NULL,
  `Discount` int(40) default NULL,
  `Paid` int(40) default NULL,
  `Due` int(40) default NULL,
  PRIMARY KEY  (`SL NO.`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

/*Data for the table `showpurchase` */

insert  into `showpurchase`(`SL NO.`,`Bill no.`,`Date`,`Suplier Name`,`Amount`,`Discount`,`Paid`,`Due`) values (18,'1','2020-01-05','Md kamal',4550,50,4500,0),(19,'1','2020-01-05','Md kamal',13550,0,13550,0),(20,'2','2020-01-06','Md kamal',146140,40,140000,6100),(21,'3','2020-01-06','Md kamal',111100,100,110000,1000);

/*Table structure for table `suplier` */

DROP TABLE IF EXISTS `suplier`;

CREATE TABLE `suplier` (
  `National Id` int(50) NOT NULL,
  `Name` varchar(60) default NULL,
  `Address` varchar(120) default NULL,
  `Contact` int(11) default NULL,
  `Details` varchar(120) default NULL,
  PRIMARY KEY  (`National Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `suplier` */

insert  into `suplier`(`National Id`,`Name`,`Address`,`Contact`,`Details`) values (4578,'Md kamal','feni',9833,'Super visonr fjsdf');

/*Table structure for table `final` */

DROP TABLE IF EXISTS `final`;

/*!50001 DROP VIEW IF EXISTS `final` */;
/*!50001 DROP TABLE IF EXISTS `final` */;

/*!50001 CREATE TABLE  `final`(
 `Product Name` varchar(80) ,
 `Invest` decimal(42,0) ,
 `Total sales` decimal(42,0) ,
 `Orginal sales price` decimal(42,0) ,
 `Benefits` decimal(43,0) ,
 `Assets` decimal(65,0) 
)*/;

/*Table structure for table `pur` */

DROP TABLE IF EXISTS `pur`;

/*!50001 DROP VIEW IF EXISTS `pur` */;
/*!50001 DROP TABLE IF EXISTS `pur` */;

/*!50001 CREATE TABLE  `pur`(
 `Product Name` varchar(80) ,
 `Product Price` int(20) ,
 `Product Quantity` decimal(32,0) ,
 `Total` decimal(42,0) 
)*/;

/*Table structure for table `sale` */

DROP TABLE IF EXISTS `sale`;

/*!50001 DROP VIEW IF EXISTS `sale` */;
/*!50001 DROP TABLE IF EXISTS `sale` */;

/*!50001 CREATE TABLE  `sale`(
 `Product Name` varchar(70) ,
 `Product Price` int(40) ,
 `Product Quantity` decimal(32,0) ,
 `Total` decimal(42,0) ,
 `Orjinal price` decimal(42,0) ,
 `Benifit` decimal(43,0) 
)*/;

/*Table structure for table `stock` */

DROP TABLE IF EXISTS `stock`;

/*!50001 DROP VIEW IF EXISTS `stock` */;
/*!50001 DROP TABLE IF EXISTS `stock` */;

/*!50001 CREATE TABLE  `stock`(
 `Product Name` varchar(80) ,
 `Total Purchase` decimal(32,0) ,
 `Total Sales` decimal(32,0) ,
 `Stock` decimal(55,0) 
)*/;

/*View structure for view final */

/*!50001 DROP TABLE IF EXISTS `final` */;
/*!50001 DROP VIEW IF EXISTS `final` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `final` AS (select `pur`.`Product Name` AS `Product Name`,`pur`.`Total` AS `Invest`,`sale`.`Total` AS `Total sales`,`sale`.`Orjinal price` AS `Orginal sales price`,`sale`.`Benifit` AS `Benefits`,sum((`pur`.`Total` - `sale`.`Orjinal price`)) AS `Assets` from (`pur` left join `sale` on((`pur`.`Product Name` = `sale`.`Product Name`))) group by `pur`.`Product Name`) */;

/*View structure for view pur */

/*!50001 DROP TABLE IF EXISTS `pur` */;
/*!50001 DROP VIEW IF EXISTS `pur` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `pur` AS (select `purchase`.`Product Name` AS `Product Name`,`purchase`.`Product Price` AS `Product Price`,sum(`purchase`.`Product Quantity`) AS `Product Quantity`,sum((`purchase`.`Product Price` * `purchase`.`Product Quantity`)) AS `Total` from `purchase` group by `purchase`.`Product Name`) */;

/*View structure for view sale */

/*!50001 DROP TABLE IF EXISTS `sale` */;
/*!50001 DROP VIEW IF EXISTS `sale` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sale` AS (select `saledata`.`Product Name` AS `Product Name`,`saledata`.`Price` AS `Product Price`,sum(`saledata`.`Quantity`) AS `Product Quantity`,sum((`saledata`.`Price` * `saledata`.`Quantity`)) AS `Total`,sum((`saledata`.`Quantity` * `product2`.`Product Price`)) AS `Orjinal price`,sum(((`saledata`.`Price` * `saledata`.`Quantity`) - (`saledata`.`Quantity` * `product2`.`Product Price`))) AS `Benifit` from (`saledata` left join `product2` on((`saledata`.`Product Name` = `product2`.`Product Name`))) group by `saledata`.`Product Name`) */;

/*View structure for view stock */

/*!50001 DROP TABLE IF EXISTS `stock` */;
/*!50001 DROP VIEW IF EXISTS `stock` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stock` AS (select `pur`.`Product Name` AS `Product Name`,`pur`.`Product Quantity` AS `Total Purchase`,`sale`.`Product Quantity` AS `Total Sales`,sum((`pur`.`Product Quantity` - `sale`.`Product Quantity`)) AS `Stock` from (`pur` left join `sale` on((`pur`.`Product Name` = `sale`.`Product Name`))) group by `pur`.`Product Name`) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
