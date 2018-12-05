CREATE TABLE `book` (
  `bookid` int(9) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(64) NOT NULL,
  `bookcontent` varchar(10240) DEFAULT NULL,
  `bookwebid` varchar(128) DEFAULT NULL,
  `bookinternalid` int(9) NOT NULL,
  `chapterid` int(9) NOT NULL,
  `chaptername` varchar(128) DEFAULT NULL,
  `createtime` datetime NOT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8

CREATE TABLE `bookinfo` (
  `bookinfoid` int(9) NOT NULL AUTO_INCREMENT,
  `bookwebid` varchar(64) DEFAULT NULL,
  `bookinternalid` int(9) NOT NULL,
  PRIMARY KEY (`bookinfoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `globalparameter` (
  `key` varchar(128) NOT NULL,
  `intvalue` int(128) DEFAULT NULL,
  `strvalue` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

INSERT INTO globalparameter(`key`, intvalue, strvalue) VALUES ("bookinternalid", 0, NULL );