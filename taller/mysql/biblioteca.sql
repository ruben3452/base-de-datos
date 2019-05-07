-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-11-2014 a las 01:51:32
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bdatos`
--

CREATE TABLE IF NOT EXISTS `bdatos` (
  `ISBN` text NOT NULL,
  `NombreLibro` text NOT NULL,
  `NombreEditorial` text NOT NULL,
  `añopublicacion` int(11) NOT NULL,
  `nropaginas` int(11) NOT NULL,
  `valordecompra` decimal(10,0) NOT NULL,
  `nrocopias` int(11) NOT NULL,
  `ubicacion` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bdatos`
--

INSERT INTO `bdatos` (`ISBN`, `NombreLibro`, `NombreEditorial`, `añopublicacion`, `nropaginas`, `valordecompra`, `nrocopias`, `ubicacion`) VALUES
('9789588820422', 'la ladrona de libros', 'debolsillo', 2014, 350, '35000', 10, 'hb4'),
('978958882045', 'el pais de la nube blanca', 'ediciones b', 2014, 300, '52000', 15, 'bn4'),
('234', 'set', 'sdfg', 342, 234, '234', 34, 'df');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
