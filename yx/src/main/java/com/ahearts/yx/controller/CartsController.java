package com.ahearts.yx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ahearts.yx.service.CartsService;
import com.ahearts.yx.util.JsonData;
import com.alibaba.fastjson.JSONObject;

@RestController
public class CartsController {

	@Autowired
	private CartsService cartsService;
	
	@ResponseBody
	@RequestMapping(value = "/api/carts/add",
	        method = RequestMethod.POST,
	        consumes="application/json")
	public Object addToCart(@RequestBody String jsonParamStr) {
		JSONObject jsonObject = JSONObject.parseObject(jsonParamStr); 
//		return JsonData.buildSuccess(0, "","success" ,jsonObject.getIntValue("currentpage") , jsonObject.getIntValue("pagesize"), commentsService.total());
		System.out.println("+++++++++++++++++++"+jsonObject.getIntValue("id"));
		return JsonData.buildSuccess(jsonObject.getIntValue("id"));
	}
}
