/**
Create Table
**/
CREATE TABLE `anonymity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clientDeviceId` varchar(100) DEFAULT NULL,
  `clientDeviceName` varchar(100) DEFAULT NULL,
  `clientDeviceToken` varchar(100) DEFAULT NULL,
  `clientVersion` varchar(20) DEFAULT NULL,
  `clientOS` varchar(20) DEFAULT NULL,
  `clientLang` varchar(20) DEFAULT NULL,
  `productVersion` varchar(20) DEFAULT NULL,
  `productID` varchar(20) DEFAULT NULL,
  `loginIp` varchar(20) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `uninstallTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `clientDeviceId` (`clientDeviceId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8



CREATE TABLE `gp_property` (
  `name` varchar(100) NOT NULL,
  `propValue` text NOT NULL,
   PRIMARY KEY (`name`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

CREATE TABLE `banner` (
 `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
 `productId` VARCHAR(50) DEFAULT NULL,  
 `appStoreId` VARCHAR(50) DEFAULT NULL,  
 `imageUrl` VARCHAR(100) DEFAULT NULL,  
 `bannerType` int(5) DEFAULT NULL,
 `status` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

CREATE TABLE `product` (
 `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
 `productId` VARCHAR(50) DEFAULT NULL,  
 `productName` VARCHAR(50) DEFAULT NULL,
 `appIsnew` int(5) DEFAULT NULL,
 `appStoreId` VARCHAR(50) DEFAULT NULL,  
 `schema` VARCHAR(100) DEFAULT NULL,  
 `productPrice` double DEFAULT NULL,
 `description` VARCHAR(100) DEFAULT NULL,  
 `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

