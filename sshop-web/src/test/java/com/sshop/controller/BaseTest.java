package com.sshop.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:servlet-context.xml", "classpath:spring-mybatis.xml"})
public class BaseTest {
	
	@Test
	public void test() {
		
	}
	
}
