package thread;

import java.io.IOException;
import java.net.ServerSocket;

public class TimeEchoServer {
    
    public static void main( String[] args ) {
        
        if ( args != null && args.length == 1 ) {
            
            try {
                int port = Integer.parseInt( args[0] );
                
                System.out.println( "Time Echo Server Started" );
                ServerSocket       serverSocket       = new ServerSocket( port );
                ConnectionRunnable connectionRunnable = new ConnectionRunnable( serverSocket );
                connectionRunnable.run();
            }
            catch ( NumberFormatException e ) {
                System.out.println( e + "\nUsage: java TimeEchoServer <port number>" );
            }
            catch ( IOException e ) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println( "Usage: java TimeEchoServer <port number>" );
        }
    }
}
