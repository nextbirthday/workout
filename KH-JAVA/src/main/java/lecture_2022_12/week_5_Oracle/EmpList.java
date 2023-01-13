package lecture_2022_12.week_5_Oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.internal.OracleCallableStatement;

public class EmpList {
    Connection        con;
    CallableStatement cstmt; // procedure를 요청할 때 사용하는 인터페이스
    ResultSet         rs; // 오라클 커서를 조작하는데 필요한 추상메서드를 가지고 있다.
    
    // 모든 RDBMS에서 제공되는 타입이 아니라 오라클에서만 제공되는 타입 -sys.refcursor
    OracleCallableStatement ocstmt;
    
    public List<Map<String, Object>> getEmpList() {
        DBConnectionMgr           db   = new DBConnectionMgr();
        List<Map<String, Object>> list = new Vector<>();
        
        // insert here - 구글링한 소스를 어디에 붙여야 하나? 기준, 선택할 수 있다? -API보고 실습코드 적용해보기
        try {
            con = db.getConnection();
            cstmt = con.prepareCall( " {call my_proc(?)} " );
            cstmt.registerOutParameter( 1, OracleTypes.CURSOR );
            cstmt.execute();
            // 추가로 제공되는 클래스로 치환하는 것은 ResultSet을 주입받는 메서드 호출이 필요하다.
            // CallableStatement에서는 getCursor()를 지원하지 않기 때문에 OracleCallableStatement로 형 변환
            ocstmt = ( OracleCallableStatement ) cstmt;
            rs = ocstmt.getCursor( 1 );
            Map<String, Object> rMap = null;
            
            while ( rs.next() ) {
                rMap = new HashMap<>();
                rMap.put( "EMPNO", rs.getInt( 1 ) );
                rMap.put( "DEPTNO", rs.getInt( 2 ) );
                rMap.put( "ENAME", rs.getString( 3 ) );
                list.add( rMap );
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        finally {
            db.freeConnection( con, cstmt );
        }
        return list;
    }
    
    // procedure 안에서는 여러가지의 DML문을 한 번 서버에 접속한 상태에서 한 번에 처리 가능하다.
    // commit, rollback이 가능하다.
    // 자바로 꺼내서 처리하지 않고 프로시저 내부에서 비즈니스 로직(업무포함 프로세스) 처리 가능(변수 활용과 제어문사용)
    // procedure 내부에서 자바의 힘을 빌리지 않고도 처리할 수 있는 프로세스들이 있다. - 강점, 시스템부하를 줄일 수도 있다.
    public static void main( String[] args ) {
        EmpList                   el       = new EmpList();
        List<Map<String, Object>> tempList = el.getEmpList();
        System.out.println( tempList );
    }
}
