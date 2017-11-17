package edu.nyit.CSCI455.MeterProject.Data;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private List<GrantedAuthority> grantedAuthorities;
	public UserDetailsImpl (){
		
	}
	public UserDetailsImpl(User user){
		email = user.getEmail();
		password = user.getPassword();
		if(user.getAdmin() == true){
			grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
		}
		grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
