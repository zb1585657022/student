package servlet;

import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("id");
        if(null!=str&&!"".equals(str)){
            int id = Integer.parseInt(str);
            StudentService service = new StudentService();
            boolean boo = service.deleteStudent(id);
            if(boo){
                request.setAttribute("deletemess", "删除成功");
                request.getRequestDispatcher("QueryStudentServlet").forward(request, response);
            }else{
                request.setAttribute("deletemess", "删除异常");
                request.getRequestDispatcher("QueryStudentServlet").forward(request, response);
            }

        }else{
            request.setAttribute("deletemess", "删除失败");
            request.getRequestDispatcher("QueryStudentServlet").forward(request, response);
        }
    }
}
