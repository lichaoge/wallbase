package tv.wallbase.manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/10/25.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String displayList() {


        return "admin/list";
    }

    @RequestMapping(value = "details", method = RequestMethod.GET)
    public String displayDetails() {


        return "admin/details";
    }
}
