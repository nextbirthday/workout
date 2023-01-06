package OnionTalk;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

public class Oracle {
    
    private static final String     RESOURCE = "connection.properties";
    private static final Properties PROPS    = new Properties();
    private static final String     DRIVER   = "oracle.jdbc.driver.OracleDriver";
    
    private Oracle() {};
    
    private static Connection con;
    
    public static synchronized Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
        
        Reader reader = Resources.getResourceAsReader( RESOURCE );
        PROPS.load( reader );
        final String url      = PROPS.getProperty( "url" );
        final String user     = PROPS.getProperty( "username" );
        final String password = PROPS.getProperty( "password" );
        
        if ( con == null || con.isClosed() ) {
            Class.forName( DRIVER );
            con = DriverManager.getConnection( url, user, password );
        }
        return con;
    }
}
