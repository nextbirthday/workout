package b3_1206;

import java.util.Arrays;

public class ArrayEx {
    // 채번을 3번하는 프로그래밍.
    
    private void getRandomNumber() {
        
        int[] com = new int[3];
        
        for ( int i = 0; i < com.length; i++ ) {
            com[i] = ( int ) ( Math.random() * 10 );
            
            for ( int j = 0; j < i; j++ ) {
                
                if ( com[0] == com[1] || com[1] == com[2] || com[0] == com[2] ) { // 3자리 모두 중복 안되게
                    i--;
                    break;
                }
            }
        }
        System.out.print( Arrays.toString( com ) );
    }
    
    void getRandomNumber2() {
        // 배열이
        int com = ( int ) ( Math.random() * 10 );
        
        int com1 = ( int ) ( Math.random() * 10 );
        
        int com2 = ( int ) ( Math.random() * 10 );
        System.out.println( com + "," + com1 + "," + com2 );
    }
    
    public static void main( String[] args ) {
        ArrayEx arr = new ArrayEx();
        // arr.getRandomNumber();
        
        arr.getRandomNumber2();
    }
    
}
