package lecture_2023_01.week_1_Review;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings( "serial" )
public class TalkServerEx extends JFrame implements ActionListener {
    
    public TalkServerEx() {} // default constructor
    
    ServerSocket   server;
    Socket         client;
    BufferedReader in;
    BufferedWriter out;
    Scanner        scanner = new Scanner( System.in );
    
    /* 
     * 
     * 
     */
    protected void connection() {
        int port = 9999;
        
        try {
            server = new ServerSocket( port );
            System.out.println( "ServerSocket created..." );
            boolean isStop = false;
            
            System.out.println( "client waiting....." );
            
            client = server.accept(); //클라이언트 시그널 받아옴
            
            System.out.println( "Client accepted...\n" + "Client info : " + client.getInetAddress() );
            
            in = new BufferedReader( new InputStreamReader( client.getInputStream() ) );
            out = new BufferedWriter( new OutputStreamWriter( client.getOutputStream() ) );
            
            while ( !isStop ) {
                String inMessage = in.readLine();
                
                // Client가 message에 bye를 입력했을 경우
                // equalsIgnoreCase 메서드는 대,소문자 구분을 하지 않는다.
                if ( inMessage.equalsIgnoreCase( "Bye" ) ) {
                    System.out.println( "Client가 접속을 종료하셨습니다." );
                    break;
                }
                
                // 정상적인 message의 경우
                System.out.println( "From Client : " + inMessage );
                
                System.out.print( "Send >>>" );
                String outMessage = scanner.nextLine();
                out.write( outMessage + "\n" );
                out.flush();
            }
            
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        finally {
            
            try {
                scanner.close();
                out.close();
                in.close();
                client.close();
            }
            catch ( IOException e ) {
                e.printStackTrace();
            }
        }
        
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        
    }
    
    public static void main( String[] args ) {
        TalkServerEx ts = new TalkServerEx();
        ts.connection();
    }
    
}
