package com.ahearts.yx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ahearts.yx.service.GoodsService;

@Controller
public class IndexController {
	
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/index")
	public String Index(Model model) {
		model.addAttribute("goodshot", goodsService.getAll());
		model.addAttribute("goodstj", goodsService.getAll());
		model.addAttribute("goodstop1", goodsService.getAll());
		model.addAttribute("goodstop2", goodsService.getAll());
		model.addAttribute("goodstop3", goodsService.getAll());
		return "index";
	}
}
