package test_1208;

public class Test02 {
    
    void testSwitch() {
        
        for ( int i = 1; i <= 20; i++ ) {
            
            switch ( i % 5 ) {
                
                case 0:
                    System.out.println( i + " : 5의 배수입니다." );
                    break;
                
                default:
                    System.out.println( i + " : 5의 배수가 아닙니다." );
                    break;
            }
        }
    }
    
    void testWhile() {
        
        int i = 1;
        
        while ( i <= 20 ) {
            
            if ( i % 5 == 0 ) {
                System.out.println( i + " : 5의 배수입니다." );
            }
            else {
                System.out.println( i + " : 5의 배수가 아닙니다." );
            }
            i++;
        }
    }
    
    void testFor() {
        
        for ( int i = 1; i <= 20; i++ ) {
            
            if ( i % 5 == 0 ) {
                System.out.println( i + " : 5의 배수입니다." );
            }
            else {
                System.out.println( i + " : 5의 배수가 아닙니다." );
            }
        }
    }
}
