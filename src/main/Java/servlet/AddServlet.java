package servlet;

import bean.Student;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService service = new StudentService();
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String beizhu = request.getParameter("beizhu");
        String avemarkStr = request.getParameter("avemark");
        int id = service.getMaxId()+1;
        Student student = new Student();
        int avemark = Integer.parseInt(avemarkStr);
        student.setId(id);
        student.setName(name);
        student.setBirthday(birthday);
        student.setBeizhu(beizhu);
        student.setAvemark(avemark);
        service.addStudent(student);
        request.getRequestDispatcher("QueryStudentServlet").forward(request,response);
    }
}
