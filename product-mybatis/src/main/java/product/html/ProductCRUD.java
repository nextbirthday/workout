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
    
    public int updateProduct( Product productVO ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.update( "updateProduct", productVO );
        
        log.info( result );
        return result;
    }
    
    public static void main( String[] args ) {
        ProductCRUD c = new ProductCRUD();
        // ProductVO productVO = new ProductVO( 20, "과자", "감자깡", 1200, 500 );
        // int result = c.insertProduct( productVO );
        Product productVO = new Product();
        productVO.setProductcode( 10 );
        productVO.setAvailability( 500 );
        // c.selectProduct();
        // c.selectOne( productVO );
        
        c.updateProduct( productVO );
        
    }
    
}
