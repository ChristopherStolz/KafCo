package edu.nyit.CSCI455.MeterProject.Server;

import edu.nyit.CSCI455.MeterProject.Data.*;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer{
	
	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsServiceImpl userDetailsService(){
		return new UserDetailsServiceImpl();
	}
	@Bean
	public UserService userService(){
		return new UserService();
	}
	@Bean
	public User userBean(){
		return new User();
	}
	AnnotationConfigApplicationContext ctx =
            new AnnotationConfigApplicationContext(DatabaseConfiguration.class);
	
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(WebApplication.class);
	}
	
	public static void main (String[] args){
		SpringApplication.run(WebApplication.class, args);
	}
}
