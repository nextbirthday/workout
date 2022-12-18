package temp;

import java.util.Arrays;
import java.util.Random;

public class Gugu {
    public static void main( String[] args ) {
        
            Random rand         = new Random();
            int[]  randomNumber = new int[3];
            
            for ( int i = 0; i < randomNumber.length; i++ ) {
                randomNumber[i] = rand.nextInt( 10 );
                
                for ( int j = 0; j < i; j++ ) { 
                    
                    if ( randomNumber[0] == 0 || randomNumber[i] == randomNumber[j] ) {
                        i--;
                        break;
                    }
                }
            }
            System.out.println( Arrays.toString( randomNumber ) );
            // for ( int i : randomNumber ) {
            // System.out.print( i + " " );
            // }
            // System.out.println();
           
       
    }
}
