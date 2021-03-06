package com.zh.zhxk.dao.implJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.zh.zhxk.bean.Teacher;
import com.zh.zhxk.dao.TeacherDao;

public class TeacherDaoJdbcImp implements TeacherDao {
  private static final String driver = "com.mysql.jdbc.Driver";
  private static final String url = "jdbc:mysql://localhost:3306/scs?CharSet=utf8&useUnicode=true&characterEncoding=utf-8&autoReconnect=true";
  private static final String username = "root";
  private static final String password = "123456";
  
  @Override
  public ArrayList<Teacher> findAllTeacher() {
    ArrayList<Teacher> arrayList = new ArrayList<>();
    try {
      Class.forName(driver);
      Connection connection = DriverManager.getConnection(url, username , password);
      String sql = "SELECT id, name, sex, phone FROM scs.teacher";
      PreparedStatement prepareStatement = connection.prepareStatement(sql);
      ResultSet resultSet = prepareStatement.executeQuery();
      while (resultSet.next()) {
        Teacher teacher = new Teacher();
        teacher.setId(resultSet.getLong(1));
        teacher.setName(resultSet.getString(2));
        teacher.setSex(resultSet.getString(3));
        teacher.setPhone(resultSet.getString(4));
        arrayList.add(teacher);        
      }
      }catch (ClassNotFoundException | SQLException e) {    
        e.printStackTrace();
      }
    return arrayList;
  }
  
  



  @Override
  public ArrayList<Teacher> findTeacher(String name, String sex, String phone) {
    ArrayList<Teacher> arrayList = new ArrayList<>();
    try {
      Class.forName(driver);
      Connection connection = DriverManager.getConnection(url, username , password);
      String sql = "SELECT id, name, sex, phone FROM scs.teacher where 1=1";
      sql += name == "" ? " and 1=? " : " and name = ?";
      sql += sex == "" ? " and 1=? " : " and sex = ?";
      sql += phone == "" ? " and 1=? " : " and phone = ?";
      System.out.println(sql);//??????
      
      PreparedStatement prepareStatement = connection.prepareStatement(sql);
      if (name == "") {
        prepareStatement.setInt(1, 1);
      } else {
        prepareStatement.setString(1, name);
      }
      if (sex == "") {
        prepareStatement.setInt(2, 1);
      } else {
        prepareStatement.setString(2, sex);
      }
      if (phone == "") {
        prepareStatement.setInt(3, 1);
      } else {
        prepareStatement.setString(3, phone);
      }
      System.out.println(prepareStatement.toString());//??????
      
     ResultSet resultSet = prepareStatement.executeQuery();
     while (resultSet.next()) {
        Teacher teacher = new Teacher();
        teacher.setId(resultSet.getLong(1));
        teacher.setName(resultSet.getString(2));
        
        teacher.setSex(resultSet.getString(3));
        teacher.setPhone(resultSet.getString(4));
        arrayList.add(teacher);        
      }
      }catch (ClassNotFoundException | SQLException e) {    
        e.printStackTrace();
      }
    return arrayList;
  }





  @Override
  public void saveOrUpdate(Teacher teacher) {
    try {
      Class.forName(driver);
      Connection connection = DriverManager.getConnection(url, username , password);
      String sql = "INSERT INTO scs.teacher ( name, sex, phone) VALUES (?, ?, ?);";
      PreparedStatement prepareStatement = connection.prepareStatement(sql);
      prepareStatement.setString(1, teacher.getName());
      prepareStatement.setString(2, teacher.getSex());
      prepareStatement.setString(3, teacher.getPhone());
       int executeUpdate = prepareStatement.executeUpdate();
      
      }catch (ClassNotFoundException | SQLException e) {    
        e.printStackTrace();
        throw new RuntimeException();
      }

  }
  
  @Override
  public Teacher findTeacherById(Long id) {
    Teacher teacher = null;
    try {
      Class.forName(driver);
      Connection connection = DriverManager.getConnection(url, username , password);
      String sql = "SELECT id, name, sex, phone FROM scs.teacher where id = ?";
      PreparedStatement prepareStatement = connection.prepareStatement(sql);
      prepareStatement.setLong(1, id);
      ResultSet resultSet = prepareStatement.executeQuery();
      if (resultSet.next()) {
         teacher = new Teacher();
         teacher.setId(resultSet.getLong(1));
         teacher.setName(resultSet.getString(2));
        
         teacher.setSex(resultSet.getString(3));
         teacher.setPhone(resultSet.getString(4));    
      }
      }catch (ClassNotFoundException | SQLException e) {    
        e.printStackTrace();
      }
    return teacher;
  }

  public static void main(String[] args) {
    TeacherDaoJdbcImp teacherDaoJdbcImp = new TeacherDaoJdbcImp();
    
    Teacher teacher = teacherDaoJdbcImp.findTeacherById(4L);
    System.out.println(teacher.getName());
    System.out.println(teacher.getSex());
    System.out.println(teacher.getPhone());
    teacher.setSex("???");
    teacherDaoJdbcImp.saveOrUpdate(teacher);
    System.out.println(teacher.getName());
    System.out.println(teacher.getSex());
    System.out.println(teacher.getPhone());

  }

}

  //public static void main(String[] args) {
  //  TeacherDaoJdbcImp teacherDaoJdbcImp = new TeacherDaoJdbcImp();
  //  Teacher teacher = teacherDaoJdbcImp.findTeacherById(4L);
  //  System.out.println(teacher.getName());
  //  System.out.println(teacher.getPhone());

  //}
  
  // public static void main(String[] args) {
  //  TeacherDaoJdbcImp teacherDaoJdbcImp = new TeacherDaoJdbcImp();
  //  Teacher teacher = new Teacher();
  //  teacher.setName("gu");
  //  teacher.setPhone("5656767767");
  // teacher.setSex("???");
  // teacherDaoJdbcImp.saveOrUpdate(teacher);

  // }

//}
  
// public static void main(String[] args) {
//    TeacherDaoJdbcImp teacherDaoJdbcImp = new TeacherDaoJdbcImp();
//    ArrayList<Teacher> list = teacherDaoJdbcImp.findTeacher("Li", "", "123");
//    for (Teacher teacher : list) {
//      System.out.println(teacher.getId());
//      System.out.println(teacher.getName());
//    }//??????
//  }



