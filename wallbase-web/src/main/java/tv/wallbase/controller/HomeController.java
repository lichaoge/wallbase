package tv.wallbase.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tv.wallbase.gateway.service.WallpaperService;

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
    private WallpaperService wallpaperService;

    @RequestMapping(method = RequestMethod.GET)
    public String displayIndex(Model model) {
        logger.info("displayIndex");
        return "/index";
    }
}
