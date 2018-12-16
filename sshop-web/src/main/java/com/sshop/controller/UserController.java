package com.sshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.sshop.core.base.BaseController;
import com.sshop.core.base.ResultInfo;
import com.sshop.core.constant.Constant;
import com.sshop.core.vo.UserLoginIdentity;
import com.sshop.service.UserService;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("signup.html")
	public String signupPage(String backurl, Model model) {
		if (StringUtils.isEmpty(backurl)) {
			backurl = "index";
		}
		model.addAttribute("backurl", backurl);
		return "signup";
	}
	
	@RequestMapping("signup")
	@ResponseBody
	public ResultInfo signup(String mobile, String code, String firstname, 
			String lastname, String imgCode, String password, String confirmPwd, 
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 从session中获取手机验证码
		String mobileCodeFromSession = (String) session.getAttribute(
				Constant.SEND_VERIFYCODE + mobile);
		// 获取图片验证码内容
		String imgCodeFromSession =  (String) session.getAttribute(
				Constants.KAPTCHA_SESSION_KEY);
		UserLoginIdentity userLoginIdentity = userService.signup(mobile, code, 
				firstname, lastname, imgCode, password, confirmPwd, 
				mobileCodeFromSession, imgCodeFromSession);
		
		session.setAttribute(Constant.LOGIN_USER_KEY, userLoginIdentity);
		
		return success(userLoginIdentity);
	}
	
	@RequestMapping("login.html")
	public String loginPage(String backurl, Model model) {
		if (StringUtils.isEmpty(backurl)) {
			backurl = "index";
		}
		model.addAttribute("backurl", backurl);
		return "login";
	}
	
	@RequestMapping("login")
	@ResponseBody
	public ResultInfo login(String mobile, String imgCode, String password, 
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 获取图片验证码内容
		String imgCodeFromSession =  (String) session.getAttribute(
				Constants.KAPTCHA_SESSION_KEY);
		UserLoginIdentity userLoginIdentity = userService.login(mobile, imgCode, 
				password, imgCodeFromSession);
		
		session.setAttribute(Constant.LOGIN_USER_KEY, userLoginIdentity);
		
		return success(userLoginIdentity);
	}
	
	@RequestMapping("logout.html")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(Constant.LOGIN_USER_KEY);
		return "redirect:../index";
	}
	
}
