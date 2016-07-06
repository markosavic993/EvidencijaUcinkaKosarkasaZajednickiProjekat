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
('Janko','Jankovic','1987-05-14 00:00:00','1212121212121','Krilni centar',55,207,102,5),
('Jovan','Milosevic','1987-06-01 00:00:00','1231231231233','Krilo',45,204,99,5),
('Ivko','Ivkovic','1981-01-01 00:00:00','1234512343555','Bek',0,199,95,14),
('Nikola','Jokic','1994-03-03 00:00:00','2121212121212','Centar',6,214,106,1),
('Edo','Muric','1991-11-21 21:02:20','2222222222222','Krilo',8,204,98,3),
('Marko','Savic','1993-09-29 00:00:00','2909993792611','Krilo',10,196,93,9),
('Darko','Savic','1997-03-30 00:00:00','3003997790014','Plejmejker',5,191,90,9),
('Bozo','Djumic','1995-11-01 00:00:00','3333333333333','Centar',29,209,102,3),
('Milos','Teodosic','1987-05-02 00:00:00','3455433455431','Plejmejker',4,194,85,11),
('Branko','Lazic','1989-03-16 21:04:21','4444444444444','Bek',8,192,90,4),
('Marko','Simonovic','1988-02-01 00:00:00','5555555555551','Krilo',3,204,98,4),
('Vasilije','Micic','1990-10-15 21:05:10','5555555555555','Plejmejker',10,191,84,4),
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
(9,'Ivanjica',2004,'Ivanjica','Crnjevo'),
(10,'Radnicki',1968,'Kragujevac','Jezero'),
(11,'CSKA',1950,'Moskva','CSKA Arena'),
(12,'PlayOff',2009,'Uzice','Gradska'),
(14,'Mega Leks',2004,'Sremska Mitrovica','Mega'),
(17,'Priboj',2000,'Priboj','Centralna'),
(18,'Borac',1962,'Cacak','Morava');

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
  PRIMARY KEY (`idUcinka`),
  KEY `kosarkas` (`kosarkas`),
  KEY `utakmica` (`utakmica`),
  KEY `tip` (`tip`),
  CONSTRAINT `ucinak_ibfk_1` FOREIGN KEY (`kosarkas`) REFERENCES `kosarkas` (`jmbg`),
  CONSTRAINT `ucinak_ibfk_2` FOREIGN KEY (`utakmica`) REFERENCES `utakmica` (`id`),
  CONSTRAINT `ucinak_ibfk_3` FOREIGN KEY (`tip`) REFERENCES `tipucinka` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

/*Data for the table `ucinak` */

insert  into `ucinak`(`idUcinka`,`kosarkas`,`utakmica`,`tip`,`vrednost`) values 
(20,'1111111111111',1,'Poeni',5),
(21,'3333333333333',1,'Poeni',5),
(22,'9879871231236',1,'Poeni',4),
(23,'2222222222222',1,'Poeni',20),
(24,'9191919191191',1,'Poeni',19),
(25,'9191919191191',1,'Asistencije',3),
(26,'3333333333333',1,'Skokovi',5),
(27,'1111111111111',1,'Asistencije',3),
(28,'4444444444444',1,'Asistencije',4),
(29,'4444444444444',1,'Poeni',7),
(30,'5555555555551',1,'Poeni',14),
(31,'5555555555551',1,'Ukradene lopte',2),
(32,'6666666666666',1,'Skokovi',2),
(33,'6666666666666',1,'Poeni',15),
(34,'1111111111111',1,'Poeni',3),
(35,'3003997790014',2,'Izgubljene lopte',7),
(36,'2909993792611',2,'Poeni',20),
(37,'3003997790014',2,'Blokade',3),
(38,'3003997790014',2,'Poeni',12),
(39,'2909993792611',2,'Skokovi',10),
(40,'3003997790014',2,'Skokovi',1),
(41,'3003997790014',2,'Poeni',10),
(42,'1111111111111',1,'Poeni',5),
(43,'1111111111111',1,'Broj minuta',35),
(44,'9879871231236',1,'Poeni',5),
(45,'5555555555551',1,'Poeni',5),
(46,'9879871231236',1,'Poeni',5),
(47,'6666666666666',3,'Bacanja',3),
(48,'6666666666666',3,'Poeni',20),
(49,'2909993792611',2,'Asistencije',2);

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
(1,'2016-06-05 00:00:00',3,4,71,41),
(2,'2013-03-03 00:00:00',9,3,42,0),
(3,'2016-01-01 00:00:00',18,4,0,20);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
