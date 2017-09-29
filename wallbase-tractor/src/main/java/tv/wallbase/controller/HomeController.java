package tv.wallbase.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tv.wallbase.common.rest.ResponseData;
import tv.wallbase.pipeline.WallhavenPipeline;
import tv.wallbase.processor.WallhavenProcessor;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;

/**
 * 首页入口
 *
 * @author youyou
 */
@Controller
@RequestMapping("/")
public class HomeController {

    final Logger logger = LoggerFactory.getLogger(getClass());


    @Resource
    private WallhavenProcessor wallhavenProcessor;

    @Resource
    private WallhavenPipeline wallhavenPipeline;

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String displayIndex(Model model) {
        return "/index";
    }


    /**
     * wallhaven抓去启动类
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/wallhaven")
    public ResponseData wallhaven() {

        Spider.create(wallhavenProcessor)
                .addPipeline(wallhavenPipeline)
                .addUrl("https://alpha.wallhaven.cc/random?page=2").run();

        return ResponseData.success();
    }
}
