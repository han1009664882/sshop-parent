package com.sshop.sms;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.sshop.core.dto.SmsInfo;
import com.sshop.sms.log.SmsLog;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

@Component
public class Consumer implements MessageListener {

	private static Logger logger = LoggerFactory.getLogger(Consumer.class);
	
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
	private MongoTemplate mongoTemplate;
	
	@Override
	public void onMessage(Message message) {
		try {
			String content = new String(message.getBody(), "UTF-8");
			logger.info("接收的消息为： {}", content);
			SmsInfo smsInfo = JSON.parseObject(content, SmsInfo.class);
			String mobile = smsInfo.getMobile();
			int randomNum = smsInfo.getRandomNum();
			if (StringUtils.isEmpty(mobile) || randomNum < 1) {
				logger.error("消息内容为空： {}", content);
				return;
			}
			// 发送
			String result = sendSms(randomNum, mobile);
			// 保存日志
			saveSmsLog(mobile, randomNum, result, 0, null);
		} catch (UnsupportedEncodingException e) {
			logger.error("发送失败： {}", e);
		}
	}
	
	/**
	 * 短信发送
	 * @param randomNum
	 * @param recNum
	 */
	private String sendSms(int randomNum, String recNum) {
		TaobaoClient client = new DefaultTaobaoClient(smsUrl, smsAppkey, smsSecret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setSmsType(smsType); // 必填
		req.setSmsFreeSignName(smsFreeSignName); // 必填 模板签名
		req.setSmsParamString("{\"randomNum\":\""+ randomNum +"\"}"); // 创建模板时需要传入的变量
		req.setRecNum(recNum); // 接收的手机号码
		req.setSmsTemplateCode(smsTemplateCode); // 模板ID
		try {
			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
			return rsp.getBody();
		} catch (Exception e) {
			logger.error("发送短信失败：{}", e);
			return null;
		}
	}
	
	/**
	 * 保存发送日志
	 * @param mobile
	 * @param randomNum
	 * @param sendResult
	 * @param sendType
	 * @param userId
	 */
	private void saveSmsLog(String mobile, Integer randomNum, 
			String sendResult, int sendType, Integer userId) {
		SmsLog smslog = new SmsLog();
		smslog.setMobile(mobile);
		smslog.setRandomNum(randomNum);
		smslog.setSendResult(sendResult);
		smslog.setSendTime(new Date());
		smslog.setSendType(sendType);
		smslog.setSmsTemplateCode(smsTemplateCode);
		smslog.setUserId(userId);
		mongoTemplate.save(smslog);
	}
	
	

}
