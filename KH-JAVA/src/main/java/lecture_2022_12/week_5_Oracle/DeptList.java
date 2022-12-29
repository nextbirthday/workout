package lecture_2022_12.week_5_Oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lecture_2022_12.week_4_List.DepartmentDTOBuilder;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeptList {
    Connection        con   = null;
    PreparedStatement pstmt = null;
    ResultSet         rs    = null;
    DBConnectionMgr   db    = new DBConnectionMgr();
    
    public List<DepartmentDTOBuilder> getDeptList() {
        con = db.getConnection();
        String                     sql      = "SELECT deptno, dname, loc FROM dept";
        List<DepartmentDTOBuilder> deptList = new ArrayList<>();
        
        try {
            pstmt = con.prepareStatement( sql );
            rs = pstmt.executeQuery( );
            
            DepartmentDTOBuilder dVO = null;
            
            while ( rs.next() ) {
                dVO = DepartmentDTOBuilder.builder().deptno( rs.getInt( "deptno" ) ).dname( rs.getString( "dname" ) ).loc( rs.getString( "loc" ) ).build();
                log.info( dVO );
                deptList.add( dVO );
            }
        }
        catch ( Exception e ) {}
        return deptList;
    }
    
    public static void main( String[] args ) {
        DeptList                   deptList = new DeptList();
        List<DepartmentDTOBuilder> list     = null;
        log.info( list );
        list = deptList.getDeptList();
        log.info( list );
        
        for ( int i = 0; i < list.size(); i++ ) {
            DepartmentDTOBuilder dto = list.get( i );
            System.out.println( dto.getDeptno() + "," + dto.getDname() + "," + dto.getLoc() );
            
        }
    }
}
