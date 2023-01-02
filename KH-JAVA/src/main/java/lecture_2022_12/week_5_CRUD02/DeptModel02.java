package lecture_2022_12.week_5_CRUD02;

import java.util.List;
import java.util.Vector;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeptModel02 {
    
    List<DeptVO02> deptList = new Vector<>();
    
    protected List<DeptVO02> dataInitialize() {
        deptList.add( new DeptVO02( 10, "인사팀", "을지로" ) );
        deptList.add( new DeptVO02( 20, "영업1팀", "을지로" ) );
        deptList.add( new DeptVO02( 30, "영업2팀", "강남" ) );
        deptList.add( new DeptVO02( 40, "재무팀", "을지로" ) );
        deptList.add( new DeptVO02( 50, "홍보팀", "강남" ) );
        return deptList;
    }
    
    protected List<DeptVO02> selectDept() {
        
        if ( deptList.size() == 0 ) {
            dataInitialize();
        }
        log.info( deptList );
        
        return deptList;
    }
    
}
