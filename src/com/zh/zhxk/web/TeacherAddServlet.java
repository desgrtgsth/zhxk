package com.zh.zhxk.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zh.zhxk.bean.Teacher;
import com.zh.zhxk.service.TeacherService;

/**
 * Servlet implementation class TeacherAddServlet
 */
@WebServlet("/teacher_add")
public class TeacherAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  TeacherService teacherService = new TeacherService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String idString = request.getParameter("id");
    if (idString != null) {
      long id = Long.valueOf(idString);
      Teacher teacher = teacherService.findTeacherById(id);
      request.setAttribute("teacher", teacher);
    }  
    request.getRequestDispatcher("/resources/common/teacher_add.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Teacher teacher = new Teacher();
    String idString = request.getParameter("id");
    String name = request.getParameter("name");
    String phone = request.getParameter("phone");
    String sex = request.getParameter("sex");
    if (idString != "" ) {
      Long id = Long.valueOf(idString);
      teacher.setId(id);
    }
    teacher.setName(name);
    teacher.setPhone(phone);
    teacher.setSex(sex);
    String msg;
    try {
      teacherService.saveOrUpdate(teacher);
      msg = "{\"statusCode\":\"200\", \"message\":\"操作成功\", \"navTabId\":\"teacher_list\", \"callbackType\":\"closeCurrent\"}";
    } catch (Exception e) {
      msg = "{\"statusCode\":\"300\", \"message\":\"操作失败\"}";
    }
    response.getWriter().print(msg);
    
  }

}