package com.fabricate.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import com.fabricate.module.AdminUserCustom;
import com.fabricate.module.AdminUserVo;
import com.fabricate.module.UserBean;
import com.fabricate.module.UserCustom;
import com.fabricate.module.UserQueryVo;

@Component("userDao")
public class UserDao extends SqlSessionDaoSupport implements UserMapper {

	@Override // 登录，查询用户，搜索用户
	public List<UserBean> findUser(UserQueryVo userQueryVo) {
		SqlSession sqlSession = this.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<UserBean> list = userMapper.findUser(userQueryVo);
		return list;
	}

	@Override // 查询管理员，登录
	public List<AdminUserCustom> findAdminUser(AdminUserVo adminUserVo) {
		SqlSession sqlSession = this.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<AdminUserCustom> list = userMapper.findAdminUser(adminUserVo);
		return list;
	}

	@Override // 添加用户
	public void addUser(UserCustom userCustom) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = this.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.addUser(userCustom);

	}

	@Override // 查询用户总数
	public int countUser(UserQueryVo userQueryVo) {
		SqlSession sqlSession = this.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int rows = userMapper.countUser(userQueryVo);
		return rows;
	}

	@Override//邮箱验证
	public List<UserCustom> reg_email(UserCustom userCustom) {
		SqlSession sqlSession=this.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		List<UserCustom> list=userMapper.reg_email(userCustom);
		return list;
	}

	@Override//删除用户
	public int delUser(int updateId) {
		System.out.println("dao层执行了");
		SqlSession sqlSession=this.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		int i=userMapper.delUser(updateId);
		return i;
	}

	@Override//修改用户
	public int updateUser(UserCustom userCustom) {
		SqlSession sqlSession=this.getSqlSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		int rows=userMapper.updateUser(userCustom);
		return rows;
	}
	
}
