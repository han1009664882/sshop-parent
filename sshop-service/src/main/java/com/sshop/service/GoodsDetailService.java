package com.sshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.sshop.core.constant.Constant;
import com.sshop.core.constant.QueryGoodsType;
import com.sshop.core.model.Goods;
import com.sshop.core.model.GoodsDetail;
import com.sshop.core.model.GoodsPart;
import com.sshop.core.model.Images;
import com.sshop.core.model.Producer;
import com.sshop.core.model.UserDnaType;
import com.sshop.core.query.GoodsQuery;
import com.sshop.core.util.AssertUtil;
import com.sshop.core.vo.GoodsDetailVo;
import com.sshop.core.vo.GoodsVo;
import com.sshop.dao.GoodsCategoryDao;
import com.sshop.dao.GoodsDao;
import com.sshop.dao.GoodsDetailDao;
import com.sshop.dao.GoodsPartDao;
import com.sshop.dao.UserDnaTypeDao;

@Service
public class GoodsDetailService {
	
	@Autowired
	private GoodsDetailDao goodsDetailDao;
	@Autowired
	private ImageService imageService;
	@Autowired
	private GoodsCategoryDao goodsCategoryDao;
	@Autowired
	private ProducerService producerService;
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private GoodsPartDao goodsPartDao;
	@Autowired
	private UserDnaTypeDao userDnaTypeDao;
	
	
	/**
	 * 获取首页数据
	 * @param type
	 * @return
	 */
	public List<GoodsDetailVo> findIndexGoods(String type) {
		
		// 构建查询条件
		GoodsQuery goodsQuery = buildGoodsQuery(type);
		
		// 分页查询数据
		PageList<GoodsDetail> goods = goodsDetailDao.findHotNewCategoryGoods
				(goodsQuery, goodsQuery.initPageBounds());
		
		// 构建返回结果
		List<GoodsDetailVo> goodsDetailVos = buildVo(goods);
		return goodsDetailVos;
	}
	
	/**
	 * 分页查询商品信息
	 * @param goodsQuery
	 * @return
	 */
	public PageList<GoodsDetailVo> selectForPage(GoodsQuery goodsQuery) {
		AssertUtil.notEmpty(goodsQuery.getType());
		goodsQuery.setLimit(12);
		String sort = QueryGoodsType.findByType(goodsQuery.getType()).getSort();
		goodsQuery.setSort(sort);
		
		// 分页查询数据
		PageList<GoodsDetail> goods = goodsDetailDao.findHotNewCategoryGoods
				(goodsQuery, goodsQuery.initPageBounds());
		Paginator paginator = goods.getPaginator();
		
		// 构建返回结果
		List<GoodsDetailVo> goodsDetailVos = buildVo(goods);
		
		return new PageList<>(goodsDetailVos, paginator);
	}
	
	/**
	 * 获取列表页面的title
	 * @param type 
	 * @param categoryId
	 * @return
	 */
	public String findTitle(String type, Integer categoryId) {
		AssertUtil.notEmpty(type);
		String title = "";
		if (QueryGoodsType.CATEGORY.getType().equals(type) && categoryId != null) { // 如果是分类
			title = goodsCategoryDao.findCategoryName(categoryId);
		} else {
			title = QueryGoodsType.findByType(type).getTitle();
		}
		return title;
	}
	
	/**
	 * 根据商品ID获取详情数据
	 * @param id
	 */
	public GoodsVo findDetail(Integer detailId) {
		
		// 基本参数验证
		AssertUtil.isTrue(detailId == null || detailId < 1, "该商品不存在。");
		
		// 返回的结果对象
		GoodsVo goodsVo = new GoodsVo();
		
		// 获取GoodsDetail信息
		GoodsDetail goodsDetail = goodsDetailDao.loadById(detailId);
		AssertUtil.isTrue(goodsDetail == null, "该商品不存在。");
		
		// 添加基本属性
		buildSingleVo(goodsDetail, goodsVo);
		
		String goodsCode = goodsDetail.getGoodsCode();
		
		// 获取到goods信息
		Goods goods = goodsDao.findByCode(goodsCode);
		AssertUtil.isTrue(goods == null, "该商品不存在。");
		addGoodsInfo(goods, goodsVo);
		
		// 获取生产者的信息
		Producer producer = producerService.findGoodsProducer(goods.getUserId());
		goodsVo.setProducer(producer);
		
		// 获取商品图片
		List<Images> goodsImages = imageService.findGoodsImages(goodsCode);
		goodsVo.setGoodsImages(goodsImages);
		
		// 获取部件
		List<GoodsPart> goodsParts = goodsPartDao.findGoodsPart(goods.getId());
		// 验证是否存在零部件
		checkGoodsParts(goodsParts, detailId, goodsCode);
		goodsVo.setGoodsParts(goodsParts);
		
		// 获取商品默认属性
		List<UserDnaType> defaultAttributes = userDnaTypeDao.findGoodsDefaultDna(goods.getCode());
		goodsVo.setDefaultAttributes(defaultAttributes);
		
		// 获取商品其他属性
		List<UserDnaType> attributes = userDnaTypeDao.findGoodsDna(goods.getCode());
		goodsVo.setAttributes(attributes);
		
		return goodsVo;
	}
	
