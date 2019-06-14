package com.ahearts.yx.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ahearts.yx.service.CommentsService;
import com.ahearts.yx.util.JsonData;
import com.alibaba.fastjson.JSONObject;

@RestController
public class CommentsController {

//	@Autowired
//	private CommentsService commentsService;
//	
//	@ResponseBody
//	@RequestMapping(value = "/api/comments/getbyid",
//	        method = RequestMethod.POST,
//	        consumes="application/json")
//	public Object getById(@RequestBody String jsonParamStr) {
//		System.out.println("+++++++++++++++++"+jsonParamStr);//{"id":"1","currentpage":"1","pagesize":"1"}
//		JSONObject jsonObject = JSONObject.parseObject(jsonParamStr); 
//		return JsonData.buildSuccess(0, "","success" ,jsonObject.getIntValue("currentpage") , jsonObject.getIntValue("pagesize"), commentsService.total());
//	}
}
