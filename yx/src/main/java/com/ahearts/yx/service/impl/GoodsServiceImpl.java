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
		return goodsMapper.getAll();
	}

	@Override
	public Goods getById(int id) {
		return goodsMapper.findById(id);
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
		return goodsMapper.pageNext(currentpage, pagesize);
	}

	@Override
	public List<Goods> getGoodsWithCatesNum(int num, int cateid) {
		return goodsMapper.getGoodsWithCatesNum(num, cateid);
	}

	@Override
	public List<Goods> getGoodsTopN(int topN) {
		return goodsMapper.getGoodsTopN(topN);
	}

	@Override
	public List<Goods> getGoodsHotTopN(int topN) {
		return goodsMapper.getGoodsHotTopN(topN);
	}

}
