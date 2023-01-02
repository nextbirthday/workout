package lecture_2022_12.week_5_CRUD02;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import lecture_2022_12.week_4_Button.DepartmentView;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings( "serial" )
public class DeptView02 extends JFrame implements ActionListener {
    
    public DeptView02() {
        init();
    }
    
    private JPanel            northPanel, centerPanel;
    private JButton           button;
    private DefaultTableModel model;
    private JTable            table;
    private JScrollPane       scrollPane;
    Font                      font       = new Font( "맑은 고딕", Font.PLAIN, 10 );
    DeptController02          controller = new DeptController02();
    
    protected void getDept() {
        
        while ( model.getRowCount() > 0 ) {
            model.removeRow( 0 );
        }
        
        List<DeptVO02> deptList = controller.getDept();
        
        for ( DeptVO02 dept : deptList ) {
            Object[] temp = { dept.deptno, dept.dname, dept.loc };
            model.addRow( temp );
        }
        
        if ( model.getRowCount() <= 0 ) {
            JOptionPane.showMessageDialog( this, "조회 결과가 없습니다.", "WARN", JOptionPane.WARNING_MESSAGE );
            return;
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
        new DeptView02();
    }
}
