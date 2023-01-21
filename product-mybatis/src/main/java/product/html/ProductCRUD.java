package product.html;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import lombok.extern.log4j.Log4j2;
import product.util.MyBatisSessionFactory;
import product.vo.ProductVO;

@Log4j2( topic = "product" )
public class ProductCRUD {
    SqlSessionFactory sqlSessionFactory;
    SqlSession        sqlSession;
    
    public int insertProduct( ProductVO productVO ) {
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.insert( "insertProduct", productVO );
        if ( result > 0 )
            sqlSession.commit();
        return result;
    }
    
    public List<ProductVO> selectProduct() {
        
        List<ProductVO> productList = new ArrayList<>();
        
        sqlSessionFactory = MyBatisSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();
        productList = sqlSession.selectList( "selectProductList" );
        productList.forEach( e -> log.info( e ) );
        
        return productList;
    }
    
    public static void main( String[] args ) {
        ProductCRUD c = new ProductCRUD();
        // ProductVO productVO = new ProductVO( 20, "과자", "감자깡", 1200, 500 );
        // int result = c.insertProduct( productVO );
        
        c.selectProduct();
    }
    
}
