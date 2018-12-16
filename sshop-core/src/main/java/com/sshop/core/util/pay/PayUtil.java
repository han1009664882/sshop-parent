package com.sshop.core.util.pay;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;

import com.sshop.core.util.AssertUtil;
import com.sshop.core.vo.BaseOrder;

public class PayUtil {
	
	/**
	 * 组装域名
	 * @param request
	 * @return
	 */
	public static String buildDomain(HttpServletRequest request) {
		String requestUrl = request.getRequestURL().toString(); // http://www.shsxt.com:8010/pay/page/C148136594439
		String requestURI = request.getRequestURI();
		String domain = requestUrl.substring(0, requestUrl.length() - requestURI.length());
		return domain;
	}
	
	/**
	 * 生成sign签名
	 * body=123&notify_url=http://www.test.com/notify_url.do&out_order_no=1233&partner=1234567899876111&return_url=http://www.test.com/return_url.do&subject=123&total_fee=1&user_seller=666666
	 * 注：此处拼接顺序必须为上述所列。
	 * prestr就是连接后的变量，sign就等于变量prestr连接云通付KEY ，而后对其进行MD5加密就可以了（如JAVA试例）
	 * key = ‘1234’;
	 * sign = md5(变量prestr +变量key);
	 */
	public static String generateSign(BaseOrder baseOrder, 
			String notify_url, String partner, String return_url, 
			String user_seller, String key) {
		AssertUtil.isTrue(baseOrder == null, "参数异常, 请联系客服");
		
		StringBuffer arg = new StringBuffer();
		
		arg.append("notify_url=" + notify_url + "&");
		arg.append("out_order_no=" + baseOrder.getOrderNo()+"&");
		arg.append("partner=" + partner + "&");
		arg.append("return_url=" + return_url + "&");
		arg.append("subject=" + baseOrder.getGoodsName() + "&");
		arg.append("total_fee=" + baseOrder.getPrice() + "&");
		arg.append("user_seller=" + user_seller);
		// 如果存在转义字符，那么去掉转义
		String prestr = StringEscapeUtils.unescapeJava(arg.toString());
		Md5Util md5Util = new Md5Util();
		String sign = md5Util.encode(prestr + key, null);
		return sign;
	}
	
	/**
	 * 回调验证sign签名
	 * @param out_order_no
	 * @param total_fee
	 * @param trade_status
	 * @param sign
	 * @param key
	 * @param pid
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static boolean md5VerifyCallbackSign(String out_order_no, BigDecimal total_fee, 
			String trade_status, String sign, String key, String pid) 
			throws UnsupportedEncodingException{
		Md5Util md5Util = new Md5Util();
		String signMd5 = md5Util.encode(out_order_no + total_fee + trade_status + pid + key, null);
		if(signMd5.equals(sign)){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String msg = "http://www.shsxt.com:8010/pay/page/C148136594439";
		String uri = "pay/page/C148136594439";
		System.out.println(msg.substring(0, msg.length() - uri.length() - 1));
	}
	
}
