package com.ahearts.yx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	@GetMapping("/login")
	public String login() {
	    return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
}
