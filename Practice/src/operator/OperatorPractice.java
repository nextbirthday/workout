package operator;

import java.util.Scanner;

public class OperatorPractice {
    public void method1() {
        
        int    num1 = 10, num2 = 0;
        String str  = "hello";
        
        num1 += 20; // num1 : 30
        num2 += 10; // num2 : 10
        num1 /= num2; // num1 : 3
        num2 *= num1;// num2 : 30
        str += num2;// str : hello30
        num2 -= num1;// num2 : 27
        
        System.out.println( "num1 :" + num1 );
        System.out.println( "num2:" + num2 );
        System.out.println( "str" + str );
        
        System.out.println("num 1 :" + num2);
       
    }
    
    public void method2() {
        //Q2 삼항연산자를 활용해서 두 개의 정수의 짝,홀 판별
        Scanner sc = new Scanner(System.in);
        System.out.println( "첫 번째 정수 입력:" );
        int num1 = sc.nextInt();
        System.out.println(  "두 번째 정수 입력:");
        int num2 = sc.nextInt();
        
        String result = (num1 % 2 ==0) && (num2 % 2 ==0) ? " 모두 짝수이다." : 
            (num1 % == 0) || (num2 % 2 == 0) ? "하나는 홀수이고 하나는 짝수이다.":"두 수 모두 홀수이다";
    }
}
