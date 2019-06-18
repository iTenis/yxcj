package com.ahearts.yx.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class MyLogoutSuccessHandle implements LogoutSuccessHandler {

    @Override
	 public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
	        System.out.println("==================>>>> LogoutSuccessHandler Begin");
	        System.out.println(authentication.getPrincipal());
	        System.out.println("==================>>>> LogoutSuccessHandler End");
	    }
}
