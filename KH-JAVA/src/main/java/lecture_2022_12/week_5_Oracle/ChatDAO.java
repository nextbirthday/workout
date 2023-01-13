package lecture_2022_12.week_5_Oracle;

import java.sql.CallableStatement;
import java.sql.Connection;

// Data Access Object - 클래스 설계에 있어서 DAO 패턴의 사용은 필수가 되었다.
// 특히 MyBatis와 같은 ORM솔루션이 제공되면서 더 강조되었다.
// JDBC API -> MyBatis -> JPA(Hibernate, 쿼리문이 없다. (추상적 - 조인관계는?))
public class ChatDAO {
    Connection        con;
    CallableStatement cstmt;
    DBConnectionMgr   db = new DBConnectionMgr();
    
    public String login( String mem_id, String mem_pw ) {
        String mem_name = null;
        
        try {
            con = db.getConnection();
            cstmt = con.prepareCall( "{call REOL.PROC_LOGIN(?,?,? )}" );
            cstmt.setString( 1, mem_id );
            cstmt.setString( 2, mem_pw );
            cstmt.registerOutParameter( 3, java.sql.Types.VARCHAR );
            cstmt.executeUpdate();
            mem_name = cstmt.getString( 3 );
            System.out.println( mem_name );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        finally {
            db.freeConnection( con, cstmt );
        }
        return mem_name;
    }
    
    public static void main( String[] args ) {
        ChatDAO dao    = new ChatDAO();
        String  r_name = dao.login( "tomato", "123" );
        System.out.println( r_name );
    }
}
