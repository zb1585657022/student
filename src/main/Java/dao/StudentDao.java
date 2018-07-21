package dao;

import bean.Student;
import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StudentDao {
    public boolean addStudent(Student s){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String student = JSON.toJSONString(s);
        jedis.zadd("students",s.getAvemark(),student);
        jedis.close();
        return true;
    }

    public List<Student> queryStudent(){
        List<Student> list = new ArrayList<Student>();
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Set<String> set = jedis.zrevrange("students",0,-1);
        for(String s: set){
            Student stu=JSON.parseObject(s, Student.class);
            Student student = new Student();
            student.setId(stu.getId());
            student.setName(stu.getName());
            student.setBirthday(stu.getBirthday());
            student.setBeizhu(stu.getBeizhu());
            student.setAvemark(stu.getAvemark());
            list.add(student);
        }
        return list;
    }

    public boolean delelteStudent(int id){
        long i = 5;
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Set<String> set = jedis.zrevrange("students",0,-1);
        for(String s: set){
            Student stu=JSON.parseObject(s, Student.class);
            if(id==stu.getId()){
                i = jedis.zrem("students",s);
            }
        }
        if(i==1){
            return true;
        }else {
            return false;
        }
    }

    public List reviceStudent(int id){
        List<Student> list = new ArrayList<Student>();
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Set<String> set = jedis.zrevrange("students",0,-1);
        for(String s: set){
            Student stu=JSON.parseObject(s, Student.class);
            if(id==stu.getId()){
                Student student = new Student();
                student.setId(stu.getId());
                student.setName(stu.getName());
                student.setBirthday(stu.getBirthday());
                student.setBeizhu(stu.getBeizhu());
                student.setAvemark(stu.getAvemark());
                list.add(student);
            }
        }
        return list;
    }

    public int getSize(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Set<String> set = jedis.zrevrange("students",0,-1);
        return set.size();
    }

    public int getMaxId(){
        int i = 0;
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Set<String> set = jedis.zrevrange("students",0,-1);
        for(String s: set){
            Student stu=JSON.parseObject(s, Student.class);
            if(i<stu.getId()){
                i=stu.getId();
            }
        }
        return i;
    }

    public List queryStudentByCurrentPage(int currentPage){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        List<Student> list = new ArrayList<Student>();
        int j = 1;
        int i=1;
        Set<String> set = jedis.zrevrange("students",0,-1);
        for(String s: set){
            Student stu=JSON.parseObject(s, Student.class);
            if(((currentPage-1)*10+j)==i&&j<=10){
                Student student = new Student();
                student.setId(stu.getId());
                student.setName(stu.getName());
                student.setBirthday(stu.getBirthday());
                student.setBeizhu(stu.getBeizhu());
                student.setAvemark(stu.getAvemark());
                list.add(student);
                j++;
            }
            i++;
        }
        return list;
    }

    public int getTotalRows() {
        return getSize();
    }

}
