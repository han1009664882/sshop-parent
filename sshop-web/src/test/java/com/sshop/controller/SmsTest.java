package com.sshop.controller;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class SmsTest {
	
	public static void main(String[] args) {
		String url = "http://gw.api.taobao.com/router/rest";
		String appkey = "23560540";
		String secret = "cb6ebff7fcdc193349497f578905b9b4";
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456"); // 发送完成后返回的结果里面包含的参数
		req.setSmsType("normal"); // 必填
		req.setSmsFreeSignName("尚学堂Tony"); // 必填 模板签名
		req.setSmsParamString("{\"randomNum\":\"1234\"}"); // 创建模板时需要传入的变量
		req.setRecNum("15221960138"); // 接收的手机号码
		req.setSmsTemplateCode("SMS_33490385"); // 模板ID
		try {
			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
			System.out.println(rsp.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
