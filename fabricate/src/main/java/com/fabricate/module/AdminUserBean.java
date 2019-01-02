package com.fabricate.module;

import org.springframework.stereotype.Component;
//管理员账号实体类
@Component("adminUserBean")
public class AdminUserBean {
	private int id;	
	private int page;	//设置的每页显示行数(未实现)
	private String uname;
	private String  password;
	private int deluser;	//删除用户权限(未实现)
	private int altuser;	//修改用户权限(未实现)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDeluser() {
		return deluser;
	}
	public void setDeluser(int deluser) {
		this.deluser = deluser;
	}
	public int getAltuser() {
		return altuser;
	}
	public void setAltuser(int altuser) {
		this.altuser = altuser;
	}
}
