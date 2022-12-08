package quiz.blank;

import java.util.Random;

import java.util.Scanner;

public class BaseballGameLogic {
    
    // 배열의 최대크기로 사용할 상수(constant)
    private static final int MAX = 3;
    
    // 스트라이크 개수로 사용할 변수
    private int strikeCount = 0;
    
    // 볼 개수로 사용할 변수
    private int ballCount = 0;
    
    // 재시도 횟수로 사용할 변수
    private int tryCount = 0;
    
    // 사용자로부터 입력을 받을 스캐너
    // 정수 입력과, 재도전 여부를 받는다
    // 프로그램이 종료되기 전에 close 해줄 것
    Scanner scan = new Scanner( System.in );
    
    /*
     * TODO 랜덤한 한 자리 양의 정수를 3번 반복 생성, 세 자리 수를 만든다.
     * 순서대로 정수형 배열에 넣어 리턴하는 메서드를 작성한다.
     * 백의 자리가 0이 되거나, 각 자릿수는 겹치는 숫자일 수 없다.
     */
    private int[] getRandomNumber() {
        
        Random ran          = new Random();
        int[]  randomnumber = new int[MAX];
        
        for ( int i = 0; i < randomnumber.length; i++ ) {
            randomnumber[i] = ran.nextInt( 10 );
            
            for ( int j = 0; j < i; j++ ) {
                
                if ( randomnumber[0] == 0 || randomnumber[i] == randomnumber[j] ) {
                    i--;
                    break;
                }
            }
        }
        return randomnumber;
    }
    
    /*
     * TODO 사용자로부터 세 자리 양의 정수를 입력받아
     * 한자리씩 정수형 배열에 넣어 리턴하는 메서드를 작성한다.
     * 또한, 한 자리씩 세 번 입력 받는 것이 아니라
     * 세 자리 정수를 한 번 입력하면 나누어 저장하도록 한다.
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
                    System.out.println( "자리 수를 다시 확인해주세요." );
                }
            }
            catch ( Exception e ) {
                System.out.println( e.toString() + "정수 이외의 문자는 입력할 수 없습니다." );
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
        
        
        
    }
    
    /*
     * TODO 위에서 작성한 3개 메서드를 활용하여
     * 사용자가 종료하기 전까지 게임을 반복실행하는 메서드를 작성한다.
     * (단, 3 STRIKE 로 게임을 이겼을 때에만 종료 여부를 묻는다.)
     */    
    public void playGame() {
        
    }
}
