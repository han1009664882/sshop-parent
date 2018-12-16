package com.sshop.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sshop.core.base.ResultInfo;


public class TestAccountController extends BaseTest {
	
	@Autowired
	private AccountController accountController;
	
	@Test
	public void testFind() {
		try {
			ResultInfo resultInfo = accountController.find();
			System.out.println(resultInfo.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
