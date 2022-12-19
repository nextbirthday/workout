package dept;

import java.util.List;

public class DeptController {
    protected DeptModel model = new DeptModel();
    
    public int cudDept( DeptDTO dto, String cmd ) {
        int result = -1;
        
        switch ( cmd ) {
            // INSERT
            case Command.INSERT:
                result = model.insertDept( dto );
                break;
            // UPDATE
            case Command.UPDATE:
                result = model.updateDept( dto );
                break;
            // DELETE
            case Command.DELETE:
                result = model.deleteDept( dto );
                break;
        }
        return result;
    }
    
    // SELECT
    public List<DeptDTO> getDept() { return model.selectDept(); }
}
