package com.sshop.dao;

import java.util.List;

import com.sshop.core.base.BaseDao;
import com.sshop.core.model.Province;

public interface ProvinceDao extends BaseDao<Province> {
	
	/**
	 * 查询所有的省市区
	 * @return
	 */
	public List<Province> findAll();

	
}
