package com.sshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sshop.annotation.IsLogin;
import com.sshop.core.base.BaseController;
import com.sshop.core.base.ResultInfo;
import com.sshop.core.model.Address;
import com.sshop.core.util.LoginUserUtil;
import com.sshop.core.vo.DoBuyVo;
import com.sshop.service.AddressService;
import com.sshop.service.OrderService;
@RequestMapping("order")
@Controller
public class OrderController extends BaseController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private AddressService addressService;
	
	@RequestMapping("buyGoods.html")
	@IsLogin
	public String find(Integer detailId, String ids, String size, 
			HttpServletRequest request, Model model) {
		
		Map<String, String> paramMaps = buildParameterMap(request);
		
		// 获取商品信息
		DoBuyVo doBuyVo = orderService.buildDoBuy(detailId, ids, size, paramMaps);
		model.addAttribute("dobuy", doBuyVo);
		
		// 获取用户地址信息
		Integer loginUserId = LoginUserUtil.releaseUserIdFromSession(request);
		List<Address> addresses = addressService.findUserAddress(loginUserId);
		model.addAttribute("addresses", addresses);
		
		return "buy_goods";
	}
	
	@RequestMapping("json/buyGoods")
	@ResponseBody
	public ResultInfo findJSON(Integer detailId, String ids, String size, 
			HttpServletRequest request, Model model) {
		
		Map<String, String> paramMaps = buildParameterMap(request);
		
		// 获取商品信息
		DoBuyVo doBuyVo = orderService.buildDoBuy(detailId, ids, size, paramMaps);
		model.addAttribute("doBuyVo", doBuyVo);
		
		// 获取用户地址信息
		Integer loginUserId = LoginUserUtil.releaseUserIdFromSession(request);
		List<Address> addresses = addressService.findUserAddress(loginUserId);
		model.addAttribute("addresses", addresses);
		Map<String, Object> result = new HashMap<>();
		result.put("doBuyVo", doBuyVo);
		result.put("addresses", addresses);
		return success(result);
	}
	
	@RequestMapping("create")
	@ResponseBody
	@IsLogin
	public ResultInfo createOrder(HttpServletRequest request, Integer addressId, 
			Integer goodsDetailId, Integer count, String message, String attr, 
			String ids) {
		Integer userId = LoginUserUtil.releaseUserIdFromSession(request);
		String orderNo = orderService.createOrder(userId, addressId, goodsDetailId,
				count, message, attr, ids);
		return success(orderNo);
	}
	
}
