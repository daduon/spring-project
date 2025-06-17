package com.helper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/public")
public class PublicController {
    @GetMapping("/about-us")
    public String getAboutUs() {
        return "This about us page.";
    }
    
}
