package product.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyBatisSessionFactory {
    
    // MyBatis에 틀이 있다.
    private static SqlSessionFactory sqlSessionFactory;
    
    private MyBatisSessionFactory() {}
    
    public static synchronized SqlSessionFactory getInstance() {
        
        if ( sqlSessionFactory == null ) {
            
            try {
                final String resource    = "mybatis-config.xml";
                InputStream  inputStream = Resources.getResourceAsStream( resource );
                sqlSessionFactory = new SqlSessionFactoryBuilder().build( inputStream );
            }
            catch ( IOException e ) {
                log.error( "데이터베이스 연결 실패 : " + e.getMessage() );
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }
    
}
