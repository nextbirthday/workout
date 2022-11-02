package conditional;

import java.util.Scanner;

public class ConditionalPractice {
    public void method1() {
        // 문제1 if문 두 개의 정수 짝수 홀수 판별
        Scanner sc = new Scanner( System.in );
        
        System.out.println( "첫 번째 정수:" );
        int num1 = sc.nextInt();
        
        System.out.println( "두 번째 정수:" );
        int num2 = sc.nextInt();
        
        String result = "";
        
        if ( ( num1 % 2 == 0 ) && ( num2 % 2 == 0 ) ) {
            result = "두 수 모두 짝수이다.";
        }
        else if ( ( num1 % 2 == 0 ) || ( num2 % 2 == 0 ) ) {
            result = " 하나는 홀수이고 하나는 짝수이다.";
        }
        else {
            result = "두 수 모두 홀수이다";
        }
        System.out.println( result );
    }
    
    public void method2() {
        // 문제2 두 정수와 연산자를 입력 받아서 연산 결과 출력
        Scanner sc = new Scanner( System.in );
        
        System.out.println( "첫 번째 정수 입력:" );
        int num1 = sc.nextInt();
        System.out.println( "두 번째 정수 입력:" );
        int num2 = sc.nextInt();
        System.out.println( "연산 기호 입력:" );
        char op = sc.next().charAt( 0 );
        
        int result = 0;
        
        switch ( op ) {
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
                if ( num2 != 0 ) {
                    result = num1 / num2;
                }
                else {
                    System.out.println( "0으로 나눌 수 없습니다." );
                }
                break;
            case '%':
                result = num1 % num2;
                break;
            default:
                System.out.println( "입력하신 연산은 없습니다. 프로그램을 종료합니다." );
                return;
         }
        System.out.println( "수행 결과 :" + num1 + "" + op + "" + num2 + "=" + result);
    }
    
}
