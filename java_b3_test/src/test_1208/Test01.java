package test_1208;

import java.util.Scanner;

public class Test01 {
    
    public void count() {
        
        Scanner sc = new Scanner( System.in );
        
        while ( true ) {
            
            System.out.println( "문자열을 입력해주세요 :" );
            String str = sc.nextLine();
            
            if ( str.equals( "exit" ) ) {
                System.out.println( "프로그램을 종료합니다." );
                break;
            }
            else {
                System.out.println( str.length() + "글자 입니다." );
                // 문자열에 대한 글자 수 반환 메서드
            }            
        }
        sc.close(); // Scanner 닫아주기
        System.exit( 0 );
    }
}
