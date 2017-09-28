package tv.wallbase.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tv.wallbase.common.rest.Page;
import tv.wallbase.common.rest.Pageable;
import tv.wallbase.common.rest.Sort;
import tv.wallbase.gateway.model.Wallpaper;
import tv.wallbase.gateway.service.WallpaperService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排行榜 初步使用查看最多来排名
 * <p>
 * Created by wangkun23 on 2017/9/24.
 */
@Controller
@RequestMapping("/top")
public class TopController {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private WallpaperService wallpaperService;


    /**
     * 每次加载24张图片
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping
    public String list(HttpServletRequest request, Model model) {
        Pageable pageable = new Pageable(1, 24);
        pageable.setSorts(Arrays.asList(new Sort("order", Sort.Direction.desc)));
        Page<Wallpaper> page = wallpaperService.findByPage(pageable);

        model.addAttribute("page", page);
        return "/top/index";
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
        pageable.setSorts(Arrays.asList(new Sort("order", Sort.Direction.desc)));
        Page<Wallpaper> pages = wallpaperService.findByPage(pageable);
        model.addAttribute("list", pages.getContent());

        return "/random/next";
    }

}
