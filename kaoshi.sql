/*
 Navicat Premium Data Transfer

 Source Server         : xhz
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : kaoshi

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 11/05/2024 10:20:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info`  (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '货品编号',
  `goods_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '货品类型（饮料、食品、洗漱、办公）',
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '货品名称',
  `goods_rent` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '货品售价',
  `goods_count` int(255) NOT NULL COMMENT '货品数量',
  `supplier` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '供货商',
  `telphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `goods_state` int(255) DEFAULT NULL COMMENT '上架状态（0未上架，1上架）',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_info
-- ----------------------------
INSERT INTO `goods_info` VALUES (1, '饮料', '康师傅绿茶', '2.5', 10, '康师傅', '15486849684', 1);
INSERT INTO `goods_info` VALUES (2, '饮料', '统一冰红茶', '2.5', 25, '统一', '15489627468', 1);
INSERT INTO `goods_info` VALUES (4, '洗漱', '清扬洗发水', '38', 20, '联合利华', '056448946867', 0);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登录名称',
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'zhangsan', '123', '15675879654');

SET FOREIGN_KEY_CHECKS = 1;
