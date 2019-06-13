package com.ahearts.yx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ahearts.yx.domain.Cates;
import com.ahearts.yx.service.CatesService;

@ControllerAdvice
public class GlobalController {
	
	@Autowired
	private CatesService catesService;
	
	@ModelAttribute(name="catesmenu")
	public List<Cates> catesmenu() {
		return catesService.getAll();
	}
}
