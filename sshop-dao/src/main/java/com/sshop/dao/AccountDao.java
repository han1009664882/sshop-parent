package com.sshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sshop.core.base.BaseDao;
import com.sshop.core.model.Account;

public interface AccountDao extends BaseDao<Account> {
	
	@Select("select * from account")
	public List<Account> findAll();

}
