package com.sshop.service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sshop.core.constant.Constant;
import com.sshop.core.constant.OrderStatus;
import com.sshop.core.constant.PayContant;
import com.sshop.core.dto.PayCallbackParams;
import com.sshop.core.exception.PayException;
import com.sshop.core.model.Images;
import com.sshop.core.model.OrderDetail;
import com.sshop.core.model.Orders;
import com.sshop.core.util.AssertUtil;
import com.sshop.core.util.pay.PayUtil;
import com.sshop.core.vo.BaseOrder;
import com.sshop.core.vo.DoBuyVo;
import com.sshop.core.vo.GoodsDetailVo;
import com.sshop.dao.GoodsDao;
import com.sshop.dao.GoodsDetailDao;
import com.sshop.dao.OrderDetailDao;
import com.sshop.dao.OrdersDao;

@Service
public class OrderService {
	
	private static Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private GoodsDetailService goodsDetailService;
	@Autowired
	private ImageService imageService;
	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private OrderDetailDao orderDetailDao;
	@Autowired
	private GoodsDetailDao goodsDetailDao;
	@Autowired
	private GoodsDao goodsDao;

	public DoBuyVo buildDoBuy(Integer detailId, String ids, 
			String size, Map<String, String> allParams) {
		
		// 基本参数验证
		AssertUtil.isTrue(detailId == null || detailId < 1, "请选择商品");

		// 构建属性
		String dna = buidDna(allParams, size);

		// 查询商品信息
		GoodsDetailVo goodsDetailVo = goodsDetailService.findDetailByDetailId(detailId);

		// 获取商品 用料
		List<Images> partsImages = imageService.findByIds(ids);

		DoBuyVo doBuyVo = new DoBuyVo();
		doBuyVo.setDetailId(detailId);
		doBuyVo.setDna(dna);
		doBuyVo.setGoods(goodsDetailVo);
		doBuyVo.setIds(ids);
		doBuyVo.setPartsImages(partsImages);
		doBuyVo.setToken(UUID.randomUUID().toString()); // 生成随机的uuid
		
		return doBuyVo;
	}
	
	/**
	 * 创建订单
	 * @param userId
	 * @param addressId
	 * @param goodsDetailId
	 * @param count
	 * @param message
	 * @param attr
	 * @param ids
	 * @return 
	 */
	public String createOrder(Integer userId, Integer addressId, 
			Integer goodsDetailId, Integer count, String message,
			String attr, String ids) {
		
		// 基本参数验证
		checkCreateOrderParam(userId, addressId, goodsDetailId, count);
		
		// 获取商品信息
		GoodsDetailVo goodsDetailVo = goodsDetailService.findDetailByDetailId(goodsDetailId);
		AssertUtil.isTrue(goodsDetailVo == null, "该商品不存在，请重新选择");
		
		// 生成订单编号
		String orderNo = "C" + System.currentTimeMillis();
		
		// 插入订单表以及其他表
		saveOrders(addressId, userId, orderNo, count, goodsDetailVo);
		saveOrderDetail(attr, count, goodsDetailId, ids, message, orderNo, 
				goodsDetailVo.getPrice());
		// 返回订单NO
		return orderNo;
	}
	
	/**
	 * 根据订单号获取订单信息
	 * @param orderNo
	 * @return
	 */
	public BaseOrder findBaseOrder(String orderNo, int userId) {
		
		AssertUtil.notEmpty(orderNo, "支付失败，订单号为空。");
		Orders orders = ordersDao.findByOrderNo(orderNo);
		AssertUtil.isTrue(orders == null, "支付失败，订单号为：{}, 请联系客户.", orderNo);
		// 验证是否是该用户发起支付
		AssertUtil.isTrue(userId != orders.getCustomerId(), "请确定你的订单是否正确：{}", orderNo);
		AssertUtil.isTrue(orders.getPrice() == null || orders.getPrice().doubleValue() < 0, 
				"请确定你的订单是否正确：{}", orderNo);
		BaseOrder baseOrder = new BaseOrder();
		baseOrder.setOrderNo(orderNo);
		// 精确到两位（四舍五入）
		BigDecimal price = orders.getPrice();
		String priceStr = price.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + ""; 
		baseOrder.setPrice(priceStr);
		
		// 获取订单详情
		List<OrderDetail> orderDetails = orderDetailDao.findByOrderNo(orderNo);
		AssertUtil.isTrue(orderDetails == null || orderDetails.size() < 1, 
				"请确定你的订单是否正确：{}", orderNo);
		
		String goodsName = findGoodsName(orderDetails);
		baseOrder.setGoodsName(goodsName);
		
		return baseOrder;
	}
	
