package tv.wallbase.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/list")
    public String displayAdminList(HttpServletRequest request) {
        logger.info("##");
        return "list";
    }


    @RequestMapping("/hello")
    @ResponseBody
    public String index() {
        logger.info("Greetings from Spring Boot!##");
        return "Greetings from Spring Boot!";
    }


}
