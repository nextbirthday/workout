package calculator;

import java.util.Scanner;

public class Main {
    
    public static void main( String[] args ) {
        Calculation calc     = new Calculation();
        Scanner     scan     = new Scanner( System.in );
        double      x        = 0.0, y = 0.0, result = 0.0;
        String      operator = null;
        
        System.out.print( "첫 번째 숫자를 입력하세요 : " );
        x = scan.nextDouble();
        System.out.print( "연산자를 입력하세요( +, -, *, / ) : " );
        operator = scan.next();
        System.out.print( "두 번째 숫자를 입력하세요 : " );
        y = scan.nextDouble();
        
        scan.close();
        
        switch ( operator ) {
            case "+":
                result = calc.add( x, y );
                break;
            case "-":
                result = calc.sub( x, y );
                break;
            case "*":
                result = calc.multi( x, y );
                break;
            case "/":
                result = calc.div( x, y );
                break;
            default:
                System.out.println( "+, -, *, / 만 사용 가능합니다." );
                System.exit( 1 );
                break;
        }
        System.out.println( "x " + operator + " y = " + result );
        
        calc.calc( x, operator, y );
    }
}
