-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 10-Ago-2019 às 04:22
-- Versão do servidor: 10.3.16-MariaDB
-- versão do PHP: 7.1.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COfLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `GERS`
--
DROP DATABASE IF EXISTS `GERS`;
CREATE DATABASE IF NOT EXISTS `GERS` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `GERS`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `booking`
--

DROP TABLE IF EXISTS `booking`;
CREATE TABLE IF NOT EXISTS `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  `vehicle_id` int(11) NOT NULL,
  `booking_date` datetime NOT NULL,
  `estimated_date` datetime NOT NULL,
  `finished_date` datetime DEFAULT NULL,
  `reason_ext_time` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `observation` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `service_id` (`service_id`),
  KEY `vehicle_id` (`vehicle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `enginetype`
--

DROP TABLE IF EXISTS `engine_type`;
CREATE TABLE IF NOT EXISTS `engine_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `enginetype`
--

INSERT INTO `engine_type` (`id`, `name`) VALUES
(1, 'Diesel'),
(2, 'Petrol'),
(3, 'Hybrid'),
(4, 'Eletric');

-- --------------------------------------------------------

--
-- Estrutura da tabela `profile`
--

DROP TABLE IF EXISTS `profile`;
CREATE TABLE IF NOT EXISTS `profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `profile`
--

INSERT INTO `profile` (`id`, `name`) VALUES
(1, 'Admin'),
(2, 'Customer'),
(3, 'Employee');

-- --------------------------------------------------------

--
-- Estrutura da tabela `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_type_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `cost` decimal(10,2) NOT NULL,
  `status` varchar(15) COLLATE utf8_bin NOT NULL,
  `estimated_date` datetime NOT NULL,
  `started_date` datetime DEFAULT NULL,
  `finished_date` datetime DEFAULT NULL,
  `reason_ext_time` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `service_type_id` (`service_type_id`),
  KEY `employee_id` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `serviceitems`
--

DROP TABLE IF EXISTS `service_items`;
CREATE TABLE IF NOT EXISTS `service_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `service_id` (`service_id`),
  KEY `item_id` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `servicetype`
--

