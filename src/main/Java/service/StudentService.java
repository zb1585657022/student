package service;

import bean.Student;
import dao.StudentDao;

import java.util.List;

public class StudentService {
    private StudentDao dao = new StudentDao();
    public boolean addStudent(Student s){
        return dao.addStudent(s);
    }

    public List<Student> queryStudent(){
        return dao.queryStudent();
    }

    public boolean deleteStudent(int id){
        return dao.delelteStudent(id);
    }

    public List reviceStudent(int id){
        return dao.reviceStudent(id);
    }

    public int getMaxId(){
        return dao.getMaxId();
    }

    public int getSize(){
        return dao.getSize();
    }

    public List queryStudentByCurrentPage(int currentPage){
        return dao.queryStudentByCurrentPage(currentPage);
    }

    public int getTotalRows() {
        return dao.getTotalRows();
    }

}
