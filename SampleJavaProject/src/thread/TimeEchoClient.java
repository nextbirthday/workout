package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeEchoClient implements Runnable {
    
    private String echoMessage = "";
    
    @Override
    public void run() {
        
        try {
            Socket         client  = new Socket( "127.0.0.1", 7777 );
            BufferedReader reader  = new BufferedReader( new InputStreamReader( client.getInputStream() ) );
            boolean        isAlive = true;
            
            while ( isAlive ) {
                echoMessage = reader.readLine();
                System.out.println( echoMessage );
                Thread.sleep( 1000 );
            }
            client.close();
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
    }
    
    public static void main( String[] args ) {
        TimeEchoClient client = new TimeEchoClient();
        client.run();
    }
}
