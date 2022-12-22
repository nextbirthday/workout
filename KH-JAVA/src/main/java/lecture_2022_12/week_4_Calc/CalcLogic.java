package lecture_2022_12.week_4_Calc;

public class CalcLogic {
    
    private int add( int x, int y ) {
        return x + y;
    }
    
    private int sub( int x, int y ) {
        return x - y;
    }
    
    private int multi( int x, int y ) {
        return x * y;
    }
    
    private int div( int x, int y ) {
        return x / y;
    }
    
    public int calc( int x, String operator, int y ) {
        int result = 0;
        
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
            
            default:
                System.out.println( "연산자는 ( +, -, *, / ) 만 가능합니다." );
        }
        return result;
    }
    
}
