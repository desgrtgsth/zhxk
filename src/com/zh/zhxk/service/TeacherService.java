package com.zh.zhxk.service;

import java.util.ArrayList;

import com.zh.zhxk.bean.Teacher;
import com.zh.zhxk.dao.TeacherDao;
import com.zh.zhxk.dao.implJdbc.TeacherDaoJdbcImp;

public class TeacherService {
private TeacherDao teacherDao = new TeacherDaoJdbcImp(); 
  
  public ArrayList<Teacher> findAllTeacher() {
    return teacherDao.findAllTeacher();
  }
  
}