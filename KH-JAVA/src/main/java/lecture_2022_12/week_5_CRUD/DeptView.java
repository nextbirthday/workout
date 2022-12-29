package lecture_2022_12.week_5_CRUD;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings( "serial" )
public class DeptView extends JFrame implements ActionListener {
    private JPanel            northPanel, centerPanel;
    private JButton           button;
    private DefaultTableModel model;
    private JTable            table;
    private JScrollPane       scrollPane;
    Font                      font = new Font( "맑은 고딕", Font.PLAIN, 10 );
    
    public DeptView() {
        init();
    }
    
    public void init() {
        northPanel = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        centerPanel = new JPanel();
        northPanel.setBackground( Color.cyan );
        
        String[] buttonText = { "INSERT", "SELECT", "UPDATE", "DELETE", "CLOSE" };
        
        for ( int i = 0; i < buttonText.length; i++ ) {
            button = new JButton( buttonText[i] );
            button.addActionListener( this );
            northPanel.add( button );
        }
        String[] columnNames = { "deptno", "dname", "loc" };
        model = new DefaultTableModel( columnNames, 0 );
        table = new JTable( model );
        scrollPane = new JScrollPane( table );
        centerPanel.add( scrollPane );
        this.add( "North", northPanel );
        this.add( "Center", centerPanel );
        this.setSize( 800, 700 );
        this.setVisible( true );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        String cmd = e.getActionCommand();
        
        switch ( cmd ) {
            
            case "SELECT":
                break;
            
            case "INSERT":
                break;
            
            case "UPDATE":
                
                break;
            
            case "DELETE":
                break;
            
            case "CLOSE":
                this.dispose();
                break;
        }
    }
    
    public static void main( String[] args ) {
        new DeptView();
    }
}
