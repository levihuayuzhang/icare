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
INSERT INTO `tb_patient` VALUES (1, '01111 111111', 'alice', 'Glasgow');
INSERT INTO `tb_patient` VALUES (2, '02222 222222', 'bob', 'New York');
INSERT INTO `tb_patient` VALUES (3, '03333 333333', 'john', 'Seoul');
INSERT INTO `tb_patient` VALUES (4, '04444 444444', 'steven', 'Tokyo');
INSERT INTO `tb_patient` VALUES (5, '05555 555555', 'thomas', 'Beijing');
INSERT INTO `tb_patient` VALUES (6, '06666 666666', 'franklin', 'London');

SET FOREIGN_KEY_CHECKS = 1;
