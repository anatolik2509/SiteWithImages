package ru.itis.antonov.images.site.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

@Profile("prod")
@Component
public class EmailUtilImpl implements EmailUtil {

    private ExecutorService executorService;

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailUtilImpl(ExecutorService executorService, JavaMailSender javaMailSender) {
        this.executorService = executorService;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String from, String text) {
        executorService.submit(() -> javaMailSender.send(mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            mimeMessage.setContent(text, "text/html; charset=UTF-8");
        }));

    }
}
