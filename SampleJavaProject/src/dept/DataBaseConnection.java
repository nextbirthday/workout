package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName( "com.mysql.cj.jdbc.Driver" );
        String url      = "jdbc:mysql://rmsen.iptime.org:33069/test";
        String user     = "geundu";
        String password = "q1w2e3r4";
        return DriverManager.getConnection( url, user, password );
    }
    
    public void closeConnection( Connection con ) throws SQLException {
        
        if ( con != null && !con.isClosed() ) {
            con.close();
        }
    }
    
    public void closeStatement( Statement stmt ) throws SQLException {
        
        if ( stmt != null && !stmt.isClosed() ) {
            stmt.close();
        }
    }
    
    public void closeResultSet( ResultSet rs ) throws SQLException {
        
        if ( rs != null && !rs.isClosed() ) {
            rs.close();
        }
    }
}
