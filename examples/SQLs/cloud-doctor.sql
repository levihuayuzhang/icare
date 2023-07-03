/*
SQL software: Mysql@8.0
*/
-- CREATE SCHEMA cloud_doctor;
-- USE cloud_doctor;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `tb_doctor`;
CREATE TABLE `tb_doctor`  (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT,
                               `docName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'doctor name',
                               `phoneNum` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'doctor phone number',
                               `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'department that the doctor belong to in the hospital',
                               PRIMARY KEY (`id`) USING BTREE,
                               UNIQUE INDEX `docName`(`docName`) USING BTREE
                            ) ENGINE = InnoDB AUTO_INCREMENT = 109 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

/* add records */
/* using my favorite singer for doctor name */
/* for testing purpose, the phone number start from 7 */

INSERT INTO `tb_doctor` VALUES (1001, 'Dr. D.R.E','71111 111111', 'internal medicine center');
INSERT INTO `tb_doctor` VALUES (1002, 'Snoop Dogg', '72222 222222', 'orthopedics department');
INSERT INTO `tb_doctor` VALUES (1003, 'bbno$', '73333 333333', 'radiology department');
INSERT INTO `tb_doctor` VALUES (1004, 'Wu-Tang Clan', '74444 444444', 'gynaecology and obstetrics department');
INSERT INTO `tb_doctor` VALUES (1005, 'Linkin Park', '75555 555555', 'neonatology department');
INSERT INTO `tb_doctor` VALUES (1006, 'Bruno Mars','76666 666666', 'otolaryngology department');

SET FOREIGN_KEY_CHECKS = 1;
