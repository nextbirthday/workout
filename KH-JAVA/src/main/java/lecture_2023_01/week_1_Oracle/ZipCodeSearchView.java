package lecture_2023_01.week_1_Oracle;

import java.awt.Color;
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
import javax.swing.JFrame;
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
public class ZipCodeSearchView extends JFrame implements ItemListener, FocusListener, ActionListener, MouseListener {
    
    JComboBox jcb_zdo  = null;
    JComboBox jcb_sigu = null;
    JComboBox jcb_dong = null;
    
    // southPanel - combobox 3ea + JTextField, JButton
    // default layout = FlowLayout ( FlowLayout - 중앙에서 좌우로 펼쳐지면서 배치가 된다.)
    JPanel northPanel = new JPanel();
    // JPanel southPanel = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
    
    // 테이블 생성
    String[]          cols       = { "우편번호", "주소" };
    String[][]        data       = new String[0][3];
    DefaultTableModel model      = new DefaultTableModel( data, cols );
    JTable            table      = new JTable( model );
    JTableHeader      header     = table.getTableHeader();
    JScrollPane       scrollPane = new JScrollPane( table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
    
    // 동 이름을 입력받는 텍스트필드와 조회 버튼 추가
    JTextField searchField  = new JTextField( "동 이름을 입력하세요.", 20 ); // 해당하는 텍스트필드 사이즈 초기화, 생성자 파라미터 자리를 이용하면 추가적인 메서드 호출 없이도 해당 화면에 대한 추가적인 초기화 작업이 가능하니까 ㅌ코드의 양을 줄일 수 있다.
    JButton    searchButton = new JButton( "조회" );
    
    // DB연결을 위한 전역변수 추가
    DBConnectionMgr   dbMgr             = new DBConnectionMgr(); // DriverClass, connection info
    Connection        con               = null; // Interface
    PreparedStatement preparedStatement = null; // 동적 쿼리 처리
    ResultSet         rs                = null; // 오라클 서버의 커서를 조작하는 Interface
    
    // 사용자가 선택한 zdo, sigu, dong
    private String zdo  = null;
    private String sigu = null;
    private String dong = null;
    
    // DB에서 가져온 zdos[], sigu[], dong[]
    private String[] totals = { "전체" };
    private String[] zdos   = null;
    private String[] sigus  = null;
    private String[] dongs  = null;
    
    MemberShip ms = null;
    
    public ZipCodeSearchView( MemberShip ms ) {
        this(); // 나 자신의 디폴트 생성자 호출, this 뒤에 괄호가 있으면 자기 자신의 디폴트 생성자 호출
        this.ms = ms;
        this.init();
    }
    
    public ZipCodeSearchView() {
        
        zdos = getZDOList();
        
        searchField.addFocusListener( this );
        searchField.addActionListener( this );
        searchButton.addActionListener( this );
        
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
    
    public void refreshData( String zdo, String dong ) {
        System.out.println( "refreshData call" );
        System.out.println( zdo + ", " + dong );
        StringBuilder sql = new StringBuilder();
        
        try {
            
            sql.append( "     SELECT ZIPCODE ,ADDRESS  " );
            sql.append( "     FROM SCOTT.ZIPCODE_T     " );
            sql.append( "     WHERE 1=1                " );
            
            if ( zdo != null && zdo.length() > 0 ) {
                sql.append( "AND ZDO = ?" );
            } // zdo가 존재할 때만
            
            if ( dong != null && dong.length() > 0 ) {
                sql.append( "     AND dong LIKE ?||'%'    " );
            } // dong이 입력받았을 때만
            
            int i = 1;
            
            try {
                con = dbMgr.getConnection();
                preparedStatement = con.prepareStatement( sql.toString() );
                
                if ( zdo != null && zdo.length() > 0 ) {
                    preparedStatement.setString( i++, zdo );
                }
                
                if ( dong != null && dong.length() > 0 ) {
                    preparedStatement.setString( i++, dong );
                }
                // 입력, 수정, 삭제인 경우에는 executrUpdate()를 사용하고 return type는 int
                // 조회의 경우에는 executeQuery()를 사용하고 return type는 ResultSet
                // 테이블을 생성할 때는 execute()를 사용한다.
                // 업무가 바뀌더라도 테이블명과 컬럼명만 변하니까 다른건 그대로 재사용된다. -> ORM솔루션 -> JPA기술 출현, 활용 -> JPA (Hibernate - Query문이 없다.)
                rs = preparedStatement.executeQuery();
                List<Map<String, Object>> zipList = new ArrayList<>();
                Map<String, Object>       rMap    = null;
                
                while ( rs.next() ) {
                    rMap = new HashMap<>();
                    rMap.put( "zipcode", rs.getString( "zipcode" ) );
                    rMap.put( "address", rs.getString( "address" ) );
                    zipList.add( rMap );
                }
                // Collection에서 제공하는 클래스는 주소번지를 출력하더라도 그 구조안에 있는 값들이 출력된다. - toString() Overriding
                System.out.println( zipList );
                
                // 화면 처리하기 - 테이블 새로고침하기
                if ( zipList.size() > 0 ) {
                    
                    // 조회를 연속하여 요청할 경우 기존에 조회된 화면은 지워주자
                    while ( model.getRowCount() > 0 ) { // JTable은 양식일 뿐이고 실제 데이터는 DefaultTableModel에 있다.
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
            catch ( SQLException e ) {}
            catch ( Exception e ) {}
        }
        finally {
            dbMgr.freeConnection( con, preparedStatement, rs );
        }
    }// end of refreshData
    
    public void init() {
        
        table.addMouseListener( this );
        
        header.setBackground( Color.orange );
        header.setFont( new Font( "맑은고딕", Font.BOLD, 20 ) );
        table.getColumnModel().getColumn( 0 ).setPreferredWidth( 100 );
        table.getColumnModel().getColumn( 1 ).setPreferredWidth( 300 );
        table.setGridColor( Color.red );
        northPanel.add( jcb_zdo );
        northPanel.add( jcb_sigu );
        northPanel.add( jcb_dong );
        northPanel.add( searchField );
        northPanel.add( searchButton );
        
        this.add( "Center", scrollPane );
        this.add( "North", northPanel );
        this.setSize( 630, 400 );
        this.setVisible( false );
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
        
        if ( object == searchField ) {}
    }
    
    @Override
    public void focusGained( FocusEvent e ) {
        
        if ( e.getSource() == searchField ) {
            searchField.setText( "" );
        }
    }
    
    @Override // 아래의 메서드는 구현할 필요가 없지만 지우면 에러가 발생한다. because 추상 메서드
    public void focusLost( FocusEvent e ) {
        
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        if ( object == searchButton || object == searchField ) {
            String myDong = searchField.getText();
            refreshData( zdo, myDong );
        }
    }
    
    public static void main( String[] args ) {
        JFrame.setDefaultLookAndFeelDecorated( true );
        ZipCodeSearchView test = new ZipCodeSearchView();
    }
    
    @Override
    public void mouseClicked( MouseEvent e ) {}
    
    @Override
    public void mousePressed( MouseEvent e ) {}
    
    @Override
    public void mouseReleased( MouseEvent e ) {
        
        if ( e.getClickCount() == 2 ) {
            
            int index = table.getSelectedRow();
            
            for ( int i = 0; i < model.getRowCount(); i++ ) {
                
                if ( table.isRowSelected( i ) ) {
                    String address = model.getValueAt( i, 1 ).toString();
                    ms.jtf_zipcode.setText( String.valueOf( model.getValueAt( i, 0 ) ) );
                    ms.jtf_address.setText( address );
                    this.dispose();
                    // ms.jtf_address.setText( String.valueOf( model.getValueAt( i, 1 ) ) );
                }
            }
        }
    }
    
    @Override
    public void mouseEntered( MouseEvent e ) {}
    
    @Override
    public void mouseExited( MouseEvent e ) {}
}
