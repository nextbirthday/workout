package b3_1216;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings( "serial" )
public class Button extends JFrame {
    
    JButton[] button;
    JPanel    northPanel, southPanel;
    
    public Button() {
        init();
    }
    
    public void init() {
        
        button = new JButton[3];
        northPanel = new JPanel();
        southPanel = new JPanel();
        String[] buttonText = { "입력", "수정", "삭제" };
        
        for ( int i = 0; i < buttonText.length; i++ ) {
            button[i] = new JButton( buttonText[i] );
            northPanel.add( button[i] );
            button[i] = new JButton( buttonText[i] );
            southPanel.add( button[i] );
        }
        
        for ( int i = 0; i < 3; i++ ) {
            northPanel.getComponent( i ).setBackground( Color.yellow );
            southPanel.getComponent( i ).setBackground( Color.yellow );
        }
        
        this.add( "North", northPanel );
        this.add( "South", southPanel );
        this.setSize( 600, 500 );
        this.setVisible( true );
    }
    
    public static void main( String[] args ) {
        new Button();
    }
}
