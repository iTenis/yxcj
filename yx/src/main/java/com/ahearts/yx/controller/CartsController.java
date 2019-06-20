package com.ahearts.yx.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ahearts.yx.domain.Carts;
import com.ahearts.yx.service.CartsService;
import com.ahearts.yx.service.UsersService;
import com.ahearts.yx.util.JsonData;
import com.alibaba.fastjson.JSONObject;

@RestController
public class CartsController {

	@Autowired
	private CartsService cartsService;
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value = "/api/carts/add",method = RequestMethod.POST,consumes="application/json")
	@ResponseBody
	public Object addToCart(@RequestBody String jsonParamStr,HttpSession session) {
		try {
			SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
			JSONObject jsonObject = JSONObject.parseObject(jsonParamStr);
			Carts carts = new Carts();
			if(jsonObject.get("goodsnum") == null) {
				carts.setCartnum(1);
			}else {
				carts.setCartnum(jsonObject.getInteger("goodsnum"));
			}
			carts.setCartgoodsid(jsonObject.getIntValue("id"));
			carts.setCarttime(new Timestamp(System.currentTimeMillis()));
			carts.setCartuserid(usersService.getUserByName(securityContext.getAuthentication().getName()).get(0).getId());
			cartsService.add(carts);
			List<Carts> cartsall = cartsService.getByUserId(carts.getCartuserid());
			return JsonData.buildSuccess(cartsall, 200);
		} catch (Exception e) {
			return JsonData.buildError("error",400);
		}
		
	}
	
	@RequestMapping(value = "/api/carts/delete" , method = RequestMethod.POST ,consumes = "application/json")
	@ResponseBody
	public Object deleteCarts(@RequestBody String jsonParamStr) {
		JSONObject jsonObject = JSONObject.parseObject(jsonParamStr);
		int uid = jsonObject.getIntValue("uid");
		int gid = jsonObject.getIntValue("gid");
		cartsService.delete(uid, gid);
		return JsonData.buildSuccess("success");
	}
}
