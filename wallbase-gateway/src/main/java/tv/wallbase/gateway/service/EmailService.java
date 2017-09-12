package tv.wallbase.gateway.service;

import java.util.Map;

/**
 * Created by wangkun23 on 2017/2/10.
 */
public interface EmailService {

    /**
     * @param toMail
     * @param subject
     * @param templateName
     * @param data
     */
    public void send(String toMail, String subject, String templateName, Map<String, Object> data);
}
