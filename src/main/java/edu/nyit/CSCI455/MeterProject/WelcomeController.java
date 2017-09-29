package edu.nyit.CSCI455.MeterProject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	@Value("${welcome.message:test}")
	private String message = "Hello, World!";
	@RequestMapping("/welcome")
	public String welcome(ModelAndView modelAndView){
		modelAndView.addObject("message", this.message);
		return "welcome";
	}	
}
