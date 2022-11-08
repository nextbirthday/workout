package baseball;

import java.util.Random;
import java.util.Scanner;

public class BaseballGameLogic {
    private static final int MAX         = 3;
    private int              strikeCount = 0;
    private int              ballCount   = 0;
    private int              tryCount    = 0;
    Scanner                  scan        = new Scanner( System.in );
    
    private int[] getRandomNumber() {
        Random rand         = new Random();
        int[]  randomNumber = new int[MAX];
        
        for ( int i = 0; i < randomNumber.length; i++ ) {
            randomNumber[i] = rand.nextInt( 10 );
            
            for ( int j = 0; j < i; j++ ) {
                if ( randomNumber[0] == 0 || randomNumber[i] == randomNumber[j] )
                    i--;
            }
        }
        
        for ( int i : randomNumber ) {
            System.out.print( i + " " );
        }
        System.out.println();
        return randomNumber;
    }
    
    private int[] getUserNumber() {
        int[] userNumber = new int[MAX];
        System.out.print( "중복되는 자릿수가 없는 세 자리 정수를 입력하세요 : " );
        int temp = scan.nextInt();
        
        for ( int i = userNumber.length - 1; i >= 0; i-- ) {
            userNumber[i] = temp % 10;
            temp /= 10;
        }
        return userNumber;
    }
    
    private void compare( int[] randomNumber, int[] userNumber ) {
        tryCount++;
        
        for ( int i = 0; i < randomNumber.length; i++ ) {
            
            for ( int j = 0; j < userNumber.length; j++ ) {
                
                if ( randomNumber[i] == userNumber[j] ) {
                    if ( i == j )
                        strikeCount++;
                    else
                        ballCount++;
                }
            }
        }
    }
    
    public void playGame() {
        boolean isExit       = false;
        int[]   randomNumber = getRandomNumber();
        int[]   userNumber   = getUserNumber();
        
        while ( !isExit ) {
            compare( randomNumber, userNumber );
            
            if ( strikeCount == 3 ) {
                System.out.println( "CONGRATULATIONS! TRY COUNT : " + tryCount );
                System.out.print( "\n재도전 하려면 y를 입력하세요. " );
                String choice = scan.next();
                
                if ( "y".equals( choice ) ) {
                    randomNumber = getRandomNumber();
                    userNumber = getUserNumber();
                    tryCount = 0;
                }
                else {
                    System.out.println( "게임 종료" );
                    scan.close();
                    isExit = true;
                }
            }
            else {
                System.out.println( strikeCount + " STRIKE, " + ballCount + " BALL" );
                userNumber = getUserNumber();
            }
            strikeCount = 0;
            ballCount = 0;
        }
    }
}
