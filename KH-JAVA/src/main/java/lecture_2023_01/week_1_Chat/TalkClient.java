package lecture_2023_01.week_1_Chat;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings( "serial" )
public class TalkClient extends JFrame implements ActionListener {
    
    Socket             socket;
    ObjectOutputStream oos;
    ObjectInputStream  ois;
    
    String nickName = null;
    
    JPanel            jp_second       = new JPanel();
    JPanel            jp_second_south = new JPanel();
    JButton           jbtn_one        = new JButton( "1:1" );
    JButton           jbtn_change     = new JButton( "대화명변경" );
    JButton           jbtn_font       = new JButton( "글자색" );
    JButton           jbtn_exit       = new JButton( "나가기" );
    String            cols[]          = { "대화명" };
    String            data[][]        = new String[0][1];
    DefaultTableModel dtm             = new DefaultTableModel( data, cols );
    JTable            jtb             = new JTable( dtm );
    JScrollPane       jsp             = new JScrollPane( jtb );
    JPanel            jp_first        = new JPanel();
    JPanel            jp_first_south  = new JPanel();
    JTextField        jtf_msg         = new JTextField( 20 );// south속지 center
    JButton           jbtn_send       = new JButton( "전송" );// south속지 east
    JTextArea         jta_display     = new JTextArea( 15, 38 );
    JScrollPane       jsp_display     = new JScrollPane( jta_display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
    
    public void initDisplay() {
        jtf_msg.addActionListener( this );
        // 사용자의 닉네임 받기
        nickName = JOptionPane.showInputDialog( "닉네임을 입력하세요." );
        this.setLayout( new GridLayout( 1, 2 ) );
        jp_second.setLayout( new BorderLayout() );
        jp_second.add( "Center", jsp );
        jp_second_south.setLayout( new GridLayout( 2, 2 ) );
        jp_second_south.add( jbtn_one );
        jp_second_south.add( jbtn_change );
        jp_second_south.add( jbtn_font );
        jp_second_south.add( jbtn_exit );
        jp_second.add( "South", jp_second_south );
        jp_first.setLayout( new BorderLayout() );
        jp_first_south.setLayout( new BorderLayout() );
        jp_first_south.add( "Center", jtf_msg );
        jp_first_south.add( "East", jbtn_send );
        jta_display.setLineWrap( true );
        jp_first.add( "Center", jsp_display );
        jp_first.add( "South", jp_first_south );
        this.add( jp_first );
        this.add( jp_second );
        this.setSize( 800, 550 );
        this.setVisible( true );
    }
    
    protected void connection() {
        
        try {
            socket = new Socket( "localhost", 30000 );
            oos = new ObjectOutputStream( socket.getOutputStream() );
            ois = new ObjectInputStream( socket.getInputStream() );
            
            // 서버에게 내가 입장한 사실을 알리기.
            oos.writeObject( 100 + ChatProtocol.separator + nickName );
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        
    }
    
    public static void main( String[] args ) {
        TalkClient tc = new TalkClient();
        tc.initDisplay();
    }
}
