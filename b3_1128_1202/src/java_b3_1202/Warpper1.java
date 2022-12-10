package java_b3_1202;

public class Warpper1 {    
    
    public static void main( String[] args ) {
        
        Integer i = new Integer( 10 );
        int j = i;
        System.out.println( i );
        System.out.println( j );
        //: 오른쪽에 있으면 리턴타입
        String x = String.valueOf( j );
        String y = x;
        
        System.out.println( y ); //10
        
        if(y instanceof String) {
            System.out.println( "y는 String 타입입니다." );
        }
        
        if( i instanceof Integer) {
            System.out.println( "i는 Integer 타입입니다." );
        }
        
    }
    
}
