package com.sunny.Library.user.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "library")
@Getter
@Setter
public class User {

	@Id
	@Column(length = 15)
	private String username;
	
	@Column(length = 100)
	private String password;
	
	@Column(length = 10)
	private String userType;
	
	@Transient
	private Set<GrantedAuthority> authorities;
}
