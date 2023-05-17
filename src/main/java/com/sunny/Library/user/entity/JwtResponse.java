package com.sunny.Library.user.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {

	private String jwtToken;
	private String message;
	private String statusCode;
	private String userType;
	
	public JwtResponse(String jwtToken, String message, String statusCode, String role) {
		this.jwtToken = jwtToken;
		this.message = message;
		this.statusCode = statusCode;
		this.userType = role;
	}
}
