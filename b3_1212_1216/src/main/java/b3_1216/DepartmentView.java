package b3_1216;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings( "serial" )
public class DepartmentView extends JFrame implements ActionListener {
    
    DepartmentDialog dialog;
    
    DepartmentController dc = DepartmentController.getInstance();
    // new 예약어를 써서 인스턴스화를 하는 방법이랑 method를 써서 인스턴스화 하는 방법이 있다.
    String[]           header  = { "부서번호", "부서명", "지역" };
    List<DepartmentVO> records = new Vector<>();
    // List Interface는 collection framework에 포함된다. List 밑에 List를 상속받는 class가 있다.
    // 대표적으로 ArrayList, Vector, LinkedList
    JButton[]         button;
    JPanel            northPanel, centerPanel;
    DefaultTableModel model      = new DefaultTableModel( header, 0 );
    JTable            table      = new JTable( model );
    JScrollPane       scrollPane = new JScrollPane( table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
    
    public DepartmentView() {
        init();
    }
    
    void init() {
        button = new JButton[4];
        northPanel = new JPanel();
        centerPanel = new JPanel();
        northPanel.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
        centerPanel.add( scrollPane );
        
        String[] buttonText = { "등록", "수정", "삭제", "상세보기" };
        
        for ( int i = 0; i < buttonText.length; i++ ) {
            button[i] = new JButton( buttonText[i] );
            button[i].addActionListener( this );
            northPanel.add( button[i] );
        }
        
        this.add( "Center", centerPanel );
        this.add( "North", northPanel );
        this.setSize( 700, 600 );
        this.setVisible( true );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        int    result = 0;
        
        if ( object == button[0] ) { // 등록
            result = dc.cudVO( new DepartmentVO( 10, "개발팀", "삼성역" ), "C" );
            
            // model.addRow( );
            if ( result == 1 ) {
                JOptionPane.showMessageDialog( this, "부서정보를 등록하였습니다." );
            }
            dialog = new DepartmentDialog( this, true );
        }
        
        else if ( object == button[1] ) { // 수정
            DepartmentVO temp = new DepartmentVO( Integer.parseInt( model.getValueAt( 0, 0 ).toString() ), model.getValueAt( 0, 1 ).toString(),
                            model.getValueAt( 0, 2 ).toString() );
            result = dc.cudVO( temp, "U" );
            
            if ( result == 1 ) {
                JOptionPane.showMessageDialog( this, "부서정보를 변경하였습니다." );
            }
        }
        
        else if ( object == button[2] ) { // 삭제
            DepartmentVO temp = new DepartmentVO( Integer.parseInt( model.getValueAt( 0, 0 ).toString() ), model.getValueAt( 0, 1 ).toString(),
                            model.getValueAt( 0, 2 ).toString() );
            result = dc.cudVO( temp, "D" );
            
            if ( result == 1 ) {
                JOptionPane.showMessageDialog( this, "부서정보를 삭제하였습니다." );
            }
        }
        else if ( object == button[3] ) { // 상세보기
            records = dc.getData();
            
            for ( DepartmentVO vo : records ) {
                String[] record = { vo.getDeptno() + "", vo.getdName(), vo.getLoc() };
                model.addRow( record );
            }
        }
        else if ( object == dialog.confirmButton ) {
            result = dc.cudVO( new DepartmentVO( Integer.parseInt( dialog.deptno_text.getText() ), dialog.dName_text.getText(), dialog.loc_text.getText() ), "C" );
            
            if ( result == 1 ) {
                JOptionPane.showMessageDialog( this, "등록 성공했습니다." );
            }
        }
        else if ( object == dialog.cancelButton ) {
            
        }
    }
    
    public static void main( String[] args ) {
        new DepartmentView(); // default constructor call
    }
}
