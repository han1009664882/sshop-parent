package com.sshop.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sshop.core.constant.Constant;
import com.sshop.core.model.User;
import com.sshop.core.util.AssertUtil;
import com.sshop.core.util.MD5;
import com.sshop.core.util.UserIDBase64;
import com.sshop.core.vo.UserLoginIdentity;
import com.sshop.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private ImageService imageService;
	@Autowired
	private AccountService accountService;
	@Value("${image.prefix}")
	private String imageDomain;
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	/**
	 * 注册
	 * @param mobile 手机号码
	 * @param code 手机验证码
	 * @param firstname 名
	 * @param lastname 姓
	 * @param imgCode 图片验证码
	 * @param password 密码
	 * @param confirmPwd 确认密码
	 * @param mobileCodeFromSession session中的手机验证码
	 * @param imgCodeFromSession session中的图片验证码
	 */
	public UserLoginIdentity signup(String mobile, String code, String firstname, 
			String lastname, String imgCode, String password,
			String confirmPwd, String mobileCodeFromSession, 
			String imgCodeFromSession) {
		
		// 基本参数验证（包括参数，也包括手机验证码以及图片验证码输入是否正确）
		checkParam(mobile, code, firstname, lastname, imgCode, password, 
				confirmPwd, mobileCodeFromSession, imgCodeFromSession);
		
		// 判断手机号是否存在
		User user = userDao.findByMobile(mobile.trim());
		AssertUtil.isTrue(user != null, "该手机号已注册");
		
		// 保存到数据库
		Integer userId = saveUser(password, mobile, lastname, firstname);
		
		// 保存默认图片
		imageService.addUserHeader(userId);
		
		// 同步到帐号中心
		accountService.addToAccount(MD5.toMD5(password), mobile);
		
		// 返回封装结果
		String headImage = imageDomain + Constant.USER_DEFAULT_HEAD_IMAGE;
		UserLoginIdentity userLoginIdentity = initLoginIdentity(userId, 
				lastname, headImage);
		return userLoginIdentity;
	}
	
	/**
	 * 登录
	 * @param mobile 手机号码
	 * @param imgCode 前台传入的图片验证
	 * @param password 密码
	 * @param imgCodeFromSession session中图片验证码的内容
	 * @return
	 */
	public UserLoginIdentity login(String mobile, String imgCode, 
			String password, String imgCodeFromSession) {
		
		// 基本参数验证
		AssertUtil.notEmpty(mobile, "请输入手机号码");
		AssertUtil.notEmpty(password, "请输入密码");
		AssertUtil.notEmpty(imgCode, "请输入验证码");
		AssertUtil.isTrue(!imgCode.equals(imgCodeFromSession), "图片验证码输入有误，请重新输入");
		
		// 验证手机号码和密码是否正确
		User user = userDao.findByMobile(mobile);
		AssertUtil.notNull(user, "手机号或密码输入错误，请重新输入");
		String md5password = MD5.toMD5(password);
		AssertUtil.isTrue(!md5password.equals(user.getPassword()), "手机号或密码输入错误，请重新输入");
		String headImage = imageService.findHeadImage(user.getId());
		
		UserLoginIdentity userLoginIdentity = initLoginIdentity(user.getId(), 
				user.getLastname(), headImage);
		return userLoginIdentity;
	}
	
	
	/**
	 * 基本参数验证
	 * @param mobile
	 * @param code
	 * @param firstname
	 * @param lastname
	 * @param imgCode
	 * @param password
	 * @param confirmPwd
	 * @param mobileCodeFromSession
	 * @param imgCodeFromSession
	 */
	private static void checkParam(String mobile, String code, String firstname, 
			String lastname, String imgCode, String password,
			String confirmPwd, String mobileCodeFromSession, 
			String imgCodeFromSession) {
		AssertUtil.notEmpty(mobile, "请输入手机号码");
		AssertUtil.notEmpty(code, "请输入手机验证码");
		AssertUtil.notEmpty(firstname, "请输入名");
		AssertUtil.notEmpty(lastname, "请输入姓");
		AssertUtil.notEmpty(imgCode, "请输入图片验证码");
		AssertUtil.notEmpty(password, "请输入密码");
		AssertUtil.notEmpty(confirmPwd, "请输入确认密码");
		AssertUtil.notEmpty(mobileCodeFromSession, "手机验证码已过期，请重新发送");
		AssertUtil.isTrue(!mobileCodeFromSession.equals(code), "手机验证码输入不正确，请重新输入");
		AssertUtil.isTrue(!imgCode.equals(imgCodeFromSession), "图片验证码输入不正确，请重新输入");
	}
	
	/**
	 * 保存并返回主键
	 * @param password
	 * @param mobile
	 * @param lastname
	 * @param firstname
	 * @return
	 */
	private Integer saveUser(String password, String mobile, 
			String lastname, String firstname) {
		User user = new User();
		String newPwd = MD5.toMD5(password);
		user.setMobile(mobile);
		user.setLastname(lastname);
		user.setFirstname(firstname);
		user.setPassword(newPwd);
		user.setCreatetime(new Date());
		user.setUpdatetime(new Date());
		user.setStatus(0);
		// 保存并返回主键
		int count = userDao.insert(user);
		logger.info("保存后返回的内容：{}", count);
		return user.getId();
	}
	
	/**
	 * 构建登录信息
	 * @param userId
	 * @param lastname
	 * @param headImage
	 * @return
	 */
	private UserLoginIdentity initLoginIdentity(Integer userId, 
			String lastname, String headImage) {
		UserLoginIdentity userLoginIdentity = new UserLoginIdentity();
		userLoginIdentity.setHeadImage(headImage);
		userLoginIdentity.setLastname(lastname);
		userLoginIdentity.setUserIdString(UserIDBase64.encoderUserID(userId));
		return userLoginIdentity;
	}
	
}
