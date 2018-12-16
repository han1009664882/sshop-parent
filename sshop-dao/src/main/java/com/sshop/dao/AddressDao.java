package com.sshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sshop.core.base.BaseDao;
import com.sshop.core.model.Address;

public interface AddressDao extends BaseDao<Address> {

	public List<Address> findUserAddress(Integer userId);
	
	@Select("select * from ADDRESS limit 1")
	public Address findAddress();
	
}
