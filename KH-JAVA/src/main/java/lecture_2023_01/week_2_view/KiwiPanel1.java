package lecture_2023_01.week_2_view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings( "serial" )
public class KiwiPanel1 extends JPanel implements ActionListener {
    // JDialog, JFrame은 default Layout이 BorderLayout
    // JPanel은 디폴트레이아웃이 플로우레이아웃이다.
    
    JButton jbtn1 = new JButton( "배경화면" );
    JButton jbtn2 = new JButton( "폰트" );
    JButton jbtn3 = new JButton( "폰트 크기" );
    // Font font를 static으로 선언한 이유는 1번 패널에서 결정된 설정이 패널2에도, 패널3에도 반영되어야 하니까
    public static Font    font;
    public static boolean isSize = false;
    
    /**
     * 1. 생성자는 필요한가 ?
     * 2. 생성자가 필요하다면 파라미터의 유, 무는?
     * 3. 파라미터가 필요하다고 생각했다면 어떤 타입이 왜 와야 하는지?
     * 생성자 안에서 initDisplay();를 호출하는 것과 그렇지 않은것의 차이는 무엇일까?
     * 위치의 문제이며 화면 정의서의 요구 사항에 따라서 다른 선택이 되어야한다.
     */
    public KiwiPanel1() {
        initDisplay();
    }
    
    public void initDisplay() {
        this.setLayout( null );
        // setBounds(가로위치, 세로위치, 길이, 폭)
        jbtn1.setBounds( 140, 80, 120, 30 );
        jbtn2.setBounds( 140, 150, 120, 30 );
        jbtn3.setBounds( 140, 220, 120, 30 );
        
        this.add( jbtn1 );
        this.add( jbtn2 );
        this.add( jbtn3 );
        jbtn1.addActionListener( this );
        jbtn2.addActionListener( this );
        jbtn3.addActionListener( this );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        if ( object == jbtn3 ) {
            
            if ( !isSize ) {
                font = new Font( "굴림체", Font.BOLD, 16 );
                jbtn1.setFont( font );
                jbtn2.setFont( font );
                jbtn3.setFont( font );
                isSize = true;
                System.out.println( isSize );
            }
            else {
                font = new Font( "굴림체", Font.PLAIN, 12 );
                jbtn1.setFont( font );
                jbtn2.setFont( font );
                jbtn3.setFont( font );
                isSize = false;
                System.out.println( isSize );
            }
        }
    }
    
    public static void main( String[] args ) {
        KiwiPanel1 test = new KiwiPanel1();
        test.initDisplay();
    }
}
