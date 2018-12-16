package com.sshop.core.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.sshop.core.constant.Constant;
import com.sshop.core.vo.UserLoginIdentity;

/**
 * Created by Tony on 2016/8/23.
 */
public class LoginUserUtil {

    /**
     * 从cookie中获取userId
     * @param request
     * @return
     */
    public static int releaseUserIdFromSession(HttpServletRequest request) {
        UserLoginIdentity userLoginIdentity = (UserLoginIdentity) request.getSession()
        		.getAttribute(Constant.LOGIN_USER_KEY);
        if (userLoginIdentity == null) {
        	return 0;
        }
        String userIdString = userLoginIdentity.getUserIdString();
        if (userLoginIdentity == null || StringUtils.isBlank(userIdString)) {
            return 0;
        }
        Integer userId = UserIDBase64.decoderUserID(userIdString);
        return userId;
    }
	
}
