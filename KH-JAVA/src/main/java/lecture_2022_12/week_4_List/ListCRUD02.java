package lecture_2022_12.week_4_List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;

public class ListCRUD02 {
    
    static List<String[]> dept = new Vector<>();
    // List<DepartmentDTO> deptList = new Vector<>();
    
    public ListCRUD02() {}
    
    public void getDeptList() {
        
        for ( int i = 0; i < dept.size(); i++ ) {
            String[] oneRow = dept.get( i );
            
            for ( int j = 0; j < oneRow.length; j++ ) {
                System.out.print( oneRow[j] + " " );
            }
            System.out.println();
        }
        
    }
    
    public int insertDept( String[] userDept ) { // Vector에 부서정보 추가하기 (Create) - 없는 거를 추가함
        System.out.println( "insertDept method call" );
        int result = 0; // 성공: 1 , 실패: 0 반환
        dept.add( userDept );
        
        if ( dept.size() != 0 ) {
            result = 1;
        }
        return result;
    }
    
    // Vector에 있는 부서정보 중에서 어떤 row를 삭제할건지 부서번호를 받아와야 한다. (식별자 ( 기본 key와 외래 key))
    // 사용자로부터 받아와야 하는 값이다.
    public int deleteDept( int deptno ) { // Vector에 부서정보 삭제하기 (Delete) - 존재하는 것을 삭제
        System.out.println( "deleteDept method call" );
        int result = 0; // 성공: 1 , 실패: 0 반환
        
        for ( int i = 0; i < dept.size(); i++ ) {
            String[] oneRow  = dept.get( i );
            int      deptno2 = 0;
            
            if ( oneRow[0] != null ) {// null check - framework에서 지원하는 기능이 있다.
                deptno2 = Integer.parseInt( oneRow[0] ); // String type to int type casting
            } // 예외발생 방어코드작성 필요 - null이 오면 NumberFormatException이 발생할 수 있다.
            
            // 사용자가 입력한 부서번호와 벡터에서 가져온 부서번호 비교하기
            System.out.println( "파라미터로 입력받은 부서번호와 Vector에서 가져온 부서번호 비교=====>" + deptno + "," + deptno2 );
            
            // 사용자가 선택한 부서번호와 벡터에 있는 부서번호를 비교하여 같은것찾기
            // 삭제할 벡터의 row값이 필요함 - 벡터의 size를 통해 찾아냄
            // remove 메서드의 파라미터가 int type인 경우에 대해서만 삭제된 벡터의 제네릭
            if ( deptno == deptno2 ) {
                String[] deleteRow = dept.remove( i );  // 변수 i가 index값에 해당함
                System.out.println( "Deleted Array is = " + Arrays.toString( deleteRow ) );
                // boolean isOk = dept.remove( oneRow );
                
                // 삭제한 object가 존재? Yes: deleted No: not deleted
                if ( deleteRow != null ) {
                    // JOptionPane.showMessageDialog( null, "삭제되었습니다." );
                    System.out.println( "부서번호 " + deptno + "번의 부서정보가 삭제 되었습니다." );
                    result = 1;
                }
            }
        }
        return result;
    }
    
    public String[] readDept( int index ) { // Vector에 부서정보 읽기(상세보기, Read) - 존재하는 것을 읽어오기
        System.out.println( "readDept method call" );
        String[] oneRow = new String[3];
        
        // textfield.setEnabled(false);
        for ( int i = 0; i < dept.size(); i++ ) {}
        return oneRow;
    }
    
    /*****************************************************************************************
     * Vector에 부서정보 수정하기 (Update) - 존재하는 것을 변경
     * 
     * @param deptno     수정하고자 하는 부서번호
     * @param user_dName 수정하고자 하는 부서명
     * @param user_loc   수정하고자 하는 지역
     * @return 1이면 성공 0이면 수정실패
     ******************************************************************************************/
    public int updateDept( int userUpdate, String user_dName, String user_loc ) {
        System.out.println( "updateDept method call" + user_dName + user_loc );
        int      result = 0; // 성공: 1 , 실패: 0 반환
        String[] oneRow = null;
        String[] comRow = null;
        
        for ( int i = 0; i < dept.size(); i++ ) {
            comRow = dept.get( i );
            
            if ( userUpdate == Integer.parseInt( comRow[0] ) ) {
                oneRow = comRow;
            }
        }
        
        for ( int i = 0; i < dept.size(); i++ ) {
            String[] row = dept.get( i ); // i is row index
            // if() Vector
            here: for ( int j = 0; j < row.length; j++ ) {// String[]
                // if() Array -> 화면에서 가져온 배열과 벡터에서 꺼낸 배열을 비교한다.
                int deptno2 = 0;
                deptno2 = Integer.parseInt( row[0] );
                System.out.println( userUpdate + " , " + deptno2 );
                
                if ( userUpdate == deptno2 ) { // oneRow[0] =
                    String[] updateRow = { oneRow[0], user_dName, user_loc };
                    dept.remove( i );
                    dept.add( i, updateRow );
                    // break 문만 사용시 이중 for문에서 내부 for문 만을 탈출하게 되는데
                    // 여기서는 외부 for문을 빠져나가야 하므로 라벨문을 붙여서 처리함 ex)here
                    result = 1;
                    break here;
                }
                else {
                    System.out.println( "선택한 부서번호와 벡터에서 가져온 부서번호가 다릅니다." );
                }
            } // 바깥쪽 for문에 라벨문을 사용할 것
        }
        getDeptList();
        return result;
    }
    
    public static void main( String[] args ) {
        
        ListCRUD02 crudTest = new ListCRUD02();
        // CRUD test
        String[] oneRow  = { "10", "개발부", "인천" };
        int      result  = crudTest.insertDept( oneRow );
        String[] oneRow2 = { "20", "총무부", "서울" };
        crudTest.insertDept( oneRow2 );
        
        if ( result == 1 ) {
            JOptionPane.showMessageDialog( null, "등록되었습니다." );
            crudTest.getDeptList();
        }
        
        // Scanner scanner = new Scanner( System.in );
        // System.out.print( "삭제할 부서번호를 입력하세요." );
        // int user = scanner.nextInt();
        // int result3 = crudTest.deleteDept( user );
        //
        // if ( result3 == 1 ) {
        // JOptionPane.showMessageDialog( null, "삭제되었습니다." );
        // crudTest.getDeptList();
        // }
        
        Scanner scanner = new Scanner( System.in );
        System.out.print( "수정할 부서번호,부서명,지역을 입력하세요.(구분은 | 연산자로함)" );
        String          userUpdate  = scanner.nextLine(); // 10 | 인사팀 | 포항
        int             user_deptno = 0;
        String          user_dName  = null;
        String          user_loc    = null;
        StringTokenizer st          = new StringTokenizer( userUpdate, "|" );
        user_deptno = Integer.parseInt( st.nextToken() );
        user_dName = st.nextToken();
        user_loc = st.nextToken();
        int resultUpdate = crudTest.updateDept( user_deptno, user_dName, user_loc );
        
        scanner.close();
    }
}
