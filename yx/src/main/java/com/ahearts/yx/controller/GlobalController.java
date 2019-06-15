package com.ahearts.yx.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ahearts.yx.domain.Carts;
import com.ahearts.yx.domain.Cates;
import com.ahearts.yx.domain.Users;
import com.ahearts.yx.service.CartsService;
import com.ahearts.yx.service.CatesService;
import com.ahearts.yx.service.UsersService;

@ControllerAdvice
public class GlobalController {
	
//	@Autowired
//	private CatesService catesService;
	
	@Autowired
	private CartsService cartsService;
	
	@Autowired
	private UsersService usersService;
	
//	@ModelAttribute(name="catesmenu")
//	public List<Cates> catesmenu() {
//		return catesService.getAll();
//	}
	
//	@ModelAttribute(name="cartsall")
//	public List<Carts> cartsAll() {
//		return cartsService.getByUserId(1);
//	}
	
	@ModelAttribute(name="userinfo")
	public Users UserinfoAll() {
		return usersService.getUserById(1);
	}
	
	@ModelAttribute(name="cartsum")
	public BigDecimal CartSum() {
		return cartsService.cartSumByUser(1);
	}
}
