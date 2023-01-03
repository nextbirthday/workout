package lecture_2023_01.week_1_Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lecture_2022_12.week_5_Oracle.DBConnectionMgr;

public class ListDeptVO {
    DBConnectionMgr   dbMgr = new DBConnectionMgr();
    Connection        con   = null; // 오라클서버와 연결통로 확보
    PreparedStatement pstmt = null; // 자바에서 오라클 서버로 DML 전달
    ResultSet         rs    = null; // 오라클 테이블에 제공되는 커서를 조작하는 함수제공
    
    public List<DeptVO> getEmpList() {
        List<DeptVO>  list = null;
        StringBuilder sql  = new StringBuilder();
        
        sql.append( " SELECT" );
        sql.append( " empno,ename,dname                 " );
        sql.append( " FROM emp,dept                     " );
        sql.append( " WHERE emp.deptno = dept.deptno   " );
        
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement( sql.toString() );
            rs = pstmt.executeQuery();
            list = new ArrayList<>(); // list.size() = 0
            
            DeptVO tempVO;
            
            while ( rs.next() ) {
                tempVO = new DeptVO( 0, null, rs.getString( "dname" ) ); // default constructor 0, null, null
                // System.out.println( rs.getInt( "empno" ) + ", " + rs.getString( "ename" ) + ", " + rs.getString( "dname" ) );
                list.add( tempVO );
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main( String[] args ) {
        ListDeptVO   listDeptVO = new ListDeptVO();
        List<DeptVO> tempList   = null;
        
        tempList = listDeptVO.getEmpList();
        // System.out.println( tempList );
        
        for ( DeptVO deptVO : tempList ) {
            System.out.println( deptVO.getDeptno() + ", " + deptVO.getDname() + ", " + deptVO.getLoc() );
        }
    }
}
