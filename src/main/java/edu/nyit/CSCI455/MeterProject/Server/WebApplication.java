package edu.nyit.CSCI455.MeterProject.Server;

import edu.nyit.CSCI455.MeterProject.Data.*;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer{
	
	//@Autowired
	//private DataRepository repository;
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
