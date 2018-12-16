package com.sshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sshop.core.base.BaseController;
import com.sshop.core.base.ResultInfo;
import com.sshop.core.model.Account;
import com.sshop.service.AccountService;
@RequestMapping("account")
@Controller
public class AccountController extends BaseController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("find")
	@ResponseBody
	public ResultInfo find() {
		List<Account> result = accountService.findAll();
		return success(result);
	}
	
}
