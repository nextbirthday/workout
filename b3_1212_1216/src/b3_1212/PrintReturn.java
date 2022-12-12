package b3_1212;

public class PrintReturn {
    
    public PrintReturn() {
        // TODO Auto-generated constructor stub
    }
    
    public PrintReturn( String str ) {
        System.out.println( str );
    }
    
    void printGugudan( int dan ) {
        
        if ( !( 2 <= dan && dan <= 9 ) )
            return; // 입력받는 파라미터가 2~9가 아니면, 메서드 종료하고 돌아가기
            
        for ( int i = 1; i < 10; i++ ) {
            // System.out.println( dan + "*" + i + "=" + dan * i );
            System.out.printf( "%d*%d = %d%n", dan, i, dan * i );
        }
        // return;
        // 반환타입이 void일 때만 생략가능하다. 컴파일러가 자동으로 추가
        // 반환타입이 void가 아닌 경우, 반드시 return문이 필요하다.
        // 메서드가 작업을 마쳤을 때 호출한 곳으로 돌아간다.
    }
    
    public static void main( String[] args ) {
     
        PrintReturn gugu = new PrintReturn();
        gugu.printGugudan( 9 );
        
        new PrintReturn( "null" );
        
    }
    
}
