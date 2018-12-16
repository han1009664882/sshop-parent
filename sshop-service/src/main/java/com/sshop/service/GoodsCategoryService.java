package com.sshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.sshop.core.constant.RedisKeyContant;
import com.sshop.core.model.GoodsCategory;
import com.sshop.core.vo.GoodsCategoryVo;
import com.sshop.dao.GoodsCategoryDao;

@Service
public class GoodsCategoryService {
	
	@Autowired
	private GoodsCategoryDao goodsCategoryDao;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	
	
	/**
	 * 获取默认的所有商品类别
	 * @return
	 */
	public List<GoodsCategoryVo> findDefaultCategory() {
		// 返回结果
		List<GoodsCategoryVo> goodsCategoryVos = new ArrayList<>();
		try {
			// 先从缓存读取
			BoundHashOperations<String, String, GoodsCategoryVo> hashOps = 
					redisTemplate.boundHashOps(RedisKeyContant.CATEGORY_KEY);
			
			Map<String, GoodsCategoryVo> goodsCategoryMap = hashOps.entries();
			if(goodsCategoryMap != null && !goodsCategoryMap.isEmpty()) {
				for (GoodsCategoryVo  goodsCategoryVo : goodsCategoryMap.values()) {
					goodsCategoryVos.add(goodsCategoryVo);
				}
				return goodsCategoryVos;
			}
			
			// 从数据库中读取
			List<GoodsCategory> goodsCategories = goodsCategoryDao.findDefaultCategory();
			for (GoodsCategory goodsCategory : goodsCategories) {
				GoodsCategoryVo goodsCategoryVo = new GoodsCategoryVo();
				BeanUtils.copyProperties(goodsCategory, goodsCategoryVo);
				goodsCategoryVos.add(goodsCategoryVo);
				goodsCategoryMap.put(goodsCategoryVo.getId() + "", goodsCategoryVo);
			}
			// 添加缓存
			hashOps.putAll(goodsCategoryMap);
			return goodsCategoryVos;
			
		} catch (Exception e) {
			List<GoodsCategory> goodsCategories = goodsCategoryDao.findDefaultCategory();
			for (GoodsCategory goodsCategory : goodsCategories) {
				GoodsCategoryVo goodsCategoryVo = new GoodsCategoryVo();
				BeanUtils.copyProperties(goodsCategory, goodsCategoryVo);
				goodsCategoryVos.add(goodsCategoryVo);
			}
		}
		
		
		return goodsCategoryVos;
	}
	
}
