package thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServerThread extends Thread {
    
    private Socket socket;
    
    protected ServerThread( Socket socket ) {
        this.socket = socket;
    }
    
    private String getTime() {
        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSSX" );
        Date             now    = Calendar.getInstance().getTime();
        return format.format( now.getTime() ).toString();
    }
    
    @Override
    public void run() {
        
        try {
            ObjectOutputStream output = new ObjectOutputStream( socket.getOutputStream() );
            ObjectInputStream  input  = new ObjectInputStream( socket.getInputStream() );
            
            while ( true ) {
                output.writeObject( getTime() );
                System.out.println( input.readObject() );
            }
        }
        catch ( IOException | ClassNotFoundException e ) {
            System.out.println( e );
        }
        finally {
            System.out.println( "클라이언트 연결이 해제되었습니다." );
            TimeEchoServer.connectionList.remove( this );
            System.out.println( TimeEchoServer.connectionList );
        }
    }
}
