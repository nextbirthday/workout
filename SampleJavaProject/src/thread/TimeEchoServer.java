package thread;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeEchoServer implements Runnable {
    
    private Socket client;
    
    TimeEchoServer() {}
    
    TimeEchoServer( Socket client ) {
        this.client = client;
    }
    
    @Override
    public void run() {
        
        try {
            PrintWriter writer  = new PrintWriter( client.getOutputStream(), true );
            boolean     isAlive = true;
            
            while ( isAlive ) {
                writer.println( getTime() );
                System.out.println( client + "에게 메시지 발송" );
                Thread.sleep( 1000 );
                System.out.println( client.isClosed() );
                
                if ( client.isClosed() )
                    isAlive = false;
            }
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
    
    private String getTime() {
        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSSX" );
        Date             now    = Calendar.getInstance().getTime();
        return format.format( now.getTime() ).toString();
    }
    
    public static void main( String[] args ) {
        
        try {
            ServerSocket server = new ServerSocket( 7777 );
            System.out.println( "서버 초기화... " + server );
            Socket  client   = null;
            boolean isAccept = true;
            
            while ( isAccept ) {
                client = server.accept();
                System.out.println( "클라이언트 연결... " + client );
                TimeEchoServer timeEchoServer = new TimeEchoServer( client );
                timeEchoServer.run();
            }
            server.close();
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
