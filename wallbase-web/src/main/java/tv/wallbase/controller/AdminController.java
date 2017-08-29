package tv.wallbase.controller;


import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping("list.do")
    public String displayAdminList(HttpServletRequest request) {

        return "list";
    }


}
