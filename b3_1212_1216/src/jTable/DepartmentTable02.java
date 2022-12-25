package jTable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings( "serial" )
public class DepartmentTable02 extends JFrame { // DepartmentTable01 is a JFrame
    
    String[]   header = { "부서번호", "부서명", "지역" };
    String[][] data   = new String[1][3];
    
    JScrollPane       scrollPane;
    JPanel            centerPanel = new JPanel();
    DefaultTableModel dtm_dept    = new DefaultTableModel( data, header ); // constructor call
    // { {"","",""}, {"","",""}, {"","",""} };
    
    public DepartmentTable02() {
        initDisplay();
    }
    
    public DepartmentTable02( String title ) {
        System.out.println( "String title 생성자 호출" );
        
    }
    
    public DepartmentTable02( int i ) {
        
    }
    
    public void initDisplay() {
        this.setTitle( "부서관리 시스템 ver 1.0" );
        this.setSize( 500, 400 );
        this.setVisible( true );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
    
    public static void main( String[] args ) {
        new DepartmentTable01();
        // class 가 다르더라도 다른 클래스에 인스턴스화 할 수 있는것처럼 생성자 호출이 가능하다.
    }
}
