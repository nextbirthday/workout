package b3_1216;

import java.util.List;

public class DepartmentController {
    DeptList deptList = new DeptList();
    
    private DepartmentController() {}
    
    public static DepartmentController getInstance() { return LazyHolder.INSTANCE; }
    
    private static class LazyHolder {
        private static final DepartmentController INSTANCE = new DepartmentController();
    }
    
    public int cudVO( DepartmentVO pdVO, String cmd ) {
        
        // DeptList deptList = new DeptList(); 변수 scope <- 여기서는 local variable이라서 영속성이 유지가 안되었다.
        
        int result = -1;
        
        if ( "C".equals( cmd ) ) {
            result = deptList.deptInsert( pdVO );
        }
        
        if ( "U".equals( cmd ) ) {
            result = deptList.deptUpdate( pdVO );
        }
        
        if ( "D".equals( cmd ) ) {
            result = deptList.deptDelete( pdVO );
        }
        return result;
    }
    
    public List<DepartmentVO> getData() { return deptList.deptSelect(); }
}
