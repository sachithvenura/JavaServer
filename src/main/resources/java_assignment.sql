/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 100121
Source Host           : localhost:3306
Source Database       : java_assignment

Target Server Type    : MYSQL
Target Server Version : 100121
File Encoding         : 65001

Date: 2017-06-15 08:39:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cities
-- ----------------------------
DROP TABLE IF EXISTS `cities`;
CREATE TABLE `cities` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cities
-- ----------------------------
INSERT INTO `cities` VALUES ('1', 'Lavinia');
INSERT INTO `cities` VALUES ('5', 'Galle Road');
INSERT INTO `cities` VALUES ('6', 'Colombo');
INSERT INTO `cities` VALUES ('7', 'Baththaramulla');
INSERT INTO `cities` VALUES ('8', 'Kollupity');

-- ----------------------------
-- Table structure for hotels
-- ----------------------------
DROP TABLE IF EXISTS `hotels`;
CREATE TABLE `hotels` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(45) DEFAULT NULL,
  `hotel_address` varchar(45) DEFAULT NULL,
  `city_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_hotels_cities_idx` (`city_id`),
  CONSTRAINT `fk_hotels_cities` FOREIGN KEY (`city_id`) REFERENCES `cities` (`city_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotels
-- ----------------------------
INSERT INTO `hotels` VALUES ('1', '\"Domino\'s\"', '\"Colombo\"', '5');
INSERT INTO `hotels` VALUES ('20', '\"Mt Lavinia\"', '\"Colombo\"', '1');
INSERT INTO `hotels` VALUES ('21', '\"Galadari\"', '\"Colombo\"', '1');
INSERT INTO `hotels` VALUES ('22', '\"GalleFace\"', '\"Bambalapity\"', '5');
INSERT INTO `hotels` VALUES ('23', '\"Shangrila\"', '\"Kotte\"', '6');
