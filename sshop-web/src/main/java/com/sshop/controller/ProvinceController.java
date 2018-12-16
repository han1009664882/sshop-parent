package com.sshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sshop.core.base.BaseController;
import com.sshop.core.base.ResultInfo;
import com.sshop.core.model.Province;
import com.sshop.service.ProvinceService;

@Controller
@RequestMapping("province")
public class ProvinceController extends BaseController {
	
	@Autowired
	private ProvinceService provinceService;
	
	
	@RequestMapping("find")
	@ResponseBody
	public ResultInfo findAll() {
		List<Province> provinces = provinceService.findAll();
		return success(provinces);
		
	}
	
}
