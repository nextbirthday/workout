package lecture_2022_12.week_4_List;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings( "serial" )
public class DepartmentUI extends JFrame implements ActionListener {
    JPanel            northpanel, centerPanel;
    JButton           button;
    DefaultTableModel model;
    JTable            table;
    JScrollPane       scrollPane;
    
    Vector<DepartmentDTO> dataBase = new Vector<>();
    
    public DepartmentUI() {
        initialize();
    }
    
    private Vector<DepartmentDTO> dataInitialize() {
        dataBase.add( new DepartmentDTO( 10, "인사부", "서울" ) );
        dataBase.add( new DepartmentDTO( 20, "영업부", "안양" ) );
        dataBase.add( new DepartmentDTO( 30, "개발부", "대전" ) );
        dataBase.add( new DepartmentDTO( 40, "사업부", "대구" ) );
        dataBase.add( new DepartmentDTO( 50, "총무부", "제주" ) );
        return dataBase;
    }
    
    public Vector<DepartmentDTO> selectDeptList() {
        
        dataInitialize();
        
        return dataBase;
    }
    
    public int insertDeptList() {
        int result = 0;
        
        return result;
    }
    
    private void initialize() {
        northpanel = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        northpanel.setBackground( Color.ORANGE );
        
        String[] buttonText = { "SELECT", "INSERT", "UPDATE", "DELETE", "CLOSE" };
        Font     font       = new Font( "맑은 고딕", Font.BOLD, 15 );
        
        for ( int i = 0; i < buttonText.length; i++ ) {
            button = new JButton( buttonText[i] );
            button.setFont( font );
            button.setActionCommand( buttonText[i] );
            button.addActionListener( this );
            northpanel.add( button );
        }
        centerPanel = new JPanel();
        String[] columnNames = { "부서번호", "부서명", "지역" };
        model = new DefaultTableModel( columnNames, 0 );
        table = new JTable( model );
        scrollPane = new JScrollPane( table );
        centerPanel.add( scrollPane );
        
        this.add( "North", northpanel );
        this.add( "Center", centerPanel );
        this.setSize( 700, 600 );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.setVisible( true );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        String cmd = e.getActionCommand();
        
        switch ( cmd ) {
            case "SELECT":
                
                // if ( model.getRowCount() > 0 ) {
                //
                // for ( int i = model.getRowCount() - 1; i >= 0; i-- ) {
                // model.removeRow( 0 );
                // }
                // }
                while ( model.getRowCount() > 0 ) {
                    model.removeRow( 0 );
                }
                Vector<DepartmentDTO> records = dataInitialize();
                
                for ( DepartmentDTO dto : records ) { // 자료형 변수명 : 배열명
                    Object[] row = { dto.getDeptno(), dto.getDname(), dto.getLoc() };
                    model.addRow( row );
                }
                
                break;
            
            case "CLOSE":
                this.dispose();
                break;
            
            default:
                break;
        }
        
    }
    
    public static void main( String[] args ) {
        new DepartmentUI();
    }
}
