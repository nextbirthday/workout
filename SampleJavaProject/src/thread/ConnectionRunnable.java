package thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ConnectionRunnable implements Runnable {
    
    private ServerSocket serverSocket;
    protected List<Thread> threadList = new ArrayList<>();
    
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
                EchoThread echoThread = new EchoThread( clientSocket, this );
                echoThread.start();
                threadList.add( echoThread );
                System.out.println( threadList );
            }
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
