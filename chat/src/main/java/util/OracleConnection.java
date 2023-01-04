package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class OracleConnection {
    private static SqlSessionFactory sqlSessionFactory;
    
    public static synchronized SqlSessionFactory getSqlSessionFactory() {
        
        if ( sqlSessionFactory == null ) {
            
            try {
                String      resource    = "mybatis-config.xml";
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