	/**
	 * 处理支付回调
	 * @param payCallbackParams
	 */
	public void handlerCallback(PayCallbackParams payCallbackParams, 
			Integer userId, String key, String partner) {
		
		// 基本参数验证
		checkPayCallbackParams(payCallbackParams);
		String orderNo = payCallbackParams.getOut_order_no();
		BigDecimal totalFee = payCallbackParams.getTotal_fee();
		String tradeNo = payCallbackParams.getTrade_no();
		
		// 回调签名验证
		checkCallbackSign(payCallbackParams, key, partner);
		
		// 获取支付订单
		Orders orders = checkOrders(orderNo, userId, totalFee);
		 // 订单的支付状态不是待支付
		if (OrderStatus.WATTING.getValue() != orders.getOrderStatus()) {
			return;
		}
		
		// 子订单验证
		List<OrderDetail> orderDetails = orderDetailDao.findByOrderNo(orderNo);
		if (orderDetails == null || orderDetails.isEmpty()) {
			throw new PayException("该订单的子订单不存在。");
		}
		
		// 更新订单的状态
		updateOrdersStatusAfterPay(orders, tradeNo);
		
		// 更新商品的数量（可以添加至消息队列处理）
		updateGoodsSaleAmount(orderDetails);
		
	}
	
	
	/**
	 * 构建用户属性
	 * @param allParams
	 * @param size
	 * @return
	 */
	private String buidDna(Map<String, String> allParams, String size) {
		StringBuilder dna = new StringBuilder();
		// 获取基本样式
		if (StringUtils.isNotBlank(size)) {
			dna.append(Constant._DEFAULT_SIZE);
			dna.append(size);
			dna.append(Constant._FENHAO);
		}
		// 获取dna属性
		for (String key : allParams.keySet()) {
			if (key.matches(".*[\\u4e00-\\u9faf].*")) { // 匹配中文
				String value = (String) allParams.get(key);
				dna.append(key);
				dna.append(Constant._MAOHAO_);
				if (value != null && StringUtils.isNotBlank(value)) {
					dna.append(value);
					dna.append(Constant._UNIT_);
					dna.append(Constant._FENHAO);
				} else {
					value = "---";
					dna.append(value);
					dna.append(Constant._FENHAO);
				}
			}
		}
		String dnaString = dna.toString();
		if (StringUtils.isNotBlank(dnaString) ) {
			dnaString = dnaString.substring(0, dnaString.lastIndexOf(Constant._FENHAO));
		}
		logger.info("用户的数据： {}", dnaString);
		return dnaString;
	}
	
	/**
	 * 基本参数验证
	 * @param userId
	 * @param addressId
	 * @param goodsDetailId
	 * @param count
	 */
	private void checkCreateOrderParam(Integer userId, Integer addressId, 
			Integer goodsDetailId, Integer count) {
		AssertUtil.isTrue(userId == null || userId < 1, "请登录");
		AssertUtil.isTrue(addressId == null || addressId < 1, "请选择地址");
		AssertUtil.isTrue(goodsDetailId == null || goodsDetailId < 1, "请选择商品");
		AssertUtil.isTrue(count == null || count < 1, "请输入购买数量");
	}
	
	/**
	 * 保存订单的基本信息
	 * @param addressId
	 * @param userId
	 * @param orderNo
	 * @param count
	 * @param goodsDetailVo
	 * @return
	 */
	private Integer saveOrders(Integer addressId, Integer userId, String orderNo, 
			int count, GoodsDetailVo goodsDetailVo) {
		Orders orders = new Orders();
		orders.setAddressId(addressId);
		orders.setCustomerId(userId);
		orders.setIsReceive(0);
		orders.setOrderNo(orderNo);
		orders.setOrderPreStatus(OrderStatus.WATTING.getValue());
		orders.setOrderStatus(OrderStatus.WATTING.getValue());
		orders.setOrderTime(new Date());
		orders.setPayStatus(OrderStatus.WATTING.getValue());
		double totalPrice = count * goodsDetailVo.getPrice().doubleValue();
		orders.setPrice(new BigDecimal(totalPrice));
		orders.setProducerId(goodsDetailVo.getProducer().getId());
		ordersDao.insert(orders);
		return orders.getId();
	}
	
	/**
	 * 保存订单详情
	 * @param attr
	 * @param count
	 * @param goodsDetailId
	 * @param ids
	 * @param message
	 * @param orderNo
	 * @param price
	 */
	private void saveOrderDetail(String attr, Integer count, 
			Integer goodsDetailId, String ids, String message, 
			String orderNo, BigDecimal price) {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setAttr(attr);
		orderDetail.setCount(count);
		String detailNo = "S" + System.currentTimeMillis();
		orderDetail.setDetailNo(detailNo);
		orderDetail.setGoodsDetailId(goodsDetailId);
		orderDetail.setIds(ids);
		orderDetail.setMessage(message);
		orderDetail.setOrderNo(orderNo);
		orderDetail.setPrice(price);
		orderDetailDao.insert(orderDetail);
		
	}
	
