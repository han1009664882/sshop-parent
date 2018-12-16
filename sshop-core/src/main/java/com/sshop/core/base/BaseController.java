package com.sshop.core.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Tony on 2016/8/22.
 */
public class BaseController {

    @ModelAttribute
    public void preMethod(HttpServletRequest request, Model model){
        model.addAttribute("ctx", request.getContextPath());
    }

    /**
     * 设置成功
     * @param result
     * @return
     */
    protected ResultInfo success(Object result) {
        return new ResultInfo(result);
    }

    /**
     * 设置失败
     * @param errorCode
     * @param result
     * @param message
     * @return
     */
    protected ResultInfo failure(Integer errorCode, Object result, String message) {
        return new ResultInfo(errorCode, result, message);
    }

    /**
     * 设置失败
     * @param errorCode
     * @return
     */
    protected ResultInfo failure(Integer errorCode) {
        return new ResultInfo(errorCode, "系统未知异常， 请联系管理员", "系统未知异常， 请联系管理员");
    }
    
    protected ResultInfo failure(String errormessge) {
        return new ResultInfo(errormessge);
    }


    /**
     * 保存数据到model里面
     * @param model
     * @param name
     * @param value
     */
    protected  void saveInModel(ModelMap model, String name, Object value) {
        model.addAttribute(name, value);
    }
    
	/**
	 * 将Request的参数构建成map
	 * @param request
	 * @return
	 */
	protected Map<String, String> buildParameterMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (String parameter : parameterMap.keySet()) {
			map.put(parameter, StringUtils.join(parameterMap.get(parameter), ','));
		}
		return map;

	}

}
