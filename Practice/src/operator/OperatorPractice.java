package operator;

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
    }
}
