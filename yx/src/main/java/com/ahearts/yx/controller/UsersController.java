package com.ahearts.yx.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ahearts.yx.domain.Users;
import com.ahearts.yx.service.UsersService;
import com.ahearts.yx.util.JsonData;


@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	
	@GetMapping("/api/users/getuser")
	public Object getUserByID(int id) {
		return JsonData.buildSuccess(usersService.getUserById(id));
	}
	
	@GetMapping("/api/users/getbyname")
	public Object getUserByName(String name) {
		int num = usersService.getUserByName(name).size();
		if(num > 0) {
			return JsonData.buildSuccess("red", 400);
		}
		return JsonData.buildSuccess("green", 200);
	}
	
	@PostMapping("/api/user/add")
	public void AddUser(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws IOException {
//		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(request.getParameter("birthday")));
		Users users = new Users();
		users.setUsername(request.getParameter("username"));
		users.setUserpasswd(request.getParameter("password"));
		users.setUserlevel(1);
		users.setUserphone(request.getParameter("mobilePhone"));
		users.setUseremail(request.getParameter("email"));
		if (request.getParameter("birthday") != "")
			users.setUserbrith(Date.valueOf(request.getParameter("birthday")));
		usersService.add(users);
		response.sendRedirect("/login");
	}
}
