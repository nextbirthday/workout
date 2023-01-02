package lecture_2023_01.week_1_Chat;

import java.net.InetAddress;
import java.net.Socket;

public class ChatClient {
    
    public void client() {
        int    port     = 3000;
        String serverIP = "localhost";
        
        // java.net, java.io 인터넷 회선 문제발생의 원인
        // io 생성시에 소켓을 통해 인스턴스화를 하니까 의존관계에 있다.
        // Thread 예외처리 ( 인터셉트를 당할 수 있다. 인터셉트 당하면 자원이용권을 빼앗김)
        // Object마다 lock flag값이 있어서 스레드가 점유하면 잠금 - 다른 스레드 사용불가
        // deadlock 상태에 빠질 수 있다. 한정된 자원을 여러 사람이 이용하기 위해 제공되는 클래스가 Thread
        try {
            System.out.println( InetAddress.getLocalHost().getHostAddress() );
            Socket socket = new Socket( serverIP, 3000 );
        }
        catch ( Exception e ) {
            e.printStackTrace(); // error message에 대한 history를 기억하고 line number와 함께 이력을 출력한다.
        }
    }
    
    public static void main( String[] args ) {
        ChatClient cc = new ChatClient();
        cc.client();
    }
}
