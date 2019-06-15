package com.ahearts.yx.service;


import com.ahearts.yx.domain.Users;

public interface UsersService {
	
	public int add(Users users);
	
	public Users getUserById(int id);
}
