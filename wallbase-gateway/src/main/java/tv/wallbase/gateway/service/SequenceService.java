package tv.wallbase.gateway.service;


/**
 * 流水号生成器
 * Created by wangkun23 on 2017/9/7.
 */
public interface SequenceService {

    /**
     * 生成交易单号
     * 流水编号前面6是递增 ，后面三位随机生成但是不能重复，放到数据序列
     * 默认100000开始
     *
     * @return
     */
    public String generateWallpaperNo();


}
