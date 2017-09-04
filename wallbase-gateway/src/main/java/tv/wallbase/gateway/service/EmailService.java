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

    /**
     * @param smtpFromMail
     * @param smtpHost
     * @param smtpPort
     * @param smtpUsername
     * @param smtpPassword
     * @param toMail
     * @param subject
     * @param templateName
     * @param data
     */
    public void send(String smtpFromMail, String smtpHost, Integer smtpPort, String smtpUsername,
                     String smtpPassword, String toMail, String subject, String templateName,
                     Map<String, Object> data);
}
