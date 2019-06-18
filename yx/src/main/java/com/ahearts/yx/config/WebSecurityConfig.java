package com.ahearts.yx.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ahearts.yx.domain.Users;
import com.ahearts.yx.service.UsersService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//
//    	PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        manager.createUser(User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("").build());
//        manager.createUser(User.withUsername("guest").password(passwordEncoder.encode("guest")).roles("").build());
//        return manager;
//    }
    
	@Autowired
	private UsersService usersService;

	
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            List<Users> users = usersService.getUserByName(username);
            if (users == null || users.size() == 0) {
                throw new UsernameNotFoundException("用户名未找到");
            }
            String password = users.get(0).getUserpasswd();
            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            String passwordAfterEncoder = passwordEncoder.encode(password);
            return User.withUsername(username).password(passwordAfterEncoder).roles("").build();
        };
    }
    
    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {
//        	@Override
//            public void configure(WebSecurity web) throws Exception {
//                web.ignoring().antMatchers
//                        ("/index/**", "/images/**","/css/**","/fonts/**","/js/**","/img/**", "/product/**", "/services/**");
//            }
            @Override
            public void configure(HttpSecurity httpSecurity) throws Exception {
            	httpSecurity.authorizeRequests()
                .antMatchers("/index/**", "/images/**","/css/**","/fonts/**","/js/**","/img/**", "/product/**", "/login/**", "/logout/**"//, "/services/**"
                )
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                // 自动登录
                .and()
                    .rememberMe()
                    // 加密的秘钥
                    .key("unique-and-secret")
                    // 存放在浏览器端cookie的key
                    .rememberMeCookieName("remember-me-cookie-name")
                    // token失效的时间，单位为秒
                    .tokenValiditySeconds(60 * 60 * 25)
                .and()
                // 暂时禁用CSRF，否则无法提交登录表单
                .csrf().disable();
            }
        };
    }

}