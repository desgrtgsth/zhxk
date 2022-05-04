package com.zh.zhxk.dao;

import java.util.ArrayList;

import com.zh.zhxk.bean.Teacher;

public interface TeacherDao {
	
	ArrayList<Teacher>findAllTeacher();
//将teacher放入链表

	ArrayList<Teacher> findTeacher(String name, String sex, String phone);//建立findTeacher

	void saveOrUpdate(Teacher teacher); 
	
}