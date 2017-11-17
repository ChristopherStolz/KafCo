package edu.nyit.CSCI455.MeterProject.Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.nyit.CSCI455.MeterProject.Data.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/", "/welcome", "/info", "/contact", "/signup", "/doLogin").permitAll()
			.antMatchers("/user/**").hasAuthority("USER")
			.anyRequest().fullyAuthenticated()
		.and()
			.formLogin()
			.loginPage("/login")
			.failureUrl("/login?error")
			.usernameParameter("email")
			.passwordParameter("password")
			.permitAll()
		.and()
			.logout()
			.logoutUrl("/logout")
			.deleteCookies("remember-me")
			.logoutSuccessUrl("/")
			.permitAll()
		.and()
			.rememberMe();
	}
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService)
        	.passwordEncoder(new BCryptPasswordEncoder());
        	
    }
}
