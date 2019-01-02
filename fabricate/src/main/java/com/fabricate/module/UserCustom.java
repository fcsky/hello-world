package com.fabricate.module;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;

import com.google.gson.Gson;


//UserBean的扩展类
@Component("userCustom")
public class UserCustom extends UserBean {
	private String searchColumns;// 查询列
	private int searchRule;// 查询规则
	private String searchText;// 查询内容
	private int flag;// 页面传入的操作
	private List<Integer> updateId=new ArrayList<Integer>();// 传入删除id
	private String updateUser;//传入的修改用户的信息
	
	
	public String getSearchColumns() {
		return searchColumns;
	}

	public void setSearchColumns(String searchColumns) {
		// 列名使用的${}拼接字符串，在这里转一下， 防止sql注入。。。。
		switch (searchColumns) {
		case "all":
			this.searchColumns = "";
			break;
		case "id":
			this.searchColumns = "id";
			break;
		case "email":
			this.searchColumns = "email";
			break;
		case "uname":
			this.searchColumns = "uname";
			break;
		case "sign":
			this.searchColumns = "sign";
			break;
		case "birthday":
			this.searchColumns = "birthday";
			break;
		case "sex":
			this.searchColumns = "sex";
			break;
		case "address":
			this.searchColumns = "address";
			break;
		default:
			this.searchColumns = null;
			break;
		}
	}

	public int getSearchRule() {
		return searchRule;
	}

	public void setSearchRule(String searchRule) {
		switch (searchRule) {
		case "=":
			this.searchRule = 2;
			break;
		case "like":
			this.searchRule = 1;
			break;
		default:
			this.searchRule = 0;
			break;
		}

	}

	public String getSearchText() {
		if (searchRule == 1 && searchText != null)
			return "%" + searchText + "%";
		else
			return searchText;
	}

	public void setSearchText(String searchText) {
		if (searchText.length() > 0)
			this.searchText = searchText;
		else
			this.searchText = null;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "UserCustom [searchColumns=" + searchColumns + ", searchRule=" + searchRule + ", searchText="
				+ searchText + ", flag=" + flag + "]";
	}

	public List<Integer> getupdateId() {
		return updateId;
	}

	public void setupdateId(String updateId) {
		//从页面传入的是一个包括所有id的字符串，需要转换成int
		String[] lists=updateId.split(",");
		for(String list:lists) {
			this.updateId.add(Integer.parseInt(list));
		}
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		Gson gson=new Gson();
		//页面传入的是json，把json转为对象，用对象获取，并给当前对象赋值
		UserBean userBean=gson.fromJson(updateUser, UserBean.class);
		
		setId(userBean.getId());
		setEmail(userBean.getEmail());
		setPassword(userBean.getPassword());
		setUname(userBean.getUname());
		setSign(userBean.getSign());
		setSex(userBean.getSex());
		setBirthday(userBean.getBirthday());
		setAddress(userBean.getAddress());
		
	}
	


}
