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

public ArrayList<Teacher> findTeacher(String name, String sex, String phone) {
	return teacherDao.findTeacher(name,sex,phone); //在teacherdao建立findTeacher
}

public  void saveOrUpdate(Teacher teacher) {
	teacherDao.saveOrUpdate(teacher);
}

public Teacher findTeacherById(long id) {
	return teacherDao.findTeacherById(id);
}
  
}