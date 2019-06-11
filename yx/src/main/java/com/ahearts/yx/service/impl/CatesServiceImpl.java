package com.ahearts.yx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahearts.yx.domain.Cates;
import com.ahearts.yx.mapper.CatesMapper;
import com.ahearts.yx.service.CatesService;

@Service
public class CatesServiceImpl implements CatesService{

	@Autowired
	private CatesMapper catesMapper;
	
	@Override
	public int add(Cates cates) {
		catesMapper.insert(cates);
		return cates.getCateid();
	}

	@Override
	public List<Cates> getAll() {
		List<Cates> cates = catesMapper.getAll();
		return cates;
	}

	@Override
	public Cates getById(int id) {
		Cates cates = catesMapper.findById(id);
		return cates;
	}

	@Override
	public void updateById(Cates cates) {
		catesMapper.update(cates);
	}

	@Override
	public void deleteById(int id) {
		catesMapper.delete(id);
		
	}

}
