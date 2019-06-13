package com.ahearts.yx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ahearts.yx.service.CatesService;
import com.ahearts.yx.service.GoodsService;

@Controller
public class IndexController {
	
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/index")
	public String Index(Model model) {
		model.addAttribute("goodshot", goodsService.getGoodsHotTopN(10));
		model.addAttribute("goodstj", goodsService.getGoodsTopN(10));
		return "index";
	}
	
}
