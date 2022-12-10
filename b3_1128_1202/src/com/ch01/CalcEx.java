package com.ch01;

public class CalcEx {
    
    private double add( double x, double y ) {
        return x + y;
    }
    
    private double sub( double x, double y ) {
        return x - y;
    }
    
    private double multi( double x, double y ) {
        return x * y;
    }
    
    private double div( double x, double y ) {
        return x / y;
    }
    
    public void calc( double x, String operator, double y ) {
        double result = 0.0;
        
        switch ( operator ) {
            
            case "+":
                result = add( x, y );
                break;
            
            case "-":
                result = sub( x, y );
                break;
            
            case "*":
                result = multi( x, y );
                break;
            
            case "/":
                if ( y != 0 ) {
                    result = div( x, y );
                    break;
                }
                else {
                    System.out.println( "0으로 나눌 수 없습니다." );
                    return;
                }
            default:
                System.out.println( "연산자는 ( +, -, *, / ) 만 가능합니다." );
                return;
        }
        System.out.println( "x " + operator + " y = " + result );
    }
}

