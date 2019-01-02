package com.fabricate.module;

import org.springframework.stereotype.Component;

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
