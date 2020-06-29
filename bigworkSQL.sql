/*
SQLyog Trial v13.1.5  (64 bit)
MySQL - 5.7.28-log : Database - order_ms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`order_ms` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `order_ms`;

/*Table structure for table `order_commodity` */

DROP TABLE IF EXISTS `order_commodity`;

CREATE TABLE `order_commodity` (
  `commodity_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `commodity_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '商品名称',
  `price` double DEFAULT NULL COMMENT '商品价格',
  `create_time` date NOT NULL COMMENT '商品生产日期',
  `supplier_id` int(20) NOT NULL COMMENT '供应商id',
  PRIMARY KEY (`commodity_id`),
  KEY `commodity_supplier` (`supplier_id`),
  CONSTRAINT `commodity_supplier` FOREIGN KEY (`supplier_id`) REFERENCES `order_supplier` (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `order_commodity` */

insert  into `order_commodity`(`commodity_id`,`commodity_name`,`price`,`create_time`,`supplier_id`) values 
(1,'阿里云',100,'2017-02-24',1),
(2,'王者荣耀',20,'2016-06-24',2),
(3,'阿里云云数据库',20.1,'2020-06-27',1),
(4,'iphone X',6999,'2017-11-02',4),
(5,'iphoneXR',5999,'2018-10-18',4),
(6,'iphone 11',5799,'2019-09-10',4),
(7,'iphone 11 Pro',7999,'2019-09-10',4),
(8,'iphone',4999,'2010-09-07',4);

/*Table structure for table `order_role` */

DROP TABLE IF EXISTS `order_role`;

CREATE TABLE `order_role` (
  `role_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `comment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称注释',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `order_role` */

insert  into `order_role`(`role_id`,`role_name`,`comment`) values 
(1,'ADMIN','系统管理员'),
(2,'USER','普通用户'),
(3,'SUPPLIER','供应商管理员'),
(4,'VIP','会员');

/*Table structure for table `order_supplier` */

DROP TABLE IF EXISTS `order_supplier`;

CREATE TABLE `order_supplier` (
  `supplier_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '供应商id',
  `supplier_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商名称',
  `supplier_address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商地址',
  `supplier_country` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '供应商国家',
  `supplier_ceo` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '供应商老板',
  `create_time` date NOT NULL COMMENT '供应商创建时间',
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `order_supplier` */

insert  into `order_supplier`(`supplier_id`,`supplier_name`,`supplier_address`,`supplier_country`,`supplier_ceo`,`create_time`) values 
(1,'阿里巴巴','浙江杭州','中国','马云','2020-06-28'),
(2,'腾讯','广州广东','中国','马化腾','2009-07-31'),
(3,'华为','广东深圳','中国','任正非','2020-06-28'),
(4,'Apple','加利福尼亚州·库比蒂诺市','美国','库克','2020-06-17'),
(5,'百度','北京','中国','李彦宏','2020-06-28'),
(6,'网易','广州','中国','丁磊','2020-06-28'),
(7,'迪奥','巴黎','法国','克里斯汀·迪奥','2020-06-28');

/*Table structure for table `order_table` */

DROP TABLE IF EXISTS `order_table`;

CREATE TABLE `order_table` (
  `order_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '账单id',
  `commodity_id` int(20) NOT NULL COMMENT '商品id',
  `commodity_number` int(20) DEFAULT NULL COMMENT '商品数量',
  `create_time` date NOT NULL COMMENT '订单创建时间',
  `create_user_id` int(20) NOT NULL COMMENT '订单创建用户id',
  `update_time` date NOT NULL COMMENT '订单修改时间',
  `update_user_id` int(20) NOT NULL COMMENT '订单修改用户id',
  PRIMARY KEY (`order_id`),
  KEY `order_commodity_id` (`commodity_id`),
  KEY `create_order_id` (`create_user_id`),
  KEY `update_user_id` (`update_user_id`),
  CONSTRAINT `create_order_id` FOREIGN KEY (`create_user_id`) REFERENCES `order_user` (`user_id`),
  CONSTRAINT `order_commodity_id` FOREIGN KEY (`commodity_id`) REFERENCES `order_commodity` (`commodity_id`),
  CONSTRAINT `update_user_id` FOREIGN KEY (`update_user_id`) REFERENCES `order_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `order_table` */

insert  into `order_table`(`order_id`,`commodity_id`,`commodity_number`,`create_time`,`create_user_id`,`update_time`,`update_user_id`) values 
(1,1,3,'2020-06-28',1,'2020-06-28',1),
(2,2,13,'2020-06-28',1,'2020-06-28',1),
(3,1,2,'2020-06-28',1,'2020-06-28',2),
(4,2,16,'2020-06-28',2,'2020-06-28',1),
(5,1,34,'2020-06-28',2,'2020-06-28',2),
(6,1,23,'2020-06-28',2,'2020-06-28',1),
(7,2,10,'2020-06-28',1,'2020-06-28',1);

/*Table structure for table `order_user` */

DROP TABLE IF EXISTS `order_user`;

CREATE TABLE `order_user` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户账号',
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户密码',
  `true_name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户真实姓名',
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户邮箱',
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户电话',
  `message` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户信息简介',
  `country` enum('China','London','India','Usa','Canada','Thailand') COLLATE utf8_unicode_ci DEFAULT 'China' COMMENT '用户祖国',
  `gender` enum('0','1') COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '用户性别：0-男 1-女',
  `birthday` date DEFAULT NULL COMMENT '用户生日',
  `create_time` date NOT NULL COMMENT '用户创建时间',
  `role_id` int(20) NOT NULL DEFAULT '2' COMMENT '用户角色id',
  PRIMARY KEY (`user_id`),
  KEY `user_role_id` (`role_id`),
  CONSTRAINT `user_role_id` FOREIGN KEY (`role_id`) REFERENCES `order_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `order_user` */

insert  into `order_user`(`user_id`,`username`,`password`,`true_name`,`email`,`phone`,`message`,`country`,`gender`,`birthday`,`create_time`,`role_id`) values 
(1,'123','111','杨以诺','375162935@qq.com','13736352736','我是一个很优秀的学生，未来也会是个优秀的首席架构师','China','0','2000-04-28','2020-06-27',1),
(2,'admin','11111111','1',NULL,'123',NULL,'China','1','2020-06-26','2020-06-27',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
