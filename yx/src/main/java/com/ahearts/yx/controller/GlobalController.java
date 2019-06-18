package com.ahearts.yx.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ahearts.yx.domain.Users;
import com.ahearts.yx.service.CartsService;
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

	@ModelAttribute(name = "userinfo")
	public Users UserinfoAll(HttpSession session) {
		SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		if (securityContext != null) {
			return usersService.getUserByName(securityContext.getAuthentication().getName()).get(0);
		}
		return null;
	}

	@ModelAttribute(name = "cartsum")
	public BigDecimal CartSum(HttpSession session) {
		SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		if (securityContext != null) {
			return cartsService.cartSumByUser(usersService.getUserByName(securityContext.getAuthentication().getName()).get(0).getId());
		}
		return new BigDecimal(0);
	}
}
