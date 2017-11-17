package edu.nyit.CSCI455.MeterProject.Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.nyit.CSCI455.MeterProject.Data.User;
import edu.nyit.CSCI455.MeterProject.Data.UserService;

@Controller
public class WebController {
	@Autowired
	UserService userService;
	
	@Autowired
	User user;
	
	@RequestMapping("/welcome")
	public String welcome(ModelAndView modelAndView){
		return "welcome";
	}	
	@RequestMapping("/contact")
	public String contact(ModelAndView modelAndView){
		return "contact";
	}
	@RequestMapping("/signup")
	public String signup(ModelAndView modelAndView){
		return "SignUp";
	}
	@RequestMapping("/download")
	public String download(ModelAndView modelAndView){
		return "download";
	}
	@RequestMapping("/tutorial")
	public String tutorial(ModelAndView modelAndView){
		return "tutorial";
	}
	@RequestMapping("/usercp")
	public String usercp(ModelAndView modelAndView){
		return "UserCP";
	}
	@RequestMapping("/dataview")
	public String dataview(ModelAndView modelAndView){
		return "DataView";
	}
	@RequestMapping("/admincp")
	public String admincp(ModelAndView modelAndView){
		return "adminCP";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login (ModelAndView modelAndView){
		return "login";
	}
	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
	public String doRegister (ModelAndView modelAndView,
								@ModelAttribute("user") User user,
								@ModelAttribute("first") String first,
								@ModelAttribute("last") String last,
								@ModelAttribute("email") String email,
								@ModelAttribute("password") String password){
		user = new User(first, last, email, password);
		userService.save(user);
		return "welcome";
		
	}
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin (ModelAndView modelAndView,
							@ModelAttribute("user") User user,
							@ModelAttribute("email") String email,
							@ModelAttribute("password") String password){
		
		if(userService.confirmUser(email, password)){
			user = userService.findByEmail(email);
		}
		
		return "welcome";
	}
}
