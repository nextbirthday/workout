package calculator;

public class Main {
    
    public static void main( String[] args ) {
        // Calculator ca = new Calculator();
        // ca.method1();
        Calculator2 calc = new Calculator2();
        System.out.println( calc.div( 2, 3 ) );
        // int 0이 아니라 double 0이기 때문에 무한대가 나오는 것
        // int 0이면 에러 출력됨
        System.out.println( calc.div( 8, 0 ) );
    }
}
