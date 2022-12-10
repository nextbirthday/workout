package com.ch01;

import java.util.Scanner;

public class CalcMain {
    
    public static void main( String[] args ) {
        
        CalcEx calc     = new CalcEx();
        Scanner  scanner  = new Scanner( System.in );
        boolean  isExit   = false;
        double   x        = 0.0;
        double   y        = 0.0;
        String   operator = null;
        String   cmd      = null;
        
        while ( !isExit ) {
            System.out.print( "첫 번째 숫자를 입력하세요 : " );
            x = scanner.nextDouble();
            
            System.out.print( "연산자를 입력하세요 ( + , - , * , / ) : " );
            operator = scanner.next();
            // scanner.nextLine();입력 - InputMismatchException 발생하였음
            
            System.out.print( "두 번째 숫자를 입력하세요 :" );
            y = scanner.nextDouble();
            
            calc.calc( x, operator, y );
            
            System.out.print( "계속하려면 아무 키나, 종료하려면 y(Y)를 입력하세요 : " );
            cmd = scanner.next();
            if ( "y".equals( cmd ) || "Y".equals( cmd ) )
                isExit = true;
        }
        System.out.println( "프로그램 종료" );
        scanner.close();
    }
    
}
