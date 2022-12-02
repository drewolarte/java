-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2022 a las 22:01:05
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `clubes`
--

--
-- Volcado de datos para la tabla `asociaciones`
--

INSERT INTO `asociaciones` (`id`, `foto`, `nombre`, `pais`, `presidente`, `siglas`) VALUES
(1, 'Fcf.png', 'Federacion Colombiana de Futbol', 'Colombia', 'Ramon Jesurun', 'FCF'),
(2, 'conmebol.jpg', 'Confederacion Sudamericana de Futbol', 'Sudamerica', 'Alejandro Dominguez', 'Conmebol'),
(4, 'Concacaf.png', 'Confederacion de Norteamerica, Centroamerica y el Caribe de Futbol', 'Norteamérica, Centroamérica y el Caribe', 'Victor Montagliani', 'Concacaf'),
(5, 'Caf.png', 'Confederacion Africana de Futbol', 'Africa', 'Patrice Motsepe', 'Caf');

--
-- Volcado de datos para la tabla `clubes`
--

INSERT INTO `clubes` (`id`, `foto`, `nombre`, `asociacion_id`, `entrenador_id`) VALUES
(1, 'AtleticoNacional.png', 'Atletico Nacional', 1, 1),
(2, 'AtleticoBucaramanga.png', 'Atletico Bucaramanga', 1, 4);

--
-- Volcado de datos para la tabla `clubes_competiciones`
--

INSERT INTO `clubes_competiciones` (`club_id`, `competiciones_id`) VALUES
(1, 2),
(2, 2);

--
-- Volcado de datos para la tabla `competiciones`
--

INSERT INTO `competiciones` (`id`, `fecha_fin`, `fecha_inicio`, `foto`, `monto_premio`, `nombre`) VALUES
(2, '2022-11-02', '2022-04-20', 'CopaColombia.png', 440000000, 'Copa Colombia'),
(3, '2022-06-26', '2022-01-20', 'SuperLiga.jfif', 524000000, 'Superliga de Colombia');

--
-- Volcado de datos para la tabla `entrenadores`
--

INSERT INTO `entrenadores` (`id`, `apellido`, `edad`, `foto`, `nacionalidad`, `nombre`) VALUES
(1, 'Herrera', 65, 'HernanDario.jpg', 'Colombiano', 'Hernan Dario'),
(3, 'Giraldo', 40, 'DavidGonzalez.jpg', 'Colombiano', 'David Gonzalez'),
(4, 'Alvarez', 57, 'LeonelAlvarez.jpg', 'Colombiano', 'Leonel '),
(5, 'Cruz Real', 46, 'JuanCruz.jpg', 'Colombiano', 'Juan');

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`id`, `apellido`, `foto`, `nombre`, `numero`, `posicion`, `id_club`) VALUES
(1, 'Ruiz Rivera', 'DanielRuiz.jpg', 'Daniel ', 10, 'Extremo izquierdo', 1),
(3, 'Montero', 'AlvaroMontero.jpeg', 'Alvaro', 31, 'Portero', 1),
(4, 'Mier', 'KevinMier.jpg', 'Kevin', 23, 'Portero', NULL),
(5, 'Barrera', 'JarlanBarrera.jpg', 'Jarlan', 7, 'Mediocentro ofensivo', 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
