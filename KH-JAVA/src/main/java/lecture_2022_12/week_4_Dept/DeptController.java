package lecture_2022_12.week_4_Dept;

import java.util.List;

public class DeptController {
    
    DeptModel model = new DeptModel();
    
    // CRUD - create, read, update, delete + detail(상세보기)
    public int cudDept( DeptDTO dto, String cmd ) {
        int result = -1;
        
        switch ( cmd ) {
            // INSERT
            case "C":
                result = model.insertDept( dto );
                break;
            
            // UPDATE
            case "U":
                result = model.updateDept( dto );
                break;
            
            // DELETE
            case "D":
                result = model.deleteDept( dto );
                break;
        }
        return result;
    }
    
    // SELECT - 조회
    public List<DeptDTO> getDept() { return model.selectDept(); }
}
