package java_b3_1206;

import java.util.Arrays;

public class ArrayEx {
    // 채번을 3번하는 프로그래밍.
    
    private void getRandomNumber() {
        
        int[] com = new int[3];
        
        for ( int i = 0; i < com.length; i++ ) {
            com[i] = ( int ) ( Math.random() * 10 );
        }
        System.out.print( Arrays.toString( com ) );
    }
    
    void getRandomNumber2() {
        
        int com = ( int ) ( Math.random() * 10 );
        System.out.println( com );
        
        com = ( int ) ( Math.random() );
        System.out.println( com );
        
        
        double com2 =  Math.random() * 10;
        System.out.println( com + "," + com2 );
    }
    
    public static void main( String[] args ) {
        ArrayEx arr = new ArrayEx();
        // arr.getRandomNumber();
        
        arr.getRandomNumber2();
    }
    
}
