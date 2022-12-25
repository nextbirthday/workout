package lecture_2022_12.week_4_NetWork_ThreadEx;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TimeEchoClient {
    
    public TimeEchoClient() {}
    
    // 소켓 관련 초기화
    
    public static void main( String[] args ) {
        
        // 소켓 관련 초기화
        try { // 서버측의 IP주소 작성하기
              // new ServerSocket( port )이 받아서 accept()통해서 client 소켓에 저장이된다.
            Socket             clientSocket = new Socket( "localhost", 40000 );
            ObjectOutputStream oos          = new ObjectOutputStream( clientSocket.getOutputStream() );
            ObjectInputStream  ois          = new ObjectInputStream( clientSocket.getInputStream() );
            String             str          = "client info sent";
            oos.writeObject( str );
        }
        catch ( Exception e ) {}
    }
    
}
