/*
Navicat MySQL Data Transfer

Source Server         : LocalMysql
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : bomber

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-11-01 23:22:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for source
-- ----------------------------
DROP TABLE IF EXISTS `source`;
CREATE TABLE `source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `time_interval` int(11) NOT NULL COMMENT '时间间隔（单位：秒）',
  `req_val` varchar(255) NOT NULL COMMENT '请求参数json格式串',
  `req_method` varchar(255) DEFAULT NULL COMMENT '请求方法，一般为post或get',
  `add_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `site_name` varchar(255) DEFAULT NULL COMMENT '站点名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of source
-- ----------------------------
INSERT INTO `source` (id, url, time_interval, req_method, req_val, site_name) VALUES
(1, 'https://www.itouzi.com/apiService/phone/getSmsVcode', '60', '{\"phone\": \"${phoneNum}\",\"voice\": \"false\",\"valicode\": \"\"}', 'post', '爱投资'),
(2, 'http://www.billionsfinance.cn/index.php?m=content&c=index&a=sms_define&mobile=${phoneNum}', 120, 'get', '', '佰仟金融'),
(3, 'http://h5.faxindai.com:8020/fxd-esb/esb/common/sendSMS.jhtml', 60, 'post', '{\"mobile_phone_\":\"${phoneNum}\",\"flag\":\"MSG_REG_\"}', '发薪贷'),
(4, 'http://www.51talk.com/ajax/sendReserveCheckCode', 60, 'post', '{\"user_mobile\":\"${phoneNum}\",\"vcode\":\"${vcode}\"}', '51talk');

alter table source add vcode_id int(11) DEFAULT NULL COMMENT '验证码';
alter table source add res_success varchar(255) DEFAULT NULL COMMENT 'response成功 一般为json格式串';
alter table source add all_res varchar(255) DEFAULT NULL COMMENT '出现的所有response 格式为数组';
alter table source add res_success varchar(255) DEFAULT NULL COMMENT 'response成功 一般为json格式串';
alter table source add status tinyint(4) DEFAULT 1 COMMENT '是否可用，0 不可用，1 可用';

UPDATE source SET status = 0 WHERE id = 4;
--vcode表
CREATE TABLE `vcode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `add_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `vcode_type` int(11) DEFAULT NULL COMMENT '验证码识别平台类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
INSERT INTO `vcode` (id, url) VALUES
(1, 'http://www.51talk.com/user/verify.php');