package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
    
    public Connection getConnection( String user, String password ) throws ClassNotFoundException, SQLException {
        Class.forName( "com.mysql.cj.jdbc.Driver" );
        String url = "jdbc:mysql://localhost/test";
        return DriverManager.getConnection( url, user, password );
    }
    
    public void closeConnection( Connection con ) throws SQLException {
        
        if ( con != null && !con.isClosed() ) {
            con.close();
        }
    }
    
    public Statement getStatement( Connection con ) throws SQLException {
        return con.createStatement();
    }
    
    public void closeStatement( Statement stmt ) throws SQLException {
        
        if ( stmt != null && !stmt.isClosed() ) {
            stmt.close();
        }
    }
    
    public ResultSet getResultSet( Statement stmt, String sql ) throws SQLException {
        return stmt.executeQuery( sql );
    }
    
    public void closeResultSet( ResultSet rs ) throws SQLException {
        
        if ( rs != null && !rs.isClosed() ) {
            rs.close();
        }
    }
}
