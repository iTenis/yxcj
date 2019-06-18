package com.ahearts.yx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ahearts.yx.domain.Users;

public interface UsersMapper {
	
	@Insert("INSERT INTO users(id, user_name, user_passwd, user_email, user_phone, user_level, user_brith) VALUES (#{id}, #{username}, #{userpasswd}, #{useremail}, #{userphone}, #{userlevel}, #{userbrith})")
	@Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
	public int add(Users users);
	
	@Select("SELECT * FROM users WHERE id = #{id}")
	@Results({
		@Result(id = true,column ="id",property = "id"),
		@Result(column ="user_name",property = "username"),
		@Result(column ="user_passwd",property = "userpasswd"),
		@Result(column ="user_email",property = "useremail"),
		@Result(column ="user_phone",property = "userphone"),
		@Result(column ="user_level",property = "userlevel"),
		@Result(column ="user_brith",property = "userbrith"),
		@Result(column ="id",property = "carts",many = @Many(select="com.ahearts.yx.mapper.CartsMapper.getByUserId")),
	})
	public Users getUserById(int id);
	
	@Select("SELECT * FROM users")
	@Results({
		@Result(id = true,column ="id",property = "id"),
		@Result(column ="user_name",property = "username"),
		@Result(column ="user_passwd",property = "userpasswd"),
		@Result(column ="user_email",property = "useremail"),
		@Result(column ="user_phone",property = "userphone"),
		@Result(column ="user_level",property = "userlevel"),
		@Result(column ="user_brith",property = "userbrith"),
		@Result(column ="id",property = "carts",many = @Many(select="com.ahearts.yx.mapper.CartsMapper.getByUserId")),
	})
	public List<Users> getAllUser();
	
	@Select("SELECT * FROM users WHERE user_name = #{username}")
	@Results({
		@Result(id = true,column ="id",property = "id"),
		@Result(column ="user_name",property = "username"),
		@Result(column ="user_passwd",property = "userpasswd"),
		@Result(column ="user_email",property = "useremail"),
		@Result(column ="user_phone",property = "userphone"),
		@Result(column ="user_level",property = "userlevel"),
		@Result(column ="user_brith",property = "userbrith"),
		@Result(column ="id",property = "carts",many = @Many(select="com.ahearts.yx.mapper.CartsMapper.getByUserId")),
	})
	public List<Users> getUserByName(String username);
}
