
## 壁纸标签表
```sql

CREATE TABLE `tb_wallpaper_tag` (
  `wallpaper_id` int(11) NOT NULL COMMENT '壁纸的ID',
  `tag_id` int(11) NOT NULL COMMENT '标签的ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`wallpaper_id`,`tag_id`),
  KEY `FK_ae5cefixnolyd7t1goh57af9n` (`tag_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='壁纸标签表'
```
