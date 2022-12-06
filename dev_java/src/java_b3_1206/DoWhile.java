package java_b3_1206;

public class DoWhile {
    
    public static void main( String[] args ) {
        int i = 1;
        
        while ( i > 3 ) // 1>3 false, 조건을 만족하지 않으면 즉,false 이면 실행하지 않는다.
        {
            System.out.println( "while 실행문 출력" );
        }
        System.out.println( "while 실행문 출력되지 않음" );
        
        i = 1;        
        // 초기화가 필요한지 판단
        // i 값을 1로 초기화한 것은 동일한 조건에서 test하기 위함임
        
        do { // 조건을 나중에 따진다. - 무조건 한 번은 실행됨
            System.out.println( "do-while 실행문 출력됨" );
            
        } while ( i > 3 );
    }
}
