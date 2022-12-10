package java_b3_1202;

public class Static1 {
    static {
        System.out.println( "static 블럭 호출" );
    }
    
    // main thread
    // main은 entry point이다.
    // main은 개발자가 호출하는 메서드가 아니다.
    // 시스템이 자동으로 호출해준다. - Callback method
    // main메서드에 코딩하는 것은 좋지 않다. - 초보다.
    // main메서드에 작성한 코드는 재사용성이 없다.
    // 클래스 안에 메인메서드는 없어도 된다. but. 실행은 불가하다.
    
    public static void main( String[] args ) {
        System.out.println( "main 호출" );
    }
}
