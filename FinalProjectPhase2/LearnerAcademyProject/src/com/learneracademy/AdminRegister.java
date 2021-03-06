package com.learneracademy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learneracademy.Entity.Administration;
import com.learneracademy.Entity.MainApplication;

@WebServlet("/adminRegister")
public class AdminRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("adminName");
		String password = request.getParameter("adminPassword");
		String city = request.getParameter("adminCity");
		String contact = request.getParameter("adminContact");
		String email = request.getParameter("adminEmail");
		 Administration administration = new Administration(name, email, contact, password, city);

		if(MainApplication.adminExist(name, email)) {
			request.setAttribute("msg", "User name and email id already exists");
			RequestDispatcher rd = request.getRequestDispatcher("/AdminRegistration.jsp");
            rd.forward(request, response);
		}
		else {
			MainApplication.addAdministration(administration);
            HttpSession session= request.getSession();
            session.setAttribute("name",name);
            response.sendRedirect("MainHomePage.jsp");
		}
		
	}

}
