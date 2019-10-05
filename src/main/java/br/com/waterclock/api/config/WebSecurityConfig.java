package br.com.waterclock.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@Order(2)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.headers().frameOptions().disable();

		http
				.antMatcher( "/web/**")

				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)

				.and()
				.authorizeRequests()
				.antMatchers( "/h2/**")
				.permitAll()

				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/web/hello")
				.failureUrl("/login?error=true")
				.permitAll()
				.and()
				.logout()
				.permitAll()

				.and()
				.csrf()
				.disable();
	}
}
