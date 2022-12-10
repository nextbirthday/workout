package b3_1208;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class RandomGameView implements ActionListener{
    // field
    
    JFrame  jf          = new JFrame();
    JButton jbtn_north  = new JButton( "북쪽" ); // 생성자 파라미터는 String
    JButton jbtn_south  = new JButton( "남쪽" ); // 생성자 파라미터는 String
    JButton jbtn_east   = new JButton( "동쪽" ); // 생성자 파라미터는 String
    JButton jbtn_west   = new JButton( "서쪽" ); // 생성자 파라미터는 String
    JButton jbtn_center = new JButton( "중앙" ); // 생성자 파라미터는 String
    
    // constructor
    public RandomGameView() {
        System.out.println( "디폴트 생성자 호출 성공" );
        initDisplay();
    }
    
    // 화면 처리부
    public void initDisplay() {
        System.out.println( "initDisplay 호출 성공" );
        //배치할 때 생략하거나 쓰지않으면 center box가 다 잡아먹는다.
        //jf.add( "North", jbtn_north );
        jf.add( "South", jbtn_south );
        jf.add( "East", jbtn_east );
        jf.add( "West", jbtn_west );
        jf.add( "Center", jbtn_center );
        
        boolean isPower = true;
        jf.setSize( 500, 1000 );
        jf.setVisible( isPower );
    }
    
    public static void main( String[] args ) {
        
        new RandomGameView();
        // 선언부 없이 생성자만 호출 할 수 있다. 인스턴스변수를 재사용할 일이 없다면 괜찮다.
        // new RandomGameView(); 인스턴스화 할 때마다 복사본이 만들어진다.
        // new RandomGameView(); 객체가 3개가 만들어진 것이고 주소번지도 각각 다르다.
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        //눌린 버튼의 문자열을 읽어온다.
        System.out.println( e.getActionCommand() );   
        // 눌린 버튼의 주소번지를 가져온다.
        System.out.println( e.getSource() );
    }
    
}
