package calculator;


public class Calculator2 {
    
    int add( int i, int k) {
        return i + k ;
    }
    
    int sub( int i, int k ) {
        return i-k;
        
    }
    
    int multi( int i, int k) {
        return i*k;
    }
    
    double div(int i, int k) {
        return (double)i/k;
    }
    
    public static void main(String[] args) {
        
        Calculator2 cal = new Calculator2();
        
        System.out.println( "합="+cal.add( 0, 0 ) );
        System.out.println( "차="+cal.sub( 0, 0 ) );
        System.out.println( "곱="+cal.multi( 0, 0 ) );
        System.out.println( "나누기="+cal.div( 0, 0 ) );
        
    }
        
        
            
}
   
    
    
    
    
    

