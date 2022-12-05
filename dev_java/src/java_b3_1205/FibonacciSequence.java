package java_b3_1205;

import java.util.Scanner;

// 피보나치 수열의 규칙을 만족하는 프로그램을 작성하고 a1에서 a10번 째 항까지 출력되도록 만들어보세요.
// 1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
public class FibonacciSequence {
    
    void fibonacciSequence() {
        Scanner scanner = new Scanner( System.in );
        System.out.print( "정수 입력 : " );
        int j = scanner.nextInt();
        
        int num1, num2, sum;
        num1 = 0; // 첫번째와 두번째 값이 1이어야 하므로 초기값을 0과
        num2 = 1; // 1로 준다
        sum = 1; // 첫번째 1은 그냥 초기값으로 설정
        
        for ( int i = 0; i < j; i++ ) {
            System.out.print( sum + " " );
            sum = num1 + num2; // 두 값을 더한 후
            num1 = num2;
            num2 = sum; // 두번째 연산자에 더한 값을 넣어준다.
        }
    } 
    
    public static void main( String[] args ) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        fibonacciSequence.fibonacciSequence();
    }
}
