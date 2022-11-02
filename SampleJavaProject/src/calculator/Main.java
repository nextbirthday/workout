package calculator;

import java.util.Scanner;

public class Main {
    
    public static void main( String[] args ) {
        
        Calculation calc = new Calculation();
        Scanner     scan = new Scanner( System.in );
        
        System.out.print( "첫 번째 숫자를 입력하세요 : " );
        double x = scan.nextDouble();
        
        System.out.print( "연산자를 입력하세요( +, -, *, / ) : " );
        String operator = scan.next();
        
        System.out.print( "두 번째 숫자를 입력하세요 : " );
        double y = scan.nextDouble();
        
        scan.close();
        
        calc.calc( x, operator, y );
    }
}
