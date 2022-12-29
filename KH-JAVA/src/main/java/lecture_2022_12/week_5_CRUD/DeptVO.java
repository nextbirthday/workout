package lecture_2022_12.week_5_CRUD;

import java.util.HashMap;
import java.util.Map;

public class DeptVO {
    
    Map<String, Object> deptMap = new HashMap<>();
    
    void setMap( int deptno, String dname, String loc ) {
        deptMap.put( "deptno", deptno );
        deptMap.put( "dname", dname );
        deptMap.put( "loc", loc );
    }
    
}
