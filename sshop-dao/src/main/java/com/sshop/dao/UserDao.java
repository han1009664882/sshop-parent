package com.sshop.dao;

import org.apache.ibatis.annotations.Param;

import com.sshop.core.base.BaseDao;
import com.sshop.core.model.User;

public interface UserDao extends BaseDao<User> {
	
	/**
	 * 根据手机号查询用户
	 * @param mobile
	 * @return
	 */
	public User findByMobile(@Param(value="mobile") String mobile);

}
