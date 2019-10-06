package br.com.waterclock.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/web/home")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    public String welcomeHome() {
        return "home";
    }

    @GetMapping("/web/hello")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    public String hello(){
        return "hello";
    }
}
