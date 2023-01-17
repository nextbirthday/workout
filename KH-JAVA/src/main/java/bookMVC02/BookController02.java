package bookMVC02;

import java.util.List;
import java.util.Map;

import lombok.extern.log4j.Log4j2;

// public class BookController extends FrontController{}
// public class BookController implements Controller { }
@Log4j2
public class BookController02 {
    
    public BookController02() {}
    
    // BookLogic bookLogic = new BookLogic();
    // 원래는 BookLogic 클래스를 객체 주입해야 하지만 업무적인 depth가 얕아서 로직클래스에서 선택, 결정에 따른 추가적인 프로세스가 전혀 없는 상태이다.
    // 따라서 Controller클래스와 DAO클래스 사이에 연결만 담당하니까 의미가 없다.
    BookDAO02 bookDAO = new BookDAO02();
    
    /**
     * 
     * @param cols    - COLUMN NAME bk_title or bk_author or bk_info
     * @param keyword - 사용자가 텍스트필드에 입력한 값
     *                <p>
     * @return BookDAO 클래스로부터 받아온 도서정보
     */
    public List<Map<String, Object>> getBookList( String cols, String keyword ) {
        System.out.println( "도서목록 조회" );
        List<Map<String, Object>> bookList = null;
        bookList = bookDAO.getBookList( cols, keyword );
        
        log.info( bookList );
        return bookList;
    }
    
    public List<Map<String, Object>> getBookList( int bk_no, String keyword, String command ) {
        System.out.println( "도서목록 조회" );
        
        List<Map<String, Object>> bookList = null;
        bookList = bookDAO.getBookList( bk_no, keyword, command );
        
        log.info( bookList + ", " + command );
        return bookList;
    }
    
    /**
     * 
     * @param bookVO
     * @return 도서정보 입력에 성공했으면 1, 실패시 0
     */
    public int bookInsert( BookVO02 bookVO ) {
        System.out.println( "도서정보 입력" );
        int result = 0;
        result = bookDAO.bookInsert( bookVO );
        
        return result;
    }
    
    /**
     * 
     * @param bookVO
     * @return 도서정보 수정에 성공했으면 1, 실패시 0
     */
    public int bookUpdate( BookVO02 bookVO ) {
        System.out.println( "도서정보 수정" );
        int result = 0;
        result = bookDAO.bookUpdate( bookVO );
        return result;
    }
    
    /**
     * 
     * @param bk_no - 사용자로부터 입력받은 도서번호
     * @return 도서정보 삭제에 성공했으면 1, 실패시 0
     */
    public int bookDelete( int bk_no ) {
        System.out.println( "도서정보 삭제" );
        int result = 0;
        result = bookDAO.bookDelete( bk_no );
        return result;
    }
    
}
