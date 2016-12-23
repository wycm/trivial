/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : gdms

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-07-08 09:28:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL,
  `degree_id` int(11) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `dateline` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stu_degree_id_fk` (`degree_id`) USING BTREE,
  KEY `comment_teacher_id_fk` (`teacher_id`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`degree_id`) REFERENCES `degree` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2', '39', '20', '资料( ^_^ )不错嘛！', '2016-07-04 20:19:05');

-- ----------------------------
-- Table structure for `degree`
-- ----------------------------
DROP TABLE IF EXISTS `degree`;
CREATE TABLE `degree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `explain` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `times` int(11) DEFAULT NULL,
  `dateline` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `degree_student_fk` (`student_id`) USING BTREE,
  CONSTRAINT `degree_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of degree
-- ----------------------------
INSERT INTO `degree` VALUES ('7', '52', 'sdfsdf', 'upload/1467602443991.dll', null, '2016-07-04 11:20:43');
INSERT INTO `degree` VALUES ('8', '52', '倒萨', 'upload/1467604064530.pak', null, '2016-07-04 11:47:44');
INSERT INTO `degree` VALUES ('9', '52', '士大夫似的', 'upload/1467615547649.exe', null, '2016-07-04 14:59:07');
INSERT INTO `degree` VALUES ('10', '52', '灰白', 'upload/1467621005823.docx', null, '2016-07-04 16:30:05');
INSERT INTO `degree` VALUES ('11', '52', '水电费', 'upload/1467621018772.11.3.js', null, '2016-07-04 16:30:18');
INSERT INTO `degree` VALUES ('12', '52', '', 'upload/1467621092296.docx', null, '2016-07-04 16:31:32');
INSERT INTO `degree` VALUES ('13', '52', '的说法是打发士大夫', 'upload/1467621114635.html', null, '2016-07-04 16:31:54');
INSERT INTO `degree` VALUES ('14', '52', '色粉', 'upload/1467621207199.cpp', null, '2016-07-04 16:33:27');
INSERT INTO `degree` VALUES ('15', '52', '111', 'upload/1467621228475.plg', null, '2016-07-04 16:33:48');
INSERT INTO `degree` VALUES ('16', '52', '222', 'upload/1467621237996.txt', null, '2016-07-04 16:33:58');
INSERT INTO `degree` VALUES ('17', '52', '4444', 'upload/1467621269149.ilk', null, '2016-07-04 16:34:29');
INSERT INTO `degree` VALUES ('18', '52', '55555', 'upload/1467621276131.pdb', null, '2016-07-04 16:34:36');
INSERT INTO `degree` VALUES ('19', '53', '统计学资料', 'upload/1467622979201.xls', null, '2016-07-04 17:02:59');
INSERT INTO `degree` VALUES ('20', '53', '就测试下你的数据库怎么样？', 'upload/1467633613741.zip', null, '2016-07-04 20:00:13');
INSERT INTO `degree` VALUES ('21', '55', '', 'upload/1467719033773.bin', null, '2016-07-05 19:43:53');
INSERT INTO `degree` VALUES ('22', '54', '', 'upload/1467720024372.doc', null, '2016-07-05 20:00:24');

-- ----------------------------
-- Table structure for `issue`
-- ----------------------------
DROP TABLE IF EXISTS `issue`;
CREATE TABLE `issue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(50) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_fk` (`user_id`) USING BTREE,
  CONSTRAINT `issue_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of issue
