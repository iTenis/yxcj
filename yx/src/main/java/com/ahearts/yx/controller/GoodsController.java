package com.ahearts.yx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahearts.yx.domain.Goods;
import com.ahearts.yx.service.GoodsService;
import com.ahearts.yx.util.JsonData;

@RestController
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/api/goods/getall")
	public Object getAll() {
		return goodsService.getAll();
	}
	
	@RequestMapping("/api/goods/getbyid")
	public Object getByid(int id) {
		return JsonData.buildSuccess(goodsService.getById(id));
	}
	
	@GetMapping("/api/goods/delete")
	public void delete(int id) {
		goodsService.deleteById(id);
	}
	
	@PostMapping("/api/goods/update")
	public void update(int id) {
		goodsService.getById(id);
	}
	
	@GetMapping("/api/goods/total")
	public Object totoal() {
		return JsonData.buildSuccess(0, 0, "success", 0, 0, goodsService.total());
	}
	
	/**
	 * 商品翻页查询
	 * @param currentpage
	 * @param pagesize
	 * @return 当前页面所有条目
	 */
	@GetMapping("/api/goods/page")
	public Object totoal(int currentpage , int pagesize) {
		List<Goods > goods = goodsService.pageNext(pagesize * (currentpage - 1 ), pagesize);
		return JsonData.buildSuccess(0, goods, "success", currentpage, pagesize, goodsService.total());
	}
}
