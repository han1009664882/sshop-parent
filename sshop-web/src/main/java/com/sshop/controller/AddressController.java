package com.sshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sshop.annotation.IsLogin;
import com.sshop.core.base.BaseController;
import com.sshop.core.base.ResultInfo;
import com.sshop.core.model.Address;
import com.sshop.core.util.LoginUserUtil;
import com.sshop.service.AddressService;
@RequestMapping("address")
@Controller
public class AddressController extends BaseController {
	
	@Autowired
	private AddressService addressService;
	
	@RequestMapping("add")
	@ResponseBody
	@IsLogin
	public ResultInfo find(Address address, HttpServletRequest request) {
		int userId = LoginUserUtil.releaseUserIdFromSession(request);
		address.setUserId(userId);
		addressService.addAddress(address);
		return success("添加成功");
	}
	
}
