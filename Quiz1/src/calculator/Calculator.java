package calculator;

import java.util.Scanner;

public class Calculator {
    
    // 메서드 명칭 의미있게 지을 것
    public void method1() {
        
        Scanner sc = new Scanner( System.in );
        
        System.out.print( "첫 번째 수 입력: " );
        double num1 = sc.nextDouble();
        
        System.out.print( "두 번째 수 입력:" );
        double num2 = sc.nextDouble();
        
        System.out.print( "연산자 입력:" );
        char oper = sc.next().charAt( 0 );
        
        double result = 0;
        
        switch ( oper ) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                // 0으로 나눌 경우 에러 발생
                result = num1 / num2;
                break;
        }
        System.out.println( "결과 값:" + num1 + oper + num2 + "=" + result );
        sc.close();
    }
}
