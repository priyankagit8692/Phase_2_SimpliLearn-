package com.learneracademy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.learneracademy.Entity.ListMaster;
import com.learneracademy.Entity.MainApplication;
import com.learneracademy.Entity.Student;

@WebServlet("/addStudent")
public class AddStudent extends HttpServlet {
	
	private static boolean addedStudentSuccess = false;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		List<String> teacherList = ListMaster.getMasterTeacher();
		List<String> subjectList = ListMaster.getMasterSubject();
		List<String> classList1 = ListMaster.getMasterCLass();
		
		PrintWriter out = response.getWriter();
		out.println("<style>" + 
					"body {\r\n" + 
				     " background-image: url('images/student.jpg');\r\n"+
				     "  background-repeat: no-repeat;\r\n" + 
				    "}"
				    + "div {\r\n"
				    + "  transform: translate(-200px,50px);\r\n"
				    + "}\r\n"
				    + "h1{\r\n"
				    + "  transform: translate(850px,50px);\r\n"
				    + "  color: #4CAF50;\r\n"
				    + "}\r\n" + 
				   "</style>");
		out.println("<h1>Add Student</h1>");
		out.println("<div align='right'>");
		out.print("<a href='MainHomePage.jsp'>Home</a><br><br>");
		out.print("<form action='addStudent' method='post'>");
		out.print("<table>");
		out.print("<tr><td>Student Name:</td><td><input type='text' name='studentName'/></td></tr>");
		out.print("<tr><td>Class:</td>");
		out.print("<td><select name='className' style='width:160px'>");
		for (String clist : classList1) {
			out.print("<option>" + clist + "</option>");
		}
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td>Subject:</td>");
		out.print("<td><select name='subjectName' style='width:160px'>");
		for (String slist : subjectList) {
			out.print("<option>" + slist + "</option>");
		}
		out.print("</select>");
		out.print("<tr><td>Teacher:</td>");
		out.print("<td><select name='teacherName' style='width:160px'>");
		for (String tlist : teacherList) {
			out.print("<option>" + tlist + "</option>");
		}
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td></td><td colspan='2'><input type='submit' value='Add student'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		if (addedStudentSuccess)
			out.println("Student added successfully");
		addedStudentSuccess = false;
		out.println("</div>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String studentName = request.getParameter("studentName");
		String className = request.getParameter("className");
		String subjectName = request.getParameter("subjectName");
		String teacherName = request.getParameter("teacherName");
		Student student = new Student(studentName, className, subjectName, teacherName);
		MainApplication.addStudent(student);
		addedStudentSuccess = true;
		response.sendRedirect("addStudent");

	}

}
