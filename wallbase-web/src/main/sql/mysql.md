
## 壁纸表（create time 2017-09-10）
```sql
CREATE TABLE `tb_wallpaper` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `category_id` int(11) NOT NULL COMMENT '分类id',
  `purity` varchar(50) DEFAULT NULL COMMENT '图片纯洁度',
  `size` double DEFAULT NULL COMMENT '图片原图大小',
  `views_count` int(11) NOT NULL DEFAULT '0' COMMENT '浏览次数',
  `favorites_count` int(11) NOT NULL DEFAULT '0' COMMENT '收藏次数',
  `thumb_url` varchar(255)  DEFAULT NULL COMMENT '缩略图ULR',
  `image_url` varchar(255) DEFAULT NULL COMMENT '原图UR',
  `user_id` int(11) NOT NULL COMMENT '创建者ID',
  `status` varchar(50)  DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='壁纸表'

alter TABLE tb_wallpaper add COLUMN width int(10) DEFAULT NULL COMMENT "壁纸宽度" ;
alter TABLE tb_wallpaper add COLUMN height int(10) DEFAULT NULL COMMENT "壁纸高度";
```

## 标签表 （create time 2017-09-14）
```sql
CREATE TABLE `tb_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `name` varchar(255) NOT NULL COMMENT '标签名称',
  `user_id` int(11) NOT NULL COMMENT '创建者ID',
  `status` varchar(50) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='标签'
```

## 壁纸标签表（create time 2017-09-14）
```sql

CREATE TABLE `tb_wallpaper_tag` (
  `wallpaper_id` int(11) NOT NULL COMMENT '壁纸的ID',
  `tag_id` int(11) NOT NULL COMMENT '标签的ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`wallpaper_id`,`tag_id`),
  KEY `FK_ae5cefixnolyd7t1goh57af9n` (`tag_id`) USING BTREE
) ENGINE=InnoDB COMMENT='壁纸标签表'
```
## 已经采集的图片数据（create time 2017-09-21）
```sql
CREATE TABLE `tb_colletor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `site` varchar(255) DEFAULT NULL COMMENT '网站名称',
  `url`  varchar(255) DEFAULT NULL COMMENT '源url地址',
  `name`  varchar(100) DEFAULT NULL COMMENT '所在网站的id或者文件名',
  `status` varchar(50) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='已经采集的图片数据';

```

## 流水号（create time 2017-09-22）
```sql
CREATE TABLE `tb_sequence` (
  `name` varchar(30) NOT NULL COMMENT '序列类别',
  `nextid` int(11) NOT NULL COMMENT '下一个ID',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB COMMENT "流水号";


```
## 删除标志（create time 2017-10-13）
```sql
ALTER TABLE tb_wallpaper ADD COLUMN deleted TINYINT (4) DEFAULT '0' COMMENT '删除标记' AFTER STATUS;
```

## 创建用户账户表（create time 2017-10-13）
```sql
CREATE TABLE `tb_account` (
	id INT (11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
	username VARCHAR (100) NOT NULL COMMENT '登录用户名',
	avatar VARCHAR (120) NOT NULL COMMENT '用户头像地址URL',
	mobile VARCHAR (200) DEFAULT NULL COMMENT '登录手机号',
	email VARCHAR (200) NOT NULL COMMENT '邮箱账号',
	PASSWORD VARCHAR (255) NOT NULL COMMENT '登录密码',
	salt VARCHAR (255) DEFAULT NULL COMMENT '混合加密盐值',
	enabled TINYINT (1) NOT NULL COMMENT '是否可以登录',
	locked TINYINT (1) NOT NULL COMMENT '是否被锁定',
	locked_date DATETIME DEFAULT NULL COMMENT '被锁定时间',
	login_date DATETIME DEFAULT NULL COMMENT '最后登录日期',
	login_failure_count INT (11) NOT NULL COMMENT '登录错误次数',
	login_ip VARCHAR (255) DEFAULT NULL COMMENT '最后登录IP',
	STATUS VARCHAR (50) DEFAULT NULL,
	create_time DATETIME NOT NULL COMMENT '创建时间',
	update_time DATETIME NOT NULL COMMENT '最后一次更新时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB COMMENT = '用户账户信息'
```
