package thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class TimeEchoServer {
    
    protected static List<ServerThread> connectionList = new Vector<>();
    
    public static void main( String[] args ) {
        
        ServerSocket serverSocket = null;
        
        if ( args.length == 1 ) {
            
            try {
                int port = Integer.parseInt( args[0] );
                System.out.println( "Time Echo Server Started" );
                serverSocket = new ServerSocket( port );
                
                while ( true ) {
                    Socket       socket = serverSocket.accept();
                    ServerThread thread = new ServerThread( socket );
                    thread.start();
                    connectionList.add( thread );
                }
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
