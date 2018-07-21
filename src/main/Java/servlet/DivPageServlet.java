package servlet;

import bean.GetTotalPage;
import bean.Student;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DivPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int countPage = GetTotalPage.getTotalPage();
        StudentService service = new StudentService();
        request.setAttribute("countPage", countPage);

        String jumpPagestr = request.getParameter("jumpPage");
        String currentPagestr = request.getParameter("currentPage");

        if(null!=currentPagestr&&!"".equals(currentPagestr)){
            int currentPage = Integer.parseInt(currentPagestr);
            if(currentPage<=1){
                currentPage=1;
            }
            if(currentPage>=countPage){
                currentPage=countPage;
            }
            request.setAttribute("currentPage", currentPage);
            List<Student> list = service.queryStudentByCurrentPage(currentPage);
            request.setAttribute("list", list);
            request.getRequestDispatcher("student.jsp").forward(request, response);
        }else if(null!=jumpPagestr&&!"".equals(jumpPagestr)){
            int currentPage = Integer.parseInt(jumpPagestr);
            if(currentPage<=1){
                currentPage=1;
            }
            if(currentPage>=countPage){
                currentPage=countPage;
            }
            request.setAttribute("currentPage", currentPage);
            List<Student> list = service.queryStudentByCurrentPage(currentPage);
            request.setAttribute("list", list);
            request.getRequestDispatcher("student.jsp").forward(request, response);
        }else{
            List<Student> list = service.queryStudentByCurrentPage(1);
            request.setAttribute("currentPage", 1);
            request.setAttribute("list", list);
            request.getRequestDispatcher("student.jsp").forward(request, response);
        }
    }
}
