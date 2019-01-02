package com.fabricate.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.fabricate.module.AdminUserBean;
import com.fabricate.module.AdminUserCustom;
import com.fabricate.module.AdminUserVo;
import com.fabricate.module.PageBean;
import com.fabricate.module.UserCustom;
import com.fabricate.module.UserQueryVo;
import com.fabricate.service.UserService;

@Controller
public class UserController extends HttpServlet {
	private static final long serialVersionUID = -33203552398946576L;
	
	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "userQueryVo")
	private UserQueryVo userQueryVo;
	@Resource(name = "adminUserBean")
	private AdminUserBean adminUserBean;
	@Resource(name = "adminUserVo")
	private AdminUserVo adminUserVo;
	@Resource(name="pageBean")
	private PageBean pageBean;
	@Resource(name="userCustom")
	private UserCustom userCustom;
	
	//用户登录
	@RequestMapping("/login")
	public void login(UserCustom userCustom,PrintWriter writer) {
		userQueryVo.setUserCustom(userCustom);
		userQueryVo.setPageBean(pageBean);
		String email = userService.login(userQueryVo);
		if (email != null) {
			//给session设值，在其他方法中，或拦截器中取值对比，保证登录才能操作(未实现)
			writer.print("{\"key\":true}");

		} else {
			writer.print("{\"key\":false}");
		}
	}
	
	//添加用户,邮箱，密码，用户名验证
	@RequestMapping("/addUser")
	public void addUser(UserCustom userCustom,PrintWriter writer) {
		//注册中的邮箱验证功能，如果邮箱已存在，提示用户
		boolean flag=userService.reg_email(userCustom);
		
		if(flag) {
			userService.addUser(userCustom);
			
			//添加用户后，会把刚添加的用户id返回给userCustom中的id
			//判断如果>0就认为添加成功
			if(userCustom.getId()>0) {
				writer.print("{\"msg\":1}");
			}
			else {
				writer.print("{\"msg\":2}");
			}
		}
		else {
			writer.print("{\"msg\":3}");
		}
	}
	
	//查询返回的行数
	@RequestMapping("/count")
	public void count(UserCustom userCustom,PrintWriter writer) {
		//在第一次加载或搜索使都先返回行数，再调用另一个ajax返回内容
		
		//如果搜索框中没有内容就不初始化包装类中的扩展类，在map.xml中扩展类为空就返回所有内容
		if(userCustom.getSearchText()!=null) {
			userQueryVo.setUserCustom(userCustom);
		}
		else {
			userQueryVo.setUserCustom(null);
		}
		//把保存的页数等信息传入
		userQueryVo.setPageBean(pageBean);

		//这个对应的是上一页，下一页等操作，因为不知道有什么其他方法。
		//又觉得给每个操作写一个ajax和方法太多余，就传入一个值，判断操作。。。
		//1是第一次加载，也是默认值，6是搜索。
		switch (userCustom.getFlag()) {
		case 1:
		case 6:userService.countUser(userQueryVo);break;
		case 2:pageBean.setNextPage();break;
		case 3:pageBean.setLastPage();break;
		case 4:pageBean.setFirstPage();break;
		case 5:pageBean.setEndPage();break;
		default:break;
	}
		//给页面返回页数和当前页
		writer.print("{\"allPage\":\""+pageBean.getPageSize()+"\",\"current\":\""+pageBean.getCurrent()+"\"}");
	}

	// 查询所有用户
	@RequestMapping("/findAllUser")
	public void findAllUser(PrintWriter writer)  {
		
		//搜索内容和页面信息，在count方法中已经传入，所以只需调用就行
		userQueryVo.setPageBean(pageBean);
		String json=userService.findAllUser(userQueryVo);
		System.out.println(json);
		writer.print(json);
	}
	
	
	// 管理员登录
	@RequestMapping("adminLogin")
	public void adminLogin(AdminUserCustom adminUserCustom, PrintWriter writer)
			throws IOException {
		
		adminUserVo.setAdminUserCustom(adminUserCustom);
		boolean flag = userService.findAdminUser(adminUserVo);

		
		if (flag) {
			writer.print("{\"key\":true}");
		} else {
			writer.print("{\"key\":false}");
		}
	}
	
	//删除用户
	@RequestMapping("delUser")
	public void delUser(UserCustom userCustom,PrintWriter writer) {
		boolean flag=userService.delUser(userCustom);
		if(flag) {
			writer.print("{\"msg\":true}");
		}
		else {
			writer.print("{\"msg\":false}");
		}
	}
	
	//修改用户
	@RequestMapping("updateUser")
	public void updateUser(UserCustom userCustom,PrintWriter writer) {
		boolean flag=userService.updateUser(userCustom);
		if(flag) {
			writer.print("{\"msg\":true}");
		}
		else {
			writer.print("{\"msg\":false}");
		}
	}
}
