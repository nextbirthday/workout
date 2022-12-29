package lecture_2022_12.week_5_Oracle;

import java.util.ArrayList;
import java.util.List;

import lecture_2022_12.week_4_List.DepartmentDTOBuilder;

public class ListExam1 {
    public static void main( String[] args ) {
        List<DepartmentDTOBuilder> deptList = new ArrayList<>();
        DepartmentDTOBuilder       dVO      = DepartmentDTOBuilder.builder().deptno( 10 ).dname( "전산팀" ).loc( "서울" ).build();
        deptList.add( dVO );
        dVO = DepartmentDTOBuilder.builder().deptno( 20 ).dname( "총무팀" ).loc( "시청" ).build();
        deptList.add( dVO );
        dVO = DepartmentDTOBuilder.builder().deptno( 30 ).dname( "영업팀" ).loc( "선릉" ).build();
        deptList.add( dVO );
        
        for ( DepartmentDTOBuilder dto : deptList ) {
            System.out.println( dto.getDeptno() + "," + dto.getDname() + "," + dto.getLoc() );
        }
        
        System.out.println( "==========" );
        for ( int i = 0; i < deptList.size(); i++ ) {
            DepartmentDTOBuilder dto = deptList.get( i );
            System.out.println( dto.getDeptno() + "," + dto.getDname() + "," + dto.getLoc() );
        }
    }
}
