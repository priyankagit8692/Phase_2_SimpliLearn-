package com.learneracademy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.learneracademy.Entity.MainApplication;
import com.learneracademy.Entity.Student;

@WebServlet("/classReport")
public class ClassReport extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<style>" + "body {\r\n" + "background-color: lightblue;\r\n" + "}\r\n" + "h1{\r\n"
				+ "  transform: translate(10px,0px);\r\n" + "  color: #4CAF50;\r\n" + "}\r\n" + "</style>");
		out.println("<div align='center' style='border: solid 4px black; height: 95%'>");
		out.println("<a href='MainHomePage.jsp'>Home</a>");
		out.println("<h1>Class report</h1>");

		boolean isDelete = false;
		String id = req.getParameter("id");
		if (id != null) {
			MainApplication.deleteDetails(id);
			isDelete = true;
		}

		List<Student> list = MainApplication.getAllDetails();
		out.print("<table border='1' width='100%'");
		out.print(
				"<tr><th>S.No</th><th>Name</th><th>Class</th><th>Subject</th><th>teacher</th><th>Edit</th><th>Delete</th></tr>");
		int count = 1;
		for (Student e : list) {
			out.print("<tr style='text-align:center'><td >" + count + "</td><td>" + e.getSname() + "</td><td>"
					+ e.getCname() + "</td><td>" + e.getSubname() + "</td><td>" + e.getTname()
					+ "</td><td><a href='editCLassDetails?id=" + e.getId() + "'>edit</a></td><td><a href='classReport?id="
					+ e.getId() + "'>delete</a></td></tr>");
			count++;
		}
		out.print("</table><br><br>");
		if (isDelete) {
			out.print("Deleted Student Details Successfully");
		}
		out.println("</div>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println("delete id" + id);
		MainApplication.deleteDetails(id);
		resp.sendRedirect("classReport");
	}
}