package dept;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

public class DataBaseConnection {
    
    private static final String RESOURCE = "geundu.properties";
    
    public Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
        Properties props  = new Properties();
        Reader     reader = Resources.getResourceAsReader( RESOURCE );
        props.load( reader );
        Class.forName( props.getProperty( "driver" ) );
        final String url      = props.getProperty( "url" );
        final String user     = props.getProperty( "username" );
        final String password = props.getProperty( "password" );
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
