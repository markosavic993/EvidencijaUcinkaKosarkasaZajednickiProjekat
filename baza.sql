/*
SQLyog Community v12.2.1 (32 bit)
MySQL - 5.6.17 : Database - evidencija_ucinka_kosarkasa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`evidencija_ucinka_kosarkasa` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `evidencija_ucinka_kosarkasa`;

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `mail` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `korisnik` */

insert  into `korisnik`(`username`,`password`,`mail`) values 
('abcde','abcde','abc@abc'),
('admin','admin','safasfa@saf'),
('darko','1233','darko@gmail.com'),
('marko','3812','savicmarko993@gmail.com'),
('semafor','semafor','s@s'),
('TejaOmaja','omaja','teja@omaja'),
('user1','admin','adresa@adresa');

/*Table structure for table `kosarkas` */

DROP TABLE IF EXISTS `kosarkas`;

CREATE TABLE `kosarkas` (
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `datumrodjenja` datetime DEFAULT NULL,
  `jmbg` varchar(13) NOT NULL,
  `pozicija` varchar(20) DEFAULT NULL,
  `broj` int(2) DEFAULT NULL,
  `visina` int(3) DEFAULT NULL,
  `tezina` int(3) DEFAULT NULL,
  `sifratima` int(10) DEFAULT NULL,
  PRIMARY KEY (`jmbg`),
  KEY `sifratima` (`sifratima`),
  CONSTRAINT `kosarkas_ibfk_1` FOREIGN KEY (`sifratima`) REFERENCES `tim` (`sifratima`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `kosarkas` */

insert  into `kosarkas`(`ime`,`prezime`,`datumrodjenja`,`jmbg`,`pozicija`,`broj`,`visina`,`tezina`,`sifratima`) values 
('Ivan','Peric','1994-11-19 00:00:00','0909090909123','Krilni centar',70,209,102,17),
('Petar','Petrovic','1967-08-01 00:00:00','1010991010991','Krilo',3,199,98,4),
('Aleksandar','Cvetkovic','1903-05-30 21:00:52','1111111111111','Plejmejker',4,192,87,3),
('Andrija','Miskovic','1986-04-05 00:00:00','1122112200987','Krilo',20,202,98,18),
('Janko','Jankovic','1987-05-14 00:00:00','1212121212121','Krilni centar',55,207,102,5),
('Jovan','Milosevic','1987-06-01 00:00:00','1231231231233','Krilo',45,204,99,5),
('kos1','p1','1960-01-01 00:00:00','1231231231237','Plejmejker',0,185,85,19),
('Ivko','Ivkovic','1981-01-01 00:00:00','1234512343555','Bek',0,199,95,14),
('Nikola','Jokic','1994-03-03 00:00:00','2121212121212','Centar',6,214,106,1),
('Edo','Muric','1991-11-21 21:02:20','2222222222222','Krilo',8,204,98,3),
('Marko','Savic','1993-09-01 00:00:00','2909993792611','Krilo',10,196,94,9),
('Darko','Savic','1997-03-30 00:00:00','3003997790014','Plejmejker',5,191,90,9),
('Bozo','Djumic','1995-11-01 00:00:00','3333333333333','Centar',29,209,102,3),
('Milos','Teodosic','1987-05-02 00:00:00','3455433455431','Plejmejker',4,194,85,11),
('Branko','Lazic','1989-03-16 21:04:21','4444444444444','Bek',8,192,90,4),
('Marko','Simonovic','1988-02-01 00:00:00','5555555555551','Krilo',3,204,98,4),
('Vasilije','Micic','1990-10-15 21:05:10','5555555555555','Plejmejker',10,191,84,4),
('Goran','Jevtic','1968-12-12 00:00:00','6565125121232','Bek',5,185,85,22),
('Todor','Todorovic','1988-01-15 00:00:00','6663331119992','Krilni centar',13,201,100,18),
('Rasko','Katic','1986-07-19 21:06:31','6666666666666','Centar',33,211,107,4),
('Milos','Milosevic','1984-06-06 00:00:00','6767676767654','Bek',20,195,92,1),
('Marko','Markovic','1989-02-13 00:00:00','9191919191191','Bek',8,198,92,3),
('Mita','Mitic','1960-01-01 00:00:00','9829819839815','Plejmejker',0,123,123,1),
('Avram','Stojkovic','1984-02-05 00:00:00','9873456212341','Krilni centar',14,199,96,1),
('Petar','Aranitovic','1994-04-01 00:00:00','9879871231236','Plejmejker',5,195,87,3);

/*Table structure for table `tim` */

DROP TABLE IF EXISTS `tim`;

CREATE TABLE `tim` (
  `sifratima` int(10) NOT NULL,
  `naziv` varchar(50) DEFAULT NULL,
  `godinaosnivanja` int(5) DEFAULT NULL,
  `grad` varchar(50) DEFAULT NULL,
  `hala` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sifratima`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tim` */

insert  into `tim`(`sifratima`,`naziv`,`godinaosnivanja`,`grad`,`hala`) values 
(1,'Slobodan agent',NULL,NULL,NULL),
(2,'Fenerbahce',1967,'Istanbul','AbdiBekci'),
(3,'Partizan',1948,'Beograd','Pionir'),
(4,'Crvena zvezda',1950,'Beograd','Pionir'),
(5,'Metalac',1934,'Valjevo','SC Valjevo'),
(8,'FMP',2003,'Beograd','Zeleznik'),
(9,'Ivanjica',2003,'Ivanjica','Crnjevo'),
(10,'Radnicki',1968,'Kragujevac','Jezero'),
(11,'CSKA',1950,'Moskva','CSKA Arena'),
(12,'PlayOff',2009,'Uzice','Gradska'),
(14,'Mega Leks',2004,'Sremska Mitrovica','Mega'),
(17,'Priboj',2000,'Priboj','Centralna'),
(18,'Borac',1965,'Cacak','Morava'),
(19,'T1',2016,'G1','H1'),
(21,'Metalac',1976,'Gornji Milanovac','Hala Breza'),
(22,'Jagodina',1984,'Jagodina','Hala Sportova');

/*Table structure for table `tipucinka` */

DROP TABLE IF EXISTS `tipucinka`;

CREATE TABLE `tipucinka` (
  `naziv` varchar(50) NOT NULL,
  `opis` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`naziv`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipucinka` */

insert  into `tipucinka`(`naziv`,`opis`) values 
('Asistencije','Broj asistencija igraca na celoj utakmici.'),
('Bacanja','Broj slobodnih bacanja koje je igrac izveo.'),
('Blokade','Broj uspešnih blokada igra?a.'),
('Broj minuta','Broj minuta koje je košarkaš proveo na terenu.'),
('Faulovi','Broj faulova igraca na celoj utakmici.'),
('Izgubljene lopte','Broj izgubljenih lopti igraca na utakmici'),
('Poeni','Broj poena igraca na celoj utakmici.'),
('Skokovi','Broj skokova igraca na celoj utakmici.'),
('Ukradene lopte','Broj ukradenih lopti igraca na utakmici.');

/*Table structure for table `ucinak` */

DROP TABLE IF EXISTS `ucinak`;

CREATE TABLE `ucinak` (
  `idUcinka` int(100) NOT NULL AUTO_INCREMENT,
  `kosarkas` varchar(13) NOT NULL,
  `utakmica` int(10) NOT NULL,
  `tip` varchar(50) NOT NULL,
  `vrednost` int(5) DEFAULT NULL,
  `korisnik` varchar(20) NOT NULL,
  PRIMARY KEY (`idUcinka`),
  KEY `kosarkas` (`kosarkas`),
  KEY `utakmica` (`utakmica`),
  KEY `tip` (`tip`),
  KEY `korisnik` (`korisnik`),
  CONSTRAINT `ucinak_ibfk_1` FOREIGN KEY (`kosarkas`) REFERENCES `kosarkas` (`jmbg`),
  CONSTRAINT `ucinak_ibfk_2` FOREIGN KEY (`utakmica`) REFERENCES `utakmica` (`id`),
  CONSTRAINT `ucinak_ibfk_3` FOREIGN KEY (`tip`) REFERENCES `tipucinka` (`naziv`),
  CONSTRAINT `ucinak_ibfk_4` FOREIGN KEY (`korisnik`) REFERENCES `korisnik` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=latin1;

/*Data for the table `ucinak` */

insert  into `ucinak`(`idUcinka`,`kosarkas`,`utakmica`,`tip`,`vrednost`,`korisnik`) values 
(95,'3455433455431',2,'Poeni',40,'semafor'),
(96,'3455433455431',2,'Faulovi',3,'semafor'),
(97,'2909993792611',2,'Poeni',31,'semafor'),
(98,'2909993792611',2,'Faulovi',2,'semafor'),
(99,'3003997790014',2,'Poeni',24,'semafor'),
(100,'3003997790014',2,'Faulovi',0,'semafor'),
(101,'2909993792611',2,'Blokade',2,'marko'),
(102,'2909993792611',2,'Poeni',5,'marko'),
(103,'3455433455431',1,'Poeni',6,'admin'),
(104,'6666666666666',3,'Poeni',15,'semafor'),
(105,'6666666666666',3,'Faulovi',0,'semafor'),
(106,'4444444444444',3,'Poeni',5,'semafor'),
(107,'4444444444444',3,'Faulovi',5,'semafor'),
(108,'5555555555555',3,'Poeni',13,'semafor'),
(109,'5555555555555',3,'Faulovi',2,'semafor'),
(110,'1010991010991',3,'Poeni',8,'semafor'),
(111,'1010991010991',3,'Faulovi',1,'semafor'),
(112,'5555555555551',3,'Poeni',21,'semafor'),
(113,'5555555555551',3,'Faulovi',0,'semafor'),
(114,'9879871231236',3,'Poeni',9,'semafor'),
(115,'9879871231236',3,'Faulovi',2,'semafor'),
(116,'1111111111111',3,'Poeni',13,'semafor'),
(117,'1111111111111',3,'Faulovi',5,'semafor'),
(118,'3333333333333',3,'Poeni',16,'semafor'),
(119,'3333333333333',3,'Faulovi',0,'semafor'),
(120,'9191919191191',3,'Poeni',6,'semafor'),
(121,'9191919191191',3,'Faulovi',0,'semafor'),
(122,'2222222222222',3,'Poeni',23,'semafor'),
(123,'2222222222222',3,'Faulovi',0,'semafor'),
(124,'6666666666666',3,'Poeni',2,'marko'),
(125,'2222222222222',3,'Skokovi',10,'marko'),
(126,'2222222222222',3,'Skokovi',10,'marko'),
(127,'2222222222222',3,'Blokade',1,'marko'),
(128,'5555555555555',3,'Bacanja',2,'TejaOmaja'),
(129,'5555555555555',3,'Poeni',2,'TejaOmaja'),
(130,'2909993792611',6,'Poeni',7,'semafor'),
(131,'2909993792611',6,'Faulovi',0,'semafor'),
(132,'3003997790014',6,'Poeni',3,'semafor'),
(133,'3003997790014',6,'Faulovi',1,'semafor'),
(134,'1122112200987',6,'Poeni',5,'semafor'),
(135,'1122112200987',6,'Faulovi',4,'semafor'),
(136,'6663331119992',6,'Poeni',4,'semafor'),
(137,'6663331119992',6,'Faulovi',0,'semafor');

/*Table structure for table `utakmica` */

DROP TABLE IF EXISTS `utakmica`;

CREATE TABLE `utakmica` (
  `id` int(10) NOT NULL,
  `datum` datetime DEFAULT NULL,
  `domacin` int(10) DEFAULT NULL,
  `gost` int(10) DEFAULT NULL,
  `poeni_domacin` int(4) DEFAULT NULL,
  `poeni_gost` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `domacin` (`domacin`),
  KEY `gost` (`gost`),
  CONSTRAINT `utakmica_ibfk_1` FOREIGN KEY (`domacin`) REFERENCES `tim` (`sifratima`),
  CONSTRAINT `utakmica_ibfk_2` FOREIGN KEY (`gost`) REFERENCES `tim` (`sifratima`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `utakmica` */

insert  into `utakmica`(`id`,`datum`,`domacin`,`gost`,`poeni_domacin`,`poeni_gost`) values 
(1,'2016-01-01 00:00:00',11,9,6,0),
(2,'2016-01-01 00:00:00',11,9,40,60),
(3,'2016-01-01 00:00:00',4,3,66,67),
(4,'2012-02-29 00:00:00',9,18,0,0),
(5,'2016-01-01 00:00:00',22,9,0,0),
(6,'2016-04-01 00:00:00',9,18,10,9),
(7,'2016-08-25 00:00:00',3,4,0,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
