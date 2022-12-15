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
        // test.getRandomNumber();
        // test.gradePrint( 0, 0, 5.0 );
        // test.randomNumberPrint();
        // test.getRandomNumberCount();
    }
    
    void gradePrint( int total, double avg, double subjectCount ) {
        
        int[] score = new int[5];
        
        Scanner scanner = new Scanner( System.in );
        
        for ( int i = 0; i < 5; i++ ) {
            System.out.println( "점수를 입력해주세요 : " );
            score[i] = scanner.nextInt();
            total += score[i];
        }
        avg = total / subjectCount;
        System.out.println( "총점은 : " + total + "입니다.\n" + "평균은 : " + avg + "입니다." );
        scanner.close();
    }
    
    void randomNumberPrint() {
        int[] getRandomNumber = new int[10];
        int   positiveSum     = 0;
        int   negativeSum     = 0;
        int   zeroCount       = 0;
        
        for ( int i = 0; i < getRandomNumber.length; i++ ) {
            int j = ( int ) ( Math.random() * 21 ) - 10;
            getRandomNumber[i] = j;
            System.out.print( getRandomNumber[i] );
            System.out.println();
            
            if ( getRandomNumber[i] > 0 ) {
                positiveSum += getRandomNumber[i];
            }
            else if ( j < 0 ) {
                negativeSum += getRandomNumber[i];
            }
            else if ( j == 0 ) {
                zeroCount++;
            }
        }
        System.out.println( "0이 출력된 횟수는 " + zeroCount + "번 입니다." );
        System.out.println( "양수의 합은 : " + positiveSum + "입니다." );
        System.out.println( "음수의 합은 : " + negativeSum + "입니다." );
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
