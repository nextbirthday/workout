package b3_1208;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Button2 {
    JFrame  jtf         = new JFrame();
    JButton jbtn_north  = new JButton( "북쪽" );
    JButton jbtn_west   = new JButton( "서쪽" );
    JButton jbtn_center = new JButton( "중앙" );
    
    public void initDisplay() {
        jtf.add( "North", jbtn_north );
        jtf.add( "West", jbtn_west );
        jtf.add( "Center", jbtn_center );
        jtf.setSize( 400, 300 );
        jtf.setVisible( true );
        
    }
    
    public static void main( String[] args ) {
        Button2 button2 = new Button2();
        button2.initDisplay();
    }
    
}
