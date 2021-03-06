-- 创建数据库
create database yitian

-- 添加数据库账号
create user 'yitian'@'localhost' identified by 'yitian';

-- 赋予数据库账号权限
grant all on yitian.* to 'yitian'@'localhost';

-- 系统配置
drop table if exists system_config;
CREATE TABLE `system_config`
(
    `id`        bigint(20)   NOT NULL AUTO_INCREMENT,
    `name`      varchar(50)  NOT NULL COMMENT '配置名字',
    `code`      varchar(50)  NOT NULL COMMENT '配置编码',
    `parent`    varchar(50)  NOT NULL COMMENT '父节点, 和code一样说明是根节点',
    `value`     varchar(200) NOT NULL COMMENT '配置值',
    `create_at` bigint(13)   NOT NULL,
    `update_at` bigint(13)   NOT NULL,
    `create_by` bigint(20)   NOT NULL,
    `update_by` bigint(20)   NOT NULL,
    PRIMARY KEY (`id`),
    KEY `code_index` (`code`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='系统配置';

-- 管理人员
drop table if exists administrator;
CREATE TABLE `administrator`
(
    `id`        bigint(20)   NOT NULL AUTO_INCREMENT,
    `email`     varchar(50)  NOT NULL unique COMMENT '邮箱',
    `nickname`  varchar(50)  NOT NULL COMMENT '昵称',
    `username`  varchar(50) DEFAULT NULL COMMENT '用户名',
    `password`  varchar(500) NOT NULL COMMENT '密码',
    `uuid`      varchar(128) NOT NULL unique COMMENT '用户id,随机字符串',
    `create_at` bigint(13)   NOT NULL,
    `update_at` bigint(13)   NOT NULL,
    `create_by` bigint(20)   NOT NULL,
    `update_by` bigint(20)   NOT NULL,
    PRIMARY KEY (`id`),
    KEY `email_index` (`email`),
    KEY `username_index` (`username`),
    KEY `uuid_index` (`uuid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='管理人员';

-- 系统日志
drop table if exists system_log;
CREATE TABLE `system_log`
(
    `id`        bigint(20)  NOT NULL AUTO_INCREMENT,
    `type`      varchar(50) NOT NULL COMMENT '类型',
    `status`    varchar(50) NOT NULL COMMENT '状态',
    `key_word`  varchar(100) DEFAULT NULL COMMENT '关键词',
    `remark`    varchar(500) DEFAULT NULL COMMENT '操作说明',
    `create_at` bigint(13)  NOT NULL,
    `create_by` bigint(20)  NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='系统日志';

-- 文章
drop table if exists article;
CREATE TABLE `article`
(
    `id`                 bigint(20)   NOT NULL AUTO_INCREMENT,
    `title`              varchar(200) NOT NULL COMMENT '标题',
    `sub_title`          varchar(500) DEFAULT NULL COMMENT '副标题',
    `key_word`           varchar(200) DEFAULT NULL COMMENT '关键词',
    `content`            text         DEFAULT NULL COMMENT '内容',
    `status`             varchar(30)  NOT NULL COMMENT '状态',
    `url`                varchar(400) DEFAULT NULL COMMENT '访问链接',
    `password`           varchar(255) DEFAULT NULL COMMENT '密码',
    `publish_trigger`    varchar(20)  NOT NULL COMMENT '发布类型',
    `publish_time`       bigint(13)   NOT NULL COMMENT '发布时间',
    `permission_group`   varchar(20)  NOT NULL COMMENT '权限分组',
    `allow_comment`      varchar(20)  NOT NULL COMMENT '是否开启评论',
    `check_comment`      varchar(20)  NOT NULL COMMENT '是否审核评论',
    `recommend`          varchar(20)  NOT NULL COMMENT '是否推荐',
    `recommend_priority` int          default 0 COMMENT '推荐指数，默认为0',
    `author_id`          bigint(20)   NOT NULL COMMENT '作者id',
    `create_at`          bigint(13)   NOT NULL,
    `create_by`          bigint(20)   NOT NULL,
    `update_at`          bigint(13)   NOT NULL,
    `update_by`          bigint(20)   NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='文章';


-- 插入系统配置数据
insert into system_config (name, code, value, parent, create_at, update_at, create_by, update_by)
values ('博客名字', 'SYSTEM_INFO', '系统初始化信息', 'SYSTEM_INFO', 1573204513496, 1573204513496, 0, 0);

-- 根据code查询配置
select id, name, code, value
from system_config
where code = 'SYSTEM_SITE_NAME';

-- 插入管理员
insert into administrator (email, nickname, username, password, uuid, create_at, update_at, create_by, update_by)
values ('erzhiqiianyi@gmail.com', '二之前一', 'erzhiqianyi', '123456789', '234jksdfsdk', 1573204513496, 1573204513496, 0,
        0);

-- 根据email查询管理员
select id, email, nickname, username, password
from administrator
where email = 'erzhiqianyi@gmail.com';

-- 插入日志
insert into system_log (type, remark, status, key_word, create_at, create_by)
values ('ARTICLE', 'Test', 'SUCCESS', 'ARTICLE', 1573204513496, 1573204513496)
-- 分页查询日志
select id, type, status, key_word, remark, create_at, create_by
from system_log
limit 0 ,10

-- 插入文章
insert into article (title, sub_title, key_word, content, status, url, password, publish_trigger, publish_time,
                     permission_group, allow_comment, check_comment, recommend, recommend_priority, create_at,
                     create_by, update_at, update_by)
values ('测试文章', '随机测试', '', '这是测试数据')
