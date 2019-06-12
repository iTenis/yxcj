package com.ahearts.yx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahearts.yx.domain.Goods;
import com.ahearts.yx.mapper.GoodsMapper;
import com.ahearts.yx.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public int add(Goods goods) {
		goodsMapper.insert(goods);
		return goods.getId();
	}

	@Override
	public List<Goods> getAll() {
		List<Goods> goods = goodsMapper.getAll();
		return goods;
	}

	@Override
	public Goods getById(int id) {
		Goods goods = goodsMapper.findById(id);
		return goods;
	}

	@Override
	public void updateById(Goods goods) {
		goodsMapper.update(goods);
		
	}

	@Override
	public void deleteById(int id) {
		goodsMapper.deleteById(id);		
	}

	@Override
	public int total() {	
		return goodsMapper.total();
	}

	@Override
	public List<Goods> pageNext(int currentpage, int pagesize) {
		List<Goods> goods = goodsMapper.pageNext(currentpage, pagesize);
		return goods;
	}

}