-- ----------------------------
INSERT INTO `issue` VALUES ('6', 'sdafasdf', 'asdfasdfasdf', '40');
INSERT INTO `issue` VALUES ('8', 'aaaaaaaaaa', 'asas', '40');
INSERT INTO `issue` VALUES ('10', '的发生的范斯的阿萨德法师打发士大夫父母可拉伸的魔法师店里发生了 阿斯达克了福建爱上  是打发士大夫', '阿士大夫士大夫', '40');
INSERT INTO `issue` VALUES ('11', 'sdfsdf', 'dfsafasf', '40');
INSERT INTO `issue` VALUES ('12', '是的发生的发生的', '的说法是', '40');
INSERT INTO `issue` VALUES ('13', '但是发士大夫撒旦法师的', '阿萨德法师打发士大夫', '40');
INSERT INTO `issue` VALUES ('14', '16161.40.', '地方师傅师傅玩儿去玩儿', '40');
INSERT INTO `issue` VALUES ('15', '苦逼爱上', '爱上', '40');
INSERT INTO `issue` VALUES ('16', '撒大大说的', '啊实打实大师', '41');
INSERT INTO `issue` VALUES ('17', '基于AN算法的量子遗传模型', '根据合理情况划分初始状!', '39');
INSERT INTO `issue` VALUES ('18', 'UML软件架构', '张立人老师任课', '39');
INSERT INTO `issue` VALUES ('20', '11', '院长', '41');
INSERT INTO `issue` VALUES ('21', '大鱼海棠', '大鱼的翅膀', '40');
INSERT INTO `issue` VALUES ('22', '1111', '11111', '40');
INSERT INTO `issue` VALUES ('23', 'hello kitty!', '', '40');
INSERT INTO `issue` VALUES ('24', '试论杨鑫为什么这样帅？', '一定要详细阐述个人观点，最好引经据典！', '39');
INSERT INTO `issue` VALUES ('29', '我是最帅的', '不服来战', '40');
INSERT INTO `issue` VALUES ('31', 'test', 'test', '41');
INSERT INTO `issue` VALUES ('32', '试问小兵为啥有点呆！', '请列举生活实例 逐一证明自己的观点！', '39');
INSERT INTO `issue` VALUES ('33', '目的是啥子', '~~', '40');
INSERT INTO `issue` VALUES ('34', '测试1', '测试啊', '41');
INSERT INTO `issue` VALUES ('35', '杨鑫是傻逼吗？', '简要描述', '58');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `recv_id` int(11) DEFAULT NULL,
  `from_id` int(11) DEFAULT NULL,
  `note` text,
  `dateline` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `recvier` (`recv_id`) USING BTREE,
  KEY `from_user` (`from_id`) USING BTREE,
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`from_id`) REFERENCES `user` (`id`),
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`recv_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('6', '52', '40', '哈哈！', '2016-07-04 14:25:31', '0');
INSERT INTO `message` VALUES ('7', '40', '52', 'df  dsfasdfasdfsd', '2016-07-04 14:26:28', '1');
INSERT INTO `message` VALUES ('8', '52', '40', 'sb', '2016-07-04 14:26:42', '0');
INSERT INTO `message` VALUES ('9', '40', '52', 'sdfasdfasdfasdfasdfasdfasdfasdf', '2016-07-04 14:26:53', '1');
INSERT INTO `message` VALUES ('10', '40', '52', 'fgdfgdfgsdf', '2016-07-04 14:29:12', '1');
INSERT INTO `message` VALUES ('11', '52', '40', 'bug', '2016-07-04 14:29:43', '0');
INSERT INTO `message` VALUES ('12', '40', '52', 'fgfgdfssgdfg', '2016-07-04 14:29:54', '1');
INSERT INTO `message` VALUES ('13', '40', '52', '····························', '2016-07-04 15:35:50', '1');
INSERT INTO `message` VALUES ('14', '53', '39', 'hello! i am your teacher', '2016-07-04 16:59:32', '1');
INSERT INTO `message` VALUES ('15', '39', '53', 'hello! teacher!', '2016-07-04 17:04:19', '1');
INSERT INTO `message` VALUES ('16', '53', '39', '1', '2016-07-04 17:04:51', '1');
INSERT INTO `message` VALUES ('17', '53', '39', '2', '2016-07-04 17:04:58', '1');
INSERT INTO `message` VALUES ('18', '53', '39', '3', '2016-07-04 17:05:06', '1');
INSERT INTO `message` VALUES ('19', '53', '39', '4', '2016-07-04 17:05:11', '1');
INSERT INTO `message` VALUES ('20', '53', '39', '5', '2016-07-04 17:05:17', '1');
INSERT INTO `message` VALUES ('21', '53', '39', '6', '2016-07-04 17:05:23', '1');
INSERT INTO `message` VALUES ('22', '53', '39', '7', '2016-07-04 17:05:29', '1');
INSERT INTO `message` VALUES ('23', '53', '39', '8', '2016-07-04 17:05:34', '1');
INSERT INTO `message` VALUES ('24', '53', '39', '9', '2016-07-04 17:05:40', '1');
INSERT INTO `message` VALUES ('25', '40', '52', '打发士大夫', '2016-07-04 17:06:46', '1');
INSERT INTO `message` VALUES ('26', '39', '53', 'j', '2016-07-04 17:06:46', '1');
INSERT INTO `message` VALUES ('27', '39', '53', '1', '2016-07-04 17:06:53', '1');
INSERT INTO `message` VALUES ('28', '39', '53', '2', '2016-07-04 17:06:59', '1');
INSERT INTO `message` VALUES ('29', '39', '53', '3', '2016-07-04 17:07:04', '1');
INSERT INTO `message` VALUES ('30', '39', '53', '4', '2016-07-04 17:07:11', '1');
INSERT INTO `message` VALUES ('31', '39', '53', '5', '2016-07-04 17:07:18', '1');
INSERT INTO `message` VALUES ('32', '39', '53', '6', '2016-07-04 17:07:25', '1');
INSERT INTO `message` VALUES ('33', '39', '53', '7', '2016-07-04 17:07:31', '1');
INSERT INTO `message` VALUES ('34', '39', '53', '8', '2016-07-04 17:07:38', '1');
INSERT INTO `message` VALUES ('35', '39', '53', '9', '2016-07-04 17:07:43', '1');
INSERT INTO `message` VALUES ('36', '39', '53', '10', '2016-07-04 17:08:02', '1');
INSERT INTO `message` VALUES ('37', '40', '52', 'sb', '2016-07-04 17:08:46', '1');
INSERT INTO `message` VALUES ('38', '40', '52', '0000000000', '2016-07-04 17:10:30', '1');
INSERT INTO `message` VALUES ('39', '40', '52', '2222222222222222222222222', '2016-07-04 17:12:41', '1');
INSERT INTO `message` VALUES ('40', '39', '53', '132135465', '2016-07-04 17:19:53', '1');
INSERT INTO `message` VALUES ('41', '39', '53', '老师，快来看看这个大系统！', '2016-07-04 19:57:46', '1');
INSERT INTO `message` VALUES ('42', '39', '53', '张树伟是傻逼', '2016-07-04 20:17:49', '1');
INSERT INTO `message` VALUES ('43', '53', '39', '你好！ 王亚兰！', '2016-07-04 20:18:43', '1');
INSERT INTO `message` VALUES ('44', '53', '39', '测试', '2016-07-05 19:56:28', '1');
INSERT INTO `message` VALUES ('45', '53', '39', '你好', '2016-07-05 20:09:37', '1');
INSERT INTO `message` VALUES ('46', '53', '39', '子项目南长街阿斯就是女模那个哦儿女卡列尼娜选出来考vnknv', '2016-07-05 20:10:19', '1');
INSERT INTO `message` VALUES ('47', '39', '53', '费用投入费用的', '2016-07-05 20:11:31', '1');
INSERT INTO `message` VALUES ('48', '39', '37', '反对的是', '2016-07-06 10:59:55', '1');
INSERT INTO `message` VALUES ('49', '39', '37', '魏老师', '2016-07-06 11:18:02', '1');
INSERT INTO `message` VALUES ('50', '39', '37', '你到底想干嘛', '2016-07-06 14:28:44', '1');
INSERT INTO `message` VALUES ('51', '39', '53', 'sdasdasdas', '2016-07-07 10:58:31', '1');
INSERT INTO `message` VALUES ('52', '53', '39', '6666', '2016-07-07 10:58:50', '1');
INSERT INTO `message` VALUES ('53', '39', '37', '你就是个都比', '2016-07-07 15:25:54', '1');

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(50) NOT NULL,
  `text` text NOT NULL,
  `type` int(1) DEFAULT NULL,
  `author` int(11) DEFAULT NULL,
  `dateline` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `author_fk` (`author`) USING BTREE,
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`author`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('6', 'wo sh dsfasd', '<p style=\"text-align: right;\">sdfasdfsdasdfasdfasdfasdfsdf dfasd</p>', '3', '38', '2016-07-04 11:22:56');
INSERT INTO `notice` VALUES ('7', '论万磁王和x教授的正义论', '<p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">浔阳江头夜送客，枫叶荻(dí)花秋瑟瑟。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">主人下马客在船，举酒欲饮无管弦。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">醉不成欢惨将别，别时茫茫江浸月。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">忽闻水上琵琶声，主人忘归客不发。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">寻声暗问弹者谁？琵琶声停欲语迟。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">移船相近邀相见，添酒回灯重开宴。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">千呼万唤始出来，犹抱琵琶半遮面。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">转轴拨弦三两声，未成曲调先有情。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">弦弦掩抑声声思，似诉平生不得志。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">低眉信手续续弹，说尽心中无限事。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">轻拢慢捻抹复挑，初为霓裳后六幺。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">大弦嘈嘈如急雨，小弦切切如私语。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">嘈嘈切切错杂弹，大珠小珠落玉盘。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">间关莺语花底滑，幽咽泉流冰下难。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">冰泉冷涩弦凝绝，凝绝不通声暂歇。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">别有幽愁暗恨生，<a target=\"_blank\" href=\"http://baike.so.com/doc/5422510.html\" style=\"color: rgb(19, 110, 194); text-decoration: none;\">此时无声胜有声</a>。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">银瓶乍破水浆迸，铁骑突出刀枪鸣。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">曲终收拨当心画，四弦一声如裂帛。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">东船西舫悄无言，唯见江心秋月白。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">沉吟放拨插弦中，整顿衣裳起敛容。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">自言本是京城女，家在虾蟆陵下住。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">十三学得琵琶成，名属教坊第一部。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">曲罢曾教善才服，妆成每被秋娘妒。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">五陵年少争缠头，一曲红绡不知数。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">钿头银篦击节碎，血色罗裙翻酒污。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">今年欢笑复明年，秋月春风等闲度。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">弟走从军阿姨死，暮去朝来颜色故。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">门前冷落鞍马稀，老大嫁作商人妇。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">商人重利轻别离，前月浮梁买茶去。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">去来江口守空船，绕船月明江水寒。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">夜深忽梦少年事，梦啼妆泪红阑干。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">我闻琵琶已叹息，又闻此语重唧唧。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\"><a target=\"_blank\" href=\"http://baike.so.com/doc/5429436.html\" style=\"color: rgb(19, 110, 194); text-decoration: none;\">同是天涯沦落人</a>，<a target=\"_blank\" href=\"http://baike.so.com/doc/5410421.html\" style=\"color: rgb(19, 110, 194); text-decoration: none;\">相逢何必曾相识</a>！</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">我从去年辞帝京，谪居卧病浔阳城。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">浔阳地僻无音乐，终岁不闻丝竹声。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">住近湓江地低湿，黄芦苦竹绕宅生。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">其间旦暮闻何物？杜鹃啼血猿哀鸣。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">春江花朝秋月夜，往往取酒还独倾。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">岂无山歌与村笛？呕哑嘲哳难为听。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">今夜闻君<a target=\"_blank\" href=\"http://baike.so.com/doc/50573.html\" style=\"color: rgb(19, 110, 194); text-decoration: none;\">琵琶语</a>，如听仙乐耳暂明。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">莫辞更坐弹一曲，为君翻作琵琶行。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">感我此言良久立，却坐促弦弦转急。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">凄凄不似向前声，满座重闻皆掩泣。</p><p style=\"margin-top: 0px; margin-bottom: 15px; padding: 0px; line-height: 24px; text-indent: 2em; zoom: 1; color: rgb(51, 51, 51); font-family: arial, sans-serif; font-size: 14px; white-space: normal; widows: 1; background-color: rgb(255, 255, 255);\">座中泣下谁最多？江州司马青衫湿。</p><p><br/></p>', '3', '38', '2016-07-04 15:02:01');
INSERT INTO `notice` VALUES ('32', '我最亲爱的，你过得怎么样', '<p>没我的日子，你别来无恙</p>', '3', '38', '2016-07-05 11:43:28');
INSERT INTO `notice` VALUES ('47', '论自贡地区下雨对我们的印象', '<p><span style=\"font-size: 36px;\">点开有惊喜</span><span style=\"font-size: 36px;\"></span></p>', '3', '38', '2016-07-06 20:38:32');
INSERT INTO `notice` VALUES ('54', '2016年关于计算机学院2014级学生办理暑假假期留校手续的通知', '<p style=\"text-indent: 2em;\"><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办</span></p><p style=\"text-indent: 2em;\"><span style=\"text-indent: 32px;\">理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通</span></p><p style=\"text-indent: 2em;\"><span style=\"text-indent: 32px;\">知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生</span></p><p style=\"text-indent: 2em;\"><span style=\"text-indent: 32px;\">办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><span style=\"text-indent: 32px;\">2016年关于计算机学院2014级学生办理暑假假期留校手续的通知</span><img src=\"../../../gdms/upload/image/20160707/1467860301057084534.jpg\" title=\"1467860301057084534.jpg\" alt=\"3041938_091451352185_2[1].jpg\"/></p>', '1', '39', '2016-07-07 10:59:05');
INSERT INTO `notice` VALUES ('57', '我是大农网', '<p>阿斯蒂芬</p>', '1', '40', '2016-07-07 11:31:05');
INSERT INTO `notice` VALUES ('58', '当初是你要分开，分开就分开', '<p style=\"text-align: center;\"><span style=\"font-size: 36px;\">现在又要用真爱，把我换回来</span></p>', '2', '40', '2016-07-07 15:05:03');
INSERT INTO `notice` VALUES ('59', '爱情不是你想买，想买就能买', '<p>爱疯</p>', '1', '40', '2016-07-07 15:05:42');
INSERT INTO `notice` VALUES ('60', '真的哇', '<p>真的</p>', '2', '40', '2016-07-07 15:05:58');

-- ----------------------------
-- Table structure for `stu_tutor`
-- ----------------------------
DROP TABLE IF EXISTS `stu_tutor`;
CREATE TABLE `stu_tutor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_fk` (`teacher_id`) USING BTREE,
  KEY `student_fk` (`student_id`) USING BTREE,
  CONSTRAINT `stu_tutor_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`),
  CONSTRAINT `stu_tutor_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_tutor
