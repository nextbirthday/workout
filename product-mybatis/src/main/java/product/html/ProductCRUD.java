package product.html;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import lombok.extern.log4j.Log4j2;
import product.util.MyBatisSessionFactory;
import product.vo.Product;

@Log4j2( topic = "product" )
public class ProductCRUD {
    SqlSessionFactory sqlSessionFactory;
    SqlSession        sqlSession;
    
    public int insertProduct( Product productVO ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert( "insertProduct", productVO );
        
        /* sqlSession.commit();이 존재하지 않으면 Oracle상에서 commit이 되지 않는다. */
        if ( result > 0 )
            sqlSession.commit();
        
        return result;
    }
    
    public List<Product> selectProduct() {
        
        List<Product> productList = new ArrayList<>();
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        productList = sqlSession.selectList( "selectProductList" );
        productList.forEach( e -> log.info( e ) );
        
        return productList;
    }
    
    public Product selectOne( Product productdoce ) {
        // List<ProductVO> productList = new ArrayList<>();
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        Product product = sqlSession.selectOne( "selectProduct", productdoce );
        
        log.info( product );
        return product;
    }
    
    public int updateProduct( Product product ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.update( "updateProduct", product );
        
        if ( result > 0 )
            sqlSession.commit();
        
        log.info( result );
        return result;
    }
    
    public static void main( String[] args ) {
        ProductCRUD c = new ProductCRUD();
        // Product product = new Product( 40, "과자", "포테토칩", 1800, 100 );
        // int result = c.insertProduct( product );
        // log.info( result );
        Product product = new Product();
        product.setProductcode( 10 );
        product.setPrice( 1500 );
        product.setAvailability( 500 );
        // c.selectOne( productVO );
        log.info( product );
        c.updateProduct( product );
        c.selectProduct();
    }
    
}
