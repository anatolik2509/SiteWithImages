package ru.itis.antonov.images.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.antonov.images.site.models.User;
import ru.itis.antonov.images.site.services.UserService;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/profile/{profileId}")
    public String getView(@PathVariable String profileId, Model model){
        User user = userService.findById(Long.parseLong(profileId));
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping(path = "/profile")
    public String getView(UserDetails authUser, Model model){
        User user = userService.findByEmail(authUser.getUsername());
        model.addAttribute("user", user);
        return "profile";
    }
}
