package lecture_2022_12.week_5_CRUD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeptModel {
    
    List<Map<String, Object>> deptList = new Vector<>();
    Map<String, Object>       deptMap;
    
    protected Map<String, Object> setMap( int deptno, String dname, String loc ) {
        deptMap = new HashMap<>();
        this.deptMap.put( "deptno", deptno );
        this.deptMap.put( "dname", dname );
        this.deptMap.put( "loc", loc );
        return deptMap;
    }
    
    protected List<Map<String, Object>> dataInitialize() {
        
        deptList.add( setMap( 10, "개발팀", "서울" ) );
        deptList.add( setMap( 20, "총무팀", "서울" ) );
        deptList.add( setMap( 30, "전산팀", "서울" ) );
        
        return deptList;
    }
    
    protected int insertDept() {
        int result = 0;
        
        return result;
    }
    
    protected int updateDept() {
        int result = 0;
        
        return result;
    }
    
    protected int deleteDept() {
        int result = 0;
        
        return result;
    }
    
    protected List<Map<String, Object>> selectDept() {
        
        if ( deptList.size() == 0 ) {
            dataInitialize();
        }
        return deptList;
    }
    
}
