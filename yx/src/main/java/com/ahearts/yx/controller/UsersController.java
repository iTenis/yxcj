package com.ahearts.yx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahearts.yx.service.UsersService;
import com.ahearts.yx.util.JsonData;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	
	@GetMapping("/api/users/getuser")
	public Object getUserByID(int id) {
		return JsonData.buildSuccess(usersService.getUserById(id));
	}
}
