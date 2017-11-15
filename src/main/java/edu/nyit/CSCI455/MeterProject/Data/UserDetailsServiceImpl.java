package edu.nyit.CSCI455.MeterProject.Data;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User not found under " + email);
		}
		return new org.springframework.security.core.userdetails.User(
					user.getEmail(), user.getPassword(), 
					getAuthorities(user));
	}
	
	private Set<GrantedAuthority> getAuthorities(User user){
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		GrantedAuthority grantedAuthority;
		if (user.getAdmin() == true) {
			grantedAuthority = new SimpleGrantedAuthority("Admin");
		} else {
			grantedAuthority = new SimpleGrantedAuthority("User");
		}
		authorities.add(grantedAuthority);
		return authorities;
	}
}
