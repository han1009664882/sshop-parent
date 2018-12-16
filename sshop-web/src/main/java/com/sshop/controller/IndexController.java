package com.sshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sshop.core.base.BaseController;
import com.sshop.core.constant.QueryGoodsType;
import com.sshop.core.query.GoodsQuery;
import com.sshop.core.vo.GoodsCategoryVo;
import com.sshop.core.vo.GoodsDetailVo;
import com.sshop.service.GoodsCategoryService;
import com.sshop.service.GoodsDetailService;
@RequestMapping("")
@Controller
public class IndexController extends BaseController {
	
	@Autowired
	private GoodsDetailService goodsDetailService;
	@Autowired
	private GoodsCategoryService goodCategoryService;
	
	@RequestMapping("index")
	public String index(GoodsQuery goodsQuery, Model model) {
		
		// 热门商品
		List<GoodsDetailVo> hotGoods = goodsDetailService
				.findIndexGoods(QueryGoodsType.HOT.getType());
		model.addAttribute("hotGoods", hotGoods);
		
		// 最新商品
		List<GoodsDetailVo> newGoods = goodsDetailService
				.findIndexGoods(QueryGoodsType.NEW.getType());
		model.addAttribute("newGoods", newGoods);
		
		// 商品类别
		List<GoodsCategoryVo> goodsCategories = goodCategoryService.findDefaultCategory();
		model.addAttribute("goodsCategories", goodsCategories);
		
		// 某个商品类别下的商品
		List<GoodsDetailVo> categoryGoods = goodsDetailService
				.findIndexGoods(QueryGoodsType.CATEGORY.getType());
		model.addAttribute("categoryGoods", categoryGoods);
		return "index";
	}
}
