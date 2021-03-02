package ru.itis.antonov.images.site.utils;

public interface EmailUtil {
    void sendEmail(String to, String subject, String from, String text);
}
