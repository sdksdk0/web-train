package cn.sogoucloud.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.sogoucloud.framework.annotation.Controller;
import cn.sogoucloud.framework.annotation.RequestMapping;
import cn.sogoucloud.framework.bean.Param;
import cn.sogoucloud.framework.bean.View;
import cn.sogoucloud.plugin.security.SecurityHelper;
import cn.sogoucloud.plugin.security.exception.AuthcException;

@Controller
public class SystemController {
	
	private static final Logger logger = LoggerFactory.getLogger(SystemController.class);
	
	/**
	 * 进入首页界面
	 */
	@RequestMapping("get:/")
	public View index(){
		return new View("index.jsp");
	}
	
	/**
	 * 进入登录界面
	 */
	@RequestMapping("get:/login")
	public View login(){
		return new View("login.jsp");
	}
	
	/**
	 * 提交登录表单
	 */
	@RequestMapping("post:/login")
	public View loginSubmit(Param param){
		String username = param.getString("username");
		String password = param.getString("password");
		try {
			SecurityHelper.login(username, password);
		} catch (AuthcException e) {
			logger.error("登录失败",e);
			return new View("/login");	
		}
		return new View("/customer");		
	}
	
	/**
	 * 提交注销清求
	 */
	@RequestMapping("get:/logout")
	public View logout(){
		SecurityHelper.logout();
		return new View("/");
	}

}
