package operator;

import java.util.Scanner;

public class OperatorTest {
    public void operatorTest() {
        // 산술 연산자 % : 나누었을 때 나머지를 구하는 연산자
        // 짝수 -> 값 % 2 == 0
        // 홀수 -> 값 % 2 == 1
        // n의 배수 -> 값 % n == 0
        
        int num1 = 10;
        int num2 = 3;
        System.out.println( "num1 % num2 =" + ( num1 % num2 ) ); // 1
        
        // 논리 연산자
        // 1과 100 사이의 수 ?
        // 1 < 수 < 100(X)
        // 변수 > 1 && 변수 < 100
        Scanner sc = new Scanner( System.in );
        System.out.println( "정수 입력 :" );
        int num3 = sc.nextInt();
        
        System.out.println( "1과 100 사이의 수?" + ( num3 > 1 && num3 < 100 ) );
        
        // 복합대입연산자
        // 코드가 간결하여 메모리에 직접 연산을 수행하여 연산속도가 빠름
        int num4 = 5;
        num4 += 10;
        System.out.println( "num4 :" + num4 ); // 15
        
        num4 -= 10;
        System.out.println( "num4 :" + num4 ); // 5
        
        num4 *= 10;
        System.out.println( "num4 :" + num4 ); // 50
        
        num4 /= 10;
        System.out.println( "num4 :" + num4 ); // 5
        
        num4 %= 10;
        System.out.println( "num4 :" + num4 ); // 5
    }
    
    public void operatorTest2() {
        // 삼항연산자
        // 사용자에 값을 가나 받아서 그 값이 양수인지 음수인지 0인지 판별
        Scanner sc = new Scanner( System.in );
        System.out.println( "정수 하나 입력:" );
        
        int num = sc.nextInt();
        
        String result = num > 0 ? "양수" : num == 0 ? "0이다" : "음수다";
        System.out.println( result);
    }
}
