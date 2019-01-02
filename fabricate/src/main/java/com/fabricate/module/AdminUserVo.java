package com.fabricate.module;

import org.springframework.stereotype.Component;
//因为没有数据库操作需要这个类所包含的内容，所以这个类目前并没有实际意义。
//创建这个包装类只是为了看起来标准点。。。
@Component("adminUserVo")
public class AdminUserVo {
	private AdminUserCustom adminUserCustom;

	public AdminUserCustom getAdminUserCustom() {
		return adminUserCustom;
	}

	public void setAdminUserCustom(AdminUserCustom adminUserCustom) {
		this.adminUserCustom = adminUserCustom;
	}
}
