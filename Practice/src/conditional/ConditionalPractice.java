package conditional;

import java.util.Scanner;

public class ConditionalPractice {
    
    public void oddEven() {
        
        // Quiz.01 if문 두 개의 정수 짝수 홀수 판별
        Scanner scanner = new Scanner( System.in );
        
        System.out.println( "첫 번째 정수:" );
        int x = scanner.nextInt();
        
        System.out.println( "두 번째 정수:" );
        int y = scanner.nextInt();
        
        String result = "";
        
        if ( ( x % 2 == 0 ) && ( y % 2 == 0 ) ) {
            result = "두 수 모두 짝수이다.";
        }
        else if ( ( x % 2 == 0 ) || ( y % 2 == 0 ) ) {
            result = " 하나는 홀수이고 하나는 짝수이다.";
        }
        else {
            result = "두 수 모두 홀수이다";
        }
        System.out.println( result );
        
    }
    
}
