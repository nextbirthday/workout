package b3_1207;

import java.util.Arrays;

public class ArrayTry02 {
    
    int[] i = new int[3]; // 이른 인스턴스화
    int[] j = new int[] { 1, 2, 3 };
    int[] x = { 1, 2, 3 };
    
    public static void main( String[] args ) {
        
        ArrayTry02 a2 = new ArrayTry02();
        System.out.println( a2.x.toString() );
        System.out.println( Arrays.toString( a2.i ) );
        System.out.println( Arrays.toString( a2.j ) );
        System.out.println( Arrays.toString( a2.x ) );
        
        for ( int a = 0; a < a2.j.length; a++ ) {
            System.out.println( a2.j[a] );
        }
        
        for ( int y : a2.x ) { // 향상된 for문
            System.out.println( y );
        }
        
    }// end of main
}