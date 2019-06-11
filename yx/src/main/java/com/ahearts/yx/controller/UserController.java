package com.ahearts.yx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@GetMapping("/home")
	@ResponseBody
	public Object home() {
		return "test";
	}
}
