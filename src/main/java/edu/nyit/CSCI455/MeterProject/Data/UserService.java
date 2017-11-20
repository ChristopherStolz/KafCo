package edu.nyit.CSCI455.MeterProject.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void save (User user){
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	public User findLoggedInUser(){
		Object userDetails = SecurityContextHolder
								.getContext()
								.getAuthentication()
								.getDetails();
		if (userDetails instanceof UserDetails){
			return findByEmail(((UserDetails) userDetails).getUsername());
		}
		return null;
	}
	public User findByEmail (String email){
		return userRepository.findByEmail(email);
	}
	
	public boolean checkUser(String email, String password){
		User user = userRepository.findByEmail(email);
		if(user != null){
			return bCryptPasswordEncoder.matches(password, user.getPassword());
		}
		return false;
	}
}
