CREATE DATABASE BANCA;

CREATE TABLE `cliente` (
  `cliente_id` bigint NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `identificacion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cuenta` (
  `cuenta_id` bigint NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) NOT NULL,
  `numero_cuenta` varchar(255) NOT NULL,
  `saldo_inicial` decimal(19,2) NOT NULL,
  `tipo_cuenta` varchar(255) NOT NULL,
  `cliente_id` bigint DEFAULT NULL,
  PRIMARY KEY (`cuenta_id`),
  KEY `FK4p224uogyy5hmxvn8fwa2jlug` (`cliente_id`),
  CONSTRAINT `FK4p224uogyy5hmxvn8fwa2jlug` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `movimiento` (
  `movimiento_id` bigint NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `saldo` decimal(19,2) DEFAULT NULL,
  `tipo_movimiento` varchar(255) DEFAULT NULL,
  `valor` decimal(19,2) DEFAULT NULL,
  `cuenta_id` bigint NOT NULL,
  PRIMARY KEY (`movimiento_id`),
  KEY `FK4ea11fe7p3xa1kwwmdgi9f2fi` (`cuenta_id`),
  CONSTRAINT `FK4ea11fe7p3xa1kwwmdgi9f2fi` FOREIGN KEY (`cuenta_id`) REFERENCES `cuenta` (`cuenta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;