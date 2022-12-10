package updown;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class UpDownLogic {
    
    private static final int MAX      = 30;
    private int              tryCount = 0;
    private Scanner          scan;
    
    private int getRandomNumber() {
        Random rand = new Random();
        
        return rand.nextInt( MAX );
    }
    
    private int getUserNumber() {
        int     userNumber = 0;
        boolean isBreak    = false;
        
        while ( !isBreak ) {
            System.out.print( "0 이상 " + ( MAX - 1 ) + " 이하 범위의 정수를 입력하세요 : " );
            
            try {
                userNumber = scan.nextInt();
                if ( userNumber < 0 || userNumber >= MAX )
                    System.out.println( "숫자 입력 범위를 벗어났습니다." );
                else
                    isBreak = true;
            }
            catch ( InputMismatchException ime ) {
                System.out.println( ime.toString() + " : 정수만 입력할 수 있습니다." );
                scan.nextLine();
            }
        }
        return userNumber;
    }
    
    private int compare( int randNumber, int userNumber ) {
        tryCount++;
        int result = 1;
        
        if ( randNumber == userNumber ) {
            System.out.println( "정답입니다. 도전 횟수 : " + tryCount );
            result = 0;
        }
        else if ( randNumber > userNumber )
            System.out.println( "UP" );
        else
            System.out.println( "DOWN" );
        
        return result;
    }
    
    public void play() {
        scan = new Scanner( System.in );
        int     randomNubmer = getRandomNumber();
        int     userNumber   = getUserNumber();
        int     result;
        boolean isBreak      = false;
        
        while ( !isBreak ) {
            result = compare( randomNubmer, userNumber );
            
            if ( result == 0 ) {
                isBreak = true;
                scan.close();
            }
            else
                userNumber = getUserNumber();
        }
    }
}
