package java_b3_1206;

import java.util.Arrays;

public class LoopArrayFor {
    
    void deptnos() {
        int[] deptnos = { 0, 1, 2 };
        
        for ( int i = 0; i < deptnos.length; i++ ) {
            System.out.println( deptnos );
            System.out.println( deptnos[i] );
        }
        System.out.println( Arrays.toString( deptnos ) );
        
        for ( int i : deptnos ) { // 향상된 for문 배열 안에 타입, 배열 주소번지
            System.out.println( i );
        }
    }
    
    public static void main( String[] args ) {
        LoopArrayFor deptnos = new LoopArrayFor();
        deptnos.deptnos();
        
    }
}
