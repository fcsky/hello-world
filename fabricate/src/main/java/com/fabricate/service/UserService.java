package com.fabricate.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fabricate.dao.UserDao;
import com.fabricate.module.AdminUserCustom;
import com.fabricate.module.AdminUserVo;
import com.fabricate.module.PageBean;
import com.fabricate.module.UserBean;
import com.fabricate.module.UserCustom;
import com.fabricate.module.UserQueryVo;
import com.google.gson.Gson;


@Service("userService")
public class UserService {
	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name="gson")
	private Gson gson;
	@Resource(name="pageBean")
	private PageBean pageBean;
	
	//用户登录
	public String login(UserQueryVo userQueryVo) {
		List<UserBean> list=userDao.findUser(userQueryVo);
		//用户登录与搜索用的同一条语句，所以只返回一条数据，就认为登录成功
		if(list.size()==1) {
			return list.get(0).getEmail();
		}
		else
			return null;
			
	}
	//添加用户
	public void addUser(UserCustom userCustom) {
		
		userDao.addUser(userCustom);
	}
	//查询所有用户，搜索
	public String findAllUser(UserQueryVo userQueryVo){
		List<UserBean> list=userDao.findUser(userQueryVo);
		String json=gson.toJson(list);
		return json;
	}
	//管理员登录
	public boolean findAdminUser(AdminUserVo adminUserVo) {
		List<AdminUserCustom> list=userDao.findAdminUser(adminUserVo);
		if(list.size()==1) {
			return true;
		}
		else {
			return false;
		}
	}
	//查询用户总数
	public void countUser(UserQueryVo userQueryVo) {
		int rows=userDao.countUser(userQueryVo);
		pageBean.setPage(rows);
	}
	//邮箱是否已存在验证
	public boolean reg_email(UserCustom userCustom) {
		List<UserCustom> list=userDao.reg_email(userCustom);
		if(list.size()>0)
			return false;
		else
			return true;
	}
	//删除用户
	public boolean delUser(UserCustom userCustom) {
		for(int updateId:userCustom.getupdateId()) {
			int i=userDao.delUser(updateId);
			if(i!=1) {
				return false;
			}
		}
		return true;
	}
	//修改用户
	public boolean updateUser(UserCustom userCustom) {
		int rows=userDao.updateUser(userCustom);
		if(rows==1) {
			return true;
		}
		else {
			return false;
		}
	}
}
