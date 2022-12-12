package b3_1212;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonUI {
    
    // field
    JFrame         jf         = new JFrame(); // 창을 띄우는 class
    JButton        jbtn_south = new JButton( "전송" );
    JButtonUIEvent jbtnEvent  = new JButtonUIEvent(this);
    
    // constructor
    public JButtonUI() {
        initDisplay();
    }
    
    // view method
    public void initDisplay() {
        // event 소스와 event 핸들러 매핑시 this를 쓸 수 있는 건
        // 오직 내안에 actionPerformed가 구현되어 있을 때 뿐이다.
        jbtn_south.addActionListener( jbtnEvent );
        
        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        jf.add( "South", jbtn_south );
        jf.setSize( 500, 600 );
        jf.setVisible( true );
    }
    
//    // main
//    public static void main( String[] args ) {
//        new JButtonUI();
//    }
    
}
