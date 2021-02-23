package ru.itis.antonov.images.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller("/profile")
public class ProfileController {

    @GetMapping("/{profileId}")
    public String getView(@PathVariable String profileId){
        //TODO
        return "profile";
    }
}
