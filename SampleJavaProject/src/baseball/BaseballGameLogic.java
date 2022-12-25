package baseball;

import java.util.Random;
import java.util.Scanner;

public class BaseballGameLogic {
    private static final int MAX         = 3;
    private int              strikeCount = 0;
    private int              ballCount   = 0;
    private int              tryCount    = 0;
    private Scanner          scan        = new Scanner( System.in );
    
    /**
     * 랜덤한 한 자리 양의 정수를 생성하여 int[3] 어레이에 하나씩 저장한다.
     * <p>
     * 어레이 인덱스 [0] = 백의 자리 (0이 될 수 없음), [1] = 십의 자리, [2] = 일의 자리
     * 
     * @return 랜덤하게 생성된 정수를 저장한 int[3] 어레이
     */
    private int[] getRandomNumber() {
        Random rand         = new Random();
        int[]  randomNumber = new int[MAX];
        
        for ( int i = 0; i < randomNumber.length; i++ ) {
            randomNumber[i] = rand.nextInt( 10 );
            
            for ( int j = 0; j < i; j++ ) { 
                
                if ( randomNumber[0] == 0 || randomNumber[i] == randomNumber[j] ) {
                    i--;
                    break;
                }
            }
        }
        // for ( int i : randomNumber ) {
        // System.out.print( i + " " );
        // }
        // System.out.println();
        return randomNumber;
    } // end of getRandomNumber
    
    /**
     * 사용자로부터 세 자리 양의 정수를 입력받아 각 자릿수를 int[3] 어레이에 저장한다.
     * <p>
     * 입력 받은 문자가 세 자리인지, 숫자가 맞는지만 확인하고 아닐 경우 다시 입력받는다.
     * <p>
     * 각 자릿수의 중복 여부는 체크하지 않는다.
     * 
     * @return 사용자로부터 입력받은 정수를 저장한 int[3] 어레이
     */
    private int[] getUserNumber() {
        int[]   userNumber = new int[MAX];
        boolean isBreak    = false;
        
        while ( !isBreak ) {
            
            try {
                System.out.print( "중복되는 자릿수가 없는 세 자리 정수를 입력하세요 : " );
                int temp = scan.nextInt();
                
                if ( String.valueOf( temp ).length() == 3 ) {
                    
                    for ( int i = userNumber.length - 1; i >= 0; i-- ) {
                        userNumber[i] = temp % 10;
                        temp /= 10;
                    }
                    isBreak = true;
                }
                else {
                    System.out.println( "자릿수를 다시 한번 확인하세요." );
                }
            }
            catch ( Exception e ) {
                System.out.println( e.toString() + " : 정수 이외의 문자는 입력할 수 없습니다." );
                scan.nextLine();
            }
        }
        return userNumber;
    } // end of getUserNumber
    
    /**
     * 두 어레이를 파라미터로 받아 비교하고 스트라이크, 볼, 시도 횟수를 카운트한다.
     * 
     * @param randomNumber 랜덤하게 생성된 정수를 저장한 int[3] 어레이
     * @param userNumber   사용자로부터 입력받은 정수를 저장한 int[3] 어레이
     */
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
    } // end of compare
    
    /**
     * 로직에 따라 게임을 진행하는 메서드
     */
    public void play() {
        int[]   randomNumber = getRandomNumber();
        int[]   userNumber   = getUserNumber();
        boolean isBreak      = false;
        
        while ( !isBreak ) {
            compare( randomNumber, userNumber );
            
            if ( strikeCount == 3 ) {
                System.out.println( "🎉CONGRATULATIONS!🎉 TRY COUNT : " + tryCount );
                System.out.print( "\n새 게임을 시작하려면 y(Y)를 입력하세요 : " );
                String choice = scan.next();
                
                if ( "y".equals( choice ) || "Y".equals( choice ) ) {
                    randomNumber = getRandomNumber();
                    userNumber = getUserNumber();
                    tryCount = 0;
                }
                else {
                    System.out.println( "GAME OVER" );
                    scan.close();
                    isBreak = true;
                }
            }
            else {
                System.out.println( "(〜￣▽￣)〜 " + strikeCount + " STRIKE, " + ballCount + " BALL 〜(￣▽￣〜)" );
                userNumber = getUserNumber();
            }
            strikeCount = 0;
            ballCount = 0;
        }
    } // end of play
}
