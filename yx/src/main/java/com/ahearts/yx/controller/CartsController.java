package com.ahearts.yx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahearts.yx.domain.Carts;
import com.ahearts.yx.service.CartsService;
import com.ahearts.yx.util.JsonData;

@RestController
public class CartsController {

	@Autowired
	private CartsService cartsService;
	
	@PostMapping("/api/carts/add")
	public Object addToCart() {
		Carts carts = new Carts();
		return JsonData.buildSuccess(carts.getId());
	}
}
