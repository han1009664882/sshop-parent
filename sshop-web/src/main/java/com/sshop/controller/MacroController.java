package com.sshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sshop.core.base.BaseController;

@RequestMapping("macro")
@Controller
public class MacroController extends BaseController {
	
	@RequestMapping("{type}")
	public String first(@PathVariable String type) {
		return "macro/macro_" + type;
	}
	
}
