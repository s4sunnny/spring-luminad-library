package com.sunny.Library.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.Library.config.JwtTokenUtil;
import com.sunny.Library.user.entity.JwtRequest;
import com.sunny.Library.user.entity.JwtResponse;
import com.sunny.Library.user.entity.UserSession;
import com.sunny.Library.user.service.UserDetailsServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping(value = "/userLogin")
	public JwtResponse userLogin(@RequestBody JwtRequest jwtRequest) throws Exception {
		
		UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		UserSession userSession = (UserSession) userDetails;
		authenticateUser(jwtRequest);
		final String token = jwtTokenUtil.generateToken(userDetails);
		return new JwtResponse(token,"Success","200", userSession.getUserType());
	}
	
	private void authenticateUser(JwtRequest jwtRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Invalid Credentials");
		}
	}
}
