package tv.wallbase.controller.admin;

import tv.wallbase.gateway.service.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * 测试dubbo服务
 * Created by Administrator on 2016/10/22.
 */
@Controller
@RequestMapping("/config")
public class ConfigController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ConfigService configService;

    @RequestMapping(value = "details", method = RequestMethod.GET)
    public String displayDetails() {
        logger.info("displayLogin {}", configService.get());
        return "config/details";
    }
}
