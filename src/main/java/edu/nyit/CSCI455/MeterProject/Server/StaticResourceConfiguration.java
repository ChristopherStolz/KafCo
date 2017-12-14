package edu.nyit.CSCI455.MeterProject.Server;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("file:resources")
				.setCachePeriod(0);
		registry.addResourceHandler("/**").addResourceLocations(
				"/resources")
				.setCachePeriod(0);
	}
}
