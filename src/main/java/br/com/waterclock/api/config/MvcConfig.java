package br.com.waterclock.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/web/home").setViewName("home");
        registry.addViewController("/web/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/web/user/registration").setViewName("registration");
    }

}