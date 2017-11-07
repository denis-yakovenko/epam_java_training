DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

INSERT INTO `dish` (`id`, `name`, `price`) VALUES (58,'Steak',1.2);
INSERT INTO `dish` (`id`, `name`, `price`) VALUES (59,'Soup',4.5);
INSERT INTO `dish` (`id`, `name`, `price`) VALUES (60,'Hamburger',2.6);
INSERT INTO `dish` (`id`, `name`, `price`) VALUES (61,'Coffee',9.4);
INSERT INTO `dish` (`id`, `name`, `price`) VALUES (62,'Tea',0.5);

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payment` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

INSERT INTO `order` (`id`, `payment`, `status`) VALUES (27,'null','CREATED');
INSERT INTO `order` (`id`, `payment`, `status`) VALUES (28,'null','CREATED');
INSERT INTO `order` (`id`, `payment`, `status`) VALUES (29,'CREDIT_CARD','PAYED');
INSERT INTO `order` (`id`, `payment`, `status`) VALUES (30,'CREDIT_CARD','PAYED');
INSERT INTO `order` (`id`, `payment`, `status`) VALUES (31,'CREDIT_CARD','PAYED');
INSERT INTO `order` (`id`, `payment`, `status`) VALUES (32,'CREDIT_CARD','PAYED');
INSERT INTO `order` (`id`, `payment`, `status`) VALUES (34,'CREDIT_CARD','PAYED');
INSERT INTO `order` (`id`, `payment`, `status`) VALUES (35,'CREDIT_CARD','PAYED');
INSERT INTO `order` (`id`, `payment`, `status`) VALUES (36,'CREDIT_CARD','PAYED');
INSERT INTO `order` (`id`, `payment`, `status`) VALUES (37,'CREDIT_CARD','PAYED');
INSERT INTO `order` (`id`, `payment`, `status`) VALUES (38,'CREDIT_CARD','PAYED');
INSERT INTO `order` (`id`, `payment`, `status`) VALUES (39,'CREDIT_CARD','PAYED');
INSERT INTO `order` (`id`, `payment`, `status`) VALUES (40,'CASH','PAYED');
INSERT INTO `order` (`id`, `payment`, `status`) VALUES (41,'CREDIT_CARD','PAYED');
INSERT INTO `order` (`id`, `payment`, `status`) VALUES (42,'CASH','PAYED');

DROP TABLE IF EXISTS `order_dishes`;
CREATE TABLE `order_dishes` (
  `order_id` int(11) NOT NULL,
  `dish_id` int(11) NOT NULL,
  KEY `order_id` (`order_id`),
  CONSTRAINT `order_dishes_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (34,60);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (34,61);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (34,62);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (34,60);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (34,61);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (34,62);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (34,60);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (34,61);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (34,62);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (35,58);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (35,62);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (36,58);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (36,59);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (37,59);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (38,60);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (39,60);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (40,60);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (41,58);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (41,59);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (42,58);
INSERT INTO `order_dishes` (`order_id`, `dish_id`) VALUES (42,59);
