package b3_1206;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomGameView {
    // 선언부
    JFrame  jf_game    = new JFrame();
    JPanel  jp_east    = new JPanel();
    JButton jbtn_new   = new JButton( "새 게임" );
    JButton jbtn_dap   = new JButton( "정답" );
    JButton jbtn_clear = new JButton( "지우기" );
    JButton jbtn_exit  = new JButton( "종료" );
    
    // 생성자 - 파라미터가 없는 생성자를 디폴트 생성자라 함 - 생략 가능함
    public RandomGameView() { // 그러나 화면을 그리는 메서드 호출하기 위해서 굳이 선언하였음
        initDisplay(); // 내 안에 있는 메서드이므로 인스턴스화 없이도 가능하다.
    }
    
    // 화면그리기 구현
    public void initDisplay() {
        // 동쪽에 붙일 속지의 layout을 설정함
        // 메서드의 파라미터로 객체를 생성함 - 왜냐하면 딱 한 번만 호출하니까
        //jp_east.setLayout( new GridLayout( 4, 1 ) );
        GridLayout layout = new GridLayout(4,1);
        jp_east.setLayout(layout); //메서드 호출 시 파라미터로 객체생성구문 가능
        
        jp_east.add( jbtn_new );
        jp_east.add( jbtn_dap );
        jp_east.add( jbtn_clear );
        jp_east.add( jbtn_exit );
        jf_game.add( "East", jp_east );
        jf_game.setSize( 450, 400 );
        jf_game.setVisible( true );
    }
    
    // 메인 메서드
    public static void main( String[] args ) {
        new RandomGameView();
    }
    
}
