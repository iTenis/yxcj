package com.ahearts.yx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ahearts.yx.service.CartsService;
import com.ahearts.yx.service.UsersService;
import com.ahearts.yx.util.JsonData;

@Controller
public class CheckOutController {

	@Autowired
	private CartsService cartsService;
	
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/checkout")
	public String checkOut(Model model,HttpSession session) {
		SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		int id = usersService.getUserByName(securityContext.getAuthentication().getName()).get(0).getId();
		model.addAttribute("carts", JsonData.buildSuccess(cartsService.getByCartsAgg(id)));
		model.addAttribute("goodsSum", cartsService.cartSumByUser(id));
		return "checkout";
	}
	
	
}
