package com.zh.zhxk.service;

import com.zh.zhxk.bean.Users;
import com.zh.zhxk.dao.UserDao;
import com.zh.zhxk.dao.implJdbc.UserDaoJdbcImp;

public class UserService {
	private UserDao userDao = new UserDaoJdbcImp();
	
	public Users findUSerByName(String name) {
		return userDao.findUserByName(name);
	}
	

}
