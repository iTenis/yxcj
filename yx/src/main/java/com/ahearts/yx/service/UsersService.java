package com.ahearts.yx.service;


import java.util.List;

import com.ahearts.yx.domain.Users;

public interface UsersService {
	
	public int add(Users users);
	
	public Users getUserById(int id);
	
	public List<Users> getUserByName(String username);
}
