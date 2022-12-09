package test_1208;

import java.util.Scanner;

public class Test01 {
    
    public void count() {
        
        System.out.println( "count method call" ); // log에 출력할 값
        
        Scanner sc = new Scanner( System.in );
        boolean isExit = false; // varaible 사용 
        
        while ( !isExit ) {
            
            System.out.print( "문자열을 입력해주세요 :" );
            String str = sc.nextLine();
            
            if ( str.equals( "exit" ) ) {
                System.out.println( "프로그램을 종료합니다." );
                break; // while문 탈출
            }
            else {
                System.out.println( str.length() + "글자 입니다." );
                // 문자열에 대한 글자 수 반환 메서드
            }            
        } //end of while
        sc.close(); // Scanner 닫아주기
        System.exit( 0 );
    }
}
