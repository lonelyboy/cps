/*
Navicat MySQL Data Transfer

Source Server         : localMysql
Source Server Version : 50087
Source Host           : localhost:3306
Source Database       : cps

Target Server Type    : MYSQL
Target Server Version : 50087
File Encoding         : 65001

Date: 2016-09-27 23:00:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_ssq`
-- ----------------------------
DROP TABLE IF EXISTS `t_ssq`;
CREATE TABLE `t_ssq` (
  `n_h1` int(8) NOT NULL default '0',
  `n_h2` int(8) default NULL,
  `n_h3` int(8) default NULL,
  `n_h4` int(8) default NULL,
  `n_h5` int(8) default NULL,
  `n_h6` int(8) default NULL,
  `n_ydjsl` int(11) default NULL,
  `dl_ydjje` double default NULL,
  `dl_jc` double default NULL,
  `n_ljsl` int(11) default NULL,
  `dl_ljje` double default NULL,
  `n_wdjsl` int(11) default NULL,
  `dl_wdjje` double default NULL,
  `n_sidjsl` int(11) default NULL,
  `dl_sidjje` double default NULL,
  `n_sdjsl` int(11) default NULL,
  `n_b1` int(8) default NULL,
  `dl_sdjje` double default NULL,
  `n_edjsl` int(11) default NULL,
  `dl_edjje` double default NULL,
  `d_kjsj` date default NULL,
  PRIMARY KEY  (`n_h1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ssq
-- ----------------------------
