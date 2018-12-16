package com.sshop.controller;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sshop.core.base.ResultInfo;
import com.sshop.core.constant.Constant;
import com.sshop.core.exception.LoginBizException;
import com.sshop.core.exception.ParamException;
import com.sshop.core.exception.PayException;
import com.sshop.core.model.log.PayErrorLog;

@ControllerAdvice
public class ProjectExceptionHandler {
	
	private static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	/**
	 * 参数异常处理
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = ParamException.class)
	@ResponseBody
	public ResultInfo handlerException(ParamException exception) {
		ResultInfo resultInfo = new ResultInfo();
		Integer errorCode = exception.getErrorCode(); // 获取异常的code
		String message = exception.getMessage(); // 获取异常的消息
		resultInfo.setResultCode(errorCode);
		resultInfo.setResult(message);
		resultInfo.setMessage(message);
		logger.error("参数异常：{}", exception); // 打印异常
		return resultInfo;
	}
	
	/**
	 * 登陆异常处理
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(LoginBizException.class)
	public String hanlderLoginBizException(LoginBizException exception, 
			HttpServletRequest request) {
		String url = request.getContextPath() + "/user/login.html";
		return "redirect:" + url;
	}
	
	/**
	 * 支付异常处理
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(PayException.class)
	public ModelAndView hanlderPayException(PayException exception, 
			HttpServletRequest request) {
		
		logger.error("支付失败：{}", exception);
		
		// 日志保存
		PayErrorLog payErrorLog = new PayErrorLog();
		// request获取
		payErrorLog.setOut_order_no(request.getParameter("out_order_no"));
		payErrorLog.setSign(request.getParameter("sign"));
		String totalFeeStr = request.getParameter("total_fee");
		payErrorLog.setTotal_fee(new BigDecimal(totalFeeStr));
		payErrorLog.setTrade_no(request.getParameter("trade_no"));
		payErrorLog.setTrade_status(request.getParameter("trade_status"));
		payErrorLog.setErrorCode(exception.getErrorCode());
		payErrorLog.setErrorMessage(exception.getMessage());
		payErrorLog.setCreateDate(new Date());
		mongoTemplate.insert(payErrorLog);
		
		// 构建返回结果
		ModelAndView modelAndView = new ModelAndView("pay_success");
		modelAndView.addObject("resultCode", Constant.RESULT_ERROR);
		modelAndView.addObject("ctx", request.getContextPath());
		return modelAndView;
		
	}
	
}
