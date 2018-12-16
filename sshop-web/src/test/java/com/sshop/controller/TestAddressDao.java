package com.sshop.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sshop.core.model.Address;
import com.sshop.dao.AddressDao;

public class TestAddressDao extends BaseTest {
	
	@Autowired
	private AddressDao addressDao;
	
	
	@Test
	public void test() {
		Address addr = addressDao.findAddress();
		System.out.println(addr.toString());
	}

}
