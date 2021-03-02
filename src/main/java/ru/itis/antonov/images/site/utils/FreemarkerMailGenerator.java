package ru.itis.antonov.images.site.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class FreemarkerMailGenerator implements MailsGenerator{

    private FreeMarkerConfigurer configurer;

    @Autowired
    public FreemarkerMailGenerator(FreeMarkerConfigurer configurer) {
        this.configurer = configurer;
    }

    @Override
    public String getMailForConfirm(String serverUrl, String code) {
        Template confirmMailTemplate;
        try {
            confirmMailTemplate = configurer.getConfiguration().getTemplate("confirm_mail.ftlh");
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        Map<String, String> attributes = new HashMap<>();
        attributes.put("confirm_code", code);
        attributes.put("server_url", serverUrl);

        StringWriter writer = new StringWriter();
        try {
            confirmMailTemplate.process(attributes, writer);
        } catch (TemplateException | IOException e) {
            throw new IllegalStateException(e);
        }
        return writer.toString();
    }

}
