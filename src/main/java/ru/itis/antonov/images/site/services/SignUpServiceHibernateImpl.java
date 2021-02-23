package ru.itis.antonov.images.site.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itis.antonov.images.site.dto.forms.SignUpForm;
import ru.itis.antonov.images.site.models.User;
import ru.itis.antonov.images.site.repositories.UserRepository;

@Service
public class SignUpServiceHibernateImpl implements SignUpService {

    private UserRepository userRepository;

    @Autowired
    public SignUpServiceHibernateImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(SignUpForm form) {
        //TODO
        return null;
    }
}
