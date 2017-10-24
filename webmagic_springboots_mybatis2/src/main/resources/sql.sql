SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `dzsp_pipiupdown_explain`;
CREATE TABLE `dzsp_pipiupdown_explain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` varchar(32) NOT NULL,
  `rank_name` varchar(128) NOT NULL,
  `explain` text NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `dzsp_pipiupdown_info`;
CREATE TABLE `dzsp_pipiupdown_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(32) NOT NULL,
  `time` varchar(32) NOT NULL,
  `trade` varchar(32) NOT NULL,
  `price` double(32,3) NOT NULL,
  `unit` varchar(32) NOT NULL,
  `dayChg` varchar(32) NOT NULL,
  `monChg` varchar(32) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
