package lecture_2022_12.week_4_Button;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import lecture_2022_12.week_4_List.DepartmentDTOBuilder;

@SuppressWarnings( "serial" )
public class DepartmentView extends JFrame implements ActionListener {
    // field
    
    InsertDialog dialog = new InsertDialog( this );
    
    String[]   header = { "부서번호", "부서명", "지역" };
    String[][] datas  = new String[0][3];
    
    DefaultTableModel model      = new DefaultTableModel( datas, header );
    JTable            table      = new JTable( model );
    JScrollPane       scrollPane = new JScrollPane( table );
    JPanel            northPanel = new JPanel();
    
    JButton selectButton = new JButton( "조회" );
    JButton insertButton = new JButton( "입력" );
    JButton updateButton = new JButton( "수정" );
    JButton deleteButton = new JButton( "삭제" );
    JButton detailButton = new JButton( "상세보기" );
    
    static Vector<DepartmentDTOBuilder> dataBase = new Vector<>();
    
    public DepartmentView() {
        init();
    }
    
    public void init() {
        northPanel.setBackground( Color.ORANGE );
        insertButton.addActionListener( this );
        updateButton.addActionListener( this );
        deleteButton.addActionListener( this );
        selectButton.addActionListener( this );
        detailButton.addActionListener( this );
        
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        northPanel.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
        
        northPanel.add( selectButton );
        northPanel.add( insertButton );
        northPanel.add( updateButton );
        northPanel.add( deleteButton );
        northPanel.add( detailButton );
        
        this.add( "North", northPanel );
        this.add( "Center", scrollPane );
        this.setTitle( "부서관리시스템 ver1.0" );
        this.setSize( 600, 500 );
        this.setVisible( true );
    }
    
    public void refreshData() {
        System.out.println( "refreshData method call" );
        
        while ( model.getRowCount() > 0 ) {
            model.removeRow( 0 );
        }
        
        if ( DepartmentView.dataBase.size() <= 0 ) {
            JOptionPane.showMessageDialog( this, "조회 결과가 없습니다.", "WARN", JOptionPane.WARNING_MESSAGE );
            return;
        }
        System.out.println( "DepartmentView : " + dataBase.size() );
        
        for ( int i = 0; i < dataBase.size(); i++ ) {
            DepartmentDTOBuilder record     = DepartmentView.dataBase.get( i );
            Vector<Object>       tempVector = new Vector<>();
            tempVector.add( record.getDeptno() );
            tempVector.add( record.getDname() );
            tempVector.add( record.getLoc() );
            model.addRow( tempVector );
        }
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        if ( object == selectButton ) {
            refreshData();
        }
        
        if ( object == insertButton ) {
            dialog.set( "입력", true, null, true );
        }
        
        else if ( object == updateButton ) {
            // JTable 목록에서 선택한 row의 index 값을 가져옴
            int index = table.getSelectedRow();
            // DataSet Object로 Vector를 사용중이니 Vector에서 꺼낸 값을 String[] 초기화
            DepartmentDTOBuilder dto = dataBase.get( index );
        }
    }
    
    public static void main( String[] args ) {
        new DepartmentView();
    }
    
}
