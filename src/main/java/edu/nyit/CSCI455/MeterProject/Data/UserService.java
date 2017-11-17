package edu.nyit.CSCI455.MeterProject.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User findByEmail(String email){
		User user = userRepository.findOne(email);
		return user;
	}
	public boolean confirmUser(String email, String password){
		User user = userRepository.findOne(email);
		if (user != null){
		return bCryptPasswordEncoder.matches(password, user.getPassword());
		}
		return false;
	}
	public void save(User user){
		userRepository.save(user);
	}
}
