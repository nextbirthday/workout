package lecture_2023_01.week_1_Chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    
    public TalkServer() {}
    
    TalkServerThread       tst;
    List<TalkServerThread> tstList;
    
    ServerSocket       serverSocket;
    Socket             socket;
    ObjectOutputStream oos;
    ObjectInputStream  ois;
    
    JTextArea   logTextArea   = new JTextArea( 10, 30 );
    JScrollPane logScrollPane = new JScrollPane( logTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
    JButton     saveLogButton = new JButton( "Save log" );
    
    public void init() {
        saveLogButton.addActionListener( this );
        this.add( "North", saveLogButton );
        this.add( "Center", logScrollPane );
        this.setSize( 500, 400 );
        this.setVisible( true );
    }
    
    @Override
    public void run() {
        tstList = new Vector<>();
        boolean isStop = false;
        
        try {
            serverSocket = new ServerSocket( 30000 );
            logTextArea.append( "Server ready...\n" );
            
            while ( !isStop ) {
                socket = serverSocket.accept(); // 클라이언트에서 시그널이 리턴될 때까지 대기
                log.info( socket );
                logTextArea.append( "Client info : " + socket + "\n" );
                logTextArea.append( "Client info : " + socket.getInetAddress() + "\n" );
                TalkServerThread tst = new TalkServerThread( this );
                tst.start();
            }
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        if ( object == saveLogButton ) {
            
        }
    }
    
    public static void main( String[] args ) {
        TalkServer ts = new TalkServer();
        ts.init();
        Thread thread = new Thread( ts );
        thread.start();
    }
}
