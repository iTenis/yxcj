package com.ahearts.yx.service;

import java.util.List;

import com.ahearts.yx.domain.Cates;

public interface CatesService {
	
	public int add(Cates cates);
	
	public List<Cates> getAll();
	
	public Cates getById(int id);
	
	public void updateById(Cates cates);
	
	public void deleteById(int id);
}
