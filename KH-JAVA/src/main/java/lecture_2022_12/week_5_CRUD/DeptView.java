package lecture_2022_12.week_5_CRUD;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings( "serial" )
public class DeptView extends JFrame implements ActionListener {
    
    public DeptView() {
        init();
    }
    
    private JPanel            northPanel, centerPanel;
    private JButton           button;
    private DefaultTableModel model;
    private JTable            table;
    private JScrollPane       scrollPane;
    Font                      font       = new Font( "맑은 고딕", Font.PLAIN, 10 );
    DeptController            controller = new DeptController();
    IUDialog                  dialog;
    
    protected void getDept() {
        
        while ( model.getRowCount() > 0 ) {
            model.removeRow( 0 );
        }
        List<Map<String, Object>> tempList = controller.getDept();
        log.info( tempList );
        
        for ( int i = 0; i < tempList.size(); i++ ) {
            Object[] temp = { tempList.get( i ).get( "deptno" ), tempList.get( i ).get( "dname" ), tempList.get( i ).get( "loc" ) };
            model.addRow( temp );
        }
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
                getDept();
                break;
            
            case "INSERT":
                dialog = new IUDialog( this );
                break;
            
            case "UPDATE":
                dialog = new IUDialog( this );
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
