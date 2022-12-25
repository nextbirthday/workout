package b3_1212;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

public class AddressBook implements ActionListener {
    
    // field
    
    AddressDialog aDialog = new AddressDialog( this );
    
    // image path 선언
    String imgPath = "C:\\Users\\HOJAE\\Desktop\\Java\\workout\\images";
    
    // Toolbar 및 Title image setting
    ImageIcon titIcon    = new ImageIcon( imgPath + "memo.png" );
    JToolBar  jtb        = new JToolBar();
    JFrame    jf_address = new JFrame();
    
    JFrame jf;
    
    JPanel jp_center = new JPanel();
    
    // menu bar 구성하기
    JMenuBar  jmb        = new JMenuBar();
    JMenu     jm_file    = new JMenu( "File" );
    JMenuItem jmi_insert = new JMenuItem( "입력" );
    JMenuItem jmi_modify = new JMenuItem( "수정" );
    JMenuItem jmi_db     = new JMenuItem( "DB연동확인" );
    JMenuItem jmi_delete = new JMenuItem( "삭제" );
    JMenuItem jmi_exit   = new JMenuItem( "종료" );
    JMenuItem jmi_all    = new JMenuItem( "전체조회" );
    JMenuItem jmi_detail = new JMenuItem( "상세보기" );
    
    JMenu jm_edit = new JMenu( "Edit" );
    
    JSeparator js_exit = new JSeparator();
    
    JButton deleteButton = new JButton();
    JButton insertButton = new JButton();
    JButton modifyButton = new JButton();
    JButton detailButton = new JButton();
    
    // BorderLayout 중앙에 Table(주소록 목록)추가하기
    // JTable Header에 들어갈 문자열 선언
    // JTable은 양식만 제공할 뿐이고 데이터를 담을 클래스는 별도로 필요하다.
    // JTable에 들어갈 실제 데이터셋을 관리할 수 있는 클래스 선언
    // JTable에 보여지는 실제 데이터는 DefaultTableModel 클래스를 통해 제어해야 함을 의미한다.
    String[]   header = { "번호", "이름", "H.P" };
    String[][] datas  = new String[3][3];
    
    // DataSet을 JTable 생성 시 파라미터로 매칭하기.
    DefaultTableModel dtm_address = new DefaultTableModel( datas, header );
    JTable            jtb_address = new JTable( dtm_address );
    
    // DefaultTableModel의 row 수가 많아지는 경우 스크롤 바 추가
    // JScrollPane은 스크롤바를 품고 있는 일종의 속지로 생각한다.
    // 첫 번째 파라미터는 양식을 가진 JTable이고 두 번째는 수직 스크롤바 정책을, 세 번째는 수평 스크롤바 정책
    JScrollPane jsp_address = new JScrollPane( jtb_address, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
    
    // constructor
    public AddressBook() {
        initDisplay();
    }
    
    // view method
    void initDisplay() {
        
        jf = new JFrame( "AddressBook ver 1.0" );
        jm_file.setMnemonic( 'F' );
        jm_edit.setMnemonic( 'E' );
        
        jtb.add( deleteButton );
        jtb.add( insertButton );
        jtb.add( modifyButton );
        jtb.add( detailButton );
        
        insertButton.setIcon( new ImageIcon( imgPath + "new.gif" ) );
        deleteButton.setIcon( new ImageIcon( imgPath + "delete.gif" ) );
        modifyButton.setIcon( new ImageIcon( imgPath + "modify.gif" ) );
        detailButton.setIcon( new ImageIcon( imgPath + "detail.gif" ) );
        
        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        jf.add( "North", jtb );
        jf.add( "Center", jtb_address );
        
        jmb.add( jm_file );
        jm_file.add( jmi_db );
        jm_file.add( jmi_all );
        jm_file.add( js_exit );
        jm_file.add( jmi_exit );
        
        jmb.add( jm_edit );
        jm_edit.add( jmi_all );
        jm_edit.add( jmi_insert );
        jm_edit.add( jmi_modify );
        jm_edit.add( jmi_delete );
        jm_edit.add( jmi_detail );
        
        // 이벤트 소스와 이벤트 핸들러 클래스의 매칭
        jmi_all.addActionListener( this );
        deleteButton.addActionListener( this );
        insertButton.addActionListener( this );
        modifyButton.addActionListener( this );
        detailButton.addActionListener( this );
        
        jf.setSize( 600, 500 );
        jf.setVisible( true );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object obj = e.getSource();
        
        if ( obj == jmi_all ) {
            String[][] members = { { "1", "이순신", "01074846897" }, { "2", "강감찬", "01072389711" }, { "3", "김춘추", "01012345678" } };
            
            // 이미 table에 조회된 정보가 있는 경우 모두 삭제함
            while ( dtm_address.getRowCount() > 0 ) {
                dtm_address.removeRow( 0 );
            }
            
            for ( int i = 0; i < members.length; i++ ) {
                Vector<String> oneRow = new Vector<>();
                oneRow.add( members[i][0] );
                oneRow.add( members[i][1] );
                oneRow.add( members[i][2] );
                dtm_address.addRow( oneRow );
            }
            
            // 익명 클래스 문법 - java 람다식, java script Arrow Function 문법과 유사
            jsp_address.getVerticalScrollBar().addAdjustmentListener( new AdjustmentListener() {
                @Override
                public void adjustmentValueChanged( AdjustmentEvent e ) {
                    JScrollBar jsb = ( JScrollBar ) e.getSource();
                    jsb.setValue( jsb.getMaximum() );
                }
            } );
        }
        else if ( obj == deleteButton ) {
            aDialog.setDialog( deleteButton.getText(), true );
        }
        else if ( obj == insertButton ) {
            aDialog.setDialog( insertButton.getText(), true );
        }
        else if ( obj == modifyButton ) {
            aDialog.setDialog( modifyButton.getText(), true );
        }
    }
    
    public static void main( String[] args ) {
        new AddressBook();  // 생성자 호출
    }
}
