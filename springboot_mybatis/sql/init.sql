-- ==========================================================
-- springboot_mybatis 工程初始化脚本
--
-- 用法：
--   1. 确保 MySQL 已启动
--   2. 执行本脚本创建库表（库名 my_db 与 application.properties 保持一致）
--   3. 若本机密码/库名不同，改下面的库名，或改 application.properties
-- ==========================================================

-- ---------- 建库 ----------
CREATE DATABASE IF NOT EXISTS `my_db` DEFAULT CHARACTER SET utf8mb4;
USE `my_db`;

-- ==========================================================
-- emp 表 —— 对应 EmpDao
-- ==========================================================
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
    `eid`     INT          NOT NULL AUTO_INCREMENT COMMENT '员工编号',
    `ename`   VARCHAR(50)  NOT NULL                COMMENT '员工姓名',
    `egender` VARCHAR(10)  DEFAULT NULL            COMMENT '性别',
    `esalary` INT          DEFAULT 0               COMMENT '薪资',
    PRIMARY KEY (`eid`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='员工表';

INSERT INTO `emp` (`eid`, `ename`, `egender`, `esalary`) VALUES
    (1, '张无忌', '男', 9000),
    (2, '赵敏',   '女', 12000),
    (3, '周颠',   '男', 6500),
    (4, '殷素素', '女', 15000),
    (5, '张翠山', '男', 11000);

-- ==========================================================
-- user 表 —— 对应 UserDao
-- ==========================================================
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `userid`      INT          NOT NULL AUTO_INCREMENT COMMENT '用户编号',
    `username`    VARCHAR(50)  NOT NULL                COMMENT '用户名',
    `usersex`     VARCHAR(10)  DEFAULT NULL            COMMENT '性别',
    `useraddress` VARCHAR(100) DEFAULT NULL           COMMENT '地址',
    `userbirthday` DATE        DEFAULT NULL            COMMENT '生日',
    PRIMARY KEY (`userid`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';

INSERT INTO `user` (`userid`, `username`, `usersex`, `useraddress`, `userbirthday`) VALUES
    (1, '张三', '男', '北京市朝阳区', '1990-05-12'),
    (2, '李四', '女', '上海市浦东区', '1992-08-23'),
    (3, '王五', '男', '广州市天河区', '1988-11-30'),
    (4, '赵六', '女', '深圳市南山区', '1995-02-14');

-- ==========================================================
-- account 表 —— 对应 AccountDao
-- 一个 user 可以有多个 account（一对多）
-- ==========================================================
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
    `aid`     INT    NOT NULL AUTO_INCREMENT COMMENT '账户编号',
    `auserid` INT    NOT NULL                COMMENT '所属用户编号',
    `amoney`  DOUBLE DEFAULT 0.0              COMMENT '余额',
    PRIMARY KEY (`aid`),
    KEY `idx_account_auserid` (`auserid`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='账户表';

INSERT INTO `account` (`aid`, `auserid`, `amoney`) VALUES
    (1, 1, 1000.50),
    (2, 1, 2000.00),
    (3, 2, 3500.75),
    (4, 3, 800.20),
    (5, 4, 12000.00);

-- ==========================================================
-- 建表完成验证
-- ==========================================================
SELECT 'emp 表数据'     AS `说明`, COUNT(*) AS `条数` FROM `emp`
UNION ALL
SELECT 'user 表数据',    COUNT(*) FROM `user`
UNION ALL
SELECT 'account 表数据', COUNT(*) FROM `account`;