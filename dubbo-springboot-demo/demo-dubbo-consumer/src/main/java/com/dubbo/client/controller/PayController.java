package com.dubbo.client.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class PayController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/qrCodeAnalyse.do")
	public String qrCodeAnalyse(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String qrNo=req.getParameter("qrNo");
		
		if(qrNo.equals("6636076")){
			if(isWXBrowser(req)){
				LOGGER.info("你正在使用微信进行支付！");
				LOGGER.info("qrcode is ok! Begin forword to [ http://47.107.145.108/qrcode-ok.html ]");
				res.sendRedirect("http://47.107.145.108/H5WeiXinPay.html");
			}else if(isALIBrowser(req)){
				LOGGER.info("你正在使用支付宝进行支付！");
				LOGGER.info("qrcode is ok! Begin forword to [ http://47.107.145.108/qrcode-ok.html ]");
				res.sendRedirect("http://47.107.145.108/H5AliPay.html");
			}else if(isUCBrowser(req)){
				LOGGER.info("你正在使用本行卡进行支付！");
				LOGGER.info("qrcode is ok! Begin forword to [ http://47.107.145.108/qrcode-ok.html ]");
				res.sendRedirect("http://47.107.145.108/qrcode-ok.html");
			}else{
				LOGGER.info("请使用微信，支付宝或本行卡进行支付！");
				res.sendRedirect("http://47.107.145.108/payErr.html");
				return "error";
			}
		}else{
			LOGGER.info("[qrNo="+qrNo+"]二维码解析失败!请检查你的二维码是否正确！");
			res.sendRedirect("http://47.107.145.108/payErr.html");
			return "error";
		}
		return "succ";
	}
	
	@RequestMapping("/H5MchtPay.do")
	public String H5MchtPay(HttpServletRequest req,HttpServletResponse res) throws IOException{
		//qrNumber channel  sum
		req.getParameter("qrNumber");
		req.getParameter("channel");
		req.getParameter("sum");
		
		//直接返回成功(附带参数返回)
		//res.sendRedirect("http://47.107.145.108/success.html?");
		res.sendRedirect("http://47.107.145.108/qrcode-ok.html");
		return "H5MchtPay";
	}
	
	protected boolean isWXBrowser(HttpServletRequest req){
		boolean isWx=false;
		if(req.getHeader("User-Agent") != null){
			LOGGER.info("客户端字符串：["+req.getHeader("User-Agent")+"]");
			if(req.getHeader("User-Agent").indexOf("MicroMessenger") >= 0){
				isWx = true;
			}
		}
		return isWx;
	}
	protected boolean isUCBrowser(HttpServletRequest req){
		boolean isUc=false;
		if(req.getHeader("User-Agent") != null){
			LOGGER.info("客户端字符串：["+req.getHeader("User-Agent")+"]");
			if(req.getHeader("User-Agent").indexOf("UCBrowser") >= 0){
				isUc = true;
			}
		}
		return isUc;
	}
	
	protected boolean isALIBrowser(HttpServletRequest req){
		boolean isAli=false;
		if(req.getHeader("User-Agent") != null){
			LOGGER.info("客户端字符串：["+req.getHeader("User-Agent")+"]");
			if(req.getHeader("User-Agent").indexOf("AlipayClient") >= 0){
				isAli = true;
			}
		}
		return isAli;
	}
}
