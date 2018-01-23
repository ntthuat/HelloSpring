-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 30, 2015 at 12:07 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbtmaleave`
--

-- --------------------------------------------------------

--
-- Table structure for table `application`
--

CREATE TABLE IF NOT EXISTS `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leave_days` int(11) DEFAULT '1',
  `reason` text COLLATE utf8mb4_unicode_ci,
  `status` int(11) DEFAULT '0',
  `start_date` date DEFAULT NULL,
  `username` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci AUTO_INCREMENT=49 ;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`id`, `leave_days`, `reason`, `status`, `start_date`, `username`) VALUES
(40, 1, 'aaaaaaaa', 1, '2015-10-06', 'admin'),
(41, 2, 'aaaaaaaaaaaaaa', 1, '2015-10-07', 'admin'),
(42, 2, 'aaaaa', 1, '2015-10-06', 'admin'),
(43, 7, 'DDDDDDDDDDDD', 1, '2015-10-14', 'admin'),
(45, 2, 'CCCCCCCCCCCCC', -1, '2015-10-05', 'lethinh'),
(47, 1, 'aaaaaaaaa', 1, '2015-10-06', 'abc'),
(48, 9, 'weqeqweweqewqewqe', -1, '2015-10-07', 'lethinh');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `username` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fullname` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT 'EMPLOYEE',
  `admin` int(11) DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`username`, `password`, `fullname`, `admin`) VALUES
('abc', 'abc', 'EMPLOYEE', 0),
('admin', 'admin', 'Admin', 1),
('lethinh', '12345', 'EMPLOYEE', 0);

-- --------------------------------------------------------

--
-- Table structure for table `paramater`
--

CREATE TABLE IF NOT EXISTS `paramater` (
  `day` int(11) DEFAULT '12'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `paramater`
--

INSERT INTO `paramater` (`day`) VALUES
(12);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `application`
--
ALTER TABLE `application`
  ADD CONSTRAINT `fk_employee` FOREIGN KEY (`username`) REFERENCES `employee` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
