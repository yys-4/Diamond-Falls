-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2023 at 04:33 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gamepbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `datascore2`
--

CREATE TABLE `datascore2` (
  `tingkat` varchar(7) NOT NULL,
  `tanggal` date NOT NULL,
  `score` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datascore2`
--

INSERT INTO `datascore2` (`tingkat`, `tanggal`, `score`) VALUES
('mudah', '2022-12-12', 25),
('mudah', '2022-10-03', 50),
('mudah', '2022-10-20', 35),
('sedang', '2022-11-17', 20),
('sulit', '2022-11-03', 10),
('mudah', '2022-12-30', 30),
('mudah', '2022-12-30', 100),
('sedang', '2022-12-30', 35),
('sulit', '2022-12-30', 0),
('sedang', '2022-12-30', 0),
('sedang', '2022-12-30', 5),
('sedang', '2022-12-30', 5),
('mudah', '2022-12-31', 50),
('mudah', '2022-12-31', 295),
('sulit', '2023-01-02', 5),
('sulit', '2023-01-02', 5),
('mudah', '2023-01-02', 40),
('mudah', '2023-01-03', 25),
('sedang', '2023-01-03', 20),
('mudah', '2023-01-03', 0),
('sulit', '2023-01-03', 5),
('sulit', '2023-01-03', 5),
('sulit', '2023-01-03', 5),
('sulit', '2023-01-03', 5),
('sulit', '2023-01-03', 10),
('sulit', '2023-01-03', 5),
('sedang', '2023-01-03', 10),
('sedang', '2023-01-03', 30),
('sedang', '2023-01-03', 40),
('mudah', '2023-01-04', 30);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
