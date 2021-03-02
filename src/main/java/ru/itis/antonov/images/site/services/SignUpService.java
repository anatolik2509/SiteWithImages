package ru.itis.antonov.images.site.services;

import org.springframework.stereotype.Service;
import ru.itis.antonov.images.site.dto.forms.SignUpForm;
import ru.itis.antonov.images.site.models.User;

@Service
public interface SignUpService {
    User register(SignUpForm form);

    boolean confirmEmail(String UUID);

    void sendEmailToConfirm(User user);
}
