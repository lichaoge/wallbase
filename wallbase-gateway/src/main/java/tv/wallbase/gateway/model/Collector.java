package tv.wallbase.gateway.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tv.wallbase.gateway.enums.CollectorType;

import java.io.Serializable;
import java.util.Date;

/**
 * 已经采集的图片数据防止重复采集使用
 * Created by wangkun23 on 2017/9/21.
 */
@ToString
public class Collector implements Serializable {
    @Setter
    @Getter
    private Integer id;

    @Setter
    @Getter
    /*所在网站的id或者文件名*/
    private String name;

    @Setter
    @Getter
    private CollectorType site;

    @Setter
    @Getter
    /*源url地址*/
    private String url;

    @Setter
    @Getter
    private String status;

    @Setter
    @Getter
    private Date createDate;

    @Setter
    @Getter
    private Date updateDate;

    public Collector() {
    }

    public Collector(CollectorType site, String name, String url) {
        this.site = site;
        this.name = name;
        this.url = url;
    }
}
