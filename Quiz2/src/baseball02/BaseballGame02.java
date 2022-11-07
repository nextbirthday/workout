package baseball02;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame02 {
    
    public static void main( String[] args ) {
        
        Random  random = new Random();
        Scanner scan   = new Scanner( System.in );
        
        int com1, com2, com3;
        int user1, user2, user3;
        int randomCount = 0;
        int gameCount   = 0;
        int strikeCount = 0, ballCount = 0;
        
        while ( true ) {
            
            while ( true ) {
                randomCount++;
                com1 = random.nextInt( 100 ) % 9 + 1;
                com2 = random.nextInt( 100 ) % 9 + 1;
                com3 = random.nextInt( 100 ) % 9 + 1;
                
                if ( !( com1 == com2 || com2 == com3 || com3 == com1 ) ) {
                    break;
                }
            }
            
            System.out.println( randomCount + "회" + com1 + "" + com2 + "" + com3 );
            
            while ( true ) {
                System.out.println( "정수 3개 입력:" );
                System.out.println( "스페이스로 구분하시고 마지막에 enter를 입력하세요" );
                user1 = scan.nextInt();
                user2 = scan.nextInt();
                user3 = scan.nextInt();
                
                gameCount++;
                
                if ( com1 == user1 )
                    strikeCount++;
                if ( com2 == user2 )
                    strikeCount++;
                if ( com3 == user3 )
                    strikeCount++;
                
                if ( com1 == user2 || com1 == user3 )
                    ballCount++;
                if ( com2 == user1 || com2 == user3 )
                    ballCount++;
                if ( com3 == user1 || com3 == user2 )
                    ballCount++;
                
                if ( strikeCount == 3 ) {
                    System.out.println( "3Strike 게임종료" );
                    System.out.println( gameCount + "번 만에 성공!" );
                    break;
                }
                else {
                    
                    if ( strikeCount == 0 && ballCount == 0 ) {
                        System.out.println( "out" );
                    }
                    else {
                        System.out.printf( "%d스트라이크,%d볼\n", strikeCount, ballCount );
                    }
                    strikeCount = 0;
                    ballCount = 0;
                }
            }
            System.out.println( "new challenge?" );
            int restart = scan.nextInt();
            
            if ( restart == 0 ) {
                System.out.println( "\n==게임이 종료되었습니다.==\n" );
                System.exit( 0 );
            }
            else if ( restart == 1 ) {
                strikeCount = 0;
                ballCount = 0;
                gameCount = 0;
                System.out.println( "\n==게임을 재시작합니다.==\n" );
                
            }
        }
    }
}
