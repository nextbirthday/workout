package instance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Instance {
    
    private static final Logger logger = LogManager.getLogger( "logger" );
    
    /**
     * 파라미터를 받지만 메서드 내에서 새 인스턴스(new)를 생성, p에 대입하여 주소가 바뀐다.
     * 즉, 기존에 파라미터로 받은 인스턴스와는 별개의 인스턴스이므로 다른 주솟값을 가진다.
     * 그래서 test1 메서드 내부에서 p.value 에 다른 값을 대입해도, 다른 인스턴스이기 때문에 기존 파라미터로 받은
     * 인스턴스의 value에는 영향이 가지 않는다.
     * 
     * @param p ParameterClass 타입 변수
     */
    public void newAddress( ParameterClass p ) {
        p = new ParameterClass();
        p.value = 30;
        logger.info( "newAddress() p의 주솟값 → {}, value = {}", p, p.value );
    }
    
    /**
     * test1 메서드와 다르게 <b>p = new ParameterClass();</b> 부분이 없어 파라미터로 받은 기존 인스턴스의 주솟값과 동일하다.
     * 그래서 test2 메서드 내부에서 p.value 에 다른 값을 대입할 경우 원본(파라미터로 받은 p)의 값도 같이 변경된다.
     * 
     * @param p ParameterClass 타입 변수
     */
    public void existingAddress( ParameterClass p ) {
        p.value = 30;
        logger.debug( "existingAddress() abc의 주솟값 → {}, value = {}", p, p.value );
    }
    
    public static void main( String[] args ) {
        Instance       it = new Instance();
        ParameterClass p  = new ParameterClass();
        
        p.value = 10;
        logger.info( "처음 생성된 인스턴스 p 주솟값 → {}", p );
        
        it.newAddress( p );
        logger.info( "main() p의 주솟값 → {}, value = {}", p, p.value );
        
        it.existingAddress( p );
        logger.debug( "main() p의 주솟값  → {}, value = {}", p, p.value );
    }
}
