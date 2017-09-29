package tv.wallbase.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页入口
 *
 * @author youyou
 */
@Controller
@RequestMapping("/")
public class HomeController {

    final Logger logger = LoggerFactory.getLogger(getClass());

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
}