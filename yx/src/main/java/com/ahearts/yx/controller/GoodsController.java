package com.ahearts.yx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahearts.yx.mapper.GoodsMapper;
import com.ahearts.yx.util.JsonData;

@RestController
public class GoodsController {
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@GetMapping("/api/goods/getall")
	public Object getAll() {
		
		return JsonData.buildSuccess(goodsMapper.getAll());
	}
}
