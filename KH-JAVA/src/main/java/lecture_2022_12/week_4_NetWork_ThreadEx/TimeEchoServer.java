package lecture_2022_12.week_4_NetWork_ThreadEx;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeEchoServer {
    
    ServerSocket serverSocket;
    Socket       socket;
    
    public static void main( String[] args ) {
        TimeEchoServer tes = new TimeEchoServer();
        
        try {
            tes.serverSocket = new ServerSocket( 40000 );
            tes.socket = tes.serverSocket.accept(); // client 연결정보를 tes.socket(소켓에 넣어주기)
            System.out.println( "client info:" + tes.socket + "\n" );
            
            ServerThread serverThread = new ServerThread( tes.socket );
            serverThread.start(); // variable를 사용해 start 시점을 조절하고 싶다면?
            // new ServerThread( tes.socket ).start(); 오샤레...
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        System.out.println( "main 종료" );
    }
}
