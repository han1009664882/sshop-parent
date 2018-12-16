package com.sshop.proxy;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sshop.annotation.IsLogin;
import com.sshop.core.constant.Constant;
import com.sshop.core.exception.LoginBizException;
import com.sshop.core.util.LoginUserUtil;

@Component
@Aspect
public class CheckIsLoginProxy {
	
	private static Logger logger = LoggerFactory.getLogger(CheckIsLoginProxy.class);
	
	/**
	 * 切入点
	 */
	@Pointcut("@annotation(com.sshop.annotation.IsLogin)")
	public void pointcut() {
		
	}
	
//	@Before(value = "")
//	private void preMethod() {
//		
//	}
	
	@Around("pointcut()&&@annotation(isLogin)")
	public Object process(ProceedingJoinPoint pjp, IsLogin isLogin) {
		// 判断用户是否登录
		HttpServletRequest request = ((ServletRequestAttributes) 
				RequestContextHolder.getRequestAttributes()).getRequest(); 
			int userId = LoginUserUtil.releaseUserIdFromSession(request);
			if (userId < 1) {
				throw new LoginBizException(Constant.LOGIN_FIRST);
			}
			try {
				return pjp.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
				logger.error("拦截出错, {}", e);
				return null;
			}
	}
	
	
}
