CREATE TABLE `parking_floor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parking_spot_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

select * from `parking_floor`;

CREATE TABLE `parking_spot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_vaccant` char DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

select * from `parking_spot`;

CREATE TABLE `parking_slot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parking_spot_id` int(11) DEFAULT NULL,
  `parking_floor_id` int(11) DEFAULT NULL,
  `parking_type` varchar(45) DEFAULT NULL,
  `is_vaccant` char DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PSI_idx` (`parking_spot_id`),
  CONSTRAINT `FK_PSI` FOREIGN KEY (`parking_spot_id`)  
  REFERENCES `parking_spot` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_PFI_idx` (`parking_floor_id`),
  CONSTRAINT `FK_PFI` FOREIGN KEY (`parking_floor_id`)  
  REFERENCES `parking_floor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

select * from `parking_slot`;

CREATE TABLE `payment_mode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_type` varchar(45) DEFAULT NULL,
  `payment_amount` int(11) DEFAULT NULL,
  `payment_timestamp` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

select * from `payment_mode`;

CREATE TABLE `attendent_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_no` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `blood group` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

select * from `attendent_info`;

CREATE TABLE `parking_rate` (
  `parking_type` varchar(45) NOT NULL,
  `rate` int(45) DEFAULT NULL,
  PRIMARY KEY (`parking_type`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

select * from `parking_rate`;

CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_no` varchar(20) DEFAULT NULL,
  `parking_spot_id` int(11) DEFAULT NULL,
  `parking_floor_id` int(11) DEFAULT NULL,
  `payment_mode_id` int(45) DEFAULT NULL,
  `issue_timestamp` TIMESTAMP NOT NULL,
  `payment_timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_PSII_idx` (`parking_spot_id`),
  CONSTRAINT `FK_PSII` FOREIGN KEY (`parking_spot_id`)  
  REFERENCES `parking_spot` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_PFII_idx` (`parking_floor_id`),
  CONSTRAINT `FK_PFII` FOREIGN KEY (`parking_floor_id`)  
  REFERENCES `parking_floor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_PMII_idx` (`payment_mode_id`),
  CONSTRAINT `FK_PMII` FOREIGN KEY (`payment_mode_id`)  
  REFERENCES `payment_mode` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

select * from `ticket`;

SHOW ENGINE INNODB STATUS;