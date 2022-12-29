package lecture_2022_12.week_4_CRUD;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings( "serial" )
public class DeptViewMap extends JFrame implements ActionListener {
    
    List<Map<String, Object>> deptList = new Vector<>();
    Map<String, Object>       tMap;
    private JPanel            northPanel, centerPanel;
    private JButton           button;
    private DefaultTableModel model;
    private JTable            table;
    private JScrollPane       scrollPane;
    Font                      font     = new Font( "맑은 고딕", Font.PLAIN, 10 );
    IUDialog                  dialog;
    
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
    
    protected Map<String, Object> setTmap( int deptno, String dname, String loc ) {
        tMap = new HashMap();
        tMap.put( "deptno", deptno );
        tMap.put( "dname", dname );
        tMap.put( "loc", loc );
        return tMap;
    }
    
    protected List<Map<String, Object>> selectTeam() {
        
        deptList.add( setTmap( 10, "인사팀", "한남동" ) );
        deptList.add( setTmap( 20, "전산팀", "판교데이터센터" ) );
        deptList.add( setTmap( 30, "데이터팀", "삼성동" ) );
        log.info( deptList );
        return deptList;
    }
    
    public DeptViewMap() {
        init();
    }
    
    protected void getData() {
        
        while ( model.getRowCount() > 0 ) {
            model.removeRow( 0 );
        }
        
        List<Map<String, Object>> tempList = new Vector<>();
        
        tempList = selectTeam();
        log.info( tempList );
        
        if ( tempList.size() <= 0 ) {
            JOptionPane.showMessageDialog( this, "조회 결과가 없습니다.", "WARN", JOptionPane.WARNING_MESSAGE );
            return;
        }
        
        for ( int i = 0; i < tempList.size(); i++ ) {
            Object[] temp = { tempList.get( i ).get( "deptno" ), tempList.get( i ).get( "dname" ), tempList.get( i ).get( "loc" ) };
            log.info( temp );
            model.addRow( temp );
        }
    }
    
    protected int insertDept() {
        int result = 0;
        
        return result;
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        String cmd = e.getActionCommand();
        
        switch ( cmd ) {
            case "INSERT":
                break;
            
            case "SELECT":
                getData();
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
        new DeptViewMap();
        
    }
    
}
