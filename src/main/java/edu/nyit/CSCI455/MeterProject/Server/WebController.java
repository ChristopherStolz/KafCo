package edu.nyit.CSCI455.MeterProject.Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.nyit.CSCI455.MeterProject.Data.User;
import edu.nyit.CSCI455.MeterProject.Data.UserService;

@Controller
@SessionAttributes("user")
public class WebController {
	
	@Autowired
	UserService userService;
	
	@ModelAttribute("user")
	public User setUpUserForm(){
		return new User();
	}
	
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
	@RequestMapping("/user/cp")
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
	@PostMapping("/doSignUp")
	public String formPost(@ModelAttribute("user") User user,
						   @RequestParam("first") String first,
						   @RequestParam("last") String last,
						   @RequestParam("email") String email,
						   @RequestParam("password") String password){
		user = new User(first, last, email, password);
		userService.save(user);
		user = new User();
		return "success";
	}
/*	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String formPost(@ModelAttribute("user") User user,
						   @RequestParam("email") String email,
						   @RequestParam("password") String password){
		if(userService.checkUser(email, password)){
			user = userService.findByEmail(email);
			return "welcome";
		}
		return "welcome";
	}*/
	@RequestMapping(value = "/login")
	public String login(){
		return "login";
	}
}
