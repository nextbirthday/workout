package lecture_2022_12.week_4_Button;

import java.awt.Color;
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
public class DeptTable3 extends JFrame implements ActionListener {
    // JTable7Dialog에서 부서번호,부서명,지역을 입력한 후 저장버튼을 누르면
    // Vector<String[]>추가하고 추가된 row를 포함하는 Vector가 부모창에 새로 refresh되어야 하니까
    JTable7Dialog dialog = new JTable7Dialog( this );
    
    String header[]  = { "부서번호", "부서명", "지역" };
    String datas[][] = new String[0][3];
    
    DefaultTableModel     model        = new DefaultTableModel( datas, header );// 생성자 호출
    JTable                table        = new JTable( model );
    JScrollPane           jScroll      = new JScrollPane( table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
    JPanel                northPanel   = new JPanel();
    JButton               selectButton = new JButton( "조회" );
    JButton               insertButton = new JButton( "입력" );
    JButton               updateButton = new JButton( "수정" );
    JButton               deleteButton = new JButton( "삭제" );
    JButton               detailButton = new JButton( "상세보기" );
    static List<String[]> dataList     = new Vector<>(); // dataList.size() = 0;
    
    public DeptTable3() {
        initDisplay();
    }
    
    public void initDisplay() {
        northPanel.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
        
        selectButton.addActionListener( this );
        insertButton.addActionListener( this );
        updateButton.addActionListener( this );
        deleteButton.addActionListener( this );
        detailButton.addActionListener( this );
        
        northPanel.add( selectButton );
        northPanel.add( insertButton );
        northPanel.add( updateButton );
        northPanel.add( deleteButton );
        northPanel.add( detailButton );
        
        selectButton.setBackground( new Color( 158, 9, 9 ) );
        selectButton.setForeground( Color.WHITE );
        insertButton.setBackground( new Color( 19, 99, 57 ) );
        insertButton.setForeground( Color.WHITE );
        updateButton.setBackground( new Color( 54, 54, 54 ) );
        updateButton.setForeground( Color.WHITE );
        deleteButton.setBackground( new Color( 7, 84, 170 ) );
        deleteButton.setForeground( Color.WHITE );
        detailButton.setBackground( new Color( 100, 81, 190 ) );
        detailButton.setForeground( Color.WHITE );
        
        this.add( "North", northPanel );
        this.add( "Center", jScroll );
        this.setTitle( "부서관리시스템 Ver1.0" );
        this.setSize( 700, 600 );
        this.setVisible( true );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    
    // 새로고침 - Vector에 담긴 String[] 출력하기
    // 입력, 수정화면에서 저장 버튼 누르면 Vector에 String[]추가하고 그 다이얼로그 화면은 닫히고
    // 부모창은 새로고침 처리한다. 다이얼로그 창에서 부모클래스의 refreshData 메서드를 호출해야함
    // 그러니까 인스턴스화 할 때 파라미터에 this를 넘겨서 사용할수 있도록 한 것.
    
    public void refreshData() {
        System.out.println( "refreshData method call" );
        
        if ( DeptTable3.dataList.size() <= 0 ) {
            JOptionPane.showMessageDialog( this, "조회결과가 없습니다", "INFO", JOptionPane.WARNING_MESSAGE );
            return; // refreshData() method exit
        }
        
        // 입력, 수정 전에 조회된 정보는 삭제함
        while ( model.getRowCount() > 0 ) {
            model.removeRow( 0 );
        }
        
        // List의 크기만큼 반복하면서 DefaultTableModel model 데이터셋에 String[] 추가함
        for ( int i = 0; i < dataList.size(); i++ ) {
            String[] oneRow = dataList.get( i );
            model.addRow( oneRow );
        }
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        if ( object == selectButton ) { // 조회
            refreshData();
        }
        
        if ( object == insertButton ) { // 입력
            dialog.set( "입력", true, null );
        }
        else if ( object == updateButton ) { // 수정
            // getSelectedRow - JTable 목록에서 선택한 row의 index 값을 가져온다.
            // DataSet 객체로 List를 사용중이니 List에서 꺼낸 값을 String[]로 초기화
            int      index  = table.getSelectedRow();
            String[] oneRow = dataList.get( index );
            
            dialog.set( "수정", true, oneRow );
        }
        else if ( object == detailButton ) {// 상세보기
            int      index  = table.getSelectedRow();
            String[] oneRow = dataList.get( index );
            
            dialog.set( "상세보기", true, oneRow );
        }
    }
    
    public static void main( String[] args ) {
        new DeptTable3();
    }
}
