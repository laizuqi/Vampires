package com.dubbo.client.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.api.UserService;
import com.dubbo.entity.UserDO;

@RestController
@RequestMapping("/user")
public class UserController {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Reference
	UserService userService;

	/*@GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。
	 * @PostMapping是一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写。*/
	@GetMapping("/findById/{id}")
	public UserDO findById(@PathVariable Long id) {
		return userService.findById(id);
	}

	@GetMapping("/listUser")
	public List<UserDO> listUser() {
		return userService.listUser();
	}
	
	@GetMapping("/login")
	public String UserLogin(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String userName=req.getParameter("name");
		String userPasswd=req.getParameter("passwd");
		
        LOGGER.trace("logback的--trace日志--输出了");
        LOGGER.debug("logback的--debug日志--输出了");
        LOGGER.info("logback的--info日志--输出了");
        LOGGER.warn("logback的--warn日志--输出了");
        LOGGER.error("logback的--error日志--输出了");
		
		if(userName.equals("lzq")&&userPasswd.equals("lzq")){
			res.sendRedirect("http://47.107.145.108/loginsucc.html");
			System.out.println("Hi,"+userName+",you are login succ!");
			LOGGER.info("Hi,"+userName+",you are login succ!");
			LOGGER.debug("Hi,"+userName+",you are login succ!");

			return "login_succ";
		}
		else{
			res.sendRedirect("http://47.107.145.108/loginfail.html");
			System.out.println("Hei,"+userName+",you are login fail!please check your name&passwd again!");
			LOGGER.info("Hei,"+userName+",you are login fail!please check your name&passwd again!");
			LOGGER.debug("Hei,"+userName+",you are login fail!please check your name&passwd again!");
			LOGGER.error("Hei,"+userName+",you are login fail!please check your name&passwd again!");
			return "login_fail";
		}
		
	}
}
