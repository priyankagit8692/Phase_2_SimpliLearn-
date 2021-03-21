package com.learneracademy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learneracademy.Entity.MainApplication;


@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		if(MainApplication.isValidAdmin(username,password)) {
			HttpSession session = request.getSession();
			session.setAttribute("name", username);
			response.sendRedirect("MainHomePage.jsp");
		}
		else {
			 request.setAttribute("message", "Invalid user or password");
	         RequestDispatcher rd = request.getRequestDispatcher("/AdminLogin.jsp");
	         rd.forward(request, response);
		}
	}

}
