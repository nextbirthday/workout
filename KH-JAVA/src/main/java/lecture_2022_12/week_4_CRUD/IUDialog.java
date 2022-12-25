package lecture_2022_12.week_4_CRUD;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings( "serial" )
public class IUDialog extends JDialog {
    DeptView view;
    
    public IUDialog() {}
    
    public IUDialog( DeptView view ) {
        this.view = view;
        init();
    }
    
    private JButton saveButton   = new JButton( "SAVE" );
    private JButton closeButton  = new JButton( "CLOSE" );
    private JPanel  centerPanel, southPanel;
//    private JLabel  teamNumLabel = new JLabel();
//    
//    private JLabel  teamNumLabel = new JLabel();
//    
//    private JLabel  teamNumLabel = new JLabel();
//    
//    private JLabel  teamNumLabel = new JLabel();
    
    private void init() {
        southPanel = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        centerPanel = new JPanel();
        
        southPanel.add( saveButton );
        southPanel.add( closeButton );
        this.add( "Center", centerPanel );
        this.add( "South", southPanel );
        this.setSize( 500, 400 );
        this.setVisible( true );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
    }
}
