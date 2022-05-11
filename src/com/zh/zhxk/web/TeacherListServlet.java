package com.zh.zhxk.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zh.zhxk.bean.Teacher;
import com.zh.zhxk.service.TeacherService;

/**
 * Servlet implementation class TeacherListServlet
 */
@WebServlet("/teacher_list")
public class TeacherListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TeacherService teacherService = new TeacherService(); // 建立TeacherService
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	String name = request.getParameter("name");
	//	String sex = request.getParameter("sex");
	//	String phone = request.getParameter("phone");
		
		String name = request.getParameter("name");
	    String sex = request.getParameter("sex");
	    String phone = request.getParameter("phone");
	    
	    name = name == null ? "":name.trim();
	    sex = sex == null ? "":sex;
	    phone = phone == null ? "": phone.trim();
	    
		ArrayList<Teacher> arrayList = null;
	    
		if (name == ""&& sex == "" && phone == "") {
			arrayList = teacherService.findAllTeacher();
			System.out.println(arrayList);
		} else {
			arrayList = teacherService.findTeacher(name,sex,phone); //建立findTeacher方法
		}
	    		
		
//		for(Teacher teacher : arrayList) {
//			System.out.println(teacher.getId());
//			System.out.println(teacher.getName());
//		}   //调试
		
		request.setAttribute("list", arrayList);
		request.getRequestDispatcher("/teacher_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
