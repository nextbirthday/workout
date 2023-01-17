package bookMVC02;

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
public class BookManager02 extends JFrame implements ActionListener {
    
    BookController02  bookController02; // 도서 CRUD?
    BoardController02 boardController02; // 게시판 CRUD?
    
    JButton button;
    
    JPanel northPanel = new JPanel();
    
    String gubun = "bookMgr"; // 도서 CRUD면 bookMgr을 게시판 CRUD이면 boardMgr을
    
    public BookManager02() {
        // initDisplay(); -> 속지(JPanel, JScrollPane)로 사용되는 페이지일 때
        // 요청에 따른 페이지 갱신처리, 화면 갱신, 화면 초기화
        // 그러나 Thread 구현 시에는 issue가 발생하니까 주의해야 한다.
    }
    
    public void initDisplay() {
        northPanel.setLayout( new FlowLayout( FlowLayout.RIGHT ) );
        northPanel.setBackground( Color.cyan );
        
        String[] buttonText = { "조회", "입력", "수정", "삭제", "게시판" };
        
        for ( int i = 0; i < buttonText.length; i++ ) {
            button = new JButton( buttonText[i] );
            northPanel.add( button );
            button.addActionListener( this );
            
            // 익명 클래스 사용
            // button.addActionListener( new ActionListener() {
            // @Override
            // public void actionPerformed( ActionEvent e ) {}});
        }
        
        this.add( "North", northPanel );
        this.setTitle( "도서관리시스템 ver 1.0" );
        this.setLocation( 100, 100 );
        this.setSize( 900, 600 );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible( true );
    }
    
    public static void main( String[] args ) {
        BookManager02 book = new BookManager02();
        book.initDisplay();
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object  = e.getSource();
        String cmd     = e.getActionCommand();
        String command = "";
        
        switch ( cmd ) {
            
            case "조회":
                command = "조회";
                List<Map<String, Object>> tempList = new ArrayList<>();
                
                tempList = new BookController02().getBookList( 0, "한국소설", command );
                
                System.out.println( tempList );
                break;
            
            case "입력":
                bookController02.bookInsert( null );
                break;
            
            case "수정":
                bookController02.bookUpdate( null );
                break;
            
            case "삭제":
                bookController02.bookDelete( 10 );
                break;
            
            case "게시판":
                gubun = "boardMgr";
                
                if ( "boardMgr".equals( gubun ) ) {
                    boardController02 = ( BoardController02 ) FrontController02.getController( gubun );
                    System.out.println( "게시판 선택, " + boardController02 + ", gubun = " + gubun );
                    
                    gubun = "bookMgr";
                }
                break;
            
            default:
                break;
        }
    }
}
