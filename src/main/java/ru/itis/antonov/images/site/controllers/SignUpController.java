package ru.itis.antonov.images.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.antonov.images.site.dto.forms.SignInForm;
import ru.itis.antonov.images.site.services.SignUpService;

import javax.validation.Valid;

@Controller("/signUp")
public class SignUpController {

    private SignUpService signUpService;

    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping
    public String getView(){
        return "signUp";
    }

    @PostMapping
    public String register(@Valid SignInForm form) {
        return "profile";
    }
}
