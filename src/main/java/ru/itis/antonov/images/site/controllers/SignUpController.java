package ru.itis.antonov.images.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.antonov.images.site.dto.forms.SignInForm;
import ru.itis.antonov.images.site.dto.forms.SignUpForm;
import ru.itis.antonov.images.site.services.SignUpService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SignUpController {

    private SignUpService signUpService;

    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping(path = "/signUp")
    public String getView(){
        return "signUp";
    }

    @PostMapping(path = "/signUp")
    public String register(@Valid SignUpForm form, BindingResult result, Model model) {
        System.out.println(form);
        if(result.hasErrors()){
            List<String> errors = new ArrayList<>();
            for(ObjectError e : result.getAllErrors()){
                errors.add(e.getDefaultMessage());
            }
            model.addAttribute("errorList", errors);
            model.addAttribute("signUpForm", form);
            return "signUp";
        }
        return "redirect:/profile";
    }
}
