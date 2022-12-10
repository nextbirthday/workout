package b3_1207;

public class Finally01 {
    
    public static void main( String[] args ) {
        int i = 10;
        int j = 2;
        j = 0;
        
        try {
            System.out.println( i / j ); // 5
        }
        catch ( ArithmeticException e ) {
            System.out.println( "error" );
        }
        finally { //연산의 결과가 정상적이라 하더라도 실행이 된다.
            System.out.println( "finally는 무조건 실행이 된다." );
        }
        
    }
    
}
