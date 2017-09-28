package tv.wallbase.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tv.wallbase.common.rest.Page;
import tv.wallbase.common.rest.Pageable;
import tv.wallbase.common.rest.Sort;
import tv.wallbase.gateway.model.Wallpaper;
import tv.wallbase.gateway.service.WallpaperService;

import java.util.Arrays;

/**
 * 最新圖片 lastest
 * <p>
 * Created by wangkun23 on 2017/9/24.
 */
@Controller
@RequestMapping("/latest")
public class LatestController {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private WallpaperService wallpaperService;

    /**
     * 每次加载24张图片
     *
     * @param model
     * @return
     */
    @RequestMapping
    public String list(Model model) {
        Pageable pageable = new Pageable(1, 24);
        pageable.setSorts(Arrays.asList(new Sort("createTime", Sort.Direction.desc)));
        Page<Wallpaper> pages = wallpaperService.findByPage(pageable);
        model.addAttribute("pages", pages);
        return "/latest/index";
    }

    /**
     * 查看更多 无限加载
     *
     * @param model
     * @return
     */
    @RequestMapping("/next")
    public String infiniteScroll(Integer page, Model model) {
        Pageable pageable = new Pageable(page, 24);
        pageable.setSorts(Arrays.asList(new Sort("createTime", Sort.Direction.desc)));
        Page<Wallpaper> pages = wallpaperService.findByPage(pageable);
        model.addAttribute("pages", pages);
        return "/latest/next";
    }
}
