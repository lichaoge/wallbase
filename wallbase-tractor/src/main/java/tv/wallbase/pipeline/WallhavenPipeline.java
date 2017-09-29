package tv.wallbase.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tv.wallbase.gateway.model.Wallpaper;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * 处理wallhaven的抓去结果
 * Created by wangkun23 on 2017/9/29.
 */
@Component
public class WallhavenPipeline implements Pipeline {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void process(ResultItems resultItems, Task task) {
        Wallpaper wallpaper = resultItems.get("wallpaper");
        //把该记录放到collector表中

        //存储图片信息



    }

}
