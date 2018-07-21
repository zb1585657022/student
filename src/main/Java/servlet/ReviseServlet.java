package servlet;

import bean.Student;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ReviseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("id");
        if(null!=str&&!"".equals(str)){
            int id = Integer.parseInt(str);
            StudentService service = new StudentService();
            List<Student> list = service.reviceStudent(id);
            request.setAttribute("list", list);
            request.getRequestDispatcher("change.jsp").forward(request, response);
        }
    }
}
