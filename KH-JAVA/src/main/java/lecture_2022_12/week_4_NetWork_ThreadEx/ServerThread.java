package lecture_2022_12.week_4_NetWork_ThreadEx;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
    
    Socket socket;
    
    public ServerThread() {}
    
    public ServerThread( Socket socket ) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        // super.run(); - super예약어(parent)는 parent class를 가리킨다.
        
        while ( true ) {
            
            try {
                ObjectOutputStream oos        = new ObjectOutputStream( socket.getOutputStream() );
                ObjectInputStream  ois        = new ObjectInputStream( socket.getInputStream() );
                String             fromClient = ( String ) ois.readObject();
                System.out.println( fromClient );
            }
            catch ( ClassNotFoundException | IOException e ) {
                e.printStackTrace();
            }
        }
    }
    
}
