package thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionRunnable implements Runnable {
    
    private ServerSocket serverSocket;
    
    ConnectionRunnable() {}
    
    ConnectionRunnable( ServerSocket serverSocket ) {
        this.serverSocket = serverSocket;
    }
    
    @Override
    public void run() {
        
        try {
            
            while ( true ) {
                System.out.println( "Connection waiting" );
                Socket clientSocket = serverSocket.accept();
                System.out.println( "Client connected" );
                EchoThread echoThread = new EchoThread( clientSocket );
                echoThread.start();
            }
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
