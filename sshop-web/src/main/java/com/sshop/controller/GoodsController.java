package com.sshop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.sshop.core.base.BaseController;
import com.sshop.core.base.Page;
import com.sshop.core.query.GoodsQuery;
import com.sshop.core.vo.GoodsDetailVo;
import com.sshop.core.vo.GoodsVo;
import com.sshop.service.GoodsDetailService;
@RequestMapping("goods")
@Controller
public class GoodsController extends BaseController {
	
	@Autowired
	private GoodsDetailService goodsDetailService;
	@Value("${image.prefix}")
	private String imagePrefix;
	
	@RequestMapping("list")
	public String list(GoodsQuery goodsQuery, Model model) {
		
		PageList<GoodsDetailVo> result = goodsDetailService.selectForPage(goodsQuery);
		model.addAttribute("data", result);
		Page page = new Page();
		BeanUtils.copyProperties(result.getPaginator(), page);
		model.addAttribute("paginator", page);
		model.addAttribute("query", goodsQuery);
		// 获取标题
		String title = goodsDetailService.findTitle(goodsQuery.getType()
				, goodsQuery.getCategoryId());
		model.addAttribute("title", title);
		
		return "goods";
	}
	
	@RequestMapping("list_json")
	@ResponseBody
	public Object findJSON(GoodsQuery goodsQuery, Model model) {
		
		PageList<GoodsDetailVo> result = goodsDetailService.selectForPage(goodsQuery);
		Map<String, Object>map = new HashMap<>();
		map.put("data", result);
		map.put("paginator", result.getPaginator());
		map.put("query", goodsQuery);
		// 获取标题
		String title = goodsDetailService.findTitle(goodsQuery.getType()
				, goodsQuery.getCategoryId());
		map.put("title", title);
		
		return map;
	}
	
	@RequestMapping("detail/{id}")
	public String findDetail(@PathVariable Integer id,
			Model model) {
		
		GoodsVo goods = goodsDetailService.findDetail(id);
		model.addAttribute("goods", goods);
		model.addAttribute("imagePrefix", imagePrefix);
		
		return "goods_detail";
	}
	
	@RequestMapping("detail/{id}.json")
	@ResponseBody
	public GoodsVo findDetailJSON(@PathVariable Integer id,
			Model model) {
		
		GoodsVo goods = goodsDetailService.findDetail(id);
		
		return goods;
	}
	
	@RequestMapping("partGoods")
	@ResponseBody
	public GoodsDetailVo findPartGoods(String ids, String goodsCode) {
		GoodsDetailVo goodsDetailVo = goodsDetailService.findPartGoods(ids, goodsCode);
		return goodsDetailVo;
	}
	
	
}
