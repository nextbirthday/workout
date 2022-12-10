package b3_1207;

public class IfTest {
    
    void testIf(int x) {
        
        if ( x > 50 ) {// 조건식1이 true일 경우 실행
            System.out.println( "조건식 1 if 문 true" );
            
            if ( x > 2000 ) {// 조건식 1이 true이고 조건식2가 true일 경우 실행
                System.out.println( "조건식2 if 문 true" );
            }
            else {// 조건식 1이 true이고 조건식2가 false일 경우 실행
                System.out.println( "조건식 1이 true이고 조건식 2가 false일 경우" );
            }
        }
        else {// 조건식 1이 거짓 일 경우 실행
            System.out.println( "조건식 1 false" );
        }
    }
    
    public static void main( String[] args ) {
        IfTest test = new IfTest();
        //test.testIf(60);
    }
    
}
