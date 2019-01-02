package com.fabricate.module;

import org.springframework.stereotype.Component;

//UserBean和pageBean的包装类
//获取用户信息的sql语句会同时使用UserBean和pageBean中的信息，
//而mybatis只能传入一个值，所以需要包装类把需要传入的所有信息包装起来传入
@Component("userQueryVo")
public class UserQueryVo {
	private UserCustom userCustom;
	
	private PageBean pageBean;

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
}
