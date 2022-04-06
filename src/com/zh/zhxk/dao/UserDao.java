package com.zh.zhxk.dao;

import com.zh.zhxk.bean.Users;

public interface UserDao {
	Users findUserByName(String name);

}
