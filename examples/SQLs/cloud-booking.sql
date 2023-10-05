/*
SQL software: Mysql@8.0
*/
-- CREATE SCHEMA cloud_booking;
-- USE cloud_booking;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `tb_booking`;
CREATE TABLE `tb_booking`  (
                              `bkID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'booking ID',
#                               `bkDate` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'booking date',
                              `bkDate` DATE COMMENT 'booking date',
                              `bkSlot` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'booking slot',
                              `docID` bigint(20) NOT NULL COMMENT 'doctor ID',
                              `ptID` bigint(20) NOT NULL COMMENT 'patient ID',
                              PRIMARY KEY (`bkID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 109 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

/* add records */

INSERT INTO `tb_booking` VALUES (901, '2023-03-01', 1, 1001, 1);
INSERT INTO `tb_booking` VALUES (902, '2023-03-01', 2, 1005, 3);
INSERT INTO `tb_booking` VALUES (903, '2023-03-02', 3, 1003, 6);
INSERT INTO `tb_booking` VALUES (904, '2023-03-03', 4, 1004, 5);
INSERT INTO `tb_booking` VALUES (905, '2023-03-03', 5, 1002, 4);
INSERT INTO `tb_booking` VALUES (906, '2023-03-04', 6, 1001, 2);

SET FOREIGN_KEY_CHECKS = 1;
