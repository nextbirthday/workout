package baseball02;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame02 {
    
    public static void main( String[] args ) {
        
        Random  random = new Random();
        Scanner scan   = new Scanner( System.in );
        
        // 게임에서 사용할 변수
        int com1, com2, com3;
        int user1, user2, user3;
        int randomCount = 0;                // 난수 생성카운트
        int gameCount   = 0;                // 게임카운트
        int strikeCount = 0, ballCount = 0; // 스트라이크,볼 카운트
        
        // 게임전체반복
        while ( true ) {
            
            // 중복되지 않는 3개의 난수생성
            while ( true ) {
                
                // 몇 번만에 난수가 생성되는지 확인
                randomCount++;
                
                // 1~9사이의 난수 생성
                com1 = random.nextInt( 100 ) % 9 + 1;
                com2 = random.nextInt( 100 ) % 9 + 1;
                com3 = random.nextInt( 100 ) % 9 + 1;
                
                if ( !( com1 == com2 || com2 == com3 || com3 == com1 ) ) {
                    // 중복되지 않는 난수 생성에 성공하면 루프탈출
                    break;
                }
            } // while end
            
            // 난수 확인
            System.out.println( randomCount + "회" + com1 + "" + com2 + "" + com3 );
            
            while ( true ) {
                
                // 사용자로 부터 3개의 정수를 입력받는다
                System.out.println( "정수 3개 입력:" );
                System.out.println( "스페이스로 구분하시고 마지막에 enter를 입력하세요" );
                user1 = scan.nextInt();
                user2 = scan.nextInt();
                user3 = scan.nextInt();
                
                // 게임카운트 1회증가
                gameCount++;
                
                // 판단1 - 스트라이크(숫자의 위치까지 일치)
                if ( com1 == user1 )
                    strikeCount++;
                if ( com2 == user2 )
                    strikeCount++;
                if ( com3 == user3 )
                    strikeCount++;
                
                // 판단2 = 볼 (숫자는 일치하나 위치가 다를 때)
                if ( com1 == user2 || com1 == user3 )
                    ballCount++;
                if ( com2 == user1 || com2 == user3 )
                    ballCount++;
                if ( com3 == user1 || com3 == user2 )
                    ballCount++;
                
                // 게임종료판단
                if ( strikeCount == 3 ) {
                    System.out.println( "3Strike 게임종료" );
                    System.out.println( gameCount + "번 만에 성공!" );
                    break; // 루프 탈출
                }
                else {
                    
                    // 하나도 못 맞추는 경우
                    if ( strikeCount == 0 && ballCount == 0 ) {
                        System.out.println( "out" );
                    }
                    else {
                        System.out.printf( "%d스트라이크,%d볼\n", strikeCount, ballCount );
                    }
                    
                    // 스트라이크, 볼 카운트 초기화
                    strikeCount = 0;
                    ballCount = 0;
                    // continue문은 필요 없음
                    
                }
            } // while end
            
            System.out.println( "new challenge?" );// (0:no,1:yes)
            int restart = scan.nextInt();
            
            if ( restart == 0 ) {
                // 게임종료
                System.out.println( "\n==게임이 종료되었습니다.==\n" );
                // 실행되는 즉시 main함수 종료
                System.exit( 0 );
            }
            else if ( restart == 1 ) {
                // 게임을 재시작하기 위해 카운트변수 초기화
                strikeCount = 0;
                ballCount = 0;
                gameCount = 0;
                System.out.println( "\n==게임을 재시작합니다.==\n" );
            }
            
        } // 게임전체반복 while end
        
    } // main method end
    
} // class end
