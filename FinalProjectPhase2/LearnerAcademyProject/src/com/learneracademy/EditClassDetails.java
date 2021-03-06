package com.learneracademy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learneracademy.Entity.ListMaster;
import com.learneracademy.Entity.MainApplication;
import com.learneracademy.Entity.Student;


@WebServlet("/editCLassDetails")
public class EditClassDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Student s = MainApplication.getStudentById(id);
        System.out.println("id->>" + id);

        HttpSession session = req.getSession();
        session.setAttribute("updatedId", s.getId());

        resp.setContentType("text/html");

        List<String> teacherList = ListMaster.getMasterTeacher();
        List<String> subjectList = ListMaster.getMasterSubject();
        List<String> classList1 = ListMaster.getMasterCLass();

        PrintWriter out = resp.getWriter();
        out.println("<style>" + "body {\r\n" + "background-color: lightblue;\r\n" + "}\r\n" + "h1{\r\n"
				+ "  transform: translate(10px,0px);\r\n" + "  color: #4CAF50;\r\n" + "}\r\n" + "</style>");
        out.println("<div align='center' style='border: solid 4px black'>");
        out.println("<h1>Student Update</h1>");
        out.print("<a href='MainHomePage.jsp'>Home</a><br><br>");
        out.print("<form action='editCLassDetails' method='post'>");
        out.print("<table>");
        out.print("<tr><td>Student Name:</td><td><input type='text' name='name' value='" + s.getSname() + "'/></td></tr>");
        out.print("<tr><td>Class:</td>");
        out.print("<td><select name='className' style='width:150px'>");
        for (String classList : classList1) {
            if (s.getCname().equals(classList))
                out.print("<option selected>" + classList + "</option>");
            else
                out.print("<option>" + classList + "</option>");
        }
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td>Subject:</td>");
        out.print("<td><select name='subject' style='width:150px'>");
        for (String subject : subjectList) {
            if (s.getSname().equals(subject))
                out.print("<option selected>" + subject + "</option>");
            else
                out.print("<option>" + subject + "</option>");
        }
        out.print("</select>");
        out.print("<tr><td>Teacher:</td>");
        out.print("<td><select name='teacher' style='width:150px'>");
        for (String teacher : teacherList) {
            if (s.getTname().equals(teacher))
                out.print("<option selected>" + teacher + "</option>");
            else
                out.print("<option>" + teacher + "</option>");
        }
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td></td><td colspan='2'><input type='submit' value='update student'/></td></tr>");
        out.print("</table>");
        out.print("</form>");
        out.println("</div>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int s = (int) session.getAttribute("updatedId");
        String name = req.getParameter("name");
        String className = req.getParameter("className");
        String subject = req.getParameter("subject");
        String teacher = req.getParameter("teacher");
        Student s1 = new Student(name, className, subject, teacher);
        s1.setId(s);
        MainApplication.updateStudent(s1);;
        resp.sendRedirect("classReport");
    }
}
