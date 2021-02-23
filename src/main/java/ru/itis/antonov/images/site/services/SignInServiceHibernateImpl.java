package ru.itis.antonov.images.site.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.antonov.images.site.dto.forms.SignInForm;
import ru.itis.antonov.images.site.models.User;
import ru.itis.antonov.images.site.repositories.UserRepository;

@Service
public class SignInServiceHibernateImpl implements SignInService {

    private UserRepository userRepository;

    @Autowired
    public SignInServiceHibernateImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signIn(SignInForm form) {
        //TODO
        return null;
    }
}
