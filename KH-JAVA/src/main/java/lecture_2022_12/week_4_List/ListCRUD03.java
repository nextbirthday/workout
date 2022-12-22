package lecture_2022_12.week_4_List;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

public class ListCRUD03 {
    
    List<DepartmentDTOBuilder> deptList = new Vector<>();
    
    static Scanner scanner = new Scanner( System.in );
    
    public ListCRUD03() {}
    
    public void getDeptList() {
        
        for ( DepartmentDTOBuilder dto : deptList ) {
            System.out.println( dto.getDeptno() + ", " + dto.getDname() + ", " + dto.getLoc() );
        }
    }
    
    public int insertDept( DepartmentDTOBuilder userDept ) { // Vector에 부서정보 추가하기 (Create) - 없는 거를 추가함
        System.out.println( "insertDept method call" );
        int     result = 0; // 성공: 1 , 실패: 0 반환
        boolean isOk   = deptList.add( userDept );
        
        if ( isOk == true ) {
            result = 1;
        }
        return result;
    }
    
    public int deleteDept() { // Vector에 부서정보 삭제하기 (Delete) - 존재하는 것을 삭제
        System.out.println( "deleteDept method call" );
        int     result  = 0; // 성공: 1 , 실패: 0 반환
        Scanner scanner = new Scanner( System.in );
        System.out.print( "삭제할 부서번호를 입력하세요." );
        int userInputDeptno = scanner.nextInt();
        scanner.close();
        
        for ( int i = 0; i < deptList.size(); i++ ) {
            DepartmentDTOBuilder record = deptList.get( i );
            
            if ( record != null ) {
                userInputDeptno = record.getDeptno();
            }
            
            if ( record.getDeptno() == userInputDeptno ) {
                DepartmentDTOBuilder deleteRecord = deptList.remove( i );
                System.out.println( "Deleted Array is = " + deleteRecord.getDeptno() );
                
                if ( deleteRecord != null ) {
                    // JOptionPane.showMessageDialog( null, "삭제되었습니다." );
                    System.out.println( "부서번호 " + deleteRecord.getDeptno() + "번의 부서정보가 삭제 되었습니다." );
                    result = 1;
                }
            }
        }
        return result;
    }
    
    public DepartmentDTOBuilder detailDept( int deptno ) { // Vector에 부서정보 읽기(상세보기, Read) - 존재하는 것을 읽어오기
        DepartmentDTOBuilder dto = null;
        
        return dto;
    }
    
    /*****************************************************************************************
     * Vector에 부서정보 수정하기 (Update) - 존재하는 것을 변경
     * 
     * @param deptno     수정하고자 하는 부서번호
     * @param user_dName 수정하고자 하는 부서명
     * @param user_loc   수정하고자 하는 지역
     * @return 1이면 성공 0이면 수정실패
     ******************************************************************************************/
    public int updateDept() {
        System.out.println( "updateDept method call" );
        int result = 0; // 성공: 1 , 실패: 0 반환
        return result;
    }
    
    public static void main( String[] args ) {
        ListCRUD03           crudTest   = new ListCRUD03();
        DepartmentDTOBuilder dtoBuilder = DepartmentDTOBuilder.builder().deptno( 10 ).dname( "개발팀" ).loc( "인천" ).build();
        int                  result     = crudTest.insertDept( dtoBuilder );
        dtoBuilder = null; // 기존에 참조하는 Object와 연결을 끊는다.
        dtoBuilder = DepartmentDTOBuilder.builder().deptno( 20 ).dname( "재무팀" ).loc( "서울" ).build();
        result = crudTest.insertDept( dtoBuilder );
        
        if ( result == 1 ) {
            JOptionPane.showMessageDialog( null, "등록되었습니다." );
            crudTest.getDeptList();
        }
        
        int result2 = crudTest.deleteDept();
        
        if ( result2 == 1 ) {
            JOptionPane.showMessageDialog( null, "삭제되었습니다." );
            crudTest.getDeptList();
        }
        
    }
}
