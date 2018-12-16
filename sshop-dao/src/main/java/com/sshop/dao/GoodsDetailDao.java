package com.sshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.sshop.core.base.BaseDao;
import com.sshop.core.model.GoodsDetail;
import com.sshop.core.query.GoodsQuery;

public interface GoodsDetailDao extends BaseDao<GoodsDetail> {
	
	/**
	 * 分页查询热门商品数据
	 * @param initPageBounds
	 * @return
	 */
	public List<GoodsDetail> findHotGoods(PageBounds pageBounds);
	
	/**
	 * 分页获取最新商品
	 * @param pageBounds
	 * @return
	 */
	public List<GoodsDetail> findNewGoods(PageBounds pageBounds);
	
	/**
	 * 查询某个类别下的商品
	 * @param categoryId
	 * @return
	 */
	public List<GoodsDetail> findByCategoryId(@Param(value = "categoryId")Integer categoryId);
	
	/**
	 * 分页获取热门、最新、类别的商品信息
	 * @param goodsQuery
	 * @param pageBounds
	 */
	public PageList<GoodsDetail> findHotNewCategoryGoods(GoodsQuery goodsQuery, PageBounds pageBounds);
	
	/**
	 * 根据图片组合获取商品信息
	 * @param imageIds
	 * @return
	 */
	public GoodsDetail findGoodsByImageIds(String imageIds);
	
	/**
	 * 获取detail信息和producerID
	 * @param id
	 * @return
	 */
	public GoodsDetail loadByIdJoinGoods(@Param(value="id") Integer id);
	
	
	/**
	 * 获取商品名称
	 * @param goodsDetailId
	 * @return
	 */
	public String findGoodsName(@Param(value="id")Integer goodsDetailId);
	
	/**
	 * 获取多个商品名
	 * @param goodsDetailIds
	 * @return
	 */
	public String findGoodsNames(@Param(value="ids")String goodsDetailIds);

	public GoodsDetail findDetailById(@Param(value="ids")Integer detailId);
	
	/**
	 * 更新商品数量
	 * @param count
	 */
	public int updateSaleCount(@Param(value="count")Integer count, @Param(value="id")Integer id);

}
