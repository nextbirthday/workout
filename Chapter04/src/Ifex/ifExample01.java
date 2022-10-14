package Ifex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ifExample01 {
    
    private static final Logger logger = LogManager.getLogger( "logger" );
    
    public static void main( String[] args ) {
        
        int age = 10;
        
        if ( age >= 8 ) {
            logger.info( "학교에 다닙니다." );
            
            System.out.println( "학교에 다닙니다." );
            // System.out.println( "test");
            ;
        }
        else {
            System.out.println( "학교에 다니지 않습니다." );
        }
    }
}
