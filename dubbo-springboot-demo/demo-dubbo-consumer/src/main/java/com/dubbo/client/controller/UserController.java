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
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Reference
	UserService userService;

	/*@GetMapping��һ�����ע�⣬��@RequestMapping(method = RequestMethod.GET)����д��
	 * @PostMapping��һ�����ע�⣬��@RequestMapping(method = RequestMethod.POST)����д��*/
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
		
		logger.error("����ERROR�������־��");
		logger.warn("����WARN�������־��");
		logger.info("����INFO�������־��");
		logger.debug("����DEBUG�������־��");
		
		if(userName.equals("lzq")&&userPasswd.equals("lzq")){
			res.sendRedirect("http://47.107.145.108/loginsucc.html");
			System.out.println("Hi,"+userName+",you are login succ!");
			logger.info("Hi,"+userName+",you are login succ!");
			logger.debug("Hi,"+userName+",you are login succ!");

			return "login_succ";
		}
		else{
			res.sendRedirect("http://47.107.145.108/loginfail.html");
			System.out.println("Hei,"+userName+",you are login fail!please check your name&passwd again!");
			logger.info("Hei,"+userName+",you are login fail!please check your name&passwd again!");
			logger.debug("Hei,"+userName+",you are login fail!please check your name&passwd again!");
			logger.error("Hei,"+userName+",you are login fail!please check your name&passwd again!");
			return "login_fail";
		}
		
	}
}
