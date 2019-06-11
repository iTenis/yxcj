package com.ahearts.yx.service;

import java.util.List;


import com.ahearts.yx.domain.Goods;

public interface GoodsService {
	
	public int add(Goods goods);
	
	public List<Goods> getAll();
	
	public Goods getById(int id);
	
	public void updateById(Goods goods);
	
	public void deleteById(int id);
}
