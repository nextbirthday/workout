package basic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Customer;
import util.MyBatisSqlSessionFactory;

public class CustomerDAO {
    
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession        session;
    
    protected List<Customer> getCustomerPaymentList( Customer customer ) {
        String resource = "/mybatis-config.xml";
        sqlSessionFactory = MyBatisSqlSessionFactory.getInstance( resource );
        session = sqlSessionFactory.openSession();
        
        List<Customer> customerList = session.selectList( "mybatis.sakila.getCustomerPaymentList", customer );
        
        session.close();
        
        return customerList;
    }
}
