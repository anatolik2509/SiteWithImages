package ru.itis.antonov.images.site.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ModelConfigController {
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg", "Hello there");
    }
}
