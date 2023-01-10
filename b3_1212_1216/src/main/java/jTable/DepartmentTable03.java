package jTable;

import java.awt.Color;
import java.awt.FlowLayout;
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
public class DepartmentTable03 extends JFrame implements ActionListener {
    
    String            header[]     = { "부서번호", "부서명", "지역" };
    String            datas[][]    = new String[0][3];
    DefaultTableModel dtm_dept     = new DefaultTableModel( datas, header ); // constructor call
    JTable            jtb_dept     = new JTable( dtm_dept );
    JScrollPane       jsp_dept     = new JScrollPane( jtb_dept, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
    JPanel            northPanel   = new JPanel(); // 버튼을 붙일 속지 선언
    JButton           searchButton = new JButton( "조회" );
    JButton           insertButton = new JButton( "입력" );
    JButton           modifyButton = new JButton( "수정" );
    JButton           deleteButton = new JButton( "삭제" );
    
    String[][] depts = { { "10", "개발부", "서울" }, { "20", "인사부", "인천" }, { "30", "총무부", "부산" } };
    
    public DepartmentTable03() {
        initDisplay();
    }
    
    public void initDisplay() {
        this.setTitle( "부서관리 시스템 ver 1.0" );
        northPanel.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
        searchButton.addActionListener( this );
        insertButton.addActionListener( this );
        modifyButton.addActionListener( this );
        deleteButton.addActionListener( this );
        
        northPanel.add( searchButton );
        northPanel.add( insertButton );
        northPanel.add( modifyButton );
        northPanel.add( deleteButton );
        
        searchButton.setBackground( Color.green );
        searchButton.setForeground( Color.black );
        insertButton.setBackground( Color.cyan );
        insertButton.setForeground( Color.black );
        modifyButton.setBackground( Color.orange );
        modifyButton.setForeground( Color.black );
        deleteButton.setBackground( Color.red );
        deleteButton.setForeground( Color.black );
        
        this.add( "Center", jsp_dept );
        this.add( "North", northPanel );
        this.setSize( 500, 400 );
        this.setVisible( true );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        if ( object == deleteButton ) {
            int index = jtb_dept.getSelectedRow();
            System.out.println( index );
            Integer deptno = Integer.parseInt( ( String ) dtm_dept.getValueAt( index, 0 ) );
            dtm_dept.removeRow( index );
            System.out.println( deptno );
        }
        
        if ( object == searchButton ) {// 너 조회버튼 누른거야?
            
            for ( int x = 0; x < depts.length; x++ ) {
                Vector<String> oneRow = new Vector<>();
                oneRow.add( depts[x][0] );
                oneRow.add( depts[x][1] );
                oneRow.add( depts[x][2] );
                dtm_dept.addRow( oneRow );
            }
            
            for ( int i = 0; i < depts.length; i++ ) {
                
                for ( int j = 0; j < depts[i].length; j++ ) {
                    // System.out.print(depts[i][j] + " ");// ln을 빼서 3개출력하고 줄바꿈처리
                    // dtm_dept.setValueAt( "여기", 0, 1 ); // setValueAt
                    // System.out.println( dtm_dept.getValueAt( i, j ) );
                }
                System.out.println();
            }
        }
    }
    
    public static void main( String[] args ) {
        new DepartmentTable03();
    }
    
}
