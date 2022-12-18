package dept;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings( "serial" )
public class InsertDialog extends JDialog {
    protected JPanel centerPanel, southPanel;
    private JButton  button;
    String           cmd;
    
    public InsertDialog( DeptView view, String cmd ) {
        this.cmd = cmd;
        initialize( view );
    }
    
    private void initialize( DeptView view ) {
        String[] labelText = { "부서번호", "부서명", "지역" };
        
        centerPanel = new JPanel( new GridLayout( 3, 2 ) );
        
        for ( int i = 0; i < labelText.length; i++ ) {
            centerPanel.add( new JLabel( labelText[i] ) );
            centerPanel.add( new JTextField() );
        }
        
        button = new JButton( "CONFIRM" );
        button.addActionListener( view );
        button.setActionCommand( "CONFIRM" );
        southPanel = new JPanel();
        southPanel.add( button );
        
        this.add( "Center", centerPanel );
        this.add( "South", southPanel );
        this.setSize( 250, 200 );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        this.setVisible( true );
    }
}
