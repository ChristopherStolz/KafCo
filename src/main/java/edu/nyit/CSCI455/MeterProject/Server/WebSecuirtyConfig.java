package edu.nyit.CSCI455.MeterProject.Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecuirtyConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		http
			.authorizeRequests().
			antMatchers("/", "/welcome", "/signup", "/doSignUp", "/doLogin").permitAll();
		http
			.authorizeRequests()
				.antMatchers("/admincp").hasAuthority("Admin")
				.antMatchers("/usercp", "/results", "/graph/**", "/test").hasAuthority("User")
				.anyRequest().authenticated()
				.and()
				.formLogin()
					.loginPage("/login")
						.usernameParameter("email")
						.passwordParameter("password")
					.loginProcessingUrl("/doLogin")
					.permitAll()
					.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/doLogout"))
					.logoutSuccessUrl("/welcome")
					.deleteCookies("JSESSIONID");
		http
			.csrf().disable();
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        	.userDetailsService(userService)
        	.passwordEncoder(bCryptPasswordEncoder);
    }
}
