package dept;

import java.util.List;

public class DeptController {
    protected DeptModel model = new DeptModel();
    
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
    
    // SELECT
    public List<DeptDTO> getDept() { return model.selectDept(); }
}
