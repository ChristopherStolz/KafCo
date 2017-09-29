package edu.nyit.CSCI455.MeterProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer{
	
	@Autowired
	private DataRepository repository;
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(WebApplication.class);
	}
	
	public static void main (String[] args){
		SpringApplication.run(WebApplication.class, args);
	}
}
