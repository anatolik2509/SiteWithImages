package ru.itis.antonov.images.site.utils;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("test")
@Component
public class FakeEmailImpl implements EmailUtil{
    @Override
    public void sendEmail(String to, String subject, String from, String text) {
        System.out.println("я отправиль");
    }
}
