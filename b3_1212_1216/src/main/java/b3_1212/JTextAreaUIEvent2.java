package b3_1212;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextAreaUIEvent2 implements ActionListener {
    JTextAreaUI2 jtaUI2 = null;
    
    public JTextAreaUIEvent2( JTextAreaUI2 jui2 ) {
        this.jtaUI2 = jui2;
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object obj = e.getSource();
        
        if ( jtaUI2.jtf == obj) {
            String input = jtaUI2.jtf.getText();
            jtaUI2.jtaUILogic2.account( input );
            jtaUI2.jtf.setText( "" );
        }
    }
    
}
