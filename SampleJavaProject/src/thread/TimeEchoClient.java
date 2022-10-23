package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeEchoClient implements Runnable {
    private Socket client;
    
    @Override
    public void run() {
        
        try {
            client = new Socket( "127.0.0.1", 7777 );
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
        TimeEchoClient client = new TimeEchoClient();
        client.run();
    }
}
