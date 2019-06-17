package com.ahearts.yx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ServiceTabController {

	@GetMapping("/services")
	public String ServicePage() {
		return "services";
	}
}
