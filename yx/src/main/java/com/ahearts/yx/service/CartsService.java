package com.ahearts.yx.service;


import java.math.BigDecimal;
import java.util.List;

import com.ahearts.yx.domain.Carts;

public interface CartsService {
	
	public int add(Carts carts);
	
	public List<Carts> getByUserId(int id);
	
	public BigDecimal cartSumByUser(int id);
}
