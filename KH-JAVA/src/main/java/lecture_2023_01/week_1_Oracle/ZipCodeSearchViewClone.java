package lecture_2023_01.week_1_Oracle;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import lecture_2022_12.week_5_Oracle.DBConnectionMgr;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings( "serial" )
public class ZipCodeSearchViewClone extends JDialog implements ItemListener, FocusListener, ActionListener, MouseListener {
    
    // 화면에 표시될 전역변수 추가
    JComboBox zdoCombo  = null;
    JComboBox siguCombo = null;
    JComboBox dongCombo = null;
    
    JPanel northPanel = new JPanel( new FlowLayout( FlowLayout.CENTER ) );
    
    // 테이블 생성
    String[]          columns    = { "Zipcode", "Address" };
    String[][]        datas      = new String[0][3];
    DefaultTableModel model      = new DefaultTableModel( datas, columns );
    JTable            table      = new JTable( model );
    JTableHeader      header     = table.getTableHeader();
    JScrollPane       scrollPane = new JScrollPane( table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
    
    // 동 이름을 입력받는 텍스트필드와 조회 버튼 추가
    JTextField dongSearchField = new JTextField( "동 이름을 입력해주세요.", 20 );
    JButton    searchButton    = new JButton( "조회" );
    
    // DB연결을 위한 전역변수 추가
    DBConnectionMgr   dbMgr = new DBConnectionMgr();
    Connection        conn  = null;
    PreparedStatement pstmt = null;
    ResultSet         rs    = null;
    
    // 사용자가 선택한 ZDO, SIGU, DONG
    private String zdo  = null;
    private String sigu = null;
    private String dong = null;
    
    // DB에서 가져온 zdos[], sigu[], dong[]
    private String[] totals = { "전체" };
    private String[] zdos   = null;
    private String[] sigus  = null;
    private String[] dongs  = null;
    
    public ZipCodeSearchViewClone() {
        zdos = getZDOList();
        zdoCombo = new JComboBox( zdos );
        zdoCombo.addItemListener( this );
        siguCombo = new JComboBox( totals );
        siguCombo.addItemListener( this );
        dongCombo = new JComboBox( totals );
        dongCombo.addItemListener( this );
        dongSearchField.addFocusListener( this );
        dongSearchField.addActionListener( this );
        searchButton.addActionListener( this );
    }
    
    MemberShipClone msc;
    
    public ZipCodeSearchViewClone( MemberShipClone msc ) {
        this.msc = msc;
        /*
         * DB에서 records를 가져올 때 가져오는 시점을 생각해보기
         * 데이터를 보여줘야 하는 place에 배치해야 한다면 이른 인스턴스화나 메서드호출 시점도 고려하기.
         */
        zdos = getZDOList();
        zdoCombo = new JComboBox( zdos );
        zdoCombo.addItemListener( this );
        siguCombo = new JComboBox( totals );
        siguCombo.addItemListener( this );
        dongCombo = new JComboBox( totals );
        dongCombo.addItemListener( this );
        dongSearchField.addFocusListener( this );
        dongSearchField.addActionListener( this );
        searchButton.addActionListener( this );
        initDisplay();
    }
    
    // 대분류 정보 초기화에 필요한 DB조회하기 구현 메서드
    public String[] getZDOList() { // 반환타입 String[] (스트링 타입 배열)
        StringBuilder sql = new StringBuilder();
        
        sql.append( " SELECT '전체' zdo FROM dual       UNION ALL     SELECT zdo                 " );
        sql.append( " FROM (SELECT DISTINCT (zdo) zdo " );
        sql.append( " FROM ZIPCODE_T " );
        sql.append( " ORDER BY ZDO ASC )                                            " );
        
        try {
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement( sql.toString() );
            rs = pstmt.executeQuery();
            
            Vector<String> tempZdo = new Vector<>();
            
            while ( rs.next() ) {
                zdo = rs.getString( "zdo" );
                tempZdo.add( zdo );
            }
            zdos = new String[tempZdo.size()];
            tempZdo.copyInto( zdos );
        }
        catch ( SQLException se ) {}
        catch ( Exception e ) {}
        finally {
            dbMgr.freeConnection( conn, pstmt, rs );
        }
        return zdos;
    }
    
    public String[] getSiguList( String zdo ) {
        log.info( zdo );
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
            conn = dbMgr.getConnection();
            pstmt = conn.prepareStatement( sql.toString() );
            pstmt.setString( 1, zdo ); // index에 해당하는 숫자는 물음표에 해당하는 순번이라고 생각
            rs = pstmt.executeQuery();
            Vector tempSigu = new Vector<>();
            
            while ( rs.next() ) {
                sigu = rs.getString( "sigu" );
                tempSigu.add( sigu );
            }
            sigus = new String[tempSigu.size()]; // siguCombo에 들어갈 배열 생성
            tempSigu.copyInto( sigus );
            
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        finally {
            dbMgr.freeConnection( conn, pstmt, rs );
        }
        return sigus;
    }
    
    public void refreshData( String zdo, String dong ) {
        log.info( zdo + ", " + dong );
        StringBuilder sql = new StringBuilder();
        
        try {
            sql.append( "     SELECT ZIPCODE ,ADDRESS  " );
            sql.append( "     FROM SCOTT.ZIPCODE_T     " );
            sql.append( "     WHERE 1=1                " );
            
            if ( zdo != null && zdo.length() > 0 ) {
                sql.append( "AND ZDO = ?" );
            } // ZDO가 존재할 때만
            
            if ( dong != null && dong.length() > 0 ) {
                sql.append( "AND dong LIKE ? ||'%'" );
            }
            
            int i = 1;
            
            try {
                conn = dbMgr.getConnection();
                pstmt = conn.prepareStatement( sql.toString() );
                
                if ( zdo != null && zdo.length() > 0 ) {
                    pstmt.setString( i++, zdo );
                }
                
                if ( dong != null && dong.length() > 0 ) {
                    pstmt.setString( i++, dong );
                }
                
                rs = pstmt.executeQuery();
                List<Map<String, Object>> zipList = new ArrayList<>();
                Map<String, Object>       rMap    = null;
                
                while ( rs.next() ) {
                    rMap = new HashMap<>();
                    rMap.put( "zipcode", rs.getString( "zipcode" ) );
                    rMap.put( "address", rs.getString( "address" ) );
                    zipList.add( rMap );
                }
                log.info( rMap );
                log.info( zipList.get( 0 ) );
                log.info( zipList.get( 1 ) );
                // 화면처리
                
                if ( zipList.size() > 0 ) {
                    
                    while ( model.getRowCount() > 0 ) {
                        model.removeRow( 0 );
                    }
                    
                    // 새로 조회된 결과 화면에 출력하기
                    for ( int x = 0; x < zipList.size(); x++ ) {
                        Map<String, Object> rMap2  = zipList.get( x );
                        Vector<String>      oneRow = new Vector<>();
                        oneRow.add( 0, rMap2.get( "zipcode" ).toString() );
                        oneRow.add( 1, rMap2.get( "address" ).toString() );
                        model.addRow( oneRow );
                    }
                }
            }
            catch ( SQLException se ) {}
        }
        catch ( Exception e ) {}
        finally {
            dbMgr.freeConnection( conn, pstmt, rs );
        }
    } // end of refreshData
    
    public void initDisplay() {
        this.setDefaultLookAndFeelDecorated( true );
        
        table.addMouseListener( this );
        
        header.setBackground( Color.cyan );
        header.setFont( new Font( "맑은고딕", Font.ITALIC, 20 ) );
        table.getColumnModel().getColumn( 0 ).setPreferredWidth( 100 );
        table.getColumnModel().getColumn( 1 ).setPreferredWidth( 300 );
        table.setGridColor( Color.ORANGE );
        
        northPanel.add( zdoCombo );
        northPanel.add( siguCombo );
        northPanel.add( dongCombo );
        northPanel.add( dongSearchField );
        northPanel.add( searchButton );
        
        this.add( "Center", scrollPane );
        this.add( "North", northPanel );
        this.setSize( 630, 400 );
        this.setVisible( false );
        this.setDefaultCloseOperation( JDialog.EXIT_ON_CLOSE );
    }
    
    @Override
    public void mouseClicked( MouseEvent e ) {}
    
    @Override
    public void mousePressed( MouseEvent e ) {}
    
    @Override
    public void mouseReleased( MouseEvent e ) {
        
        if ( e.getClickCount() == 2 ) {
            int index = table.getSelectedRow();
            
        }
    }
    
    @Override
    public void mouseEntered( MouseEvent e ) {}
    
    @Override
    public void mouseExited( MouseEvent e ) {}
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        if ( object == searchButton || object == dongSearchField ) {
            String myDong = dongSearchField.getText();
            refreshData( zdo, myDong );
            log.info( zdo );
        }
    }
    
    @Override
    public void focusGained( FocusEvent e ) {
        
        if ( e.getSource() == dongSearchField ) {
            dongSearchField.setText( "" );
        }
    }
    
    @Override
    public void focusLost( FocusEvent e ) {}
    
    @Override
    public void itemStateChanged( ItemEvent e ) {
        Object object = e.getSource();
        
        if ( object == zdoCombo ) {
            
            if ( e.getStateChange() == ItemEvent.SELECTED ) {
                System.out.println( "선택하신 시*도는 ===>" + zdos[zdoCombo.getSelectedIndex()] );
                zdo = zdos[zdoCombo.getSelectedIndex()];
                log.info( zdo );
                
                // 대분류가 결정 되었을 때 sigus를 초기화 해주어야 한다.
                // 기존에 default로 "전체" 상수값을 넣어두었기 때문에 이것을 삭제해야한다.
                sigus = getSiguList( zdo );
                
                siguCombo.removeAllItems();
                
                for ( int i = 0; i < sigus.length; i++ ) {
                    siguCombo.addItem( sigus[i] );
                }
            }
        }
    }
    
    public static void main( String[] args ) {
        ZipCodeSearchViewClone test = new ZipCodeSearchViewClone();
        test.initDisplay();
    }
}
