package basic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChildClass extends ParentClass {
    
    private static final Logger logger = LogManager.getLogger( "logger" );
    
    @Override
    protected void parentMethod() {
        // 오버라이딩은 부모 클래스에서 선언된 메서드의 '이름'과 '파라미터 개수'는 유지하고,
        // body(중괄호 = {} 안) 부분을 자식 클래스에서 재정의하여 사용하는 것
        logger.info( "자식 클래스에서 오버라이딩한 메서드" );
    }
    
    private void methodOverloading() {
        logger.info( "파라미터 없는 methodOverloading 메서드" );
    }
    
    // private String methodOverloading() {
    // logger.info( "파라미터 없는 methodOverloading 메서드" );
    // return "문자열 리턴하는 메서드";
    // }
    
    private void methodOverloading( String str ) {
        logger.info( "파라미터 1개 methodOverloading 메서드 str : {}", str );
    }
    
    private void methodOverloading( String str, int i ) {
        logger.info( "파라미터 2개 methodOverloading 메서드 str : {}, i : {}", str, i );
    }
    
    public static void main( String[] args ) {
        ChildClass c = new ChildClass();
        c.parentMethod();
        
        // methodOverloading() 메서드는 셋 다 메서드 이름이 같지만, 파라미터 개수로 구분할 수 있다
        // 메서드의 리턴 타입은 오버로딩에 영향을 주지 않는다.
        // 예를 들어, 동일한 이름과 파라미터 개수를 가진 두 메서드가 리턴타입만 다를 경우 에러 발생
        // Duplicate method methodOverloading() in type ChildClass
        c.methodOverloading();
        c.methodOverloading( "문자열" );
        c.methodOverloading( "응애", 10 );
    }
}
