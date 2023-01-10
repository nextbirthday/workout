package b3_1216;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings( "serial" )
public class Button02 extends JFrame {
    String[]  buttonText   = { "입력", "수정", "삭제" };
    JButton   insertButton = new JButton( buttonText[0] );
    JButton   updateButton = new JButton( buttonText[1] );
    JButton   deleteButton = new JButton( buttonText[2] );
    JButton[] button       = { insertButton, updateButton, deleteButton };
    
    JPanel          northPanel   = new JPanel();;
    Vector<JButton> vectorButton = new Vector<>( buttonText.length );
    
    public Button02() {
        init();
    }
    
    public void init() {
        
        for ( int i = 0; i < vectorButton.size(); i++ ) {
            vectorButton.add( button[i] );
            northPanel.add( vectorButton.get( i ) );
        }
        
        // for ( int i = 0; i < buttonText.length; i++ ) {
        // button[i] = new JButton( buttonText[i] );
        // vectorButton.add( button[i] );
        // northPanel.add( vectorButton.get( i ) );
        // }
        this.add( "North", northPanel );
        this.setSize( 600, 500 );
        this.setVisible( true );
    }
    
    public static void main( String[] args ) {
        new Button02();
        
    }
}