package lecture_2022_12.week_5_CRUD;

import java.util.List;
import java.util.Map;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeptController {
    DeptModel model = new DeptModel();
    
    protected int cudDept( List<Map<String, Object>> deptList, String cmd ) {
        int result = 0;
        
        switch ( cmd ) {
            case "INSERT":
                
                break;
            
            case "UPDATE":
                break;
            
            case "DELETE":
                break;
        }
        
        return result;
        
    }
    
    protected List<Map<String, Object>> getDept() {
        
        return model.selectDept();
    }
    
}
