package com.sshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sshop.core.constant.Constant;
import com.sshop.core.model.Address;
import com.sshop.core.util.AssertUtil;
import com.sshop.dao.AddressDao;

@Service
public class AddressService {
	
	@Autowired
	private AddressDao addressDao;
	
	public List<Address> findUserAddress(Integer userId) {
		AssertUtil.isTrue(userId == null || userId < 1, Constant.LOGIN_FIRST);
		return addressDao.findUserAddress(userId);
	}

	public void addAddress(Address address) {
		
		// 参数验证
		checkParams(address);
		// 添加
		addressDao.insert(address);
		
		
	}

	private void checkParams(Address address) {
		String contacterName = address.getContacterName();
		AssertUtil.notEmpty(contacterName, "请输入联系人");
		
		String phoneNumber = address.getPhoneNumber();
		AssertUtil.notEmpty(phoneNumber, "请输入联系电话");
		
		String postalCode = address.getPostalCode();
		AssertUtil.notEmpty(postalCode, "请输入邮编");
		
		Integer provinceId = address.getProvinceId();
		AssertUtil.isTrue(provinceId == null || provinceId < 1, "请选择省份");
		
		Integer cityId = address.getCityId();
		AssertUtil.isTrue(cityId == null || cityId < 1, "请选择城市");
		Integer areaId = address.getAreaId();
		AssertUtil.isTrue(areaId == null || areaId < 1, "请选择地区");
		String addr = address.getDetailedAddress();
		AssertUtil.notEmpty(addr, "请输入详细地址");
		
	}

}
