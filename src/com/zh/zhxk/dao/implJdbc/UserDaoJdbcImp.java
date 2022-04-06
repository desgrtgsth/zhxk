package com.zh.zhxk.dao.implJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zh.zhxk.bean.Users;
import com.zh.zhxk.dao.UserDao;

public class UserDaoJdbcImp implements UserDao {
	private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/scs?CharSet=utf8&useUnicode=true&characterEncoding=utf-8&autoReconnect=true";
	private static final String username = "root";
	private static final String password = "123456";
	@Override
	public Users findUserByName(String name) {
		Users users = null;
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, username , password);
			String sql = "SELECT id, name, password, realname, age, sex, email, dtype\r\n" + 
					"FROM scs.users where name = ? ;";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1,name);
			ResultSet resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				users = new Users();
				users.setId(resultSet.getLong(1));
				users.setName(resultSet.getString(2));
				users.setName(resultSet.getString(3));
				users.setName(resultSet.getString(4));
				users.setAge(Integer.valueOf(resultSet.getInt(5)));
				users.setSex(resultSet.getString(6));
				users.setEmail(resultSet.getString(7));
			}

		} catch (ClassNotFoundException | SQLException e) {		
			e.printStackTrace();
		}
		return users;
	}

}
