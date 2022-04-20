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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Teacher> arrayList = null;
		arrayList = teacherService.findAllTeacher();
		request.setAttribute("list", arrayList);
		request.getRequestDispatcher("/teacher_list.jsp").forward(request, response);

	}

}
