package tv.wallbase.manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.CredentialsExpiredException;
//import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Administrator on 2016/10/21.
 */
@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, HttpServletRequest request, Model model) {
        if (error != null) {
//            String message = getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION");
//            logger.info("error### {}", message);
//            model.addAttribute("error", message);
        }
        return "login";
    }


//    private String getErrorMessage(HttpServletRequest request, String key) {
//        Exception exception = (Exception) request.getSession().getAttribute(key);
//        String error = "";
//        //logger.info("getErrorMessage {}", exception);
//        if (exception instanceof BadCredentialsException) {
//            error = "用户名或者密码不正确!";
//        } else if (exception instanceof LockedException) {
//            error = "账户已被锁定!";
//        } else if (exception instanceof CredentialsExpiredException) {
//            error = "登录凭证已过期!";
//        } else {
//            error = "用户名或者密码不正确!";
//        }
//        return error;
//    }
}
