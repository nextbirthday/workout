package encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MyBatisSqlSessionFactory;

public class EncryptionUtil {
    
    private static SqlSessionFactory sqlSessionFactory;
    
    private Encryption toCiphertext( String plaintext, byte[] salt ) throws NoSuchAlgorithmException {
        // digest : 임의 크기의 메시지를 특정 고정 크기의 블럭으로 만드는 것
        // SHA-256 : 임의 길이의 메시지를 256 bits(=32 Bytes) 크기의 메시지로 변환하는 hash 알고리즘
        MessageDigest messageDigest = MessageDigest.getInstance( "SHA-256" );
        
        byte[] saltedBytes = new byte[plaintext.getBytes().length + salt.length];
        System.arraycopy( salt, 0, saltedBytes, 0, salt.length );
        System.arraycopy( plaintext.getBytes(), 0, saltedBytes, salt.length, plaintext.getBytes().length );
        
        // 평문 비밀번호 + 솔트를 결합한 byte[]를 digest
        messageDigest.update( saltedBytes );
        byte[]       digestBytes = messageDigest.digest();
        StringBuffer strBuffer   = new StringBuffer();
        
        for ( byte b : digestBytes ) {
            /*
             * 0xFF bitwise AND 연산을 하는 이유
             * (16진수 한 자리는 2⁴(4 bits) 0000₂ ~ 1111₂ 범위 표현 가능, 0xFF = 1111 1111₂ = 255)
             * 
             * java에서 int는 4 Bytes, 항상 signed 이다.
             * 예를 들어 -1을 0xFF bitwise AND 하면, int signed 에서는 4 Bytes(=32 bits)
             * 11111111 11111111 11111111 11111111 이 된다.
             * 00000000 00000000 00000000 11111111 과 AND를 하면
             * 00000000 00000000 00000000 11111111 unsigned 255로 변환이 된다.
             * 즉, signed 에서 unsigned 로 변환하는 작업이 & 0xFF 이다.
             * 
             * 그리고 항상 두 자리를 고정으로 출력하기 위해 256(=0x100) 을 더해준다.
             * 00000000 00000000 00000000 00000001 // 1 을 01과 같이 만들기 위하여
             * 00000000 00000001 00000000 00000000 // 256 을 더한다.
             * 00000000 00000001 00000000 00000001 // 결과적으로 첫번째는 1 고정인 세 자리 16진수가 되는데,
             * .substring( 1 ) 메서드로 첫번째자리 1을 잘라주면 나머지 두 자리만 남게 되어 원하는 결과를 얻을 수 있다.
             * String.format( "%02x", b ) 도 동일한 결과를 얻을 수 있지만 비교적 느리다.
             */
            strBuffer.append( Integer.toString( ( b & 0xFF ) + 256, 16 ).substring( 1 ) );
        }
        StringBuffer saltBuffer = new StringBuffer();
        
        for ( byte b : salt ) {
            saltBuffer.append( Integer.toString( ( b & 0xFF ) + 256, 16 ).substring( 1 ) );
        }
        return new Encryption( saltBuffer.toString(), strBuffer.toString() );
    }
    
    private byte[] generateSalt() {
        byte[] salt = new byte[8];
        new SecureRandom().nextBytes( salt );
        
        System.out.print( "16진수 표기 솔트 : " );
        
        for ( byte b : salt ) {
            System.out.print( Integer.toString( ( b & 0xFF ) + 256, 16 ).substring( 1 ) );
        }
        System.out.print( ", 길이 : " + salt.length + " Bytes\n" );
        return salt;
    }
    
    public static void main( String[] args ) {
        EncryptionUtil util = new EncryptionUtil();
        sqlSessionFactory = MyBatisSqlSessionFactory.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        int index = 0;
        
        if ( args.length == 1 ) {
            
            do {
                
                try {
                    System.out.println( "입력한 비밀번호 : " + args[0] );
                    Encryption encryption = util.toCiphertext( args[0], util.generateSalt() );
                    sqlSession.insert( "insertPassword", encryption );
                    
                    System.out.println( "암호화된 비밀번호 : " + encryption.getPassword() + ", 길이 : "
                                    + ( encryption.getPassword().length() / 2 ) + " Bytes" );
                }
                catch ( NoSuchAlgorithmException e ) {
                    e.printStackTrace();
                }
                System.out.println();
            } while ( ++index < 10 );
            // 트랜잭션 반영 여부
            // sqlSession.commit();
            sqlSession.close();
        }
    }
}
