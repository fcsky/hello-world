//package com.fabricate.dao;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import com.fabricate.module.AdminUserBean;
//import com.fabricate.module.PageBean;
//import com.fabricate.module.UserBean;
////使用jdbcTemplate实现的dao层，太麻烦了。。。
//
//@Repository("userDao2")
//public class UserDao2 {
//	@Resource(name = "jdbcTemplate")
//	private JdbcTemplate jdbctem;
//
//	// 登录
//	public void login(UserBean userBean) {
//
//		String sql = "select id from usertb where email=? and password=?";
//		List<Integer> rows = jdbctem.query(sql, new RowMapper<Integer>() {
//
//			@Override
//			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
//				String id=rs.getString("id");
////				int i=Integer.parseInt();
//				System.out.println(id==null);
//				return 1;
//			}
//		}, userBean.getEmail(), userBean.getPassword());
////		System.out.println("id="+rows);
////		return rows;
//	}
//	//查询总人数
//	public int count() {
//		String sql="select count(*) from usertb";
//		int rows=jdbctem.queryForObject(sql, Integer.class);
//		return rows;
//	}
//
//	// 注册
//	public int addUser() {
//		String sql = "insert usertb(email,password,uname)";
//		int rows = jdbctem.update(sql);
//		return rows;
//	}
//
//	// 删除用户
//	public int delUser(UserBean ub) {
//		String sql = "delete form usertb where id=?";
//		int rows = jdbctem.update(sql, ub.getId());
//		return rows;
//	}
//
//	// 更新用户
//	public int updateUser(UserBean ub) {
//		String sql = "update usertb set uname=?,imgpath=?,sign=?,sex=? where id=?";
//		int rows = jdbctem.update(sql, ub.getUname(), ub.getImgpath(), ub.getSign(), ub.getSex(), ub.getId());
//		return rows;
//	}
//
//	// 更新密码
//	public int updatePassword(UserBean ub) {
//		String sql = "update usertb set password=? where id=?";
//		int rows = jdbctem.update(sql, ub.getPassword(), ub.getId());
//		return rows;
//	}
//
//	// 查询所有用户,与当前管理员用户id,并分页
//	public List<UserBean> findAllUser(AdminUserBean adminUserBean,PageBean pageBean) {
//		//获取该管理员设置的显示行数
//		int columns=getColumns(adminUserBean);
//		
//		String sql = "select * from usertb limit ?,?";
//
//		List<UserBean> list = jdbctem.query(sql, new RowMapper<UserBean>() {
//
//			@Override
//			public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
//				
//				UserBean ub=new UserBean();
//				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//
//				int id = rs.getInt("id");
//				String email = rs.getString("email");
//				String uname = rs.getString("uname");
//				String sign = rs.getString("sign");
//				Date date = rs.getDate("birthday");
//				String sex = rs.getString("sex");
//				String address = rs.getString("address");
//				
//				//把date格式的birthday格式化为String
//				String birthday=sdf.format(date);
//				
//				
//				
//				ub.setId(id);
//				ub.setEmail(email);
//				ub.setUname(uname);
//				ub.setSign(sign);
//				ub.setBirthday(birthday);
//				ub.setSex(sex);
//				ub.setAddress(address);
//				return ub;
//			}
//		},pageBean.getStart(),columns);
//		return list;
//	}
//	//根据条件查询用户
//	public List<UserBean> findUser(String searchColumns,String searchRule,int start, int rows) {//传入limit需要的起始位置和行数
//		String sql = "select * from usertb limit ?,?";
//
//		List<UserBean> list = jdbctem.query(sql, new RowMapper<UserBean>() {
//
//			@Override
//			public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
//				
//				UserBean ub=new UserBean();
//				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//
//				int id = rs.getInt("id");
//				String email = rs.getString("email");
//				String uname = rs.getString("uname");
//				String sign = rs.getString("sign");
//				Date date = rs.getDate("birthday");
//				String sex = rs.getString("sex");
//				String address = rs.getString("address");
//				
//				//把date类型的birthday转为String类型
//				String birthday=sdf.format(date);
//				
//				
//				
//				ub.setId(id);
//				ub.setEmail(email);
//				ub.setUname(uname);
//				ub.setSign(sign);
//				ub.setBirthday(birthday);
//				ub.setSex(sex);
//				ub.setAddress(address);
//				return ub;
//			}
//		},start,rows);
//		return list;
//	}
//	
//	//查询管理员设置的每页显示行数
//	public int getColumns(AdminUserBean adminUserBean) {
//		String sql="select columns from id=?";
//		int columns=jdbctem.queryForObject(sql, Integer.class);
//		return columns;
//		
//	}
//}
