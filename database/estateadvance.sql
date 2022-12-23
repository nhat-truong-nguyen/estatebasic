-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 23, 2022 at 02:05 PM
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
-- Database: `estateadvance`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignmentbuilding`
--

DROP TABLE IF EXISTS `assignmentbuilding`;
CREATE TABLE IF NOT EXISTS `assignmentbuilding` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `buildingid` bigint(20) NOT NULL,
  `staffid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkk3mdegrmfcdlsxqds1m6q238` (`buildingid`),
  KEY `FKf4ibbod44h32ao1o6pb4yq98p` (`staffid`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `assignmentbuilding`
--

INSERT INTO `assignmentbuilding` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `buildingid`, `staffid`) VALUES
(16, NULL, NULL, NULL, NULL, 3, 1),
(15, NULL, NULL, NULL, NULL, 26, 2),
(14, NULL, NULL, NULL, NULL, 26, 1),
(19, NULL, NULL, NULL, NULL, 2, 3),
(18, NULL, NULL, NULL, NULL, 17, 3),
(17, NULL, NULL, NULL, NULL, 3, 3),
(12, NULL, NULL, NULL, NULL, 16, 2),
(11, NULL, NULL, NULL, NULL, 16, 1);

-- --------------------------------------------------------

--
-- Table structure for table `assignmentcustomer`
--

DROP TABLE IF EXISTS `assignmentcustomer`;
CREATE TABLE IF NOT EXISTS `assignmentcustomer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `customerid` bigint(20) NOT NULL,
  `staffid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4sygo3a6twd6tkay7em8f1lgg` (`customerid`),
  KEY `FKco26n95l1hpuq1suv0briljor` (`staffid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
CREATE TABLE IF NOT EXISTS `building` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brokeragefee` double DEFAULT NULL,
  `carfee` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createdby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `decorationtime` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `deposit` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `direction` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `district` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `electricityfee` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `floorarea` int(11) DEFAULT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `level` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `linkofbuilding` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `managername` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `managerphone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `map` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `motorbikefee` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `numberofbasement` int(11) DEFAULT NULL,
  `overtimefee` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `payment` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `rentprice` int(11) DEFAULT NULL,
  `rentpricedescription` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `renttime` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `servicefee` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `street` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `structure` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ward` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `waterfee` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `rentareadescription` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `building`
--

INSERT INTO `building` (`id`, `brokeragefee`, `carfee`, `createdby`, `createddate`, `decorationtime`, `deposit`, `direction`, `district`, `electricityfee`, `floorarea`, `image`, `level`, `linkofbuilding`, `managername`, `managerphone`, `map`, `modifiedby`, `modifieddate`, `motorbikefee`, `name`, `note`, `numberofbasement`, `overtimefee`, `payment`, `rentprice`, `rentpricedescription`, `renttime`, `servicefee`, `street`, `structure`, `type`, `ward`, `waterfee`, `rentareadescription`) VALUES
(26, 0.7, '', NULL, NULL, '', '', '', 'QUAN_1', '', 500, NULL, '', NULL, 'nguyen van b', '01234567890', NULL, NULL, NULL, '', 'Nam Giao Building Tower', '', 2, '4', '', 15, '15 triệu/m2', '', '4', '59 phan xích long', '', 'TANG_TRET,NGUYEN_CAN', 'Phường 2', NULL, '290m2(lầu lừng), 150m2(lầu 4)'),
(2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'QUAN_2', NULL, 650, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ACM Tower', NULL, 2, NULL, NULL, 18, '18 triệu/m2', NULL, NULL, '96 cao thắng', NULL, 'NGUYEN_CAN', 'Phường 4', NULL, NULL),
(3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'QUAN_1', NULL, 200, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Alpha 2 Building Tower', NULL, 1, NULL, NULL, 20, '20 triệu/m2', NULL, NULL, '153 nguyễn đình chiểu', NULL, 'NOI_THAT', 'Phường 6', NULL, NULL),
(16, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'QUAN_1', NULL, 500, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Nam Giao Building Tower', NULL, 2, NULL, NULL, 15, '15 triệu/m2', NULL, NULL, '59 phan xích long', NULL, 'TANG_TRET,NGUYEN_CAN', 'Phường 2', NULL, NULL),
(17, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'QUAN_2', NULL, 650, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ACM Tower', NULL, 2, NULL, NULL, 18, '18 triệu/m2', NULL, NULL, '96 cao thắng', NULL, 'NGUYEN_CAN', 'Phường 4', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fullname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rentarea`
--

DROP TABLE IF EXISTS `rentarea`;
CREATE TABLE IF NOT EXISTS `rentarea` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  `buildingid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqhqoxlvm1iblaew5s0v8n3ut4` (`buildingid`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `rentarea`
--

INSERT INTO `rentarea` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `value`, `buildingid`) VALUES
(24, NULL, NULL, NULL, NULL, 300, 20),
(23, NULL, NULL, NULL, NULL, 200, 20),
(22, NULL, NULL, NULL, NULL, 100, 20);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createdby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `code`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `name`) VALUES
(1, 'admin', NULL, '2022-12-21 18:46:06', NULL, '2022-12-21 18:46:06', 'Quản trị viên'),
(2, 'staff', NULL, '2022-12-21 18:46:06', NULL, '2022-12-21 18:46:06', 'Nhân viên');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE IF NOT EXISTS `transaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `customerid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKldobv9jeuxje0fjqnhrw6e23v` (`customerid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fullname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `createdby`, `createddate`, `email`, `fullname`, `modifiedby`, `modifieddate`, `password`, `phone`, `status`, `username`) VALUES
(1, NULL, NULL, NULL, 'nguyen van a', NULL, NULL, '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', NULL, NULL, 'nguyenvana'),
(2, NULL, NULL, NULL, 'nguyen van b', NULL, NULL, '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', NULL, NULL, 'nguyenvanb'),
(3, NULL, NULL, NULL, 'nguyen van c', NULL, NULL, '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', NULL, NULL, 'nguyenvanc'),
(4, NULL, NULL, NULL, 'nguyen van d', NULL, NULL, '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', NULL, NULL, 'nguyenvand');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `roleid` bigint(20) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbo5ik0bthje7hum554xb17ry6` (`roleid`),
  KEY `FKd0xwi6psywvnj59btfns0alnm` (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `roleid`, `userid`) VALUES
(1, NULL, '2022-12-21 18:48:17', NULL, '2022-12-21 18:48:17', 2, 1),
(2, NULL, '2022-12-21 18:48:17', NULL, '2022-12-21 18:48:17', 2, 2),
(3, NULL, '2022-12-21 18:48:33', NULL, '2022-12-21 18:48:33', 2, 3),
(4, NULL, '2022-12-21 18:48:41', NULL, '2022-12-21 18:48:41', 2, 4);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
