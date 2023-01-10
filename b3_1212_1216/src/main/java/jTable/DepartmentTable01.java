package jTable;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings( "serial" )
public class DepartmentTable01 extends JFrame { // DepartmentTable01 is a JFrame
    
    String[]          header   = { "부서번호", "부서명", "지역" };
    String[][]        data     = new String[1][3];
    DefaultTableModel dtm_dept = new DefaultTableModel( data, header ); // constructor call
    JTable            jtb_dept = new JTable( dtm_dept );
    JScrollPane       jsp_dept = new JScrollPane( jtb_dept, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
    JButton           button;
    
    JPanel northPanel = new JPanel(); // 버튼을 붙일 속지 선언
    
    // { {"","",""}, {"","",""}, {"","",""} };
    
    public DepartmentTable01() {
        initDisplay();
    }
    
    public void initDisplay() {
        this.add( "Center", jsp_dept );
        this.add( "North", northPanel );
        northPanel.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
        this.setTitle( "부서관리 시스템 ver 1.0" );
        this.setSize( 500, 400 );
        this.setVisible( true );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        
        String[] buttonText = { "조회", "입력", "수정", "삭제" };
        
        for ( int i = 0; i < buttonText.length; i++ ) {
            button = new JButton( buttonText[i] );
            northPanel.add( button );
            button.setBackground( Color.red );
            button.setForeground( Color.white );
        }
    }
    
    public static void main( String[] args ) {
        new DepartmentTable01();
    }
    
}
