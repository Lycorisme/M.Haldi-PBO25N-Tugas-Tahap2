-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 01, 2024 at 01:15 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `m.haldi_2210010283_pbo2`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `kodeanggota` char(10) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `jk` char(1) DEFAULT NULL,
  `alamat` text DEFAULT NULL,
  `telp` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `angsuran`
--

CREATE TABLE `angsuran` (
  `kodeangsuran` char(10) NOT NULL,
  `kodeanggota` char(10) DEFAULT NULL,
  `tgldaftar` date DEFAULT NULL,
  `periode` int(11) DEFAULT NULL,
  `jumlahbulan` int(11) DEFAULT NULL,
  `totalcicilan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cicilan`
--

CREATE TABLE `cicilan` (
  `kodecicilan` char(10) NOT NULL,
  `kodeangsuran` char(10) DEFAULT NULL,
  `tglbayar` date DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `danaoperasional`
--

CREATE TABLE `danaoperasional` (
  `kode` char(10) NOT NULL,
  `kodeanggota` char(10) DEFAULT NULL,
  `tgldibayar` date DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`kodeanggota`);

--
-- Indexes for table `angsuran`
--
ALTER TABLE `angsuran`
  ADD PRIMARY KEY (`kodeangsuran`),
  ADD KEY `kodeanggota` (`kodeanggota`);

--
-- Indexes for table `cicilan`
--
ALTER TABLE `cicilan`
  ADD PRIMARY KEY (`kodecicilan`),
  ADD KEY `kodeangsuran` (`kodeangsuran`);

--
-- Indexes for table `danaoperasional`
--
ALTER TABLE `danaoperasional`
  ADD PRIMARY KEY (`kode`),
  ADD KEY `kodeanggota` (`kodeanggota`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `angsuran`
--
ALTER TABLE `angsuran`
  ADD CONSTRAINT `angsuran_ibfk_1` FOREIGN KEY (`kodeanggota`) REFERENCES `anggota` (`kodeanggota`);

--
-- Constraints for table `cicilan`
--
ALTER TABLE `cicilan`
  ADD CONSTRAINT `cicilan_ibfk_1` FOREIGN KEY (`kodeangsuran`) REFERENCES `angsuran` (`kodeangsuran`);

--
-- Constraints for table `danaoperasional`
--
ALTER TABLE `danaoperasional`
  ADD CONSTRAINT `danaoperasional_ibfk_1` FOREIGN KEY (`kodeanggota`) REFERENCES `anggota` (`kodeanggota`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
