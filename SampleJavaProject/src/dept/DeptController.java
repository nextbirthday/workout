package dept;

import java.util.List;

public class DeptController {
    protected DeptModel  model  = new DeptModel();
    protected DeptModel2 model2 = new DeptModel2();
    
    public int cudDept( DeptDTO dto, String cmd ) {
        int result = -1;
        
        switch ( cmd ) {
            // INSERT
            case Command.INSERT:
                result = model2.insertDept( dto );
                break;
            // UPDATE
            case Command.UPDATE:
                result = model2.updateDept( dto );
                break;
            // DELETE
            case Command.DELETE:
                result = model2.deleteDept( dto );
                break;
        }
        return result;
    }
    
    // SELECT
    public List<DeptDTO> getDept() { return model2.selectDept(); }
}
