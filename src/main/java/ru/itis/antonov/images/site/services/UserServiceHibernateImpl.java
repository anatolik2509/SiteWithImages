package ru.itis.antonov.images.site.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.antonov.images.site.models.User;
import ru.itis.antonov.images.site.repositories.UserRepository;

@Service
public class UserServiceHibernateImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceHibernateImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(email + " doesnt exists")
        );
    }
}
