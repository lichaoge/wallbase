
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