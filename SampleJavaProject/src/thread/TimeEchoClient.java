package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeEchoClient implements Runnable {
    private String ip;
    private int    port;
    
    TimeEchoClient() {}
    
    TimeEchoClient( String ip, int port ) {
        this.ip = ip;
        this.port = port;
    }
    
    private Socket client;
    
    @Override
    public void run() {
        
        try {
            client = new Socket( ip, port );
            PrintWriter    writer  = new PrintWriter( client.getOutputStream(), true );
            BufferedReader reader  = new BufferedReader( new InputStreamReader( client.getInputStream() ) );
            String         message = reader.readLine();
            
            while ( message != null ) {
                System.out.println( message );
                writer.println( client.getInetAddress() + " " + client.getLocalPort() );
                Thread.sleep( 1000 );
                message = reader.readLine();
            }
        }
        catch ( UnknownHostException e ) {
            e.printStackTrace();
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        catch ( IllegalArgumentException iae ) {
            iae.printStackTrace();
        }
        catch ( InterruptedException ie ) {
            ie.printStackTrace();
        }
        finally {
            
            try {
                client.close();
            }
            catch ( IOException e ) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main( String[] args ) {
        
        if ( args != null && args.length == 2 ) {
            String ip = args[0];
            
            try {
                int port = Integer.parseInt( args[1] );
                
                TimeEchoClient client = new TimeEchoClient( ip, port );
                client.run();
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
