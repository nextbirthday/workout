package thread;

import java.io.IOException;
import java.net.ServerSocket;

public class TimeEchoServer {
    
    public static void main( String[] args ) {
        System.out.println( "Time Echo Server Started" );
        
        try {
            ServerSocket       serverSocket       = new ServerSocket( 7777 );
            ConnectionRunnable connectionRunnable = new ConnectionRunnable( serverSocket );
            connectionRunnable.run();
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
