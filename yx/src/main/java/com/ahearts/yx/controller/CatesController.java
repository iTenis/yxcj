package com.ahearts.yx.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ahearts.yx.domain.Cates;
import com.ahearts.yx.service.CatesService;
import com.ahearts.yx.util.JsonData;

@RestController
//@RequestMapping("/api/cates")
public class CatesController {
	
	@Autowired
	private CatesService catesService;

	@GetMapping("/addview")
	public ModelAndView addview() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addview");
		return mv;
	}
	
	@PostMapping("/api/cates/add")
	public Object Add(HttpServletRequest request) {
		Cates cate = new Cates();
		cate.setCatename(request.getParameter("name"));
		cate.setCatedesc(request.getParameter("desc"));
		int id = catesService.add(cate);
		System.out.println(cate.getCatename());
		return JsonData.buildSuccess(id);
	}
	
	@GetMapping("/api/cates/getall")
	public Object getAll() {
		return JsonData.buildSuccess(catesService.getAll());
	}
	
	@GetMapping("/api/cates/getbyid")
	public Object getById(int id) {
		return JsonData.buildSuccess(catesService.getById(id));
	}
	
	@GetMapping("/api/cates/delbyid")
	public Object delById(int id) {
		catesService.deleteById(id);
		return JsonData.buildSuccess();
	}
	
	@PostMapping("/api/cates/update")
	public Object update(HttpServletRequest request) {
		Cates cate = catesService.getById(Integer.parseInt(request.getParameter("id")));		
		cate.setCatename(request.getParameter("name"));
		cate.setCatedesc(request.getParameter("desc"));
		catesService.updateById(cate);
		return JsonData.buildSuccess();
	}
}
