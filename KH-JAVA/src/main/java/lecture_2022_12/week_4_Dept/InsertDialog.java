package lecture_2022_12.week_4_Dept;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings( "serial" )
public class InsertDialog extends JDialog {
    
    JPanel  centerPanel, southPanel;
    JButton button;
    String  cmd;
    
    public InsertDialog() {}
    
    public InsertDialog( DeptView view, boolean isView, String cmd ) {
        this.cmd = cmd;
        initialize( view, isView );
    }
    
    public void initialize( DeptView view, boolean isView ) {
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
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        this.setSize( 400, 300 );
        this.setVisible( isView );
    }
}
