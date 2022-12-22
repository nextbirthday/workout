package lecture_2022_12.week_4_List;

import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;

public class ListCRUD04 {
    
    static List<DepartmentDTOBuilder> deptList = new Vector<>();
    
    static Scanner scanner = new Scanner( System.in );
    
    public ListCRUD04() {}
    
    public void getDeptList() {
        
        for ( DepartmentDTOBuilder dto : deptList ) {
            System.out.println( dto.getDeptno() + ", " + dto.getDname() + ", " + dto.getLoc() );
        }
    }
    
    public int insertDept( DepartmentDTOBuilder userDept ) { // Vector에 부서정보 추가하기 (Create) - 없는 거를 추가함
        int     result = 0; // 성공: 1 , 실패: 0 반환
        boolean isOk   = deptList.add( userDept );
        
        if ( isOk == true ) {
            result = 1;
        }
        return result;
    }
    
    // public int deleteDept() { // Vector에 부서정보 삭제하기 (Delete) - 존재하는 것을 삭제
    // System.out.println( "deleteDept method call" );
    // int result = 0; // 성공: 1 , 실패: 0 반환
    // System.out.print( "삭제할 부서번호를 입력하세요." );
    // int userInputDeptno = scanner.nextInt();
    //
    // for ( int i = 0; i < deptList.size(); i++ ) {
    // DepartmentDTOBuilder record = deptList.get( i );
    //
    // if ( record != null ) {
    // userInputDeptno = record.getDeptno();
    // }
    //
    // if ( record.getDeptno() == userInputDeptno ) {
    // DepartmentDTOBuilder deleteRecord = deptList.remove( i );
    // System.out.println( "Deleted Array is = " + deleteRecord.getDeptno() );
    //
    // if ( deleteRecord != null ) {
    // // JOptionPane.showMessageDialog( null, "삭제되었습니다." );
    // System.out.println( "부서번호 " + deleteRecord.getDeptno() + "번의 부서정보가 삭제 되었습니다." );
    // result = 1;
    // }
    // }
    // }
    // return result;
    // }
    
    public int deleteDept( int deptno ) {
        System.out.println( "부서 정보 삭제 호출" + deptno );
        int result = 0;
        
        for ( int i = 0; i < deptList.size(); i++ ) {
            DepartmentDTOBuilder record  = deptList.get( i );
            int                  deptno2 = 0;
            deptno2 = record.getDeptno();
            
            if ( deptno == deptno2 ) {
                DepartmentDTOBuilder deletedDTO = deptList.remove( i );
                if ( deletedDTO != null )
                    result = 1;
            }
        }
        return result;
    }
    
    public DepartmentDTOBuilder detailDept( int deptno ) { // Vector에 부서정보 읽기(상세보기, Read) - 존재하는 것을 읽어오기
        DepartmentDTOBuilder dto = null;
        
        return dto;
    }
    
    public int updateDept( DepartmentDTOBuilder dto ) {
        System.out.println( "updateDept method call" );
        int result = 0;
        int choice = 0;
        System.out.print( "수정은 1, 삭제는 2를 입력하세요." );
        choice = scanner.nextInt();
        
        if ( choice == 1 ) {
            int    userInputDeptno = 0;
            String userInputDname  = null;
            String userInputLoc    = null;
            
            System.out.print( "수정하고자 하는 부서번호를 입력하세요. =====>" );
            ListCRUD04.scanner = null;
            ListCRUD04.scanner = new Scanner( System.in );
            int                  userDeptno = scanner.nextInt();
            DepartmentDTOBuilder updateDTO  = DepartmentDTOBuilder.builder().deptno( userDeptno ).build();
            
            if ( updateDTO.getDeptno() == dto.getDeptno() ) {
                System.out.print( "수정할 부서번호, 부서명, 지역을 입력하세요(구분은 |연산자로 함)" );
                String          userInput = null;
                StringTokenizer st        = new StringTokenizer( userInput, "|" );
                userInputDeptno = Integer.parseInt( st.nextToken() );
                userInputDname = st.nextToken();
                userInputLoc = st.nextToken();
                DepartmentDTOBuilder modifiedDTO = DepartmentDTOBuilder.builder().deptno( userInputDeptno ).dname( userInputDname ).loc( userInputLoc ).build();
                
                DepartmentDTOBuilder comDTO = null;
                
                for ( int i = 0; i < deptList.size(); i++ ) {
                    comDTO = deptList.get( i );
                    
                    if ( modifiedDTO.getDeptno() == comDTO.getDeptno() ) {
                        deptList.remove( i );
                        deptList.add( i, modifiedDTO );
                        result = 1;
                    }
                }
            }
        }
        else if ( choice == 2 ) {
            System.out.println( "삭제하고자 하는 부서번호를 입력하세요. =====>" );
        }
        
        getDeptList();
        return result;
    }
    
    public static void main( String[] args ) {
        ListCRUD04           crudTest   = new ListCRUD04();
        DepartmentDTOBuilder dtoBuilder = DepartmentDTOBuilder.builder().deptno( 10 ).dname( "개발팀" ).loc( "인천" ).build();
        int                  result     = crudTest.insertDept( dtoBuilder );
        dtoBuilder = null; // 기존에 참조하는 Object와 연결을 끊는다.
        dtoBuilder = DepartmentDTOBuilder.builder().deptno( 20 ).dname( "재무팀" ).loc( "서울" ).build();
        result = crudTest.insertDept( dtoBuilder );
        
        if ( result == 1 ) {
            JOptionPane.showMessageDialog( null, "등록되었습니다." );
            crudTest.getDeptList();
        }
        
        // int result2 = crudTest.deleteDept();
        //
        // if ( result2 == 1 ) {
        // JOptionPane.showMessageDialog( null, "삭제되었습니다." );
        // crudTest.getDeptList();
        // }
        crudTest.updateDept( dtoBuilder );
    }
}
