package b3_1215;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz {
    
    int[] getRandomNumber = new int[100];
    
    int[] getRandomNumber() {
        
        for ( int i = 0; i < getRandomNumber.length; i++ ) {
            getRandomNumber[i] = ( int ) ( Math.random() * 10 );
        }
        return getRandomNumber;
    }
    
    void randomNumberPrint( int[] randomNumber ) {
        
        for ( int i = 0; i < 10; i++ ) {
            int k = 0;
            k = i * 10;
            
            for ( int j = k; j <= k + 9; j++ ) {
                System.out.print( randomNumber[j] );
                
            }
            System.out.println( "" );
        }
    }
    
    public static void main( String[] args ) {
        Quiz  test         = new Quiz();
        int[] randomNumber = test.getRandomNumber();
        test.randomNumberPrint( randomNumber );
       
        // test.randomNumberPrint();
        // test.getRandomNumberCount();
    }
    
       
    
    
    void getRandomNumberCount() {
        int[] getRandomNumber = new int[100];
        int[] zeroToNine      = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] count           = new int[10];
        
        for ( int i = 0; i < getRandomNumber.length; i++ ) {
            getRandomNumber[i] = ( int ) ( Math.random() * 10 );
            
            if ( ( i + 1 ) % 10 == 0 ) {
                System.out.println( getRandomNumber[i] );
            }
            else {
                System.out.print( getRandomNumber[i] + " " );
            }
            
            if ( getRandomNumber[i] == 0 ) {
                count[0]++;
            }
            else if ( getRandomNumber[i] == 1 ) {
                count[1]++;
            }
            else if ( getRandomNumber[i] == 2 ) {
                count[2]++;
            }
            else if ( getRandomNumber[i] == 3 ) {
                count[3]++;
            }
            else if ( getRandomNumber[i] == 4 ) {
                count[4]++;
            }
            else if ( getRandomNumber[i] == 5 ) {
                count[5]++;
            }
            else if ( getRandomNumber[i] == 6 ) {
                count[6]++;
            }
            else if ( getRandomNumber[i] == 7 ) {
                count[7]++;
            }
            else if ( getRandomNumber[i] == 8 ) {
                count[8]++;
            }
            else if ( getRandomNumber[i] == 9 ) {
                count[9]++;
            }
        }
        System.out.println( Arrays.toString( zeroToNine ) );
        System.out.println( Arrays.toString( count ) );
    }
    
}
