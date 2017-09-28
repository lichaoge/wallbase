package tv.wallbase.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tv.wallbase.common.rest.Page;
import tv.wallbase.common.rest.Pageable;
import tv.wallbase.gateway.model.Wallpaper;
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

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String displayIndex(Model model) {
        Pageable pageable = new Pageable(1, 24);
        Page<Wallpaper> pages = wallpaperService.findByPage(pageable);
        model.addAttribute("pages", pages);
        return "/index";
    }
}
