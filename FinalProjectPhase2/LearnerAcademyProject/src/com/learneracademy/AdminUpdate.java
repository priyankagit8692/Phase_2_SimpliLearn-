package com.learneracademy;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learneracademy.Entity.Administration;
import com.learneracademy.Entity.MainApplication;

/**
 * Servlet implementation class AdminUpdate
 */
@WebServlet("/adminUpdate")
public class AdminUpdate extends HttpServlet {
	
	
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("adminName");
			String email = request.getParameter("adminEmail");
			String password = request.getParameter("adminPassword");
			String phone = request.getParameter("adminPhone");
			String city = request.getParameter("adminCity");
			Administration admin = new Administration(name,email,phone,password,city);

			if(MainApplication.updateAdmin(admin)) {
				request.setAttribute("msg","Admin Updated Successfully !!");
				RequestDispatcher rd = request.getRequestDispatcher("/AdminUpdate.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("msg","Admin Update Failed !!");
				RequestDispatcher rd = request.getRequestDispatcher("/AdminUpdate.jsp");
				rd.forward(request, response);
			}
			
	    }
	}




