package thread;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TimeEchoServer {
    
    protected static List<ServerThread> connectionList = new Vector<>();
    
    public static void main( String[] args ) {
        
        ServerSocket serverSocket = null;
        
        if ( args.length == 1 ) {
            
            try {
                int port = Integer.parseInt( args[0] );
                log.info( "Time Echo Server Started" );
                serverSocket = new ServerSocket( port );
                
                while ( true ) {
                    Socket       socket = serverSocket.accept();
                    ServerThread thread = new ServerThread( socket );
                    thread.start();
                    connectionList.add( thread );
                }
            }
            catch ( Exception e ) {
                log.error( "Usage: java TimeEchoServer <port number>", e );
            }
        }
        else {
            log.info( "Usage: java TimeEchoServer <port number>" );
        }
    }
}
