package net.software.projects.carwash.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
    	
    	User.UserBuilder admin = User.withDefaultPasswordEncoder();
  	  	admin.username("admin").password("2019carwash").roles("USER", "ADMIN");
        auth.inMemoryAuthentication().withUser(admin);
        
        User.UserBuilder cashier = User.withDefaultPasswordEncoder();
  	  	cashier.username("employee").password("carwash2019").roles("USER");
        auth.inMemoryAuthentication().withUser(cashier);
        
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.csrf().disable()
        	.authorizeRequests()
        		.antMatchers("/login").permitAll()
        		.antMatchers("/service/**", "/employee/**").access("hasRole('ADMIN')")
        		.antMatchers("/", "/**").access("hasRole('USER')")
        	.and()
        	.formLogin();
    }

}
