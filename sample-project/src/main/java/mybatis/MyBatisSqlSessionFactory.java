package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSessionFactory {
    
    private static SqlSessionFactory sqlSessionFactory;
    
    private MyBatisSqlSessionFactory() {}
    
    public static synchronized SqlSessionFactory getInstance() {
        
        if ( sqlSessionFactory == null ) {
            
            try {
                String      resource    = "mysql-mybatis-config.xml";
                InputStream inputStream = Resources.getResourceAsStream( resource );
                sqlSessionFactory = new SqlSessionFactoryBuilder().build( inputStream );
            }
            catch ( IOException e ) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }
}
