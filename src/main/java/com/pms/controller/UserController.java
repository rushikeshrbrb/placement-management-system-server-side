package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.dto.UserRegistrationStatus;
import com.pms.entity.User;
import com.pms.exception.PmsServiceException;
import com.pms.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	@PostMapping("/register")
	public UserRegistrationStatus userRegister(@RequestBody User user) {
		try {
			int id=userService.registerUser(user);
			UserRegistrationStatus status=new UserRegistrationStatus();
			status.setStatus(true);
			status.setStatusMessage("user register successfully");
			status.setCustomerId(id);
			return status;
			
		}
		catch(PmsServiceException e) {
			UserRegistrationStatus status=new UserRegistrationStatus();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
			
		}
		
	}
}