DROP TABLE IF EXISTS `service_type`;
CREATE TABLE IF NOT EXISTS `service_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `cost` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `servicetype`
--

INSERT INTO `service_type` (`id`, `name`, `cost`) VALUES
(1, 'Annual Service', '200.00'),
(2, 'Major Service', '250.00'),
(3, 'Repair / Fault', '80.00'),
(4, 'Major Repair', '150.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `profile_id` int(11) NOT NULL,
  `first_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `last_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `email` varchar(20) COLLATE utf8_bin NOT NULL,
  `mobile_phone` varchar(20) COLLATE utf8_bin NOT NULL,
  `second_phone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(15) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `profile_id` (`profile_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `user`
--

INSERT INTO `user` (`id`, `profile_id`, `first_name`, `last_name`, `email`, `mobile_phone`, `second_phone`, `password`) VALUES
(1, 1, 'Ger', 'Garage', 'ger@garage.com', '0830000001', NULL, '123'),
(2, 2, 'Italo', 'Marcius', 'italomarcius@gmail.c', '0830000002', NULL, '123'),
(3, 3, 'Joseph', 'O\'Connel', 'joconnel@garage.com', '0830000003', NULL, '123'),
(4, 2, 'Felipe', 'Souza', 'felipesouza@gmail.c', '0830000004', NULL, '123'),
(5, 3, 'Sean', 'Mc\'Gonnal', 'sean@garage.com', '0830000005', NULL, '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE IF NOT EXISTS `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL,
  `engine_id` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `license` varchar(15) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  KEY `engine_id` (`engine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estrutura da tabela `vehicleitem`
--

DROP TABLE IF EXISTS `vehicle_item`;
CREATE TABLE IF NOT EXISTS `vehicle_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_bin NOT NULL,
  `cost` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `vehicleitem`
--

INSERT INTO `vehicle_item` (`id`, `name`, `cost`) VALUES
(41, '2.5 Gallon Air Tank', '72.99'),
(42, 'TeraFlex Pullover Hoodie', '34.99'),
(43, 'Lange Originals Paint Saver', '49.99'),
(44, 'Fab Fours ViCowl Limb Rise', '159.99'),
(45, 'ACE Engineering Inner Fender Insert', '42.99'),
(46, 'Warn ATV Gravel Skid Kit', '16.99'),
(47, 'GBC Sand Shark 20x11-8 Tire', '52.99'),
(48, 'AT489 24x12-10 ATV Tire', '123.99'),
(49, 'Dune Star 26x9-12 ATV Tire', '98.99'),
(50, 'Big Horn Radial 2.0 23x8R-12 ATV', '106.99'),
(51, 'ARB Compressor', '18.99'),
(52, 'Inlet Air Filter Assembly', '3.99'),
(53, '5-Piece Tank Port Fittings Kit', '9.99'),
(54, 'VIAIR Check Valve', '6.99'),
(55, 'VIAIR Air Down Gauge', '16.99'),
(56, 'AirLift Dual Needle Air', '72.99'),
(57, '4x4 Accessories Inflation Case', '50.99'),
(58, '100% Duty Air Compressor', '219.99'),
(59, 'ARB Twin Air Compressor Bundle', '727.96'),
(60, '400C Onboard Air System', '599.99'),
(61, '2 Gal. Tank High-Flow', '329.99'),
(62, '2.54 CFM Air Compressor', '89.99'),
(63, '88P Portable Compressor Kit', '65.99'),
(64, 'Firestone Ride-Rite Air Tank', '55.99'),
(65, '10lb. Package A System (Black)', '439.99'),
(66, 'Neon Clock', '82.99'),
(67, 'Poison Spyder Diff Cover Keychain (Black)', '22.99'),
(68, 'Grille Key Chain (Raw)', '11.99'),
(69, 'TeraFlex Lanyard (Black)', '2.99'),
(70, 'MSD Work Apron', '19.99'),
(71, '10lb. Package B System (Yellow)', '509.99'),
(72, 'Sidearm Package A with Bracket (Blue)', '379.99'),
(73, 'Trail Rated Jeep LED Sign', '115.99'),
(74, '24x8-11 Radial ATV Tire', '70.99'),
(75, 'Mud Lite 22x8-10 Radial ATV Tire', '65.99'),
(76, 'Scorpion ATV Tire', '75.99'),
(77, '26x10.00-12 K538 Executioner', '91.99'),
(78, '22x11.00-9 K535A Parker DT ATV Tire', '99.99'),
(79, 'Tires 21x11.00-10 K534 Gecko', '62.99'),
(80, '22x11.00-10 K533 Klaw', '74.99');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vehicle_make`
--

DROP TABLE IF EXISTS `vehicle_make`;
CREATE TABLE IF NOT EXISTS `vehicle_make` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `type_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `vehiclemake`
--

INSERT INTO `vehicle_make` (`id`, `name`, `type_id`) VALUES
(63, 'Other', 5),
(64, 'BMW X1', 2),
(65, 'BMW X2', 2),
(66, 'BMW X3', 2),
(67, 'BMW X4', 2),
(68, 'BMW RR', 1),
(69, 'Suzuki 125', 1),
(70, 'Suzuki 250', 1),
(71, 'Toyota Corolla', 2),
(72, 'Toyota Camry', 2),
(73, 'Toyota Prius', 2),
(74, 'Toyota Proace', 3),
(75, 'Toyota Hiace', 4),
(76, 'Ford Fiesta', 2),
(77, 'Ford Ka', 2),
(78, 'Ford Mondeo', 2),
(79, 'Ford Ranger', 2),
(80, 'Ford Transit', 3),
(81, 'Ford Transit Bus', 4),
(82, 'Ford Ecosport', 2),
(83, 'Range Rover Evoque', 2),
(84, 'Range Rover Sport', 2),
(85, 'Range Rover Velar', 2),
(86, 'Range Rover', 2),
(87, 'Mercedez Sprinter', 3),
(88, 'Audi A3', 2),
(89, 'Audi A4', 2),
(90, 'Audi A5', 2),
(91, 'Audi A6', 2),
(92, 'Audi A7', 2),
(93, 'Iveco Daily', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vehicle_type`
--

DROP TABLE IF EXISTS `vehicle_type`;
CREATE TABLE IF NOT EXISTS `vehicle_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `vehicletype`
--

INSERT INTO `vehicle_type` (`id`, `name`) VALUES
(1, 'Motorbike'),
(2, 'Car'),
(3, 'Small Van'),
(4, 'Small Bus'),
(5, 'Other');

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`),
  ADD CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`);

--
-- Limitadores para a tabela `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `service_ibfk_1` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`id`),
  ADD CONSTRAINT `service_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `user` (`id`);

--
-- Limitadores para a tabela `serviceitems`
--
ALTER TABLE `service_items`
  ADD CONSTRAINT `serviceitems_ibfk_1` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`),
  ADD CONSTRAINT `serviceitems_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `vehicle_item` (`id`);

--
-- Limitadores para a tabela `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`);

--
-- Limitadores para a tabela `vehicle`
--
ALTER TABLE `vehicle`
  ADD CONSTRAINT `vehicle_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `vehicle_type` (`id`),
  ADD CONSTRAINT `vehicle_ibfk_2` FOREIGN KEY (`engine_id`) REFERENCES `engine_type` (`id`);

--
-- Limitadores para a tabela `vehiclemake`
--
ALTER TABLE `vehicle_make`
  ADD CONSTRAINT `vehiclemake_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `vehicle_type` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
