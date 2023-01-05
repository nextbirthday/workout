package lecture_2023_01.week_1_Oracle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import lecture_2022_12.week_5_Oracle.DBConnectionMgr;

@SuppressWarnings( "serial" )
public class ZipCodeSearchView extends JFrame implements ItemListener {
    
    @SuppressWarnings( "rawtypes" )
    JComboBox jcb_zdo    = null;
    @SuppressWarnings( "rawtypes" )
    JComboBox jcb_sigu   = null;
    @SuppressWarnings( "rawtypes" )
    JComboBox jcb_dong   = null;
    JPanel    northPanel = new JPanel();
    
    // 테이블 생성
    String[]          cols       = { "우편번호", "주소" };
    String[][]        data       = new String[3][3];
    DefaultTableModel model      = new DefaultTableModel( data, cols );
    JTable            table      = new JTable( model );
    JTableHeader      header     = table.getTableHeader();
    JScrollPane       scrollPane = new JScrollPane( table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
    
    // DB연결을 위한 전역변수 추가
    DBConnectionMgr   dbMgr             = new DBConnectionMgr();
    Connection        con               = null;
    PreparedStatement preparedStatement = null;
    ResultSet         rs                = null;
    
    // 사용자가 선택한 zdo, sigu, dong
    private String zdo  = null;
    private String sigu = null;
    private String dong = null;
    
    // DB에서 가져온 zdos[], sigu[], dong[]
    private String[] totals = { "전체" };
    private String[] zdos   = null;
    private String[] sigus  = null;
    private String[] dongs  = null;
    
    public ZipCodeSearchView() {
        zdos = getZDOList();
        
        jcb_zdo = new JComboBox( zdos );
        jcb_zdo.addItemListener( this );
        jcb_sigu = new JComboBox( totals );
        jcb_zdo.addItemListener( this );
        jcb_dong = new JComboBox( totals );
        jcb_dong.addItemListener( this );
    }
    
    // 대분류 정보 초기화에 필요한 DB조회하기 구현 메서드
    public String[] getZDOList() {
        StringBuilder sql = new StringBuilder();
        
        sql.append( " SELECT '전체' zdo FROM dual       UNION ALL     SELECT zdo                 " );
        sql.append( " FROM (SELECT DISTINCT (zdo) zdo " );
        sql.append( " FROM ZIPCODE_T " );
        sql.append( " ORDER BY ZDO ASC )                                            " );
        
        try {
            // con의 주소번지가 확인되면 oracle server와 연결통로가 확보되었다.
            con = dbMgr.getConnection();
            preparedStatement = con.prepareStatement( sql.toString() );
            rs = preparedStatement.executeQuery();
            // oracle에서 생성된 table의 커서 default위치는 항상 isTop이다.
            
            Vector<String> tempZdo = new Vector<>();
            
            while ( rs.next() ) {
                zdo = rs.getString( "zdo" );
                tempZdo.add( zdo );
            }
            zdos = new String[tempZdo.size()];
            tempZdo.copyInto( zdos );
            
        }
        catch ( SQLException se ) {
            System.out.println( se.toString() );
            System.out.println( sql.toString() );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        finally { // 사용한 자원 반납 - 반납은 생성의 역순
            dbMgr.freeConnection( con, preparedStatement, rs );
        }
        
        return zdos;
    }
    
    public String[] getSiguList( String zdo ) {
        StringBuilder sql = new StringBuilder();
        
        sql.append( "   SELECT '전체' sigu                 " );
        sql.append( "   FROM dual                          " );
        sql.append( "   UNION ALL                          " );
        sql.append( "   SELECT sigu                        " );
        sql.append( "   FROM(SELECT DISTINCT (sigu) sigu   " );
        sql.append( "   FROM ZIPCODE_T               " );
        sql.append( "   WHERE zdo = ?                    " );
        sql.append( "   ORDER BY SIGU ASC )                " );
        
        try {
            con = dbMgr.getConnection();
            preparedStatement = con.prepareStatement( sql.toString() );
            preparedStatement.setString( 1, zdo );
            rs = preparedStatement.executeQuery();
            Vector<String> tempSigu = new Vector<>();
            
            while ( rs.next() ) {
                sigu = rs.getString( "sigu" );
                tempSigu.add( sigu );
            }
            // sigu combobox에 들어갈 배열 생성하기
            sigus = new String[tempSigu.size()];
            
            tempSigu.copyInto( sigus );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        finally { // 사용한 자원 반납 - 반납은 생성의 역순
            dbMgr.freeConnection( con, preparedStatement, rs );
        }
        
        return sigus;
    }
    
    public void init() {
        header.setBackground( Color.orange );
        header.setFont( new Font( "맑은고딕", Font.BOLD, 20 ) );
        table.getColumnModel().getColumn( 0 ).setPreferredWidth( 100 );
        table.getColumnModel().getColumn( 1 ).setPreferredWidth( 300 );
        table.setGridColor( Color.red );
        northPanel.add( jcb_zdo );
        northPanel.add( jcb_sigu );
        northPanel.add( jcb_dong );
        this.add( "Center", scrollPane );
        this.add( "North", northPanel );
        this.setSize( 830, 500 );
        this.setVisible( true );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    
    @Override
    public void itemStateChanged( ItemEvent e ) {
        // event가 감지되는 소스 가져오기
        Object object = e.getSource();
        
        if ( object == jcb_zdo ) {
            
            if ( e.getStateChange() == ItemEvent.SELECTED ) {
                System.out.println( "선택하신 시|도 ===> " + zdos[jcb_zdo.getSelectedIndex()] );
                zdo = zdos[jcb_zdo.getSelectedIndex()];
                sigus = getSiguList( zdo );
                // 대분류가 결정이 되었을 때 sigus를 초기화 해줘야 한다.
                // 기존에 default로 전체 상수값을 넣어두었으니 이것을 삭제하고
                jcb_sigu.removeAllItems();
                
                // 새로운 DB Server에서 읽어온 값으로 아이템을 추가해야한다. - 초기화
                for ( int i = 0; i < sigus.length; i++ ) {
                    jcb_sigu.addItem( sigus[i] );
                }
                
            }
        }
        
    }
    
    public static void main( String[] args ) {
        JFrame.setDefaultLookAndFeelDecorated( true );
        ZipCodeSearchView test = new ZipCodeSearchView();
        test.init();
    }
}
