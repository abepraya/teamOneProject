-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 15, 2022 at 04:09 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `myhelpdesk`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id_account` int(11) NOT NULL,
  `id_emp` int(11) NOT NULL,
  `password` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id_account`, `id_emp`, `password`) VALUES
(1, 1, 'dona123'),
(2, 2, 'gmail123'),
(3, 3, 'jadid123'),
(4, 4, 'okta123345'),
(5, 5, 'bagus123');

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `id_branch` int(11) NOT NULL,
  `branch_name` varchar(255) NOT NULL,
  `branch_address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`id_branch`, `branch_name`, `branch_address`) VALUES
(1, 'KC Tangerang', 'Jl. Karawaci Tangerang'),
(2, 'KC  Roxy Mas', 'Jl. Roxy Mas Salim'),
(3, 'KC Fatmawati', 'Jl. Fatmawati Jakarta'),
(4, 'KC Cempaka Mas\r\n', 'Jl. Cempaka Mas Jakarta'),
(5, 'KC SS3', 'Jl. Asia Afrika');

-- --------------------------------------------------------

--
-- Table structure for table `division`
--

CREATE TABLE `division` (
  `id_division` int(11) NOT NULL,
  `name_division` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `division`
--

INSERT INTO `division` (`id_division`, `name_division`, `role`) VALUES
(1, 'Teller', 'Employee'),
(2, 'Customer Service', 'Employee'),
(3, 'Cyber Security', 'Developer'),
(4, 'Security Assurance', 'Developer'),
(5, 'Database Administrator', 'Developer'),
(6, 'Database Engineer', 'Developer'),
(7, 'Dev Ops Engineer', 'Developer');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id_emp` int(11) NOT NULL,
  `name_emp` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `id_branch` int(11) NOT NULL,
  `id_division` int(11) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `birth_date` date NOT NULL,
  `job_title` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id_emp`, `name_emp`, `email`, `address`, `id_branch`, `id_division`, `phone`, `birth_date`, `job_title`) VALUES
(1, 'Rusheila Donna', 'rusheila@gmail.com\r\n', 'Jl. Jakarta Barat', 5, 3, '081782372', '2022-02-01', ''),
(2, 'Steady', 'steady@gmail.com', 'Jl. Karawaci Tangerang', 5, 4, '08394985', '2022-02-01', ''),
(3, 'Jadid Abipraya', 'jadid@gmail.com', 'Jl. Jakarta Selatan', 5, 4, '083937823', '2022-02-02', ''),
(4, 'Oktasanti Puteri', 'okta@gmail.com', 'Jl. Bekasi Timur', 1, 1, '083467484', '2022-02-03', ''),
(5, 'Bagus Indiarto', 'bagus@gmail.com', 'Jl. Tangerang Selatan', 2, 2, '08465743', '2022-02-04', '');

-- --------------------------------------------------------

--
-- Table structure for table `problem`
--

CREATE TABLE `problem` (
  `id_problem` int(11) NOT NULL,
  `problem_name` varchar(255) NOT NULL,
  `job_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `problem`
--

INSERT INTO `problem` (`id_problem`, `problem_name`, `job_id`) VALUES
(1, 'Antivirus', 3),
(2, 'DCIF', 4);

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `id_ticket` int(11) NOT NULL,
  `id_emp` int(11) NOT NULL,
  `create_date` date NOT NULL,
  `id_problem` int(11) NOT NULL,
  `problem_detail` varchar(255) NOT NULL,
  `assign_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `id_solver` int(11) DEFAULT NULL,
  `dev_note` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`id_ticket`, `id_emp`, `create_date`, `id_problem`, `problem_detail`, `assign_date`, `end_date`, `status`, `id_solver`, `dev_note`) VALUES
(1, 4, '2022-02-15', 1, 'Antivirus block data', '0000-00-00', '0000-00-00', '', NULL, NULL),
(2, 5, '2022-02-15', 2, 'DCIF tidak bisa login', '0000-00-00', '0000-00-00', '', NULL, NULL),
(3, 4, '2022-02-15', 1, 'Antivirus block data', '0000-00-00', '0000-00-00', '', NULL, NULL),
(4, 5, '2022-02-15', 2, 'DCIF tidak bisa login', '0000-00-00', '0000-00-00', '', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id_account`),
  ADD KEY `id_emp` (`id_emp`);

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`id_branch`);

--
-- Indexes for table `division`
--
ALTER TABLE `division`
  ADD PRIMARY KEY (`id_division`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id_emp`),
  ADD KEY `id_branch` (`id_branch`),
  ADD KEY `id_job` (`id_division`);

--
-- Indexes for table `problem`
--
ALTER TABLE `problem`
  ADD PRIMARY KEY (`id_problem`),
  ADD KEY `job_id` (`job_id`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id_ticket`),
  ADD KEY `id_emp` (`id_emp`),
  ADD KEY `id_problem` (`id_problem`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id_account` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `id_branch` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `division`
--
ALTER TABLE `division`
  MODIFY `id_division` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id_emp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `problem`
--
ALTER TABLE `problem`
  MODIFY `id_problem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id_ticket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`id_emp`) REFERENCES `employee` (`id_emp`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`id_division`) REFERENCES `division` (`id_division`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`id_branch`) REFERENCES `branch` (`id_branch`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `problem`
--
ALTER TABLE `problem`
  ADD CONSTRAINT `problem_ibfk_1` FOREIGN KEY (`job_id`) REFERENCES `division` (`id_division`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`id_problem`) REFERENCES `problem` (`id_problem`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`id_emp`) REFERENCES `employee` (`id_emp`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
