package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLConnection {
    
    public void closeConnection( Connection con ) {
        
        try {
            
            if ( con != null && con.isClosed() ) {
                con.close();
            }
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
    }
    
    public void closeStatement( Statement stmt ) {
        
        try {
            
            if ( stmt != null && stmt.isClosed() ) {
                stmt.close();
            }
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
    }
    
    public void closeResultSet( ResultSet rs ) {
        
        try {
            
            if ( rs != null && rs.isClosed() ) {
                rs.close();
            }
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
    }
    
    public static void main( String[] args ) {
        MySQLConnection mysql        = new MySQLConnection();
        Connection      con          = null;
        Statement       stmt         = null;
        ResultSet       rs           = null;
        String          user         = null;
        String          password     = null;
        List<Customer>  customerList = new ArrayList<>();
        Customer        customer     = null;
        
        if ( args.length > 0 ) {
            user = args[0];
            password = args[1];
        }
        else {
            System.out.println( "Usage: java MySQLConnection <user> <password>" );
            System.exit( 1 );
        }
        
        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            String        url = "jdbc:mysql://localhost/sakila";
            StringBuilder sql = new StringBuilder();
            sql.append( "SELECT *          " );
            sql.append( "  FROM sakila.customer" );
            con = DriverManager.getConnection( url, user, password );
            stmt = con.createStatement();
            rs = stmt.executeQuery( sql.toString() );
            
            while ( rs.next() ) {
                customer = new Customer();
                customer.setCustomer_id( rs.getInt( "customer_id" ) );
                customer.setStore_id( rs.getInt( "store_id" ) );
                customer.setFirst_name( rs.getString( "first_name" ) );
                customer.setLast_name( rs.getString( "last_name" ) );
                customer.setEmail( rs.getString( "email" ) );
                customer.setAddress_id( rs.getInt( "address_id" ) );
                customer.setActive( rs.getInt( "active" ) );
                customer.setCreate_date( rs.getString( "create_date" ) );
                customer.setLast_update( rs.getString( "last_update" ) );
                customerList.add( customer );
            }
        }
        catch ( ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
        }
        finally {
            mysql.closeResultSet( rs );
            mysql.closeStatement( stmt );
            mysql.closeConnection( con );
        }
        
        for ( Customer record : customerList ) {
            System.out.println( record.toString() );
        }
    }
}
