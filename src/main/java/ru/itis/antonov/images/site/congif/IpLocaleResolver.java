package ru.itis.antonov.images.site.congif;

import org.springframework.context.i18n.LocaleContext;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class IpLocaleResolver implements LocaleResolver {

    private String cookieName = "locale";

    private static final Locale def = Locale.ENGLISH;

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        if(httpServletRequest.getCookies() != null) {
            for (Cookie c : httpServletRequest.getCookies()) {
                if (c.getName().equals(cookieName)) {
                    return Locale.forLanguageTag(c.getValue());
                }
            }
        }
        String lang = httpServletRequest.getHeader("Accept-Language");
        System.out.println(lang);
        System.out.println(Locale.forLanguageTag(lang));
        if(Locale.forLanguageTag(lang) == null){
            return def;
        }
        return Locale.forLanguageTag(lang);
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
        if(locale != null) {
            httpServletResponse.addCookie(new Cookie(cookieName, locale.toLanguageTag()));
        }
    }
}
