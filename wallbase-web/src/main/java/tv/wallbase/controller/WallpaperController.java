package tv.wallbase.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tv.wallbase.gateway.model.Wallpaper;
import tv.wallbase.gateway.service.WallpaperService;

/**
 * 高清壁纸详情页面
 *
 * @author Administrator
 */
@Controller("wallpaperController")
@RequestMapping("/wallpaper")
public class WallpaperController {

    Logger logger = LoggerFactory.getLogger(WallpaperController.class);

    @Resource
    private WallpaperService wallpaperService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String wallpaper(@PathVariable("id") Integer id, ModelMap model) {
        Wallpaper wallpaper = wallpaperService.findDetails(id);
//        String tagString = "";
//        if (photos.getTags() != null) {
//            for (TagModel tag : photos.getTags()) {
//                tagString += tag.getName() + ",";
//            }
//            tagString = tagString.substring(0, tagString.length());
//        }
        //壁纸的主要颜色
        //List<PhotosColors> colors = photosColorsService.findByPhotosId(photosId);

        model.addAttribute("wallpaper", wallpaper);
//        model.addAttribute("tagString", tagString);
        //model.addAttribute("colors", colors);

        return "/wallpaper";

    }
}
