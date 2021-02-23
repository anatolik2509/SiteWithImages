package ru.itis.antonov.images.site.services;


import ru.itis.antonov.images.site.dto.forms.SignInForm;
import ru.itis.antonov.images.site.models.User;

public interface SignInService {
    User signIn(SignInForm form);
}
