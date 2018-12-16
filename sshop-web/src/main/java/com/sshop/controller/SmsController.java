package com.sshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sshop.core.base.BaseController;
import com.sshop.core.base.ResultInfo;
import com.sshop.core.constant.Constant;
import com.sshop.core.dto.SmsInfo;

@RestController
@RequestMapping("sms")
public class SmsController  extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(SmsController.class);
	
	@Value("${sms.url}")
	private String smsUrl;
	@Value("${sms.appkey}")
	private String smsAppkey;
	@Value("${sms.secret}")
	private String smsSecret;
	@Value("${sms.type}")
	private String smsType;
	@Value("${sms.free.signname}")
	private String smsFreeSignName;
	@Value("${sms.template.code}")
	private String smsTemplateCode;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	/**
	 * 发送短信
	 */
	@RequestMapping("send")
	public ResultInfo send(HttpServletRequest request, String mobile) {
		
		// 生成六位的随机数
		int randomNum = (int)((Math.random() * 9 + 1) * 100000);
		
		// 将生成的随机数存入rabbit队列
		SmsInfo smsInfo = new SmsInfo(randomNum, mobile);
		rabbitTemplate.convertAndSend(smsInfo);
		
		// 短信发送调用发送的API 丢队列
//		sendSms(randomNum, mobile);
		logger.info("短信的随机数：{}", randomNum);
		// key: SEND_VERIFYCODE_138888888, 88888
		request.getSession().setAttribute(Constant.SEND_VERIFYCODE + mobile, randomNum + ""); 
		request.getSession().setMaxInactiveInterval(300);
		return success("发送成功");
	}
	
	/**
	 * 短信发送
	 * @param randomNum
	 * @param recNum
	 */
//	private void sendSms(int randomNum, String recNum) {
//		TaobaoClient client = new DefaultTaobaoClient(smsUrl, smsAppkey, smsSecret);
//		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
//		req.setSmsType(smsType); // 必填
//		req.setSmsFreeSignName(smsFreeSignName); // 必填 模板签名
//		req.setSmsParamString("{\"randomNum\":\""+ randomNum +"\"}"); // 创建模板时需要传入的变量
//		req.setRecNum(recNum); // 接收的手机号码
//		req.setSmsTemplateCode(smsTemplateCode); // 模板ID
//		try {
//			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
//			System.out.println(rsp.getBody());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	


}
