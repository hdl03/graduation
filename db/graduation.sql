/*
Navicat MySQL Data Transfer

Source Server         : graduation
Source Server Version : 50621
Source Host           : 119.23.232.141:3306
Source Database       : graduation

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-05-18 20:12:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `guide_order`
-- ----------------------------
DROP TABLE IF EXISTS `guide_order`;
CREATE TABLE `guide_order` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(11) DEFAULT NULL COMMENT '创建者',
  `updated_at` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` varchar(11) DEFAULT NULL COMMENT '修改者',
  `is_delete` bit(1) DEFAULT NULL COMMENT '是否删除',
  `version` bigint(10) DEFAULT NULL COMMENT '乐观锁',
  `send_no` varchar(32) DEFAULT NULL COMMENT '发帖者',
  `recevier_no` varchar(32) DEFAULT NULL COMMENT '接受者',
  `status` int(11) DEFAULT NULL COMMENT '订单状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='学霸订单表';

-- ----------------------------
-- Records of guide_order
-- ----------------------------

-- ----------------------------
-- Table structure for `guide_task`
-- ----------------------------
DROP TABLE IF EXISTS `guide_task`;
CREATE TABLE `guide_task` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(11) DEFAULT NULL COMMENT '创建者',
  `updated_at` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` varchar(11) DEFAULT NULL COMMENT '修改者',
  `is_delete` bit(1) DEFAULT NULL COMMENT '是否删除',
  `version` bigint(10) DEFAULT NULL COMMENT '乐观锁',
  `task_no` varchar(32) DEFAULT NULL COMMENT '帖子编号',
  `task_title` varchar(1024) DEFAULT NULL COMMENT '发帖标题',
  `user_no` varchar(32) DEFAULT NULL COMMENT '发帖人',
  `tag` varchar(256) DEFAULT NULL COMMENT '标签（显示归属哪类）已逗号分隔',
  `task_content` longtext COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='学霸发帖表';

-- ----------------------------
-- Records of guide_task
-- ----------------------------

-- ----------------------------
-- Table structure for `help_order`
-- ----------------------------
DROP TABLE IF EXISTS `help_order`;
CREATE TABLE `help_order` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(11) DEFAULT NULL COMMENT '创建者',
  `updated_at` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` varchar(11) DEFAULT NULL COMMENT '修改者',
  `is_delete` bit(1) DEFAULT NULL COMMENT '是否删除',
  `version` bigint(10) DEFAULT NULL COMMENT '乐观锁',
  `send_no` varchar(32) DEFAULT NULL COMMENT '发帖人编号',
  `recevier_no` varchar(32) DEFAULT NULL COMMENT '接收者编号',
  `status` int(11) DEFAULT '0' COMMENT '订单状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='学渣订单表';

-- ----------------------------
-- Records of help_order
-- ----------------------------

-- ----------------------------
-- Table structure for `help_task`
-- ----------------------------
DROP TABLE IF EXISTS `help_task`;
CREATE TABLE `help_task` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(11) DEFAULT NULL COMMENT '创建者',
  `updated_at` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` varchar(11) DEFAULT NULL COMMENT '修改者',
  `is_delete` bit(1) DEFAULT NULL COMMENT '是否删除',
  `version` bigint(10) DEFAULT NULL COMMENT '乐观锁',
  `task_no` varchar(32) DEFAULT '' COMMENT '帖子编号',
  `task_title` varchar(1024) DEFAULT NULL COMMENT '帖子标题',
  `task_content` longtext COMMENT '内容',
  `user_no` varchar(32) DEFAULT NULL COMMENT '发帖人',
  `tag` varchar(256) DEFAULT NULL COMMENT '标签（显示归属哪类）已逗号分隔',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='学渣发帖表';

-- ----------------------------
-- Records of help_task
-- ----------------------------

-- ----------------------------
-- Table structure for `order_comment`
-- ----------------------------
DROP TABLE IF EXISTS `order_comment`;
CREATE TABLE `order_comment` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(11) DEFAULT NULL COMMENT '创建者',
  `updated_at` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` varchar(11) DEFAULT NULL COMMENT '修改者',
  `is_delete` bit(1) DEFAULT NULL COMMENT '是否删除',
  `version` bigint(10) DEFAULT NULL COMMENT '乐观锁',
  `comment_no` varchar(32) DEFAULT NULL COMMENT '评论编号',
  `comment_user_no` varchar(32) DEFAULT NULL COMMENT '评论者',
  `order_type` int(11) DEFAULT NULL COMMENT '订单类型',
  `score` decimal(10,0) DEFAULT NULL COMMENT '分数',
  `comment_time` datetime DEFAULT NULL COMMENT '评论时间',
  `recevier_user_no` varchar(32) DEFAULT NULL COMMENT '被评论者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='订单评论表';

-- ----------------------------
-- Records of order_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(11) DEFAULT NULL COMMENT '创建者',
  `updated_at` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` varchar(11) DEFAULT NULL COMMENT '修改者',
  `is_delete` bit(1) DEFAULT NULL COMMENT '是否删除',
  `user_no` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `mobile_no` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `province` varchar(32) DEFAULT NULL COMMENT '省',
  `city` varchar(32) DEFAULT NULL COMMENT '市',
  `address` varchar(64) DEFAULT NULL COMMENT '详细地址',
  `school` varchar(128) DEFAULT NULL COMMENT '学校',
  `major` varchar(64) DEFAULT NULL COMMENT '专业',
  `version` bigint(10) DEFAULT NULL COMMENT '乐观锁',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('8', '2017-05-06 07:32:17', '1', null, null, '', 'b5ef5309a2f241babf003c9dce04c93d', '学生', '123456', '12345678911', '上海', '浦东', '唐镇', '华大', '信息', null);
INSERT INTO `user` VALUES ('11', '2017-05-07 11:17:46', '1', null, null, '', '96bdadd30abb43e5bdf6ff081437b4c6', null, '123456', '12345678921', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('12', '2017-05-18 09:30:48', '1', null, null, '', 'd200e3ba5488439eaec9c24bce4c7232', 'hdl', 'e10adc3949ba59abbe56e057f20f883e', '15161507305', '江西', '上饶', '王家村', '东华理工', '信计', '0');
INSERT INTO `user` VALUES ('13', '2017-05-18 14:07:44', '1', null, null, '', '430c5a5711f44534ba9b6c41ddc101d2', 'hdl', 'e10adc3949ba59abbe56e057f20f883e', '18161507305', '江西', '上饶', '王家村', '东华理工', '信计', '0');
INSERT INTO `user` VALUES ('14', '2017-05-18 15:14:25', '000000', null, null, '', 'd2316bf4ea1244e78537da6dcb7663f0', 'hdl', 'e10adc3949ba59abbe56e057f20f883e', '17161507305', '江西', '上饶', '王家村', '东华理工', '信计', '0');

-- ----------------------------
-- Table structure for `user_detail`
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(11) DEFAULT NULL COMMENT '创建者',
  `updated_at` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` varchar(11) DEFAULT NULL COMMENT '修改者',
  `is_delete` bit(1) DEFAULT NULL COMMENT '是否删除',
  `version` bigint(10) DEFAULT NULL COMMENT '乐观锁',
  `photo` longblob COMMENT '图片',
  `skill` varchar(256) DEFAULT NULL COMMENT '技能',
  `introduction` text COMMENT '介绍',
  `total_task` int(11) DEFAULT NULL COMMENT '总共成交数',
  `avg_score` decimal(10,0) DEFAULT NULL COMMENT '平均分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='用户表详情表';

-- ----------------------------
-- Records of user_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `user_token`
-- ----------------------------
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(60) DEFAULT NULL COMMENT '创建者',
  `is_delete` bit(1) DEFAULT NULL COMMENT '是否删除',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(60) DEFAULT NULL COMMENT '更新者',
  `version` int(11) DEFAULT NULL,
  `expire_time` bigint(20) DEFAULT NULL COMMENT '过期时间',
  `last_time` datetime DEFAULT NULL COMMENT '上次更新时间',
  `token` varchar(64) DEFAULT NULL COMMENT 'token 信息',
  `user_no` varchar(64) DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1118 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_token
-- ----------------------------
INSERT INTO `user_token` VALUES ('1114', null, null, '', null, null, null, '1495087921631', '2017-05-18 14:07:02', '8eb2d3b7f1db40428bd022ea26ecb492', 'd200e3ba5488439eaec9c24bce4c7232');
INSERT INTO `user_token` VALUES ('1117', null, null, '', '2017-05-18 20:08:32', '000000', '0', '1495109612273', '2017-05-18 20:08:32', '8052a5bef1774b86ae12528bac614d7a', '430c5a5711f44534ba9b6c41ddc101d2');
