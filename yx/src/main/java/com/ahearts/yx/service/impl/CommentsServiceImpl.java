package com.ahearts.yx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahearts.yx.domain.Comments;
import com.ahearts.yx.mapper.CommentsMapper;
import com.ahearts.yx.service.CommentsService;

@Service
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	private CommentsMapper commentsMapper;
	
	@Override
	public int add(Comments comments) {
		commentsMapper.insert(comments);
		return comments.getId() ;
	}

	@Override
	public List<Comments> getByGoodsId(int id) {
		List<Comments> comments = commentsMapper.findById(id);
		return comments;
	}

}
