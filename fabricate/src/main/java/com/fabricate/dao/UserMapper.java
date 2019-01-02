package com.fabricate.dao;

import java.util.List;


import com.fabricate.module.AdminUserCustom;
import com.fabricate.module.AdminUserVo;
import com.fabricate.module.UserBean;
import com.fabricate.module.UserCustom;
import com.fabricate.module.UserQueryVo;

public interface UserMapper {
	
	//用户登录，搜索所有用户
	public List<UserBean> findUser(UserQueryVo userQueryVo);
	//管理员登录
	public List<AdminUserCustom> findAdminUser(AdminUserVo adminUserVo);
	//统计用户数量
	public int countUser(UserQueryVo userQueryVo);
	//添加用户
	public void addUser(UserCustom userCustom);
	//邮箱验证
	public List<UserCustom> reg_email(UserCustom userCustom);
	//删除用户
	public int delUser(int updateId);
	//修改用户
	public int updateUser(UserCustom userCustom);
}
