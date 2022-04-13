package com.zh.zhxk.dao.implJdbc;

import java.awt.TextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.zh.zhxk.bean.Teacher;
import com.zh.zhxk.dao.TeacherDao;

public class TeacherDaoJdbcImp implements TeacherDao {
	private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/scs?CharSet=utf8&useUnicode=true&characterEncoding=utf-8&autoReconnect=true";
	private static final String username = "root";
	private static final String password = "123456";
  @Override
  public ArrayList<Teacher> findAllTeacher() {
    // TODO Auto-generated method stub
	  
	  try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, username , password);
			String sql = "SELECT id, name, sex, phone FROM scs.teacher";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.set();
			}
			
    return null;
  }

}