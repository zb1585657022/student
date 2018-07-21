package servlet;

import bean.Student;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String beizhu = request.getParameter("beizhu");
        String avemarkStr = request.getParameter("avemark");
        Student student = new Student();
        int id = Integer.parseInt(idStr);
        int avemark = Integer.parseInt(avemarkStr);
        student.setId(id);
        student.setName(name);
        student.setBirthday(birthday);
        student.setBeizhu(beizhu);
        student.setAvemark(avemark);
        StudentService service = new StudentService();
        boolean b = service.deleteStudent(id);
        service.addStudent(student);
        request.getRequestDispatcher("QueryStudentServlet").forward(request,response);
    }
}
