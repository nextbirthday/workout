package lecture_2023_01.week_1_Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lecture_2022_12.week_5_Oracle.DBConnectionMgr;

public class ListMap {
    
    DBConnectionMgr   dbMgr = new DBConnectionMgr();
    Connection        con   = null; // 오라클서버와 연결통로 확보
    PreparedStatement pstmt = null; // 자바에서 오라클 서버로 DML 전달
    ResultSet         rs    = null; // 오라클 테이블에 제공되는 커서를 조작하는 함수제공
    
    public List<Map<String, Object>> getEmpList() {
        List<Map<String, Object>> list = null;
        StringBuilder             sql  = new StringBuilder();
        
        sql.append( " SELECT" );
        sql.append( " empno,ename,dname                 " );
        sql.append( " FROM emp,dept                     " );
        sql.append( " WHERE emp.deptno = dept.deptno   " );
        
        try {
            con = dbMgr.getConnection();
            pstmt = con.prepareStatement( sql.toString() );
            rs = pstmt.executeQuery();
            list = new ArrayList<>(); // list.size() = 0
            
            Map<String, Object> rmap;
            
            while ( rs.next() ) {
                rmap = new HashMap<>();
                
                rmap.put( "empno", rs.getInt( "empno" ) );
                rmap.put( "ename", rs.getString( "ename" ) );
                rmap.put( "dname", rs.getString( "dname" ) );
                list.add( rmap );
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main( String[] args ) {
        ListMap                   lm         = new ListMap();
        List<Map<String, Object>> listDeptVO = new ArrayList<>();
        List<Map<String, Object>> tempList   = null;
        
        tempList = lm.getEmpList();
        // System.out.println( tempList );
        
        for ( Map<String, Object> rMap : tempList ) {
            System.out.println( rMap.get( "empno" ) + ", " + rMap.get( "ename" ) + ", " + rMap.get( "dname" ) );
        }
    }
}
