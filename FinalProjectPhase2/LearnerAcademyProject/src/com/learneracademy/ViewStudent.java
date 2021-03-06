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


@WebServlet("/viewStudent")
public class ViewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        List<String> classList1 = ListMaster.getMasterCLass();

        PrintWriter out = response.getWriter();
        out.println("<style>" + 
				"body {\r\n" + 
				  "background-color: lightblue;\r\n"
				+ "}\r\n" 
        		+ "h1{\r\n"
			    + "  transform: translate(10px,50px);\r\n"
			    + "  color: #4CAF50;\r\n"
			    + "}\r\n" 
			    + "a{\r\n"
			    + "  transform: translate(850px,50px);\r\n"
			    + "}\r\n" + 
			   "</style>");
        out.println("<div align='center'>");
        out.println("<h1>View Students</h1><br><br>");
        out.print("<a href='MainHomePage.jsp'>Home</a><br><br>");
        out.print("<form action='viewStudent' method='post'>");
        out.print("<table>");
        out.print("<tr><td>Class:</td>");
        out.print("<td><select name='className' style='width:150px'>");
        for (String classList : classList1) {
            out.print("<option>" + classList + "</option>");
        }
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td></td><td colspan='2'><input type='submit' value='Show'/></td></tr>");
        out.print("</table>");
        out.print("</form>");
        out.println("</div>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String className = request.getParameter("className");
		PrintWriter out = response.getWriter();
		List<String> studentList = MainApplication.getStudentFromClass(className);
		out.println("<style>" + 
				"body {\r\n" + 
				  "background-color: lightblue;\r\n"
				+ "}\r\n" 
        		+ "h1{\r\n"
			    + "  transform: translate(10px,50px);\r\n"
			    + "  color: #4CAF50;\r\n"
			    + "}\r\n" +
			   "</style>");
		out.println("<div align='center'>");
		out.print("<h1>View Student</h1><br><br>");
		out.println("<a href='MainHomePage.jsp'>Home</a><br><br>");
		out.print("<table border='1' width='60%'");
	    out.print("<tr><th>S.No</th><th>Name</th></tr>");
	    for (int i = 0; i < studentList.size(); i++) {
            out.print("<tr><td style='text-align:center'>" + (i + 1) + "</td><td style='text-align:center'>" + studentList.get(i) + "</td></tr>");
        }
        out.print("</table>");
        out.println("</div>");
        out.close();


	}

}
