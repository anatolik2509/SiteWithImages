package ru.itis.antonov.images.site.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itis.antonov.images.site.dto.forms.SignUpForm;
import ru.itis.antonov.images.site.exceptions.OccupiedEmailException;
import ru.itis.antonov.images.site.models.User;
import ru.itis.antonov.images.site.repositories.UserRepository;
import ru.itis.antonov.images.site.utils.EmailUtil;
import ru.itis.antonov.images.site.utils.MailsGenerator;

import java.util.Optional;
import java.util.UUID;

@Service
public class SignUpServiceHibernateImpl implements SignUpService {

    private UserRepository userRepository;

    private MailsGenerator mailsGenerator;

    private EmailUtil emailUtil;

    @Autowired
    public SignUpServiceHibernateImpl(UserRepository userRepository, MailsGenerator mailsGenerator, EmailUtil emailUtil) {
        this.userRepository = userRepository;
        this.mailsGenerator = mailsGenerator;
        this.emailUtil = emailUtil;
    }

    @Value("${server.url}")
    private String serverUrl;

    @Value("${spring.mail.username}")
    private String from;



    @Override
    public User register(SignUpForm form) {
        Optional<User> userWithSameEmail = userRepository.findByEmail(form.getEmail());
        if(userWithSameEmail.isPresent()){
            throw new OccupiedEmailException();
        }
        User user = User.builder()
                .email(form.getEmail())
                .userName(form.getNickName())
                .confirmCode(UUID.randomUUID().toString())
                .password(form.getPassword())
                .build();
        //userRepository.save(user);
        sendEmailToConfirm(user);
        return user;
    }

    @Override
    public boolean confirmEmail(String UUID) {
        Optional<User> user = userRepository.findByConfirmCode(UUID);
        return user.isPresent();
    }

    @Override
    public void sendEmailToConfirm(User user) {
        String confirmMail = mailsGenerator.getMailForConfirm(serverUrl, user.getConfirmCode());
        emailUtil.sendEmail(user.getEmail(), "Регистрация", from, confirmMail);

    }


}
