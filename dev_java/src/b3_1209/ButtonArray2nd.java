package b3_1209;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout; // abstract window toolkit
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButtonArray2nd implements ActionListener {
    
    // 선언부
    JFrame jf        = new JFrame();
    JPanel jp_center = new JPanel();
    JPanel jp_east   = new JPanel();
    
    JTextArea   jta_display = new JTextArea( 10, 20 );
    JScrollPane jsp_display = new JScrollPane( jta_display );
    JTextField  jtf_input   = new JTextField();
    
    JButton jbtn = new JButton();
    /*
     * JButton jbtn_newButton = new JButton( "새 게임" );
     * JButton jbtn_dapButton = new JButton( "정답" );
     * JButton jbtn_clearButton = new JButton( "지우기" );
     * JButton jbtn_exitButton = new JButton( "종료" );
     */
    
    // 배열 처리
    JButton[] jbtns       = new JButton[4];
    String[]  jbtns_label = { "새 게임", "정답", "지우기", "종료" };
    
    // 생성자
    public ButtonArray2nd() { // 생성자는 클래스 이름과 동일 파라미터가 없으면 디폴트 생성자 //non-static영역이므로 method 호출가능
        System.out.println( "디폴트 생성자 호출" );
        // event src와 event 처리를 담당하는 핸들러 클래스를 맵핑하기
        jtf_input.addActionListener( this );
        
        initDisplay();
    }
    
    // 화면그리기
    public void initDisplay() {
        System.out.println( "화면그리기 호출" );
        
        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); // 가상머신과 연결 끊기
        
        jp_center.setLayout( new BorderLayout() );
        jp_center.add( "Center", jsp_display );
        jp_center.add( "South", jtf_input );
        jp_east.setLayout( new GridLayout( 4, 1, 2, 2 ) ); // setLayout 위치
        
        jf.add( "Center", jp_center );
        jf.add( "East", jp_east );
        
        for ( int i = 0; i < jbtns.length; i++ ) {
            jbtns[i] = new JButton( jbtns_label[i] );
            jbtns[i].addActionListener( this );
            jp_east.add( jbtns[i] );
        }
        
        jp_center.setBackground( Color.green );
        jbtns[0].setBackground( Color.yellow );
        jbtns[0].setForeground( null );
        
        jbtns[1].setBackground( Color.yellow );
        jbtns[1].setForeground( null );
        
        jbtns[2].setBackground( Color.yellow );
        jbtns[2].setForeground( null );
        
        jbtns[3].setBackground( Color.yellow );
        jbtns[3].setForeground( null );
        
        jf.setSize( 400, 300 );
        jf.setVisible( true );
    }
    
    @Override // Callback Method
    public void actionPerformed( ActionEvent e ) {
        // e.getSource는 이벤트가 감지되는 컴포넌트(JTextField)의 주소번지를 반환함
        Object obj = e.getSource();
        
        if ( jbtns[0] == obj ) {
            jta_display.append( "★★★새 게임을 시작합니다.★★★\n" );
        }
        else if ( jbtns[1] == obj ) {
            jta_display.append( "정답은 ???입니다." );
        }
        else if ( jbtns[2] == obj ) {
            jta_display.setText( "" );
        }
        else if ( jbtns[3] == obj ) {
            // 창 하나씩 닫고 싶을 때 jf.dispose();
            System.exit( 0 ); // 전부 한 번에 닫을 때
        }
        // 너 JTextField에서 엔터 친거야?
        else if ( jtf_input == obj ) {
            // 사용자가 텍스트 필드에 입력하면
            String input = jtf_input.getText();
            jta_display.append( input + "\n" ); // 줄 바꿈 처리 \n
            jtf_input.setText( "" );
        }
    }
    
    // 메인메서드
    public static void main( String[] args ) {
        new ButtonArray2nd();
    }
}
