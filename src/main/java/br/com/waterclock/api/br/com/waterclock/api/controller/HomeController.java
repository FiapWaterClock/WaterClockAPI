package br.com.waterclock.api.br.com.waterclock.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String welcomeHome(){
        return "page-home";
    }
}
