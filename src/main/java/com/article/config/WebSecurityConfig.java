package com.article.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication()
			.withUser("dba").password("dba").roles("DBA");
		auth.inMemoryAuthentication()
			.withUser("user").password("user").roles("USER");	
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage("/login");

		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		http.authorizeRequests()
			.antMatchers("/article/remove**").hasAnyRole("ADMIN","DBA")
			.antMatchers("/article/**").hasAnyRole("USER","ADMIN","DBA");
	
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
