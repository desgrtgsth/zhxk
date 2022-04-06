package com.zh.zhxk.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zh.zhxk.bean.Users;
import com.zh.zhxk.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	UserService userService = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		Users users = userService.findUSerByName(name);
		if (users == null || users.getName().equals(password)) {
			request.getSession().setAttribute("failMsg", "用户名或密码错了");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("realname", users.getRealname());
			request.getRequestDispatcher("WEB-INF/views/main.jsp").forward(request, response);

		}
	}

}
