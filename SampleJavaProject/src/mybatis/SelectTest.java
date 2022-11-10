package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mysql.Customer;
import mysql.Payment;

public class SelectTest {
    
    private static final Logger logger = LogManager.getLogger( "mybatis.sakila" );
    
    public static void main( String[] args ) {
        SqlSessionFactory sqlSessionFactory = MyBatisSqlSessionFactory.getInstance();
        SqlSession        session           = sqlSessionFactory.openSession();
        List<Customer>    customerList      = session.selectList( "mybatis.sakila.getCustomer", 148 );
        
        for ( Customer i : customerList ) {
            logger.info( i );
            
            for ( Payment j : i.getPayments() ) {
                logger.info( j );
            }
        }
        
        session.close();
    }
}
