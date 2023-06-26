/*
SQL software: Mysql@8.0
*/
-- CREATE SCHEMA cloud_patient;
-- USE cloud_patient;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `tb_patient`;
CREATE TABLE `tb_patient`  (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `patientName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'patient name',
                            `phoneNum` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'patient phone number',
                            `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'patient address',
                            PRIMARY KEY (`id`) USING BTREE,
                            UNIQUE INDEX `patientName`(`patientName`) USING BTREE
                            ) ENGINE = InnoDB AUTO_INCREMENT = 109 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

/* add records */
INSERT INTO `tb_patient` VALUES (1, 'alice','01111 111111', 'Glasgow');
INSERT INTO `tb_patient` VALUES (2, 'bob', '02222 222222', 'New York');
INSERT INTO `tb_patient` VALUES (3, 'john', '03333 333333', 'Seoul');
INSERT INTO `tb_patient` VALUES (4, 'steven', '04444 444444', 'Tokyo');
INSERT INTO `tb_patient` VALUES (5, 'thomas', '05555 555555', 'Beijing');
INSERT INTO `tb_patient` VALUES (6, 'franklin','06666 666666', 'London');

SET FOREIGN_KEY_CHECKS = 1;
