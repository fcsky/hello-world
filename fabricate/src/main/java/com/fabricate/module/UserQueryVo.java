package com.fabricate.module;

import org.springframework.stereotype.Component;

//UserBean的包装类
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
