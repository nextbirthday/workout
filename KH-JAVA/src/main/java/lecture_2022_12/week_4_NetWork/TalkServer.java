package lecture_2022_12.week_4_NetWork;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings( "serial" )
public class TalkServer extends JFrame implements Runnable, ActionListener {
    // 자바는 단일상속만 가능하다. 자바는 단일상속의 단점을 보완하기 위해 interface는 다중으로 처리 가능하다.(구현체클래스)
    // 클라이언트 측에서 new Socket하면 그 소켓정보를 받아서 쓰레드로 넘긴다.
    TalkServerThread tst = null;
    
    // 동시에 여러명이 접속하니까 List - Vector<>(); - multi thread 안전
    List<TalkServerThread> globalList = null;
    
    ServerSocket server = null;
    Socket       socket = null;
    
    JTextArea   jta_log  = new JTextArea( 10, 30 );
    JScrollPane jsp_log  = new JScrollPane( jta_log, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
    JButton     jbtn_log = new JButton( "로그저장" );
    
    public TalkServer() {
        // initDisplay(); 시점의 문제 - 화면을 먼저 호출해야 하기 때문에 생성자의 제어권 안에 놓으면 안된다.
    }
    
    public void initDisplay() {
        jbtn_log.addActionListener( this );
        this.add( "North", jbtn_log );
        this.add( "Center", jsp_log );
        this.setSize( 500, 400 );
        this.setVisible( true );
    }
    
    // 서버소켓과 클라이언트 소켓을 연결
    @Override
    public void run() {
        // 서버에 접속해온 클라이언트 스레드 정보를 관리할 벡터 생성하기
        globalList = new Vector<>();
        boolean isStop = false;
        
        try {
            server = new ServerSocket( 54300 ); // 서버 포트번호 설정하기
            jta_log.append( "Server Ready.........\n" ); // 스레드는 클라이언트가 올 때 까지 대기(wait)
            
            while ( !isStop ) {
                socket = server.accept(); // 클라이언트에서 시그널이 리턴될 때까지 대기 - TalkClient class의 56번 코드가 실행되어야 연결정보가 return
                jta_log.append( "client info:" + socket + "\n" );
                jta_log.append( "Server Ready.........\n" );
                TalkServerThread tst = new TalkServerThread( this );
                tst.start();
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    } ////////// end of run method
    
    @Override
    public void actionPerformed( ActionEvent e ) {}
    
    public static void main( String[] args ) { // entry point
        // 스레드를 출발시키면 지연이 발생하기 때문에 화면을 먼저 호출한다.
        TalkServer ts = new TalkServer();
        ts.initDisplay();
        Thread th = new Thread( ts ); // ts변수를 넘겨줘야 협업이 가능하다.
        th.start(); // 48번 run() method 호출 - 지연이 발생한다. - 클라이언트가 접속할 때까지 기다린다.
    }
    
}
