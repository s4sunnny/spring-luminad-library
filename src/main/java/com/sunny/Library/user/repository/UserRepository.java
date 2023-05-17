package com.sunny.Library.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunny.Library.user.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);

}
