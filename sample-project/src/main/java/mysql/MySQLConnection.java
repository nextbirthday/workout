package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

public class MySQLConnection {
    
    private static final Logger logger = LogManager.getLogger( "mysql" );
    
    public void closeConnection( Connection con ) {
        
        try {
            
            if ( con != null && con.isClosed() ) {
                con.close();
            }
        }
        catch ( SQLException e ) {
            logger.error( "SQLException", e );
        }
    }
    
    public void closeStatement( Statement stmt ) {
        
        try {
            
            if ( stmt != null && stmt.isClosed() ) {
                stmt.close();
            }
        }
        catch ( SQLException e ) {
            logger.error( "SQLException", e );
        }
    }
    
    public void closeResultSet( ResultSet rs ) {
        
        try {
            
            if ( rs != null && rs.isClosed() ) {
                rs.close();
            }
        }
        catch ( SQLException e ) {
            logger.error( "SQLException", e );
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
        Gson            gson         = new Gson();
        
        if ( args.length == 2 ) {
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
            sql.append( "SELECT c.customer_id                       " );
            sql.append( "     , store_id                            " );
            sql.append( "     , first_name                          " );
            sql.append( "     , last_name                           " );
            sql.append( "     , email                               " );
            sql.append( "     , address_id                          " );
            sql.append( "     , active                              " );
            sql.append( "     , create_date                         " );
            sql.append( "     , payment_id                          " );
            sql.append( "     , staff_id                            " );
            sql.append( "     , rental_id                           " );
            sql.append( "     , amount                              " );
            sql.append( "     , payment_date                        " );
            sql.append( "     , p.last_update                       " );
            sql.append( "  FROM sakila.customer c                   " );
            sql.append( "           INNER JOIN payment p            " );
            sql.append( "           ON c.customer_id = p.customer_id" );
            sql.append( " WHERE c.customer_id BETWEEN 1 AND 50      " );
            
            con = DriverManager.getConnection( url, user, password );
            stmt = con.createStatement();
            rs = stmt.executeQuery( sql.toString() );
            
            while ( rs.next() ) {
                customer = new Customer( new Payment() );
                customer.setCustomer_id( rs.getInt( "customer_id" ) );
                customer.setStore_id( rs.getInt( "store_id" ) );
                customer.setFirst_name( rs.getString( "first_name" ) );
                customer.setLast_name( rs.getString( "last_name" ) );
                customer.setEmail( rs.getString( "email" ) );
                customer.setAddress_id( rs.getInt( "address_id" ) );
                customer.setActive( rs.getInt( "active" ) );
                customer.setCreate_date( rs.getString( "create_date" ) );
                customer.getPayment().setCustomer_id( rs.getInt( "customer_id" ) );
                customer.getPayment().setPayment_id( rs.getInt( "payment_id" ) );
                customer.getPayment().setStaff_id( rs.getInt( "staff_id" ) );
                customer.getPayment().setRental_id( rs.getInt( "rental_id" ) );
                customer.getPayment().setAmount( rs.getDouble( "amount" ) );
                customer.getPayment().setPayment_date( rs.getString( "payment_date" ) );
                customer.getPayment().setLast_update( rs.getString( "last_update" ) );
                customerList.add( customer );
            }
        }
        catch ( Exception e ) {
            logger.error( "Exception", e );
        }
        finally {
            mysql.closeResultSet( rs );
            mysql.closeStatement( stmt );
            mysql.closeConnection( con );
        }
        
        for ( Customer record : customerList ) {
            logger.debug( gson.toJson( record ) );
        }
    }
}
