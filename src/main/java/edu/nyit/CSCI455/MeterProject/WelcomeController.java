package edu.nyit.CSCI455.MeterProject;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@Value("${welcome.message:test}")
	private String message = "Hello, World!";
	
	@RequestMapping("/Welcome")
	public String welcome(Map<String, Object> model){
		model.put("message", this.message);
		return "welcome";
	}
	
	@RequestMapping("/")
	public String all(Map<String, Object> model){
		throw new RuntimeException("Not Found");
	}
	@RequestMapping("/foo")
	public String foo(Map<String, Object> model) {
		throw new RuntimeException("Foo");
	}
	
}
