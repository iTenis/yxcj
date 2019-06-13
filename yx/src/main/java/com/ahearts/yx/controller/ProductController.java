package com.ahearts.yx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ahearts.yx.domain.Comments;
import com.ahearts.yx.domain.Goods;
import com.ahearts.yx.service.CommentsService;
import com.ahearts.yx.service.GoodsService;

@Controller
public class ProductController {

	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private CommentsService commentsService;
	
	@GetMapping("/product")
	public String product(Model model,int id,int currentpage,int pagesize) {	
		Goods goods = goodsService.getById(id);
		String[] preview_pics = goods.getGoodspreview().split(";");
		System.out.println("------------------------"+goods.getId());
		List<Comments> comments = commentsService.pageNext(goods.getId(), pagesize * (currentpage - 1 ), pagesize);
		
		int commentstotal = comments.size()+1;
		model.addAttribute("goodsid", goods.getId());
		model.addAttribute("commentstotoal",commentstotal);
		model.addAttribute("currentpage", currentpage);
		model.addAttribute("pagesize", pagesize);
		model.addAttribute("totalpage", commentstotal/pagesize);
		
		
		model.addAttribute("goods",goods);
		model.addAttribute("previewpics",preview_pics);
		model.addAttribute("comments",comments);
		model.addAttribute("goodsmore", goodsService.getGoodsWithCatesNum(4, goods.getCates().getCateid()));
		return "product";
	}
}
