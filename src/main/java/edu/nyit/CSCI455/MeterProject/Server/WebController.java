package edu.nyit.CSCI455.MeterProject.Server;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import edu.nyit.CSCI455.MeterProject.Data.DataRun;
import edu.nyit.CSCI455.MeterProject.Data.DataService;
import edu.nyit.CSCI455.MeterProject.Data.User;
import edu.nyit.CSCI455.MeterProject.Data.UserService;

@Controller
@SessionAttributes({"user"})
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
		return new ArrayList<DataRun>(dataService.findAll());
	}
	
//	@ModelAttribute("result")
//	public DataRun getResult(String id){
//		DataRun data = dataService.findById(id);
//		return (data != null) ? data : new DataRun();
//	}
	
	@RequestMapping("/")
	public String base(ModelAndView modelAndView,
						@ModelAttribute User user){
		User getuser = this.setUpUserForm();
		user.setDateAdded(getuser.getDateAdded());
		user.setEmail(getuser.getEmail());
		user.setAdmin(getuser.getAdmin());
		user.setFirstName(getuser.getFirstName());
		user.setLastName(getuser.getLastName());
		return "welcome";
	}
	@RequestMapping("/welcome")
	public String welcome(ModelAndView modelAndView,
							@ModelAttribute User user){
		User getuser = this.setUpUserForm();
		user.setDateAdded(getuser.getDateAdded());
		user.setEmail(getuser.getEmail());
		user.setAdmin(getuser.getAdmin());
		user.setFirstName(getuser.getFirstName());
		user.setLastName(getuser.getLastName());
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
	
	@RequestMapping(value = "/graph")
	public String graph(ModelAndView modelAndView, 
						HttpServletRequest request,
						@ModelAttribute ("result") DataRun result){
		String Id = request.getQueryString();
		Id = Id.replaceAll("%20", " ");
		DataRun data = dataService.findById(Id);
		result.setData(data.getData());
		result.setDate(data.getDate());
		result.setMeterName(data.getMeterName());
		result.setId(data.getId());
		result.setTimeOffset(data.getTimeOffset());
		return "graph";
	}
	@PostMapping("/updatePassword")
	public String updatePassword(ModelAndView modelAndView,
								 @ModelAttribute("user") User user,
								 @RequestParam("current-password") String current,
								 @RequestParam("password") String password){
		boolean matches = (userService.checkUser(user.getEmail(), current)) ?
				true : false;
		if(matches){
			user.setPassword(password);
			userService.save(user);
		}
		return (matches) ? "updated" : "pwfail";
	}
	@PostMapping("updateUser")
	public String updateUser(ModelAndView modelAndView,
							 @ModelAttribute("user") User user,
							 @RequestParam("first") String first,
							 @RequestParam("last") String last,
							 @RequestParam("email") String email){
		user.setFirstName(first);
		user.setLastName(last);
		user.setEmail(email);
		userService.save(user);
		return "updated";
	}
}
