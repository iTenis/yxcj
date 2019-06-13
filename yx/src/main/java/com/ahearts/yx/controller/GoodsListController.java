package com.ahearts.yx.controller;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ahearts.yx.service.CatesService;
import com.ahearts.yx.service.GoodsService;

@Controller
public class GoodsListController {

	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private CatesService catesService;
	
	@GetMapping("/product/list")
	public String GoodsList(Model model,int currentpage,int pagesize) {
		int goodstotal = goodsService.total();
		model.addAttribute("goodstotoal",goodstotal);
		model.addAttribute("currentpage", currentpage);
		model.addAttribute("pagesize", pagesize);
		model.addAttribute("totalpage", goodstotal/pagesize);
		model.addAttribute("goodsall",goodsService.pageNext(pagesize * (currentpage - 1 ), pagesize));
		model.addAttribute("catesall",catesService.getAll());
		model.addAttribute("goodshot", goodsService.getGoodsHotTopN(5));
		return "productlist";
	}
}
