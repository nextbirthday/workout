package java_b3_1202;

import java.util.Scanner;

public class StaticExam6 {
        
    public static void main( String[] args ) {
        
        Scanner scanner = new Scanner( System.in );
        System.out.println( "0~9사이의 수를 입력하세요 >" );
        
        String user   = scanner.nextLine();
        int    i_user = Integer.parseInt( user );
    
        System.out.println( "사용자가 입력한 숫자는" + user + "입니다." );
        System.out.println( user + 1 );
        System.out.println( i_user + 1 );
        
        scanner.close();
    }
}
