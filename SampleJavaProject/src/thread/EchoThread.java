package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EchoThread extends Thread {
    
    private Socket             clientSocket;
    private ConnectionRunnable connectionRunnable;
    
    EchoThread() {}
    
    EchoThread( Socket clientSocket, ConnectionRunnable connectionRunnable ) {
        this.clientSocket = clientSocket;
        this.connectionRunnable = connectionRunnable;
    }
    
    private String getTime() {
        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSSX" );
        Date             now    = Calendar.getInstance().getTime();
        return format.format( now.getTime() ).toString();
    }
    
    @Override
    public void run() {
        
        try {
            PrintWriter    writer = new PrintWriter( clientSocket.getOutputStream(), true );
            BufferedReader reader = new BufferedReader( new InputStreamReader( clientSocket.getInputStream() ) );
            
            writer.println( "now : " + getTime() );
            String message = reader.readLine();
            
            while ( message != null ) {
                Thread.sleep( 1000 );
                System.out.println( "client : " + message );
                writer.println( "now : " + getTime() );
                message = reader.readLine();
            }
        }
        catch ( IOException e ) {
            e.printStackTrace();
            System.out.println( "클라이언트 연결이 해제되었습니다." );
            connectionRunnable.threadList.remove( this );
        }
        catch ( IllegalArgumentException iae ) {
            iae.printStackTrace();
        }
        catch ( InterruptedException ie ) {
            ie.printStackTrace();
        }
    }
}
