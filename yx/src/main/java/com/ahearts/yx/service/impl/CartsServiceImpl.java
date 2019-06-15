package com.ahearts.yx.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahearts.yx.domain.Carts;
import com.ahearts.yx.mapper.CartsMapper;
import com.ahearts.yx.service.CartsService;

@Service
public class CartsServiceImpl implements CartsService{

	@Autowired
	private CartsMapper cartsMapper;
	
	@Override
	public int add(Carts carts) {
		return cartsMapper.add(carts);
	}

	@Override
	public List<Carts> getByUserId(int id) {
		return cartsMapper.getByUserId(id);
	}

	@Override
	public BigDecimal cartSumByUser(int id) {
		return cartsMapper.cartSumByUser(id);
	}

}
