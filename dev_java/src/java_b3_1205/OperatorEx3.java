package java_b3_1205;

public class OperatorEx3 {
    
    public static void main( String[] args ) {
        
        int i = 1;
        int j = 2;        
        
         /*if ( ( i == --j ) && ( ++i <= j ) ) {
         // i = 1 j =1 -> 2 <= 1
         System.out.println( "조건을 만족했을 때" );
         }
         else {
         System.out.println( "조건을 만족하지 않았을 때" );
         }
         // insert here -> i는 얼마? j는 얼마일까요?
         System.out.println( i + " , " + j );*/
         
        
        /*
         * if ( ( i != --j ) & ( ++i <= j ) ) { //&연산자가 하나일 때는 앞의 조건식이 false여도 뒤의 조건식을 따진다
         * System.out.println( "조건을 만족했을 때" );
         * }
         * else {
         * System.out.println( "조건을 만족하지 않았을 때" );
         * }
         * System.out.println( i + " , " + j );
         */
        
        if ( ( i != j-- ) && ( i++ <= j ) ) { // or 연산자일 때는 하나만 true여도 true
            //false 를 true로 반환 why? != 연산자 때문에 
            System.out.println( "조건을 만족했을 때" );
        }
        else {
            System.out.println( "조건을 만족하지 않았을 때" );
        }
        System.out.println( i + " , " + j );
    }
}
