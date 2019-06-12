package com.ahearts.yx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ahearts.yx.domain.Goods;
import com.ahearts.yx.service.GoodsService;

@Controller
public class ProductController {

	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/product")
	public String product(Model model,int id) {	
		Goods goods = goodsService.getById(id);
		String[] preview_pics = goods.getGoodspreview().split(";");
		System.out.println(preview_pics);
		model.addAttribute("goods",goods);
		model.addAttribute("previewpics",preview_pics);
		return "product";
	}
}
