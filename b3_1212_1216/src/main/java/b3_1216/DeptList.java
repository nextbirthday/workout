package b3_1216;

import java.util.List;
import java.util.Vector;

public class DeptList {
    
    List<DepartmentVO> records = new Vector<>();
    
    private void printData( List<DepartmentVO> records ) {
        
        if ( records.size() > 0 ) {
            
            for ( DepartmentVO departmentVO : records ) {
                System.out.println( departmentVO );
            }
        }
        else
            System.out.println( "List is empty" );
    }
    
    // 부서등록 (성공 1 , 실패 0)
    int deptInsert( DepartmentVO pdVO ) {
        int result = -1;
        
        if ( pdVO != null ) {
            records.add( pdVO );
            result = 1;
        }
        printData( records );
        return result;
    }
    
    // 부서수정 - 부서명과 지역만 수정할 수 있다. (일종의 요구사항)
    int deptUpdate( DepartmentVO pdVO ) {
        int result = -1;
        
        if ( records.size() > 0 ) {
            
            for ( DepartmentVO vo : records ) {
                
                if ( vo.getDeptno() == pdVO.getDeptno() ) {
                    vo.setdName( pdVO.getdName() );
                    vo.setLoc( pdVO.getLoc() );
                }
            }
            result = 1;
        }
        else
            System.out.println( "DB 비어있음" );
        printData( records );
        return result;
    }
    
    // 부서삭제
    int deptDelete( DepartmentVO pdVO ) {
        int result = -1;
        
        if ( records.size() > 0 ) {
            
            // for(int i = 0; records.size(); i++){}
            for ( int i = 0; i < records.size(); i++ ) {
                
                if ( records.get( i ).getDeptno() == pdVO.getDeptno() ) {
                    
                    records.remove( i );
                }
            }
        }
        result = 1;
        printData( records );
        return result;
    }
    
    // 부서 상세보기
    List<DepartmentVO> deptSelect() {
        records.add( new DepartmentVO( 50, "영업2팀", "서울대" ) );
        return records;
    }
    
}
