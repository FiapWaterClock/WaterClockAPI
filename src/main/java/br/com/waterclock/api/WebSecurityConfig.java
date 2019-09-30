package br.com.waterclock.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.headers().frameOptions().disable();

        // See: https://github.com/Baeldung/spring-security-registration/blob/857ff0d0197914ad4ec72d7d7c31ff33237ab365/src/main/java/org/baeldung/spring/SecSecurityConfig.java#L77
        http.csrf().disable()
                .authorizeRequests()
                // WIDE OPEN
                .antMatchers( "/", "/h2/**", "/user/registration").permitAll()
                // AUTHORIZED
                .antMatchers("/home").permitAll()
                .anyRequest().authenticated()//.hasAuthority("READ_PRIVILEGE") // TODO create and name privileges
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}