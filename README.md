# 大作业

该工程是为完成数据库大作业编写的业务逻辑。

对应的数据库为：db_company

具体介绍如下：

## 背景资料

- 某单位现有1000名员工，其中有管理人员、财务人员、技术人员和销售人员。
- 该单位下设4个科室，即经理室、财务科、技术科和销售科。
- 工资由基本工资、福利补贴和奖励工资构成，扣除项包括考勤、保险、住房公积金、个人所得税、其它，并在工资中扣除。
- 每个员工的基本资料有姓名、性别、年龄、单位和职业（如经理、文员、工程师、销售员等）。
- 工资按月发放，实际发放的工资金额为**工资减去扣除**。
- 系统用户分为：工资管理员和职工。工资管理员负责职工工资的发放。职工可以登录查看自己每月的工资

### 声明分析

#### 实体类

##### 员工

具有以下属性：

- 工号（未写入但应为必要项，作为表的主键）
- 姓名
- 性别
- 年龄
- 单位——与科室相对应——外键
- 职业
- 工资编号

映射表：t_stuff

##### 科室

具有以下属性：

- 科室代号——自增、主键
- 科室名

映射表：t_department

##### 工资

具有以下属性：

- 基本工资（+basePay）
- 福利补贴（+subsidy）
- 奖励工资（+rewardSalary）
- 考勤（-check）
- 保险（-insurance）——Auto
- 住房公积金（-accumulationFund）——Auto
- 个人所得税（-tax）——Auto
- 其他（-other）
- 对应员工Id（stuffId）

映射表：t_salary

##### 系统用户权限级（角色）

具有以下属性：

- 管理员
- 职工

故使用枚举型直接创建两个对象进行描述。

映射表：t_userRole

##### 职业

具有以下属性：

- 职业代号（主键）
- 职业名

## 设计要求

工资管理员和职工的功能分别对应不同视图和数据库用户权限。

## 设计实现

### 数据库表声明

#### t_stuff

用于记录员工工号和基本信息的表单

```sql
/*
 Navicat Premium Data Transfer

 Source Server         : ASUSPersonPC
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : db_company

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 19/05/2022 21:14:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_stuff
-- ----------------------------
DROP TABLE IF EXISTS `t_stuff`;
CREATE TABLE `t_stuff`  (
  `stuffId` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `departmentId` int(0) NULL DEFAULT NULL,
  `occupationId` int(0) NULL DEFAULT NULL,
  `userRoleId` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`stuffId`) USING BTREE,
  UNIQUE INDEX `stuffId`(`stuffId`) USING BTREE,
  INDEX `departmentId`(`departmentId`) USING BTREE,
  CONSTRAINT `departmentId` FOREIGN KEY (`departmentId`) REFERENCES `t_department` (`departmentId`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_stuff
-- ----------------------------

-- ----------------------------
-- Triggers structure for table t_stuff
-- ----------------------------
DROP TRIGGER IF EXISTS `updateDepartmentId`;
delimiter ;;
CREATE TRIGGER `updateDepartmentId` BEFORE UPDATE ON `t_stuff` FOR EACH ROW BEGIN
 IF ((select * from t_stuff where t_stuff.departmentId = old.departmentId)IS not NULL) then
 UPDATE t_stuff set t_stuff.departmentId = new.departmentId where t_stuff.departmentId = old.departmentId;
 end IF;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;

```

#### t_salary

用于记录员工工号和对应工资信息的表单

```sql
/*
 Navicat Premium Data Transfer

 Source Server         : ASUSPersonPC
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : db_company

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 19/05/2022 21:15:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_salary
-- ----------------------------
DROP TABLE IF EXISTS `t_salary`;
CREATE TABLE `t_salary`  (
  `stuffId` int(0) NOT NULL AUTO_INCREMENT,
  `basePay` double NULL DEFAULT NULL,
  `subsidy` double NULL DEFAULT NULL,
  `rewardSalary` double NULL DEFAULT NULL,
  `check` double NULL DEFAULT NULL,
  `insurance` double NULL DEFAULT NULL,
  `accumulationFund` double NULL DEFAULT NULL,
  `tax` double NULL DEFAULT NULL,
  `other` double NULL DEFAULT NULL,
  PRIMARY KEY (`stuffId`) USING BTREE,
  UNIQUE INDEX `stuffId`(`stuffId`) USING BTREE,
  CONSTRAINT `t_salary_ibfk_1` FOREIGN KEY (`stuffId`) REFERENCES `t_stuff` (`stuffId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_salary
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

```

#### t_stuffToUserRole

用于记录用户和其对应权限代码的表单

```sql
/*
 Navicat Premium Data Transfer

 Source Server         : ASUSPersonPC
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : db_company

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 19/05/2022 21:14:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_stufftouserrole
-- ----------------------------
DROP TABLE IF EXISTS `t_stufftouserrole`;
CREATE TABLE `t_stufftouserrole`  (
  `stuffId` int(0) NOT NULL,
  `userRoleId` int(0) NOT NULL,
  PRIMARY KEY (`stuffId`, `userRoleId`) USING BTREE,
  UNIQUE INDEX `stuffId`(`stuffId`) USING BTREE,
  INDEX `userRoldId`(`userRoleId`) USING BTREE,
  CONSTRAINT `stuffId` FOREIGN KEY (`stuffId`) REFERENCES `t_stuff` (`stuffId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userRoldId` FOREIGN KEY (`userRoleId`) REFERENCES `t_userrole` (`userRoleId`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_stufftouserrole
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

```

#### t_department

用于记录部门表述和部门代码的表单

```sql
/*
 Navicat Premium Data Transfer

 Source Server         : ASUSPersonPC
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : db_company

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 19/05/2022 21:15:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department`  (
  `departmentId` int(0) NOT NULL AUTO_INCREMENT,
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`departmentId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_department
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

```

#### t_userRole

存储用户权限（角色）及其代号的表单

```sql
/*
 Navicat Premium Data Transfer

 Source Server         : ASUSPersonPC
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : db_company

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 19/05/2022 21:11:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_userrole
-- ----------------------------
DROP TABLE IF EXISTS `t_userrole`;
CREATE TABLE `t_userrole`  (
  `userRoleId` int(0) NOT NULL AUTO_INCREMENT,
  `userRole` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userRoleId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_userrole
-- ----------------------------
INSERT INTO `t_userrole` VALUES (0, 'Admin');
INSERT INTO `t_userrole` VALUES (1, 'User');

SET FOREIGN_KEY_CHECKS = 1;

```

基于其极少变动的特性预先将数据直接写入表单。
