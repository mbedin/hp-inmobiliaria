/*
SQLyog Community Edition- MySQL GUI v7.02 
MySQL - 5.0.67-community-nt : Database - inmobiliaria
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`inmobiliaria` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `inmobiliaria`;

/*Table structure for table `citas` */

DROP TABLE IF EXISTS `citas`;

CREATE TABLE `citas` (
  `Id` int(11) NOT NULL auto_increment,
  `descripcion` varchar(200) default NULL,
  `estado` varchar(255) default NULL,
  `fechaCita` datetime NOT NULL,
  `horaCita` time NOT NULL,
  PRIMARY KEY  (`Id`),
  UNIQUE KEY `Id` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `citas` */

/*Table structure for table `contratos` */

DROP TABLE IF EXISTS `contratos`;

CREATE TABLE `contratos` (
  `Id` int(11) NOT NULL auto_increment,
  `descEstado` varchar(255) default NULL,
  `estado` int(11) NOT NULL,
  `fechaEmision` date NOT NULL,
  `fechaFin` date NOT NULL,
  `fechaInicio` date NOT NULL,
  `observaciones` longtext NOT NULL,
  `IdPersona` int(11) default NULL,
  `IdPropiedad` int(11) default NULL,
  PRIMARY KEY  (`Id`),
  UNIQUE KEY `Id` (`Id`),
  KEY `FKE86D50D76FB2D9AB` (`IdPersona`),
  KEY `FKE86D50D792EE1863` (`IdPropiedad`),
  CONSTRAINT `FKE86D50D76FB2D9AB` FOREIGN KEY (`IdPersona`) REFERENCES `personas` (`Id`),
  CONSTRAINT `FKE86D50D792EE1863` FOREIGN KEY (`IdPropiedad`) REFERENCES `propiedades` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contratos` */

/*Table structure for table `localidades` */

DROP TABLE IF EXISTS `localidades`;

CREATE TABLE `localidades` (
  `id` int(11) NOT NULL auto_increment,
  `descripcion` varchar(50) NOT NULL,
  `IdProvincia` int(11) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK791906D7A77068ED` (`IdProvincia`),
  CONSTRAINT `FK791906D7A77068ED` FOREIGN KEY (`IdProvincia`) REFERENCES `provincias` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `localidades` */

insert  into `localidades`(`id`,`descripcion`,`IdProvincia`) values (1,'Arequito',1),(2,'Rosario',1),(3,'Santa Fe',1),(4,'Los Molinos',1),(5,'Casilda',1);

/*Table structure for table `pagos` */

DROP TABLE IF EXISTS `pagos`;

CREATE TABLE `pagos` (
  `Id` int(11) NOT NULL auto_increment,
  `contrato` tinyblob,
  `fechaVencimiento` datetime default NULL,
  `montoMensual` decimal(19,2) default NULL,
  PRIMARY KEY  (`Id`),
  UNIQUE KEY `Id` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `pagos` */

insert  into `pagos`(`Id`,`contrato`,`fechaVencimiento`,`montoMensual`) values (1,NULL,NULL,NULL);

/*Table structure for table `personas` */

DROP TABLE IF EXISTS `personas`;

CREATE TABLE `personas` (
  `Id` int(11) NOT NULL auto_increment,
  `EMail` varchar(200) NOT NULL,
  `Activo` tinyint(1) NOT NULL,
  `Dni` varchar(200) NOT NULL,
  `NombreYApellido` varchar(200) NOT NULL,
  `telefono` varchar(255) default NULL,
  `tipoPersona` int(11) NOT NULL,
  `Usuario` varchar(20) NOT NULL,
  PRIMARY KEY  (`Id`),
  UNIQUE KEY `Id` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `personas` */

insert  into `personas`(`Id`,`EMail`,`Activo`,`Dni`,`NombreYApellido`,`telefono`,`tipoPersona`,`Usuario`) values (1,'emearequito@gmail.com',1,'31663213','Mario Bedin','3453-3234322',1,'mbedin');

/*Table structure for table `propiedades` */

DROP TABLE IF EXISTS `propiedades`;

CREATE TABLE `propiedades` (
  `Id` int(11) NOT NULL auto_increment,
  `activa` bit(1) NOT NULL,
  `alquilada` bit(1) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `estado` varchar(255) default NULL,
  `fechaAlta` date NOT NULL,
  `localidad` tinyblob,
  `IdPropietario` int(11) default NULL,
  `cantAmbientes` int(11) default NULL,
  `cantHabitaciones` int(11) default NULL,
  PRIMARY KEY  (`Id`),
  UNIQUE KEY `Id` (`Id`),
  KEY `FKD68E6161788D2AB` (`IdPropietario`),
  CONSTRAINT `FKD68E6161788D2AB` FOREIGN KEY (`IdPropietario`) REFERENCES `personas` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `propiedades` */

/*Table structure for table `provincias` */

DROP TABLE IF EXISTS `provincias`;

CREATE TABLE `provincias` (
  `Id` int(11) NOT NULL auto_increment,
  `Nombre` varchar(200) default NULL,
  `Orden` int(11) default NULL,
  PRIMARY KEY  (`Id`),
  UNIQUE KEY `Id` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `provincias` */

insert  into `provincias`(`Id`,`Nombre`,`Orden`) values (1,'Santa Fe',1);

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `Id` int(11) NOT NULL auto_increment,
  `Activo` tinyint(1) default NULL,
  `Password` varchar(200) NOT NULL,
  `Usuario` varchar(20) NOT NULL,
  PRIMARY KEY  (`Id`),
  UNIQUE KEY `Id` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `usuarios` */

insert  into `usuarios`(`Id`,`Activo`,`Password`,`Usuario`) values (1,1,'admin','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
