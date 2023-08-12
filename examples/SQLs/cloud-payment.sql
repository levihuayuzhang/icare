/*
SQL software: Mysql@8.0
*/
-- CREATE SCHEMA cloud_payment;
-- USE cloud_payment;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `tb_payment`;
CREATE TABLE `tb_payment`  (
                               `pmID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'payment ID',
                               `ptID` bigint(20) NOT NULL COMMENT 'patient ID',
                               `docID` bigint(20) NOT NULL COMMENT 'doctor ID',
                               `pmTime` DATETIME COMMENT 'payment time',
                               PRIMARY KEY (`pmID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 109 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

/* add records */

INSERT INTO `tb_payment` VALUES (9301, 1, 1001, '2023-03-01 09:33:32');
INSERT INTO `tb_payment` VALUES (9302, 2, 1005, '2023-03-01 10:01:13');
INSERT INTO `tb_payment` VALUES (9303, 3, 1003, '2023-03-02 11:58:01');
INSERT INTO `tb_payment` VALUES (9304, 4, 1004, '2023-03-03 14:26:15');
INSERT INTO `tb_payment` VALUES (9305, 5, 1002, '2023-03-03 16:33:34');
INSERT INTO `tb_payment` VALUES (9306, 6, 1001, '2023-03-04 16:40:01');

SET FOREIGN_KEY_CHECKS = 1;
