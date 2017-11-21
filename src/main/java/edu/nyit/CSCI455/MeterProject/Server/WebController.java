package edu.nyit.CSCI455.MeterProject.Server;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.nyit.CSCI455.MeterProject.Data.DataRun;
import edu.nyit.CSCI455.MeterProject.Data.DataService;
import edu.nyit.CSCI455.MeterProject.Data.User;
import edu.nyit.CSCI455.MeterProject.Data.UserService;

@Controller
@SessionAttributes("user")
public class WebController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	DataService dataService;
	
	@ModelAttribute("user")
	public User setUpUserForm(){
		User user = userService.findLoggedInUser();
		return (user != null) ? user : new User();
	}
	@ModelAttribute("results")
	public ArrayList<DataRun> setUpResults(){
		return new ArrayList(dataService.findAll());
	}
	
	@RequestMapping("/test")
	public String test(ModelAndView modelAndView,
						@ModelAttribute("user") User user){
		user = setUpUserForm();
		modelAndView.addObject("user", user);
		return "test";
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
	@RequestMapping("/usercp")
	public String usercp(ModelAndView modelAndView){
		return "usercp";
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
	
	@RequestMapping(value = "/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "/results")
	public String results(ModelAndView modelAndView){
		ArrayList<DataRun> results = setUpResults();
		modelAndView.addObject("results", results.toArray());
		return "results";
	}
}
