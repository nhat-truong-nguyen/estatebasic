-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 12, 2022 at 10:45 AM
-- Server version: 8.0.16
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `estatebasic`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignmentbuilding`
--

DROP TABLE IF EXISTS `assignmentbuilding`;
CREATE TABLE IF NOT EXISTS `assignmentbuilding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staffid` bigint(20) NOT NULL,
  `buildingid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_building` (`staffid`),
  KEY `fk_building_user` (`buildingid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `assignmentbuilding`
--

INSERT INTO `assignmentbuilding` (`id`, `staffid`, `buildingid`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
(1, 2, 1, NULL, NULL, NULL, NULL),
(2, 2, 3, NULL, NULL, NULL, NULL),
(3, 3, 1, NULL, NULL, NULL, NULL),
(4, 3, 4, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `assignmentcustomer`
--

DROP TABLE IF EXISTS `assignmentcustomer`;
CREATE TABLE IF NOT EXISTS `assignmentcustomer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staffid` bigint(20) NOT NULL,
  `customerid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_customer` (`staffid`),
  KEY `fk_customer_user` (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
CREATE TABLE IF NOT EXISTS `building` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `street` varchar(255) DEFAULT NULL,
  `ward` varchar(255) DEFAULT NULL,
  `districtid` bigint(20) NOT NULL,
  `structure` varchar(255) DEFAULT NULL,
  `numberofbasement` int(11) DEFAULT NULL,
  `floorarea` int(11) DEFAULT NULL,
  `direction` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `rentprice` int(11) NOT NULL,
  `rentpricedescription` text,
  `servicefee` varchar(255) DEFAULT NULL,
  `carfee` varchar(255) DEFAULT NULL,
  `motorbikefee` varchar(255) DEFAULT NULL,
  `overtimefee` varchar(255) DEFAULT NULL,
  `waterfee` varchar(255) DEFAULT NULL,
  `electricityfee` varchar(255) DEFAULT NULL,
  `deposit` varchar(255) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `renttime` varchar(255) DEFAULT NULL,
  `decorationtime` varchar(255) DEFAULT NULL,
  `brokeragefee` decimal(13,2) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `linkofbuilding` varchar(255) DEFAULT NULL,
  `map` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_building_district` (`districtid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `building`
--

INSERT INTO `building` (`id`, `name`, `street`, `ward`, `districtid`, `structure`, `numberofbasement`, `floorarea`, `direction`, `level`, `rentprice`, `rentpricedescription`, `servicefee`, `carfee`, `motorbikefee`, `overtimefee`, `waterfee`, `electricityfee`, `deposit`, `payment`, `renttime`, `decorationtime`, `brokeragefee`, `note`, `linkofbuilding`, `map`, `image`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
(1, 'Nam Giao Building Tower', '59 phan xích long', 'Phường 2', 1, NULL, 2, 500, 'Dong', 'A', 15, '15 triệu/m2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'ACM Tower', '96 cao thắng', 'Phường 4', 2, NULL, 2, 650, NULL, NULL, 18, '18 triệu/m2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'Alpha 2 Building Tower', '153 nguyễn đình chiểu', 'Phường 6', 1, NULL, 1, 200, 'Tây bắc', 'C', 20, '20 triệu/m2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'IDD 1 Building', '111 Lý Chính Thắng', 'Phường 7', 3, NULL, 1, 200, NULL, NULL, 12, '12 triệu/m2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `buildingrenttype`
--

DROP TABLE IF EXISTS `buildingrenttype`;
CREATE TABLE IF NOT EXISTS `buildingrenttype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `buildingid` bigint(20) NOT NULL,
  `renttypeid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_buildingtype_building` (`buildingid`),
  KEY `fk_buildingtype_renttype` (`renttypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `buildingrenttype`
--

INSERT INTO `buildingrenttype` (`id`, `buildingid`, `renttypeid`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 2),
(4, 3, 3),
(5, 4, 1),
(6, 4, 2),
(7, 4, 3);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
CREATE TABLE IF NOT EXISTS `district` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `district`
--

INSERT INTO `district` (`id`, `code`, `name`) VALUES
(1, 'Q1', 'Quận 1'),
(2, 'Q2', 'Quận 2'),
(3, 'Q4', 'Quận 4');

-- --------------------------------------------------------

--
-- Table structure for table `rentarea`
--

DROP TABLE IF EXISTS `rentarea`;
CREATE TABLE IF NOT EXISTS `rentarea` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` int(11) DEFAULT NULL,
  `buildingid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rentarea_building` (`buildingid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rentarea`
--

INSERT INTO `rentarea` (`id`, `value`, `buildingid`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
(1, 100, 1, NULL, NULL, NULL, NULL),
(2, 200, 1, NULL, NULL, NULL, NULL),
(3, 200, 2, NULL, NULL, NULL, NULL),
(4, 300, 2, NULL, NULL, NULL, NULL),
(5, 400, 2, NULL, NULL, NULL, NULL),
(6, 300, 3, NULL, NULL, NULL, NULL),
(7, 400, 3, NULL, NULL, NULL, NULL),
(8, 500, 3, NULL, NULL, NULL, NULL),
(9, 100, 4, NULL, NULL, NULL, NULL),
(10, 400, 4, NULL, NULL, NULL, NULL),
(11, 250, 4, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `renttype`
--

DROP TABLE IF EXISTS `renttype`;
CREATE TABLE IF NOT EXISTS `renttype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `renttype`
--

INSERT INTO `renttype` (`id`, `code`, `name`) VALUES
(1, 'tang-tret', 'Tầng trệt'),
(2, 'nguyen-can', 'Nguyên căn'),
(3, 'noi-that', 'Nội thất');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`, `code`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
(1, 'Quản lý', 'manager', NULL, NULL, NULL, NULL),
(2, 'Nhân viên', 'staff', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE IF NOT EXISTS `transaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `note` varchar(255) DEFAULT NULL,
  `customerid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `type` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_transaction` (`customerid`),
  KEY `fk_transactiontype_transaction_idx` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `transactiontype`
--

DROP TABLE IF EXISTS `transactiontype`;
CREATE TABLE IF NOT EXISTS `transactiontype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `fullname`, `phone`, `email`, `status`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
(1, 'nguyenvana', '123456', 'nguyen van a', NULL, NULL, 1, NULL, NULL, NULL, NULL),
(2, 'nguyenvanb', '123456', 'nguyen van b', NULL, NULL, 1, NULL, NULL, NULL, NULL),
(3, 'nguyenvanc', '123456', 'nguyen van c', NULL, NULL, 1, NULL, NULL, NULL, NULL),
(4, 'nguyenvand', '123456', 'nguyen van d', NULL, NULL, 1, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleid` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role` (`userid`),
  KEY `fk_role_user` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`id`, `roleid`, `userid`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
(1, 1, 1, NULL, NULL, NULL, NULL),
(2, 2, 2, NULL, NULL, NULL, NULL),
(3, 2, 3, NULL, NULL, NULL, NULL),
(4, 2, 4, NULL, NULL, NULL, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assignmentbuilding`
--
ALTER TABLE `assignmentbuilding`
  ADD CONSTRAINT `fk_building_user` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`),
  ADD CONSTRAINT `fk_user_building` FOREIGN KEY (`staffid`) REFERENCES `user` (`id`);

--
-- Constraints for table `assignmentcustomer`
--
ALTER TABLE `assignmentcustomer`
  ADD CONSTRAINT `fk_customer_user` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `fk_user_customer` FOREIGN KEY (`staffid`) REFERENCES `user` (`id`);

--
-- Constraints for table `building`
--
ALTER TABLE `building`
  ADD CONSTRAINT `fk_building_district` FOREIGN KEY (`districtid`) REFERENCES `district` (`id`);

--
-- Constraints for table `buildingrenttype`
--
ALTER TABLE `buildingrenttype`
  ADD CONSTRAINT `fk_buildingtype_building` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`),
  ADD CONSTRAINT `fk_buildingtype_renttype` FOREIGN KEY (`renttypeid`) REFERENCES `renttype` (`id`);

--
-- Constraints for table `rentarea`
--
ALTER TABLE `rentarea`
  ADD CONSTRAINT `rentarea_building` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `fk_customer_transaction` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `fk_transactiontype_transaction` FOREIGN KEY (`type`) REFERENCES `transactiontype` (`id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `fk_role_user` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `fk_user_role` FOREIGN KEY (`userid`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
