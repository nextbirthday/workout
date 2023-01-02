package lecture_2023_01.week_1_Chat;

import java.net.ServerSocket;
import java.net.Socket;

import lombok.extern.log4j.Log4j2;

@Log4j2
// interface를 통해 thread 구현방법 - run method
public class ChatServer implements Runnable {
    
    @Override
    public void run() {
        log.info( "run method call" );
        int          port         = 3000;
        ServerSocket serverSocket = null;
        
        try {
            serverSocket = new ServerSocket( port );
            boolean isStop = false;
            System.out.println( "ServerSocket 생성 완료 - Client connect waiting....." );
            
            while ( !isStop ) {
                
                Socket client = serverSocket.accept(); // new Socket("IP Address", port);
                System.out.println( "Client info = " + client.getInetAddress() ); // 접속한 클라이언트 정보 출력
                
                // 말하기 - ObjectOutputStream -> writeObject(); 네트워크 전송이 일어난다 - 패킷
                // 듣기 - ObjectInputStream -> readObject();
                
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }
    
    public static void main( String[] args ) {
        System.out.println( "main start..." );
        ChatServer cs = new ChatServer();
        Thread     th = new Thread( cs );
        th.start();
        System.out.println( "main end..." );
    }
}
