package mybatis;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import mysql.Customer;

public class Controller {
    
    // Logic은 생략한다.
    private CustomerDAO         dao;
    private static final Logger logger = LogManager.getLogger( "mybatis.sakila" );
    
    public List<Customer> getCustomerPaymentList() {
        // Spring 연동이 아니므로 setter 없이 직접 Instantiation
        dao = new CustomerDAO();
        Customer customer = new Customer();
        customer.setCustomer_id( 130 );
        List<Customer> customerList = dao.getCustomerList( customer );
        
        return customerList;
    }
    
    public void printToJson( List<Customer> customerList ) {
        Gson gson = new Gson();
        
        for ( Customer i : customerList ) {
            logger.info( gson.toJson( i ) );
        }
    }
}
