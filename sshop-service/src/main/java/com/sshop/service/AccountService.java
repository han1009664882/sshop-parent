package com.sshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sshop.core.model.Account;
import com.sshop.dao.AccountDao;

@Service
public class AccountService {
	
	@Autowired
	private AccountDao accountDao;

	public List<Account> findAll() {
		List<Account> allAccounts = accountDao.findAll();
		return allAccounts;
	}

	public void addToAccount(String password, String mobile) {
		Account account = new Account();
		account.setPhone(mobile);
		account.setPwd(password);
		accountDao.insert(account);
	}
}