	/**
	 * 根据图片的ids多个以,分隔
	 * @param imageIds
	 * @param goodsCode
	 */
	public GoodsDetailVo findPartGoods(String imageIds, String goodsCode) {
		AssertUtil.notEmpty(imageIds, "请选择商品");
		AssertUtil.notEmpty(goodsCode, "请选择商品");
		GoodsDetail goodsDetail = goodsDetailDao.findGoodsByImageIds(imageIds);
		GoodsDetailVo goodsDetailVo = new GoodsDetailVo();
		buildSingleVo(goodsDetail, goodsDetailVo);
		
		return goodsDetailVo;
	}
	
	/**
	 * 通过ID获取商品VO
	 * @param detailId
	 * @return
	 */
	public GoodsDetailVo findDetailByDetailId(Integer detailId) {
		AssertUtil.isTrue(detailId == null || detailId < 1, "请选择商品");
		GoodsDetail goodsDetail = goodsDetailDao.loadByIdJoinGoods(detailId);
		AssertUtil.notNull(goodsDetail, "请选择商品");
		GoodsDetailVo goodsDetailVo = new GoodsDetailVo();
		buildSingleVo(goodsDetail, goodsDetailVo);
		return goodsDetailVo;
	}
	
	/**
	 * 构建查询条件
	 * @param type
	 * @return
	 */
	private GoodsQuery buildGoodsQuery(String type) {
		GoodsQuery goodsQuery = new GoodsQuery();
		AssertUtil.notEmpty(type);
		if (QueryGoodsType.CATEGORY.getType().equals(type)) {
			goodsQuery.setLimit(3);
			goodsQuery.setCategoryId(2); // 设置一个分类
		} else {
			goodsQuery.setLimit(8);
		}
		String sort = QueryGoodsType.findByType(type).getSort();
		goodsQuery.setSort(sort);
		return goodsQuery;
	}
	
	/**
	 * 构建返回结果
	 * @param goods
	 * @return
	 */
	private List<GoodsDetailVo> buildVo(List<GoodsDetail> goods) {
		List<GoodsDetailVo> goodsDetailVos = new ArrayList<>();
		for (GoodsDetail goodsDetail : goods) {
			GoodsDetailVo goodsDetailVo = new GoodsDetailVo();
			// 构建
			buildSingleVo(goodsDetail, goodsDetailVo);
			
			goodsDetailVos.add(goodsDetailVo);
			
		}
		return goodsDetailVos;
	}
	
	/**
	 * 构建单个VO
	 * @param goodsDetail 商品详情
	 * @param goodsDetailVo 返回的VO
	 */
	private void buildSingleVo(GoodsDetail goodsDetail, GoodsDetailVo goodsDetailVo) {
		// copy属性
		BeanUtils.copyProperties(goodsDetail, goodsDetailVo);
		// 获取商品图片
		String images = imageService.findGoodsDetailImage(goodsDetail.getCode());
		goodsDetailVo.setImages(images);
		// 读取生产者的图片
		if (goodsDetail.getProducerId() != null && goodsDetail.getProducerId() > 1) {
			Producer producer = producerService.findGoodsProducer(goodsDetail.getProducerId());
			goodsDetailVo.setProducer(producer);
		}
		
	}
	
	/**
	 * copy商品的基本信息
	 * @param goods
	 * @param goodsVo
	 */
	private void addGoodsInfo(Goods goods, GoodsVo goodsVo) {
//		private Integer goodsId; // 商品主键
//		private String description; // 描述
//		private String origin; // 制作原由
//		private String reviews; // 制作心得
//		private Integer type; // 0=小微商家 1=实力生产商
		goodsVo.setGoodsId(goods.getId());
		goodsVo.setDescription(goods.getDescription());
		goodsVo.setOrigin(goods.getOrigin());
		goodsVo.setReviews(goods.getReviews());
		goodsVo.setType(goods.getType());
	}
	
	/**
	 * 判断商品是否有零部件 如果没有就获取默认
	 * @param goodsParts
	 * @param detailId
	 * @param goodsCode
	 */
	private void checkGoodsParts(List<GoodsPart> goodsParts, 
			Integer detailId, String goodsCode) {
		
		if (goodsParts == null || goodsParts.isEmpty()) {
			if(goodsParts == null) {
				goodsParts = new ArrayList<>();
			}
			GoodsPart goodsPart = new GoodsPart();
			goodsPart.setId(detailId);
			goodsPart.setName(Constant._DEFAULT_PART_NAME_);
			List<Images> list = imageService.findDefaultPartImages(goodsCode);
	    	goodsPart.setImages(list);
			goodsParts.add(goodsPart);
		}
	}
}
