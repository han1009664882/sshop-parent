package com.sshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sshop.core.model.Province;
import com.sshop.dao.ProvinceDao;

@Service
public class ProvinceService {
	
	@Autowired
	private ProvinceDao provinceDao;

	public List<Province> findAll() {
		List<Province> provinces = provinceDao.findAll();
		return provinces;
	}
	
	
}
