package variable;

public class ReturnEx {
    
    int practice( int x, int y ) {
        return x + y;
    }
    
    public static void main( String[] args ) {
        ReturnEx re = new ReturnEx();
        
       
        System.out.println(re.practice( 10, 20 ));
    }
}
