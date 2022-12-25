package lecture_2022_12.week_4_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public static void main( String[] args ) {
        // 연결 담당
        Connection connection = null;
        // 연결한 정보로 쿼리 실행결정
        Statement statement = null;
        // SELECT 결과 (가지고 온 결과 = record 수)
        ResultSet resultSet = null;
        
        try {
            //
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            String url      = "jdbc:mysql://rmsen.iptime.org:33069/test";
            String user     = "geundu";
            String password = "q1w2e3r4";
            connection = DriverManager.getConnection( url, user, password );
            statement = connection.createStatement();
            String sql = "SELECT * FROM test.dept";
            resultSet = statement.executeQuery( sql ); // SELECT
            // statement.executeUpdate( sql ); // INSERT, UPDATE, DELETE
            
            while ( resultSet.next() ) {
                System.out.println( resultSet.getInt( "deptno" ) + resultSet.getString( "dname" ) + resultSet.getString( "loc" ) );
            }
            
        }
        catch ( ClassNotFoundException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch ( SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
