package tv.wallbase.service.impl;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import tv.wallbase.gateway.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {
    final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Value(value = "${mail.sending.enabled}")
    private Boolean sendingEnabled;

    public void send(String toMail, String subject, final String templateName, Map<String, Object> params) {
        Assert.hasText(toMail, "toMail must not be null, empty, or blank");
        Assert.hasText(subject, "subject must not be null, empty, or blank");
        Assert.hasText(templateName, "templateName must not be null, empty, or blank");
        String text = "";
        try {
            Template freemarkerTemplate = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
            text = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerTemplate, params);
        } catch (TemplateException | IOException e) {
            logger.error(e.getMessage());
        }
        try {
            MimeMessage mailMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = messageHelper = new MimeMessageHelper(mailMessage, false, "utf-8");
            messageHelper.setFrom(MimeUtility.encodeWord("系统邮件") + " <wang.kun@zhongfl.com>");
            messageHelper.setTo(toMail);
            messageHelper.setSubject(subject);
            messageHelper.setText(text, true);
            mailSender.send(mailMessage);
        } catch (MessagingException | UnsupportedEncodingException ex) {
            logger.error(ex.getMessage());
        }
    }
}
