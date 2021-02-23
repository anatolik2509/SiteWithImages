package ru.itis.antonov.images.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.antonov.images.site.dto.forms.SignInForm;
import ru.itis.antonov.images.site.services.SignInService;

import javax.validation.Valid;

@Controller("/signIn")
public class SignInController {

    private SignInService signInService;

    @Autowired
    public SignInController(SignInService signInService) {
        this.signInService = signInService;
    }

    @GetMapping
    public String getView(){
        return "signIn";
    }

    @PostMapping
    public String login(@Valid SignInForm form){
        return "profile";
    }
}
