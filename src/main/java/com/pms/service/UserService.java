package com.pms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.User;
import com.pms.exception.PmsServiceException;
import com.pms.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository  userRepository;
	
	public int registerUser(User user) {
		Optional<User> userCheck=userRepository.findByEmail(user.getEmail());
		if(userCheck.isEmpty()) {
			User saveUser=userRepository.save(user);
			return saveUser.getId();
		}
		else
			throw new PmsServiceException("Customer already registered!");
	}
	}


