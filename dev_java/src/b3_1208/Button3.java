package b3_1208;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Button3 {
    JFrame    jtf   = new JFrame();
    JButton[] jbtns = new JButton[3];
    // String[] jbtn_label = new String[] {"북쪽", "서쪽", "중앙"};
    String[] jbtn_label = { "북쪽", "서쪽", "중앙" };
    String[] jbtn_loc   = { "North", "West", "Center" };
    
    public void initDisplay() {
        
        for ( int i = 0; i < jbtns.length; i++ ) {
            jbtns[i] = new JButton( jbtn_label[i] );
            jtf.add( jbtn_loc[i], jbtns[i] );
        }
        jtf.setSize( 400, 300 );
        jtf.setVisible( true );
    }
    
    public static void main( String[] args ) {
        Button3 button3 = new Button3();
        button3.initDisplay();
    }
}
