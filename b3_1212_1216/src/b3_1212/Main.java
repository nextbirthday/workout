package b3_1212;

public class Main {
    
    int       i    = 1;
    boolean[] isOk = null;
    
    public Main() {
        System.out.println( "Main defalut constructor call" );
        getIsOk();
        // 디폴트 생성자는 생략이 가능하다. 그러나 지금은 isOk배열의 생성을 위해서
        // getIsOk()을 경유하도록 해야지 NullPointerException을 피할 수 있다.
    }
    
    // 선언과 동시에 인스턴스화를 하지 않는 경우를 게으른 인스턴스화라고 한다.
    boolean[] getIsOk() {
        
        if ( isOk == null ) {
            isOk = new boolean[] { true, false, true };
        } // for null check, 실전적인 코드
        
        return isOk;
    }
    
    public static void main( String[] args ) {
        
        Sub sub = new Sub();
        System.out.println( sub.j );
        // 전역변수만이 인스턴스변수.변수명으로 호출 가능하다.
        
    }
    
}
