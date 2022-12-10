package b3_1205;

import java.util.Random;
import java.util.Scanner;

public class Quiz04 {
    // 0부터 9사이의 임의의 수를 채번하고 그 숫자를 맞추는 게임을 구현하시오.
    // 기회는 5번이고 5번 이내에 성공시 "congratulations" 5번 초과시 "idiot" 출력
    
    void ansewer() {
        Random  ran     = new Random(); // new 다음에 오는 이름의 객체가 로딩 -> 생성자 호출도 일어남
        Scanner scanner = new Scanner( System.in );
        // Scanner 클래스를 사용하면 입력장치로 입력된 정보를 받아올 수 있다.
        // 생성자의 파라미터에 입력장치에 대한 코드가 필요하다.
        // System - 내가 사용하는 컴퓨터 장치
        // 그 뒤에 변수 in을 붙이면 입력장치를 나타냄
        int com = ran.nextInt( 10 ); // bound : 0~10 //nextInt 메서드는 Scanner 클래스가 소유주이다.
        System.out.println( "사용자가 채번한 숫자는:" + com );
        
        int my    = -1;
        int count = 1; // 시도를 count하는 변수 선언
        // 언제 카운트를 증가 시킬것인가? - hint를 줄 때 증가 시킨다.
        boolean isOk = true; // 변수 활용, 상수 사용 지양
        
        while ( isOk ) { // 무한루프에 빠지는 코드
            // 사용자에게 입력받아야 하는 유효한 값의 범위를 출력하기
            System.out.println( "0부터 9사이의 정수를 입력하세요." );
            // Scanner 클래스가 소유한 nextInt 메서드 호출하기
            // nextInt()의 반환타입은 int이다.
            my = scanner.nextInt();
            
            if ( count == 5 ) {
                System.out.println( "idiot" );
                System.exit( 0 );//파라미터에 0을 주면 JVM과 연결이 끊긴다. 종료, 할당 thread 반환          
            }
            
            // 컴퓨터가 채번한 값과 사용자가 입력한 값이 같니?
            if ( com == my ) { // 변수가 가리키는 값이 같은지를 비교하는 조건식 - primitive type
                System.out.println( "congratulations" );
                scanner.close(); // 사용한 Scanner의 주소번지는 닫아야한다.
                break; // 무한루프를 빠져나가는 코드를 반드시 작성할 것.
            }
            else if ( com > my ) {
                System.out.println( "입력하신 숫자가 정답보다 작습니다." );
                System.out.println( count++ );
            }
            else if ( com < my ) {
                System.out.println( "입력하신 숫자가 정답보다 큽니다." );
                System.out.println( count++ );
            }
        }
        
    }
    
    public static void main( String[] args ) {
        
        Quiz04 quiz04 = new Quiz04();
        
        quiz04.ansewer();
        
    }
    
}
