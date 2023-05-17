package com.sunny.Library.user.service;

import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sunny.Library.user.entity.User;
import com.sunny.Library.user.entity.UserSession;
import com.sunny.Library.user.repository.UserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("No user found with username: " + username);
		
		}

		Set<GrantedAuthority> ga = new HashSet<GrantedAuthority>();
		ga.add(new SimpleGrantedAuthority(user.getUsername()));
		user.setAuthorities(ga);
		return new UserSession(user);
	}

}
