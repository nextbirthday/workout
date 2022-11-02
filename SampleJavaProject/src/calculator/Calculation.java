package calculator;

public class Calculation {
    
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
                result = div( x, y );
                break;
        }
        System.out.println( "x " + operator + " y = " + result );
    }
}
