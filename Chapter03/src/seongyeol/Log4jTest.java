package seongyeol;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jTest {
    
    private static final Logger logger = LogManager.getLogger( "logger" );
    
    public void printMessage() {
        logger.trace( "trace level message" ); // log4j2.xml 레벨이 DEBUG 이상이기 때문에 출력되지 않는다.
        logger.debug( "debug level message" );
        logger.info( "info level message" );
        logger.warn( "warn level message" );
        logger.error( "error level message" );
        logger.fatal( "fatal level message\n" );
    }
    
    public static void main( String[] args ) {
        
        Log4jTest log4jTest = new Log4jTest();
        log4jTest.printMessage();
        
        logger.trace( "trace level message" ); // log4j2.xml 레벨이 DEBUG 이상이기 때문에 출력되지 않는다.
        logger.debug( "debug level message" );
        logger.info( "info level message" );
        logger.warn( "warn level message" );
        logger.error( "error level message" );
        logger.fatal( "fatal level message" );
    }
}
