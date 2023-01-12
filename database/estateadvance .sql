-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 12, 2023 at 03:45 PM
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
(1, 2),
(2, 2),
(2, 3),
(3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `assignmentcustomer`
--

DROP TABLE IF EXISTS `assignmentcustomer`;
CREATE TABLE IF NOT EXISTS `assignmentcustomer` (
  `customerid` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  KEY `FKsi3s4mxxco4rh92usq7wgdyrm` (`userid`),
  KEY `FK4sygo3a6twd6tkay7em8f1lgg` (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `assignmentcustomer`
--

INSERT INTO `assignmentcustomer` (`customerid`, `userid`) VALUES
(1, 2),
(1, 4);

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `building`
--

INSERT INTO `building` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `brokeragefee`, `carfee`, `decorationtime`, `deposit`, `direction`, `district`, `electricityfee`, `floorarea`, `image`, `level`, `linkofbuilding`, `managername`, `managerphone`, `map`, `motorbikefee`, `name`, `note`, `numberofbasement`, `overtimefee`, `payment`, `rentareadescription`, `rentprice`, `rentpricedescription`, `renttime`, `servicefee`, `street`, `structure`, `type`, `ward`, `waterfee`) VALUES
(1, NULL, NULL, 'admin', '2023-01-12 22:32:15', 0.7, '', '', '', '', 'QUAN_1', '', 500, NULL, '', NULL, 'nguyen van b', '01234567890', NULL, '', 'Nam Giao Building Tower', '', 2, '4', '', '290m2(lầu lừng), 150m2(lầu 4)', 15, '15 triệu/m2', '', '4', '59 phan xích long', '', 'TANG_TRET,NGUYEN_CAN', 'Phường 2', NULL),
(2, NULL, NULL, 'admin', '2023-01-12 22:32:20', NULL, NULL, NULL, NULL, NULL, 'QUAN_2', NULL, 650, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ACM Tower', NULL, 2, NULL, NULL, NULL, 18, '18 triệu/m2', NULL, NULL, '96 cao thắng', NULL, 'NGUYEN_CAN', 'Phường 4', NULL),
(3, NULL, NULL, 'admin', '2023-01-12 22:32:24', NULL, NULL, NULL, NULL, NULL, 'QUAN_1', NULL, 200, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Alpha 2 Building Tower', NULL, 1, NULL, NULL, NULL, 20, '20 triệu/m2', NULL, NULL, '153 nguyễn đình chiểu', NULL, 'NOI_THAT', 'Phường 6', NULL),
(4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'QUAN_1', NULL, 500, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Nam Giao Building Tower', NULL, 2, NULL, NULL, NULL, 15, '15 triệu/m2', NULL, NULL, '59 phan xích long', NULL, 'TANG_TRET,NGUYEN_CAN', 'Phường 2', NULL),
(5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'QUAN_2', NULL, 650, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ACM Tower', NULL, 2, NULL, NULL, NULL, 18, '18 triệu/m2', NULL, NULL, '96 cao thắng', NULL, 'NGUYEN_CAN', 'Phường 4', NULL);

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
  `companyname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `demand` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fullname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `companyname`, `demand`, `email`, `fullname`, `note`, `phone`, `status`) VALUES
(1, NULL, NULL, 'admin', '2023-01-12 22:44:21', 'ACB', 'Tầng trệt 70m2', 'nguyenvana@gmail.com', 'Nguyen Van A', 'Chua co ghi chu', '01234567', NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
(1, NULL, NULL, NULL, NULL, 'MANAGER', 'Quản lý'),
(2, NULL, NULL, NULL, NULL, 'STAFF', 'Nhân viên');

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
  `customerid` bigint(20) NOT NULL,
  `staffid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKldobv9jeuxje0fjqnhrw6e23v` (`customerid`),
  KEY `FKrsenqvwjhwtsiuyw4ht1cgpvp` (`staffid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `createdby`, `createddate`, `modifiedby`, `modifieddate`, `note`, `type`, `customerid`, `staffid`) VALUES
(2, 'admin', '2023-01-11 14:36:02', 'admin', '2023-01-11 14:36:02', 'Goi dien thoai', 'QUA_TRINH_CHAM_SOC_KHACH_HANG', 1, 1),
(6, 'admin', '2023-01-11 14:45:27', 'admin', '2023-01-11 14:45:27', 'Da dan di xem toa nha Landmark 81', 'DAN_DI_XEM', 1, 1),
(11, 'admin', '2023-01-11 21:37:09', 'admin', '2023-01-11 21:37:09', 'Tu van gia nha', 'QUA_TRINH_CHAM_SOC_KHACH_HANG', 1, 1),
(12, 'admin', '2023-01-11 21:37:24', 'admin', '2023-01-11 21:37:24', 'Da dan di xem toa Bitexco', 'DAN_DI_XEM', 1, 1);

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
  ADD CONSTRAINT `FK4sygo3a6twd6tkay7em8f1lgg` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
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
  ADD CONSTRAINT `FKldobv9jeuxje0fjqnhrw6e23v` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `FKrsenqvwjhwtsiuyw4ht1cgpvp` FOREIGN KEY (`staffid`) REFERENCES `users` (`id`);

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
