package bookMVC;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings( "serial" )
public class BookManager extends JFrame implements ActionListener {
    
    JButton jbtn_sel   = new JButton( "조회" ); // SELECT
    JButton jbtn_ins   = new JButton( "입력" ); // INSERT
    JButton jbtn_upd   = new JButton( "수정" ); // UPDATE
    JButton jbtn_del   = new JButton( "삭제" ); // DELETE
    JButton jbtn_board = new JButton( "게시판" ); // 게시판
    
    JButton button;
    
    JPanel northPanel = new JPanel();
    
    String gubun = "bookMgr"; // 도서 CRUD면 bookMgr을 게시판 CRUD이면 boardMgr을
    
    // private List<Map<String, Object>> getBookList() {
    // BookController bookController = new BookController();
    // List<Map<String, Object>> tempList = new ArrayList<>();
    // bookController.getBookList( gubun, gubun );
    // return tempList;
    // }
    
    public BookManager() {
        // initDisplay(); -> 속지(JPanel, JScrollPane)로 사용되는 페이지일 때
        // 요청에 따른 페이지 갱신처리, 화면 갱신, 화면 초기화
        // 그러나 Thread 구현 시에는 issue가 발생하니까 주의해야 한다.
    }
    
    public void initDisplay() {
        northPanel.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
        northPanel.setBackground( Color.cyan );
        
        // String[] buttonText = { "조회", "입력", "수정", "삭제", "게시판" };
        //
        // for ( int i = 0; i < buttonText.length; i++ ) {
        // button = new JButton( buttonText[i] );
        // northPanel.add( button );
        // button.addActionListener( this );
        // }
        
        northPanel.add( jbtn_sel );
        northPanel.add( jbtn_ins );
        northPanel.add( jbtn_upd );
        northPanel.add( jbtn_del );
        northPanel.add( jbtn_board );
        
        jbtn_sel.addActionListener( this );
        jbtn_ins.addActionListener( this );
        jbtn_upd.addActionListener( this );
        jbtn_del.addActionListener( this );
        jbtn_board.addActionListener( this );
        
        this.add( "North", northPanel );
        this.setTitle( "도서관리시스템 ver 1.0" );
        this.setLocation( 100, 100 );
        this.setSize( 900, 600 );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible( true );
    }
    
    public static void main( String[] args ) {
        BookManager book = new BookManager();
        book.initDisplay();
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        BookController  bookController  = null; // 도서 CRUD?
        BoardController boardController = null; // 게시판 CRUD?
        
        if ( object == jbtn_board ) {
            gubun = "boardMgr";
            
            if ( "boardMgr".equals( gubun ) ) {
                boardController = ( BoardController ) FrontController.getController( gubun );
                log.info( "게시판 선택, " + boardController + ", gubun = " + gubun );
                // log.info( "게시판 선택, " + boardController + ", gubun = " + gubun );
                // 게시판 컨트롤러가 결정되면 다시 디폴트 값으로 초기화
                gubun = "bookMgr";
            }
        }
        else if ( "bookMgr".equals( gubun ) ) {
            
            bookController = ( BookController ) FrontController.getController( gubun );
            log.info( "도서관리 선택, " + bookController + ", gubun = " + gubun );
            // log.info( "게시판 선택, " + bookController + ", gubun = " + gubun );
            
            // if문은 무조건 조건을 따진다.
            // else if 문은 앞 조건 을 수렴하면 뒤에 있는 코드는 실행기회를 갖지 않는다.
            if ( object == jbtn_sel ) {
                List<Map<String, Object>> tempList = new ArrayList<>();
                
                tempList = bookController.getBookList( gubun, "한국소설" );
                log.info( tempList );
            }
            else if ( object == jbtn_ins ) {
                bookController.bookInsert( null );
            }
            else if ( object == jbtn_upd ) {
                bookController.bookUpdate( null );
            }
            else if ( object == jbtn_del ) {
                bookController.bookDelete( 10 );
            }
        }
    }
}

// String cmd = e.getActionCommand();
//
// switch ( cmd ) {
// case "조회":
// break;
// case "입력":
// break;
// case "수정":
// break;
// case "삭제":
// break;
// case "게시판":
// break;
// default:
// break;
// }
