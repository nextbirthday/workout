package temp;

import java.util.ArrayList;
import java.util.List;

import b3_1216.DepartmentVO;

public class DeptList {
    
    // 부서등록 (성공 1 , 실패 0)
    int deptInsert( DepartmentVO pdVO ) {
        int result = -1;
        return result;
    }
    
    // 부서수정 - 부서명과 지역만 수정할 수 있다. (일종의 요구사항)
    int deptUpdate( DepartmentVO pdVO ) {
        int result = -1;
        return result;
    }
    
    // 부서삭제
    int deptDelete( int deptno ) {
        int result = -1;
        
        return result;
    }
    
    // 부서정보 상세보기
    
    public static void main( String[] args ) {
        List<DepartmentVO> deptList = new ArrayList<>();
        deptList.add( new DepartmentVO( 10, "개발부", "서울" ) );
        deptList.add( new DepartmentVO( 20, "영업부", "안양" ) );
        deptList.add( new DepartmentVO( 30, "인사부", "부산" ) );
        
        // 목록 초기화
        for ( DepartmentVO record : deptList ) {
            System.out.println( record.toString() );
        }
    }
}
