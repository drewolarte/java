package com.clubes.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
	
	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("sergiosoto")
            .password("sergio123")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/index","/main","/blog","/contact","/matches","/players","/single","/resources/**","/static/**","/js/**","/css/**","/images/**","/fonts/**","/images/**","/scss/**").permitAll().anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/login").defaultSuccessUrl("/admin",true).failureUrl("/login?error=true")
			.loginProcessingUrl("/admin/login-post").permitAll()
		.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout=true");
		
	}
	
	

}
