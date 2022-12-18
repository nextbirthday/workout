package inheritance;

import java.util.LinkedList;
import java.util.List;

public class Child extends Parent {
    
    private int childVar;
    
    @Override
    protected void parentMethod() {
        System.out.println( "Override parentMethod" );
    }
    
    private void childMethod() {
        System.out.println( "childMethod" );
    }
    
    public static void main( String[] args ) {
        /*
         * 인스턴스는 Child 타입이지만 부모 타입 변수에 주소를 저장한다.
         * 타입이 Parent이기 때문에 Child에서 선언한 childVar, childMethod() 를 사용할 수 없다.
         * Child 타입의 멤버를 사용하려면 다운캐스팅을 해주면 된다.
         */
        Parent       p        = new Child();
        List<String> tempList = new LinkedList<>();
        
        System.out.println( p + ", parentVar : " + p.parentVar );
        // 아래 두 라인은 에러 발생
        // p.childVar;
        // p.childMethod();
        
        Child c = ( Child ) p;
        // 변수의 타입이 바뀌는 거지 주소가 바뀌는 것이 아니므로 주솟값은 동일하다.
        System.out.println( c + ", childVar : " + c.childVar );
        
        // 메서드는 오버라이드 된 메서드가 호출된다.
        p.parentMethod();
        c.childMethod();
    }
}
