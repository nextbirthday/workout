package java_b3_1205;

import java.util.Random;
import java.util.Scanner;

public class Quiz04 {
    // 0부터 9사이의 임의의 수를 채번하고 그 숫자를 맞추는 게임을 구현하시오.
    // 기회는 5번이고 5번 이내에 성공시 "congratulations" 5번 초과시 "idiot" 출력
    
    void ansewer() {
        Random  ran     = new Random();
        Scanner scanner = new Scanner( System.in );
        int     com     = ran.nextInt( 10 ); // bound : 0.0~10.0
        int     my      = -1;
        int     count   = 1;
        
        while ( true ) {
            System.out.println( "0부터 9사이의 정수를 입력하세요." );
            my = scanner.nextInt();
            
            if ( count > 5 ) {
                System.out.println( "idiot" );
                break;
            }
            
            if ( com == my ) {
                System.out.println( "congratulations" );
                scanner.close();
                break; // 무한루프를 빠져나가는 코드를 반드시 작성할 것.
            }
            else if ( com > my ) {
                System.out.println( "입력하신 숫자가 정답보다 작습니다." );
            }
            else if ( com < my ) {
                System.out.println( "입력하신 숫자가 정답보다 큽니다." );
            }
            else if ( my == 10 ) {
                System.exit( 0 ); // 종료
                scanner.close(); // 닫는 위치도 중요
            }
            count++;
        }
        
    }
    
    public static void main( String[] args ) {
        Quiz04 quiz04 = new Quiz04();
        quiz04.ansewer();
    }
    
}
