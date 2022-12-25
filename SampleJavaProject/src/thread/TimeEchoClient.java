package thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TimeEchoClient implements Runnable {
    
    private Socket client;
    private String ip;
    private int    port;
    
    TimeEchoClient( String ip, int port ) {
        this.ip = ip;
        this.port = port;
    }
    
    @Override
    public void run() {
        
        try {
            client = new Socket( ip, port );
            ObjectOutputStream output = new ObjectOutputStream( client.getOutputStream() );
            ObjectInputStream  input  = new ObjectInputStream( client.getInputStream() );
            
            while ( true ) {
                System.out.println( input.readObject() );
                Thread.sleep( 1000 );
                output.writeObject( "Client info : " + client.getLocalSocketAddress() );
            }
        }
        catch ( IOException | ClassNotFoundException | InterruptedException e ) {
            e.printStackTrace();
        }
    }
    
    public static void main( String[] args ) {
        
        if ( args.length == 2 ) {
            
            try {
                String ip   = args[0];
                int    port = Integer.parseInt( args[1] );
                
                TimeEchoClient client = new TimeEchoClient( ip, port );
                new Thread( client ).start();
            }
            catch ( NumberFormatException e ) {
                System.out.println( e + "\nUsage: java TimeEchoClient <host name> <port number>" );
            }
        }
        else {
            System.out.println( "Usage: java TimeEchoClient <host name> <port number>" );
        }
    }
}
