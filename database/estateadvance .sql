-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 28, 2022 at 01:53 PM
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
  `buildingid` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  KEY `FKedql9q7wl9jh4qpk8idb4nko3` (`userid`),
  KEY `FKkk3mdegrmfcdlsxqds1m6q238` (`buildingid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `assignmentbuilding`
--

INSERT INTO `assignmentbuilding` (`buildingid`, `userid`) VALUES
(3, 2),
(3, 3),
(3, 4),
(3, 5),
(4, 3),
(4, 4),
(2, 2),
(2, 3),
(2, 4);

-- --------------------------------------------------------

--
-- Table structure for table `assignmentcustomer`
--

DROP TABLE IF EXISTS `assignmentcustomer`;
CREATE TABLE IF NOT EXISTS `assignmentcustomer` (
  `userid` bigint(20) NOT NULL,
  `roleid` bigint(20) NOT NULL,
  KEY `FK7eu59m1tvj1ynopcyo1sttrhn` (`roleid`),
  KEY `FKsi3s4mxxco4rh92usq7wgdyrm` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
CREATE TABLE IF NOT EXISTS `building` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `brokeragefee` double DEFAULT NULL,
  `carfee` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
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
  `motorbikefee` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `numberofbasement` int(11) DEFAULT NULL,
  `overtimefee` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `payment` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `rentareadescription` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `rentprice` int(11) DEFAULT NULL,
  `rentpricedescription` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `renttime` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `servicefee` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `street` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `structure` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ward` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `waterfee` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `building`
--

INSERT INTO `building` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `brokeragefee`, `carfee`, `decorationtime`, `deposit`, `direction`, `district`, `electricityfee`, `floorarea`, `image`, `level`, `linkofbuilding`, `managername`, `managerphone`, `map`, `motorbikefee`, `name`, `note`, `numberofbasement`, `overtimefee`, `payment`, `rentareadescription`, `rentprice`, `rentpricedescription`, `renttime`, `servicefee`, `street`, `structure`, `type`, `ward`, `waterfee`) VALUES
(2, NULL, NULL, 'admin', '2022-12-28 20:49:57', NULL, '', '', '', '', 'QUAN_2', '', 650, NULL, '', NULL, '', '', NULL, '', 'ACM Tower', 'Chua co ghi chu', 2, '', '', '', 18, '18 triệu/m2', '', '', '96 cao thắng', '', 'TANG_TRET,NGUYEN_CAN,NOI_THAT', 'Phường 4', NULL),
(3, NULL, NULL, 'admin', '2022-12-27 23:55:46', NULL, '', '', '', '', 'QUAN_1', '', 200, NULL, '', NULL, '', '', NULL, '', 'Alpha 2 Building Tower', '', 1, '', '', '', 20, '20 triệu/m2', '', '', '153 nguyễn đình chiểu', '', 'NOI_THAT', 'Phường 6', NULL),
(4, NULL, NULL, 'admin', '2022-12-27 23:56:04', NULL, '', '', '', '', 'QUAN_1', '', 500, NULL, '', NULL, '', '', NULL, '', 'Nam Giao Building Tower', '', 2, '', '', '', 15, '15 triệu/m2', '', '', '59 phan xích long', '', 'TANG_TRET,NGUYEN_CAN', 'Phường 2', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fullname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `rentarea`
--

INSERT INTO `rentarea` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `value`, `buildingid`) VALUES
(26, 'admin', '2022-12-27 22:18:51', 'admin', '2022-12-27 22:18:51', 100, 4),
(27, 'admin', '2022-12-27 22:18:51', 'admin', '2022-12-27 22:18:51', 200, 4),
(28, 'admin', '2022-12-27 22:18:51', 'admin', '2022-12-27 22:18:51', 300, 4),
(47, 'admin', '2022-12-27 23:55:46', 'admin', '2022-12-27 23:55:46', 100, 3),
(48, 'admin', '2022-12-27 23:55:46', 'admin', '2022-12-27 23:55:46', 200, 3),
(49, 'admin', '2022-12-27 23:55:46', 'admin', '2022-12-27 23:55:46', 300, 3),
(50, 'admin', '2022-12-28 20:49:57', 'admin', '2022-12-28 20:49:57', 100, 2),
(51, 'admin', '2022-12-28 20:49:57', 'admin', '2022-12-28 20:49:57', 200, 2),
(52, 'admin', '2022-12-28 20:49:57', 'admin', '2022-12-28 20:49:57', 300, 2);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `code` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_c36say97xydpmgigg38qv5l2p` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `code`, `name`) VALUES
(1, NULL, NULL, NULL, NULL, 'ADMIN', 'Quản trị hệ thống'),
(2, NULL, NULL, NULL, NULL, 'USER', 'người dùng');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fullname` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `email`, `fullname`, `password`, `status`, `username`) VALUES
(1, NULL, NULL, NULL, NULL, NULL, 'admin', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1, 'admin'),
(2, NULL, NULL, NULL, NULL, NULL, 'nguyen van a', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1, 'nguyenvana'),
(3, NULL, NULL, NULL, NULL, NULL, 'nguyenvanb', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1, 'nguyen van b'),
(4, NULL, NULL, NULL, NULL, NULL, 'nguyenvanc', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1, 'nguyen van c'),
(5, NULL, NULL, NULL, NULL, NULL, 'nguyenvand', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 1, 'nguyen van d');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FKj345gk1bovqvfame88rcx7yyx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 2),
(5, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assignmentbuilding`
--
ALTER TABLE `assignmentbuilding`
  ADD CONSTRAINT `FKedql9q7wl9jh4qpk8idb4nko3` FOREIGN KEY (`userid`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKkk3mdegrmfcdlsxqds1m6q238` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`);

--
-- Constraints for table `assignmentcustomer`
--
ALTER TABLE `assignmentcustomer`
  ADD CONSTRAINT `FK7eu59m1tvj1ynopcyo1sttrhn` FOREIGN KEY (`roleid`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `FKsi3s4mxxco4rh92usq7wgdyrm` FOREIGN KEY (`userid`) REFERENCES `users` (`id`);

--
-- Constraints for table `rentarea`
--
ALTER TABLE `rentarea`
  ADD CONSTRAINT `FKqhqoxlvm1iblaew5s0v8n3ut4` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `FKldobv9jeuxje0fjqnhrw6e23v` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
