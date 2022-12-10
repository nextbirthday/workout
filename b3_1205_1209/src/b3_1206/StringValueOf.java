package b3_1206;

public class StringValueOf {
    
    public static void main( String[] args ) {
        
        Object obj = null; 
        //System.out.println(obj.toString()); //NullPointerException
        System.out.println(String.valueOf(obj)); // String "null" 반환        
    }
    
}
