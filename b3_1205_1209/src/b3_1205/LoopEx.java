package b3_1205;

public class LoopEx {
    
    public static void main( String[] args ) {
        
        /*
         * for ( int i = 1; i <= 3; i++ ) {
         * System.out.println( i );
         * } // end of for
         * 
         * int i = 0; // 초기화식
         * 
         * while ( i <= 3 ) { // 조건식
         * System.out.println( i );
         * ++i;// 증감식
         * //while문 사용시에는 조건식에 사용된 변수에 증감연산자가 있는지 반드시 확인할
         * }
         */
        
        for ( int i = 2; i <= 9; i++ ) {
            System.out.println( i +"단" );
            
            for ( int j = 1; j <= 9; j++ ) {
                System.out.println( i + "*" + j + "=" + i * j + "입니다." );
            }     
        }
       
    }
    
}
