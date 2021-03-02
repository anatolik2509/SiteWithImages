package ru.itis.antonov.images.site.utils;

public interface MailsGenerator {
    String getMailForConfirm(String serverUrl, String code);
}

