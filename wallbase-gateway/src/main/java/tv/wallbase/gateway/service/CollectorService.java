package tv.wallbase.gateway.service;

import tv.wallbase.gateway.enums.CollectorType;
import tv.wallbase.gateway.model.Collector;

/**
 * 图片采集
 * Created by wangkun23 on 2017/9/29.
 */
public interface CollectorService {

    /**
     * 保存
     *
     * @param entity
     */
    public void save(Collector entity);


    /**
     * 查询该网站的壁纸是否已经抓去过
     *
     * @param site
     * @param name
     * @return
     */
    public Boolean exist(CollectorType site, String name);
}
