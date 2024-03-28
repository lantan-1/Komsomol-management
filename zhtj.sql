/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : zhtj

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 28/03/2024 13:39:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `organization` int NULL DEFAULT NULL COMMENT '团组织序号',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '活动类型',
  `date` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '活动日期',
  `host` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '活动主持人',
  `place` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '活动地点',
  `content` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '活动内容',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_act_org`(`organization` ASC) USING BTREE,
  CONSTRAINT `fk_act_org` FOREIGN KEY (`organization`) REFERENCES `organization` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES (1, 1, '团支部会议', '2023-07-05', '六一', '思源119', '1.2020-2022级学生:7月17日(星期一）-9月3日（星期日)。\r\n2.2020-2022级学生:9月2日（星期六）、9月3日（星期日）报到注册，9月4日（星期一)正式上课。');
INSERT INTO `activity` VALUES (2, 2, '团支部会议', '2023-07-05', '六二', '思源119', '1.2020-2022级学生:7月17日(星期一）-9月3日（星期日)。\r\n2.2020-2022级学生:9月2日（星期六）、9月3日（星期日）报到注册，9月4日（星期一)正式上课。');
INSERT INTO `activity` VALUES (3, 3, '团支部会议', '2023-07-05', '六三', '思源119', '1.2020-2022级学生:7月17日(星期一）-9月3日（星期日)。\r\n2.2020-2022级学生:9月2日（星期六）、9月3日（星期日）报到注册，9月4日（星期一)正式上课。');
INSERT INTO `activity` VALUES (4, 4, '团支部会议', '2023-07-05', '六四', '思源119', '1.2020-2022级学生:7月17日(星期一）-9月3日（星期日)。\r\n2.2020-2022级学生:9月2日（星期六）、9月3日（星期日）报到注册，9月4日（星期一)正式上课。');
INSERT INTO `activity` VALUES (5, 5, '团支部会议', '2023-07-05', '六五', '思源119', '1.2020-2022级学生:7月17日(星期一）-9月3日（星期日)。\r\n2.2020-2022级学生:9月2日（星期六）、9月3日（星期日）报到注册，9月4日（星期一)正式上课。');
INSERT INTO `activity` VALUES (6, 6, '团支部会议', '2023-07-05', '六六', '思源119', '1.2020-2022级学生:7月17日(星期一）-9月3日（星期日)。\r\n2.2020-2022级学生:9月2日（星期六）、9月3日（星期日）报到注册，9月4日（星期一)正式上课。');
INSERT INTO `activity` VALUES (7, 7, '团支部会议', '2023-07-05', '六七', '思源119', '1.2020-2022级学生:7月17日(星期一）-9月3日（星期日)。\r\n2.2020-2022级学生:9月2日（星期六）、9月3日（星期日）报到注册，9月4日（星期一)正式上课。');

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '组织名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES (1, '2101班团支部');
INSERT INTO `organization` VALUES (2, '2102班团支部');
INSERT INTO `organization` VALUES (3, '2103班团支部');
INSERT INTO `organization` VALUES (4, '2104班团支部');
INSERT INTO `organization` VALUES (5, '2105班团支部');
INSERT INTO `organization` VALUES (6, '2106班团支部');
INSERT INTO `organization` VALUES (7, '2107班团支部');
INSERT INTO `organization` VALUES (8, '2108班团支部');
INSERT INTO `organization` VALUES (9, '2109班团支部');
INSERT INTO `organization` VALUES (10, '2110班团支部');
INSERT INTO `organization` VALUES (11, '2111班团支部');
INSERT INTO `organization` VALUES (12, '2112班团支部');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `organization` int NULL DEFAULT NULL COMMENT '团组织序号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `card` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证',
  `ethnic` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '民族',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机',
  `pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name` ASC) USING BTREE,
  INDEX `fk_user_org`(`organization` ASC) USING BTREE,
  CONSTRAINT `fk_user_org` FOREIGN KEY (`organization`) REFERENCES `organization` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 1, '六一', '100000000000000001', '汉族', '10000000001', '2101');
INSERT INTO `user` VALUES (2, 2, '六二', '100000000000000002', '汉族', '10000000002', '2102');
INSERT INTO `user` VALUES (3, 3, '六三', '100000000000000003', '汉族', '10000000003', '2103');
INSERT INTO `user` VALUES (4, 4, '六四', '100000000000000004', '汉族', '10000000004', '2104');
INSERT INTO `user` VALUES (5, 5, '六五', '100000000000000005', '汉族', '10000000005', '2105');
INSERT INTO `user` VALUES (6, 6, '六六', '100000000000000006', '汉族', '10000000006', '2106');
INSERT INTO `user` VALUES (7, 7, '六七', '100000000000000007', '汉族', '10000000007', '2107');

SET FOREIGN_KEY_CHECKS = 1;
