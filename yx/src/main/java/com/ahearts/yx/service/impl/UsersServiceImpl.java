package com.ahearts.yx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahearts.yx.domain.Cates;
import com.ahearts.yx.domain.Users;
import com.ahearts.yx.mapper.UsersMapper;
import com.ahearts.yx.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersMapper usersMapper;

	@Override
	public int add(Users users) {
		return usersMapper.add(users);
	}

	@Override
	public Users getUserById(int id) {
		return usersMapper.getUserById(id);
	}
	
	
}
