package com.ahearts.yx.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahearts.yx.mapper.CartsMapper;
import com.ahearts.yx.util.JsonData;

@RestController
public class testapi {

	@Autowired
	private CartsMapper cartsMapper;
	
	@GetMapping("/tests")
	public Object test() {
		return JsonData.buildSuccess(cartsMapper.getByCartsAgg(2));
	}
}
