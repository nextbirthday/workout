package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dto.Member;

public class MybatisConnectionTest {
    
    private static final Logger logger = LogManager.getLogger( "oracle" );
    
    public static void main( String[] args ) {
        String            resource          = "mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory = null;
        
        try {
            InputStream inputStream = Resources.getResourceAsStream( resource );
            sqlSessionFactory = new SqlSessionFactoryBuilder().build( inputStream );
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        
        SqlSession session = sqlSessionFactory.openSession();
        
        // int insertResult = session.insert( "addMember", new Member( "test5", "q1w2e3r4", "010-5555-5555" ) );
        // logger.info( "INSERT RESULT : " + insertResult );
        //
        // if ( insertResult > 0 ) {
        // session.commit();
        // }
        
        List<Member> memberList = session.selectList( "getMemberList" );
        memberList.forEach( e -> logger.info( e.toString() ) );
        
        // Member param = new Member();
        // param.setUser_id( 6 );
        // int updateResult = session.update( "deleteMember", param );
        // logger.info( "UPDATE RESULT : " + updateResult );
        //
        // if ( updateResult > 0 ) {
        // session.commit();
        // }
        //
        // memberList = session.selectList( "getMemberList" );
        // memberList.forEach( e -> logger.info( e.toString() ) );
        
        session.close();
    }
}
