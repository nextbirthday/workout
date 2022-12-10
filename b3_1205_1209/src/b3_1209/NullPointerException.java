package b3_1209;

public class NullPointerException {
    
    public static void main( String[] args ) {
        String str = null;
        if("exit".equals( str )) {
          
        }
        
        String str2 = "null";
        if(str2.equals( "exit" )) { // NullPointerException
            
        }
    }
    
}