-- ----------------------------
INSERT INTO `stu_tutor` VALUES ('4', '37', '39');
INSERT INTO `stu_tutor` VALUES ('5', '52', '39');
INSERT INTO `stu_tutor` VALUES ('6', '53', '39');
INSERT INTO `stu_tutor` VALUES ('7', '54', '39');
INSERT INTO `stu_tutor` VALUES ('8', '57', '58');

-- ----------------------------
-- Table structure for `tutor_stu`
-- ----------------------------
DROP TABLE IF EXISTS `tutor_stu`;
CREATE TABLE `tutor_stu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `f_teacher` (`student_id`),
  KEY `f_student` (`teacher_id`),
  CONSTRAINT `f_student` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`),
  CONSTRAINT `f_teacher` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tutor_stu
-- ----------------------------
INSERT INTO `tutor_stu` VALUES ('13', '52', '40');
INSERT INTO `tutor_stu` VALUES ('14', '37', '39');
INSERT INTO `tutor_stu` VALUES ('19', '53', '39');
INSERT INTO `tutor_stu` VALUES ('20', '54', '40');
INSERT INTO `tutor_stu` VALUES ('22', '57', '58');
INSERT INTO `tutor_stu` VALUES ('23', '56', '59');
INSERT INTO `tutor_stu` VALUES ('24', '55', '59');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `work_id` varchar(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `grade` int(255) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `jobtitle` varchar(10) DEFAULT NULL,
  `amount` int(10) DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  `issue_id` int(10) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `user_class` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `work_id_k` (`work_id`) USING BTREE,
  KEY `issue_fk` (`issue_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`issue_id`) REFERENCES `issue` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('37', '13101020321', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '我就是个锤子', '2013', '严建国', null, null, '8', '17', '13088280860', '卓越');
INSERT INTO `user` VALUES ('38', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '', '院长', null, '院长', '讲师助手', '23', '4', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('39', '123456', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '导师', null, '韦老师', '讲师', '10', '1', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('40', '123457', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '测试老师，导师和系主任', null, '张老师', '教授', '10', '3', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('41', '123458', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '测试老师，导师和系主任和院长', null, '王老师', '教授', '10', '7', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('42', '123459', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '测试老师，导师', null, '王老师', '教授', '10', '1', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('52', '13101020324', '5050186f871e0a60412831870820e168', '软件工程', '帅哥', '2013', '张起灵', null, null, '8', '33', '13088280860', '卓越');
INSERT INTO `user` VALUES ('53', '12345678', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '学生', '2013', '刘晓红', '', null, '8', '18', '13088280860', '卓越');
INSERT INTO `user` VALUES ('54', '13101025362', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '测试', '2013', '王亚兰', null, null, '8', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('55', '13101020329', '3df80a2ae157d4bb7eb22c2a5951d7ea', '软件工程', '水电费所发生的', '2013', '刘晓红', null, null, '8', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('56', '12345679', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '水电费所发生的', '2013', '老王', '', null, '8', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('57', '007', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '理工内马尔', '2013', '黄万亮', null, null, '8', '35', '13088280860', '卓越');
INSERT INTO `user` VALUES ('58', '008', 'e10adc3949ba59abbe56e057f20f883e', '电子商务', '诺贝尔和平奖获得者', null, '杨鑫', '教授', '10', '1', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('59', '2345', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '1967年3月出生，湖南武冈人，九三学社社员，工学博士，教授。1995年7月毕业于四川大学应用数学专业，2001年6月获得重庆大学机械制造及自动化专业博士学位。曾任四川轻化工学院计算机科学系副主任，四川理工学院计算机科学系系副主任，现任四川理工学院科技处处长，九三学社自贡市市委委员，自贡市政协委员。', null, '彭龑', '教授', '12', '1', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('60', '2346', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '2002年毕业于四川农业大学计算机专业，获学士学位\n\n2009年毕业于电子科技大学软件系统理论专业，获硕士学位', null, '梁兴建', '副教授', '16', '1', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('61', '2347', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '1993-1997 四川理工学院 电子工程系 获得自动化专业学士学位 2003-2006 电子科技大学 计算机学院 获得计算机应用专业硕士学位', null, '何海涛', '副教授', '15', '1', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('62', '2348', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '是一个好老师', null, '袁超', '讲师助手', '12', '1', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('63', '2349', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '工学硕士，2009.12，电子科技大学，计算机应用技术。', null, '蓝集明', '副教授', '12', '1', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('64', '2350', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '1984-1988 北京农业大学应用物理专业毕业，学士 2004-2007 重庆大学计算机应用技术，工学硕士', null, '陈年', '副教授', '13', '1', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('65', '2351', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '1994-1998 武汉大学本科  2001-2204 西南交通大学硕士研究生', null, '张立人', '讲师', '14', '1', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('66', '2352', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '好老师', null, '欧阳俊林', '讲师', '12', '1', null, '13088280860', '卓越');
INSERT INTO `user` VALUES ('67', '2353', 'e10adc3949ba59abbe56e057f20f883e', '软件工程', '毕业于西南石油大学', null, '贺全兵', '讲师', '12', '1', null, '13088280860', '卓越');