	/**
	 * 获取商品名称
	 * @param orderDetails
	 * @return
	 */
	private String findGoodsName (List<OrderDetail> orderDetails) {
		String goodsName = "";
		if (orderDetails.size() == 1) { // 只有一个商品
			goodsName = goodsDetailDao.findGoodsName(orderDetails.get(0).getGoodsDetailId());
		} else {
			String detailIds = "";
			for (OrderDetail orderDetail : orderDetails) {
				detailIds += orderDetail.getGoodsDetailId() + ",";
			}
			detailIds = detailIds.substring(0, detailIds.lastIndexOf(","));
			goodsName = goodsDetailDao.findGoodsNames(detailIds);
		}
		return goodsName;
	}
	
	/**
	 * 参数验证
	 * @param payCallbackParams
	 */
	private void checkPayCallbackParams(PayCallbackParams payCallbackParams) {
		String tradeStatus = payCallbackParams.getTrade_status();
		if (StringUtils.isBlank(tradeStatus)) {
			throw new PayException("回调支付状态没有。");
		}
		if (!PayContant.TRADE_SUCCESS.equals(tradeStatus)) {
			throw new PayException("支付失败，请联系客服");
		}
		String orderNo = payCallbackParams.getOut_order_no();
		if (StringUtils.isBlank(orderNo)) {
			throw new PayException("支付订单未知。");
		}
		String sign = payCallbackParams.getSign();
		if (StringUtils.isBlank(sign)) {
			throw new PayException("签名未知。");
		}
		BigDecimal totalFee = payCallbackParams.getTotal_fee();
		if (totalFee == null || totalFee.doubleValue() < 0) {
			throw new PayException("支付金额为0。");
		}
		String tradeNo = payCallbackParams.getTrade_no();
		if (StringUtils.isBlank(tradeNo)) {
			throw new PayException("交易流水号未知。");
		}
	}
	
	/**
	 * 签名验证
	 * @param payCallbackParams
	 * @param key
	 * @param partner
	 */
	private boolean checkCallbackSign(PayCallbackParams payCallbackParams,
			String key, String partner) {
		boolean verifyResult = false;
		try {
			verifyResult = PayUtil.md5VerifyCallbackSign(payCallbackParams.getOut_order_no(), 
					payCallbackParams.getTotal_fee(), payCallbackParams.getTrade_status(), 
					payCallbackParams.getSign(), key, partner);
		} catch (UnsupportedEncodingException e) {
			logger.error("签名验证失败：{}", e);
			throw new PayException(e.toString());
		}
		if (!verifyResult) {
			throw new PayException("签名验证失败。");
		}
		return verifyResult;
	}
	
	/**
	 * 订单验证
	 * @param orderNo
	 * @param userId
	 * @param totalFee
	 * @return
	 */
	private Orders checkOrders(String orderNo, Integer userId, BigDecimal totalFee) {
		Orders orders = ordersDao.findByOrderNo(orderNo);
		// 支付的订单进行验证1. 订单的正确性；2.是否是该用户(userId)下的单; 3. 订单的金额判定
		if (orders == null) {
			throw new PayException("订单不存在。订单号为：" + orderNo);
		}
		
		if (!userId.equals(orders.getCustomerId())) {
			throw new PayException("订单账号不匹配。支付的用户ID为：" + userId 
					+ ";实际订单的UserID为： " + orders.getCustomerId());
		}
		BigDecimal price = orders.getPrice();
		if (!totalFee.equals(price)) { // ??
			throw new PayException("订单费用不匹配，回调的费用好似：" 
					+ totalFee + ";实际订单的费用是：" + price);
		}
		return orders;
	}
	
	/**
	 * 支付回调更新用户订单状态
	 * @param orders
	 * @param tradeNo
	 */
	private void updateOrdersStatusAfterPay(Orders orders, String tradeNo) {
		orders.setOrderStatus(OrderStatus.Pay_SUCCESS.getValue());
		orders.setOrderPreStatus(OrderStatus.WATTING.getValue());
		orders.setPayCompleteTime(new Date());
		orders.setPayNo(tradeNo);
		orders.setPayTime(new Date());
		orders.setPayStatus(OrderStatus.Pay_SUCCESS.getValue());
		ordersDao.updateAfterPay(orders);
	}
	
	/**
	 * 更新订单商品的数量
	 * @param orderDetails
	 */
	private void updateGoodsSaleAmount(List<OrderDetail> orderDetails) {
		for (OrderDetail orderDetail : orderDetails) {
			// 更新商品详情中的数量
			Integer goodDetailId = orderDetail.getGoodsDetailId();
			int amount = orderDetail.getCount();
			int count = goodsDetailDao.updateSaleCount(amount, goodDetailId);
			if (count < 1) {
				throw new PayException("商品的数量更新失败。");
			}
			// 更新商品表的总销量
			count = goodsDao.updaeSaleCount(amount, goodDetailId);
			if (count < 1) {
				throw new PayException("商品的数量更新失败。");
			}
		}
	}
	
	
}
