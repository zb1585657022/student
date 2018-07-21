package bean;

import service.StudentService;

public class GetTotalPage {
    public static int getTotalRows(){
        StudentService service = new StudentService();
        return service.getTotalRows();
    }

    public static int getTotalPage(){
        int rows = getTotalRows();
        return rows%10==0?rows/10:rows/10+1;
    }
}
