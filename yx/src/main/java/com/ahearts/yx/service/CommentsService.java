package com.ahearts.yx.service;

import java.util.List;

import com.ahearts.yx.domain.Comments;


public interface CommentsService {
	
	public int add(Comments comments);
	
	public List<Comments> getByGoodsId(int id);
	
	public int total();
	
	List<Comments> pageNext(int id,int currentpage , int pagesize);
}
