package tv.wallbase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tv.wallbase.common.rest.Page;
import tv.wallbase.common.rest.Pageable;
import tv.wallbase.gateway.model.Wallpaper;
import tv.wallbase.gateway.service.WallpaperService;

import javax.annotation.Resource;

/**
 * 随机
 * Created by wangkun23 on 2017/9/24.
 */
@Controller
@RequestMapping("/random")
public class RandomController {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private WallpaperService wallpaperService;

    /**
     * random page
     *
     * @param model
     * @return
     */
    @RequestMapping
    public String list(Model model) {
        Pageable pageable = new Pageable(1, 24);
        Page<Wallpaper> page = wallpaperService.findByPage(pageable);

        model.addAttribute("list", page.getContent());
        return "/random/index";
    }

    /**
     * infiniteScroll
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/next")
    public String infiniteScroll(Integer page, Model model) {
        Pageable pageable = new Pageable(page, 24);
        Page<Wallpaper> pages = wallpaperService.findByPage(pageable);

        model.addAttribute("list", pages.getContent());
        return "/random/next";
    }
}
