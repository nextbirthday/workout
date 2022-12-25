package b3_1214;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings( "serial" )
public class JFrameRepaint extends JFrame implements ActionListener {
    
    JPanel    jp      = new JPanel(); 
    JTextArea jta     = new JTextArea( "JTextArea", 10, 20 );
    JButton   jButton = new JButton( "화면 변경" );
    
    public JFrameRepaint() {
        initDisplay(); 
    }
    
    void methodA() {
        
    }
    
    public void initDisplay() {
        jButton.addActionListener( this );
        jp.setLayout( new BorderLayout() );
        jp.add( "Center", jta );
        this.add( "Center", jp ); 
        this.add( "North", jButton );
        this.setSize( 400, 300 );
        this.setVisible( true );        
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object obj = e.getSource();
        if(obj == jButton) {
            Container con = this.getContentPane();
            if(jp != null) {
                con.remove( jp );
                con.remove( jButton );
            }
            JPanel jp1 = new JPanel();
            jp1.setBackground( Color.orange );
            this.add( "Center", jp1 );
            con.revalidate();
        }
    }
    
    public static void main( String[] args ) {
        new JFrameRepaint();
    }
}
