/*
 Navicat MySQL Data Transfer

 Source Server         : book
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : fabricate

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 02/01/2019 17:10:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
SET NUM = 0;
-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `columns` tinyint(4) NULL DEFAULT 10,
  `deluser` tinyint(4) NULL DEFAULT 0,
  `altuser` tinyint(4) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES (1, 'admin', 'admin', 10, 0, 0);

-- ----------------------------
-- Table structure for usertb
-- ----------------------------
DROP TABLE IF EXISTS `usertb`;
CREATE TABLE `usertb`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `imgpath` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sign` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `sex` enum('男','女','保密') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '保密',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usertb
-- ----------------------------
INSERT INTO `usertb` VALUES (1, '123456@qq.com', '123456', '喝果汁的杯子', NULL, NULL, '2018-12-04', '男', NULL);
INSERT INTO `usertb` VALUES (2, '2134325@qq.com', 'runoob', 'haha', NULL, NULL, '2018-12-29', '男', NULL);
INSERT INTO `usertb` VALUES (4, '3w42', '345', '235', NULL, NULL, '2018-12-12', '女', NULL);
INSERT INTO `usertb` VALUES (6, '235', '5346', '235', NULL, NULL, '2018-12-03', '女', NULL);
INSERT INTO `usertb` VALUES (13, 'sdf', 'sdf', 'sdf', NULL, NULL, '2018-12-08', '男', NULL);
INSERT INTO `usertb` VALUES (14, '345234@qq.com', '3425', 'g', NULL, 'sdgert', '2018-12-23', '男', 'sdfa');
INSERT INTO `usertb` VALUES (15, '345', '234', '234', NULL, NULL, '2018-12-04', '男', NULL);
INSERT INTO `usertb` VALUES (16, 'czxfsad', 'sdf', 'sdf', NULL, NULL, '2018-12-14', '男', NULL);
INSERT INTO `usertb` VALUES (17, 'wer', 'sdf', 'sdf', NULL, NULL, '2018-12-26', '保密', NULL);
INSERT INTO `usertb` VALUES (21, 'xcv', 'xcv', 'x', NULL, NULL, '2018-12-08', '男', NULL);
INSERT INTO `usertb` VALUES (23, 'sfwe', '123456', '张三', NULL, '', '2019-01-07', '保密', '');
INSERT INTO `usertb` VALUES (24, '3254@qq.com', '234', 'sdfi', NULL, NULL, '2019-01-25', '保密', NULL);
INSERT INTO `usertb` VALUES (25, 'werwe', 'werqw', 'dsvsa', NULL, NULL, '2019-02-01', '保密', NULL);
INSERT INTO `usertb` VALUES (26, 'wqerqw', '345342', 'sdaf', NULL, NULL, '2019-01-17', '保密', NULL);
INSERT INTO `usertb` VALUES (27, '3425', '3245', 'brgh', NULL, NULL, '2019-01-02', '保密', NULL);
INSERT INTO `usertb` VALUES (28, 'sdaf', 'saer', 'rtreyh', NULL, NULL, '2019-01-19', '保密', NULL);
INSERT INTO `usertb` VALUES (29, 'wer234', 'sfa23', 'rthfghdf', NULL, NULL, '2019-06-02', '保密', NULL);
INSERT INTO `usertb` VALUES (30, '1591477969@hotmail.com', '345', '这是一个月黑风高的夜晚', NULL, '微软微软', '2019-01-24', '保密', '山大佛i是你的');
INSERT INTO `usertb` VALUES (31, '2352345@qq.com', '3452345', '3456456', NULL, NULL, '2018-12-31', '保密', NULL);
INSERT INTO `usertb` VALUES (32, '3452345', '3464256', '3642345', NULL, NULL, '2018-12-03', '保密', NULL);
INSERT INTO `usertb` VALUES (33, '32542534@qq.com', '35234534', '3452345', NULL, NULL, '2019-01-10', '保密', NULL);
INSERT INTO `usertb` VALUES (34, '325324@qq.com', '234125', '3462345', NULL, 'dgsfd', '2019-01-04', '保密', '11111111');
INSERT INTO `usertb` VALUES (35, '4356345@qq.com', '32451235', '2353245', NULL, 'sdfa', '2019-01-27', '保密', 'wertq');
INSERT INTO `usertb` VALUES (36, '4364536@qq.com', '4645363456', '4563456', NULL, 'aaaa', '2019-01-28', '保密', 'bbbbb');
INSERT INTO `usertb` VALUES (37, '345325@qq.com', '4352346', '3452345', NULL, NULL, '2019-01-17', '保密', NULL);
INSERT INTO `usertb` VALUES (40, 'fhwieuhr@qq.com', '2341234', '3452345', NULL, NULL, '2019-01-14', '保密', NULL);
INSERT INTO `usertb` VALUES (50, '346544556@qq.com', '45t63465456', '45634564536', NULL, NULL, '2019-01-04', '保密', NULL);
INSERT INTO `usertb` VALUES (51, 'ertw@sdf.com', '32534', '5432', '3245', '3245', '2018-12-26', '男', '3452');
INSERT INTO `usertb` VALUES (53, '345gre', '345', '3245', '346', 'awe', '2018-12-31', '保密', NULL);

SET FOREIGN_KEY_CHECKS = 1;
