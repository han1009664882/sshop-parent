package com.sshop.sms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class Application {
	
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("classpath:application.xml");
	}
	
}
