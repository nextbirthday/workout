package lecture_2022_12.week_5_Server;

import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServer {
    // 서버측에는 소켓이 두개 필요하다.
    // ServerSocket - 동시에 많은 사람이 접속해올 때 튕기지 않고 모두 받아주기 위한 소켓
    // Socket - 실제로 일하는 소켓
    public void server() {
        int          port   = 3000;
        ServerSocket server = null;
        
        try {
            server = new ServerSocket( port );
            System.out.println( "서버 소켓 생성되었습니다." );
            
            while ( true ) {
                Socket client = server.accept();
                System.out.println( "client : " + client );
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }
    
    public static void main( String[] args ) {
        NetworkServer ns = new NetworkServer();
        ns.server();
    }
    
}
