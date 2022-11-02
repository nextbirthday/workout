package calculator;

public class Calculation {
    public double add( double x, double y ) {
        return x + y;
    }
    
    public double sub( double x, double y ) {
        return x - y;
    }
    
    public double multi( double x, double y ) {
        return x * y;
    }
    
    public double div( double x, double y ) {
        return x / y;
    }
    
    public void calc( double x, String operator, double y ) {
        double result = 0.0;
        
        switch ( operator ) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;
        }
        System.out.println( "x " + operator + " y = " + result );
    }
}
