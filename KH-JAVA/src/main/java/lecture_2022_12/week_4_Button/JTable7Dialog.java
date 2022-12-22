package lecture_2022_12.week_4_Button;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

@SuppressWarnings( "serial" )
public class JTable7Dialog extends JDialog implements ActionListener {
    
    DeptTable3 view;
    
    public JTable7Dialog() {}
    
    public JTable7Dialog( DeptTable3 view ) {
        this.view = view;
        initDisplay();
    }
    
    String[] oneRow = null;
    
    JPanel      jp_center  = new JPanel();
    JScrollPane jsp_center = new JScrollPane( jp_center );
    JPanel      jp_south   = new JPanel();
    
    JLabel     jLabel_deptno     = new JLabel( "부서번호" );
    JTextField jTextField_deptno = new JTextField( 10 );
    JLabel     jLabel_dname      = new JLabel( "부서명" );
    JTextField jTextField_dname  = new JTextField( 20 );
    JLabel     jLabel_loc        = new JLabel( "지역" );
    JTextField jTextField_loc    = new JTextField( 20 );
    
    JButton jbtn_save  = new JButton( "저장" );
    JButton jbtn_close = new JButton( "닫기" );
    
    public void initDisplay() {
        jp_center.setLayout( null );
        jp_south.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
        jLabel_deptno.setBounds( 20, 20, 100, 20 );
        jTextField_deptno.setBounds( 120, 20, 100, 20 );
        jLabel_dname.setBounds( 20, 45, 100, 20 );
        jTextField_dname.setBounds( 120, 45, 150, 20 );
        jLabel_loc.setBounds( 20, 70, 100, 20 );
        jTextField_loc.setBounds( 120, 70, 150, 20 );
        jp_center.add( jLabel_deptno );
        jp_center.add( jTextField_deptno );
        jp_center.add( jLabel_dname );
        jp_center.add( jTextField_dname );
        jp_center.add( jLabel_loc );
        jp_center.add( jTextField_loc );
        jp_south.add( jbtn_save );
        jp_south.add( jbtn_close );
        jbtn_save.addActionListener( this );
        jbtn_close.addActionListener( this );
        this.add( "Center", jsp_center );
        this.add( "South", jp_south );
        this.setSize( 500, 460 );
        this.setVisible( false );
        this.setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
    }
    
    // 각 컬럼(부서집합-부서번호,부서명,지역)의; 값들을 설정하거나 읽어오는 getter/setter 메서드임
    public String getDeptno() { return jTextField_deptno.getText(); }
    // JTextField_deptno에 입력된 값을 get(가져온다.)
    
    public void setDeptno( String deptno ) {
        jTextField_deptno.setText( deptno );
    }// JTextField_deptno에 입력된 값을 set(save)한다
    
    public String getDname() { return jTextField_dname.getText(); }
    
    public void setDname( String dName ) {
        jTextField_dname.setText( dName );
    }
    
    public String getLoc() { return jTextField_loc.getText(); }
    
    public void setLoc( String loc ) {
        jTextField_loc.setText( loc );
    }
    
    // actionPerformed에서 이벤트(입력,수정,상세보기)가 발생되면 호출됨
    public void set( String title, boolean isView, String[] oneRow ) {
        this.setTitle( title );
        this.setVisible( isView );
        this.oneRow = oneRow;
        setValue( oneRow );
    }
    
    public void setValue( String[] oneRow ) { // 공통 코드 작성
        
        // 입력을 위한 윈도우 설정 - 모든 값을 빈문자열로 세팅함
        if ( oneRow == null ) {
            setDeptno( "" );
            setDname( "" );
            setLoc( "" );
        }
        // 상세조회, 수정시는 배열로 받은 값으로 세팅함
        // 부모창에서 set method 호출시 파라미터로 넘겨준 값으로 초기화한것
        else {
            setDeptno( oneRow[0] );
            setDname( oneRow[1] );
            setLoc( oneRow[2] );
        }
    }
    
    public static void main( String[] args ) {
        new JTable7Dialog( null );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        if ( object == jbtn_save ) {
            
            // oneRow가 존재하면 수정모드, 그렇지 않으면 입력모드
            if ( oneRow != null ) {
                
            }
            else { // (oneRow == null)
                String[] oneRow = { getDeptno(), getDname(), getLoc() };
                DeptTable3.dataList.add( oneRow );
                view.refreshData();
                this.dispose();
            }
        }
        
        if ( object == jbtn_close ) {
            this.dispose();
        }
    }
}
