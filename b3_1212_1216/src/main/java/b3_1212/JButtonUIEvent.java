package b3_1212;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonUIEvent implements ActionListener {
    
    JButtonUI bear = null;
    
    public JButtonUIEvent( JButtonUI jButtonUI ) {
        this.bear = jButtonUI;
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object obj = e.getSource();
        
        if ( obj == bear.jbtn_south ) {
            System.out.println( bear.jbtn_south.getText() + "버튼 클릭" );
        }
    }
    
}
