package lotto;

import java.util.Arrays;

public class NumberCalculation {
    
    public int[] pick( int[] pickNumber ) {
        
        for ( int i = 0; i < pickNumber.length; i++ ) {
            pickNumber[i] = ( int ) ( Math.random() * 45 ) + 1;
            
            for ( int j = 0; j < i; j++ ) {
                
                if ( pickNumber[j] == pickNumber[i] ) {
                    i--;
                }
            }
        }
        Arrays.sort( pickNumber );
        return pickNumber;
    }
    
    public int[] compare( int[] winningNumber, int[] userNumber, int[] result ) {
        int count = -1;
        
        for ( int i = 0; i < winningNumber.length; i++ ) {
            
            for ( int j = 0; j < userNumber.length; j++ ) {
                
                if ( winningNumber[i] == userNumber[j] ) {
                    result[++count] = winningNumber[i];
                }
            }
        }
        
        return result;
    }
    
    public void printArray( int[] array ) {
        
        for ( int i : array ) {
            System.out.print( i + " " );
        }
        System.out.println();
    }
}
