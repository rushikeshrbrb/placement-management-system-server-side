package com.pms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public Optional<User> findByEmail(String email);
}
