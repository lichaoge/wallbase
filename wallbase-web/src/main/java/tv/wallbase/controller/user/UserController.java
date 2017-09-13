package tv.wallbase.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/user")
public class UserController {
    final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 用户个人首页
     *
     * @return
     */
    @RequestMapping("/profile")
    public String profile() {
        return "/user/profile";
    }

}
