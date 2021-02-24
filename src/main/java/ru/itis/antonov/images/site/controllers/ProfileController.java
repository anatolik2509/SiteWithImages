package ru.itis.antonov.images.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {

    @GetMapping(path = "profile/{profileId}")
    public String getView(@PathVariable String profileId){
        //TODO
        return "profile";
    }
}
