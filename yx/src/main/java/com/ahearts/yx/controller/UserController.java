package com.ahearts.yx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ahearts.yx.service.CommentsService;
import com.ahearts.yx.util.JsonData;

@Controller
public class UserController {


	@GetMapping("/test")
	public String home() {
		return "test";
	}
}
