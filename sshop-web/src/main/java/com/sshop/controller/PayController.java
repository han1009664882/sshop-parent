package com.sshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sshop.annotation.IsLogin;
import com.sshop.core.base.BaseController;
import com.sshop.core.constant.Constant;
import com.sshop.core.constant.PayContant;
import com.sshop.core.dto.PayCallbackParams;
import com.sshop.core.util.LoginUserUtil;
import com.sshop.core.util.pay.PayUtil;
import com.sshop.core.vo.BaseOrder;
import com.sshop.service.OrderService;
@RequestMapping("pay")
@Controller
public class PayController extends BaseController {
	
	@Autowired
	private OrderService orderService;
	@Value("${PARTNER}")
	private String partner;
	@Value("${KEY}")
	private String key;
	@Value("${USER_SELLER}")
	private String user_seller;
	@Value("${GATEWAY_NEW}")
	private String gateway_new;
	
	@RequestMapping("page/{orderNo}")
	@IsLogin
	public String pay(@PathVariable String orderNo, HttpServletRequest request, Model model) {
		int userId = LoginUserUtil.releaseUserIdFromSession(request);
		BaseOrder baseOrder = orderService.findBaseOrder(orderNo, userId);
		model.addAttribute("baseOrder", baseOrder);
		model.addAttribute("gateway_new", gateway_new);
		String domain = PayUtil.buildDomain(request);
		String notify_url = domain + PayContant.notify_url;
		model.addAttribute("notify_url", notify_url);
		model.addAttribute("partner", partner);
		String return_url = domain + PayContant.return_url;
		model.addAttribute("return_url", return_url);
		model.addAttribute("user_seller", user_seller);
		String sign = PayUtil.generateSign(baseOrder, notify_url, partner, return_url, 
				user_seller, key);
		model.addAttribute("sign", sign);
		
		return "pay";
	}
	
	@RequestMapping("notify_url")
	@IsLogin
	public String notifyUrl(PayCallbackParams payCallbackParams, 
			Model model, HttpServletRequest request) {
		int userId = LoginUserUtil.releaseUserIdFromSession(request);
		orderService.handlerCallback(payCallbackParams, userId, key, partner);
		model.addAttribute("money", payCallbackParams.getTotal_fee());
		model.addAttribute("orderNo", payCallbackParams.getOut_order_no());
		model.addAttribute("resultCode", Constant.RESULT_OK);
		return "pay_success";
	}
	
	@RequestMapping("return_url")
	@IsLogin
	public String returnUrl(PayCallbackParams payCallbackParams, 
			Model model, HttpServletRequest request) {
		int userId = LoginUserUtil.releaseUserIdFromSession(request);
		orderService.handlerCallback(payCallbackParams, userId, key, partner);
		model.addAttribute("money", payCallbackParams.getTotal_fee());
		model.addAttribute("orderNo", payCallbackParams.getOut_order_no());
		model.addAttribute("resultCode", Constant.RESULT_OK);
		return "pay_success";
	}
	
	
}
